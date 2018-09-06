package pe.gob.inei.dmorales.firebasequerys;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto){
        this.contexto = contexto;
        sqLiteOpenHelper = new DataBaseHelper(contexto);
    }

    public Data(Context contexto, int flag) throws IOException {
        this.contexto = contexto;
        sqLiteOpenHelper = new DataBaseHelper(contexto);
        createDataBase();
    }

    public Data(Context contexto, String inputPath) throws IOException {
        this.contexto = contexto;
        sqLiteOpenHelper = new DataBaseHelper(contexto);
        createDataBase(inputPath);
    }

    public void createDataBase() throws IOException {
        boolean dbExist = checkDataBase();
        if(!dbExist){
            sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
            sqLiteDatabase.close();
            try{
                copyDataBase();
                sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
//                sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_ASISTENCIA_LOCAL);
                sqLiteDatabase.close();
            }catch (IOException e){
                throw new Error("Error: copiando base de datos");
            }
        }

    }

    @SuppressLint("NewApi")
    public void createDataBase(String inputPath) throws IOException {
        boolean dbExist = checkDataBase();
        if(dbExist){
            File dbFile = new File(SQLConstantes.DB_PATH + SQLConstantes.DB_NAME);
            SQLiteDatabase.deleteDatabase(dbFile);
        }
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        sqLiteDatabase.close();
        try{
            copyDataBase(inputPath);
            sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
//            sqLiteDatabase.execSQL(SQLConstantes.SQL_CREATE_TABLA_ASISTENCIA_LOCAL);
            sqLiteDatabase.close();
        }catch (IOException e){
            throw new Error("Error: copiando base de datos");
        }
    }

    public void copyDataBase() throws IOException{
        InputStream myInput = contexto.getAssets().open(SQLConstantes.DB_NAME);
        String outFileName = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) != -1){
            if (length > 0){
                myOutput.write(buffer,0,length);
            }
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();

    }


    public void copyDataBase(String inputPath) throws IOException{
//        InputStream myInput = contexto.getAssets().open(SQLConstantes.DB_NAME);
        InputStream myInput = new FileInputStream(inputPath);
        String outFileName = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) != -1){
            if (length > 0){
                myOutput.write(buffer,0,length);
            }
        }
        myOutput.flush();
        myInput.close();
        myOutput.close();

    }

    public void open() throws SQLException {
        String myPath = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
        sqLiteDatabase = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public synchronized void close(){
        if(sqLiteDatabase != null){
            sqLiteDatabase.close();
        }
    }

    public boolean checkDataBase(){
        try{
            String myPath = SQLConstantes.DB_PATH + SQLConstantes.DB_NAME;
            sqLiteDatabase = SQLiteDatabase.openDatabase(myPath,null, SQLiteDatabase.OPEN_READWRITE);
        }catch (Exception e){
            File dbFile = new File(SQLConstantes.DB_PATH + SQLConstantes.DB_NAME);
            return dbFile.exists();
        }
        if (sqLiteDatabase != null) sqLiteDatabase.close();

        return sqLiteDatabase != null ? true : false;
    }

    public UsuarioLocal getUsuarioLocal(String clave){
        UsuarioLocal usuario = null;
        String[] whereArgs = new String[]{clave};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablausuariolocal,
                    null,SQLConstantes.WHERE_CLAUSE_CLAVE,whereArgs,null,null,null);
            if(cursor.getCount() == 1){
                cursor.moveToFirst();
                usuario = new UsuarioLocal();
                usuario.setUsuario(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_usuario)));
                usuario.setClave(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_clave)));
                usuario.setRol(cursor.getInt(cursor.getColumnIndex(SQLConstantes.usuario_local_rol)));
                usuario.setNro_local(cursor.getInt(cursor.getColumnIndex(SQLConstantes.usuario_local_nro_local)));
                usuario.setNombreLocal(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_nombreLocal)));
                usuario.setNaulas(cursor.getInt(cursor.getColumnIndex(SQLConstantes.usuario_local_naulas)));
                usuario.setNcontingencia(cursor.getInt(cursor.getColumnIndex(SQLConstantes.usuario_local_ncontingencia)));
                usuario.setCodsede(cursor.getInt(cursor.getColumnIndex(SQLConstantes.usuario_local_codsede)));
                usuario.setSede(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_sede)));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstantes.usuario_local_nombre)));
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return usuario;
    }

    public ArrayList<Caja> getAllCajasxSede(String idSede){
        ArrayList<Caja> cajas = new ArrayList<Caja>();
        String[] whereArgs = new String[]{idSede};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_ID_SEDE,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Caja caja =  new Caja();
                caja.setCod_barra_caja(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_cod_barra_caja)));
                caja.setIdnacional(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idnacional)));
                caja.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_ccdd)));
                caja.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_idsede)));
                caja.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idlocal)));
                caja.setNlado(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_nlado)));
                caja.setTipo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_tipo)));
                cajas.add(caja);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return cajas;
    }


    public LocalRes getLocalResumen(String idLocal){
        LocalRes localRes = null;
        Cursor cursor = null;
        int aplicacion;
        int adicionales;

        try{
            String[] whereArgs = new String[]{String.valueOf(idLocal),String.valueOf(1)};
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_ID_LOCAL + " AND " + SQLConstantes.WHERE_CLAUSE_CAJA_TIPO,whereArgs,null,null,null);
            aplicacion =  cursor.getCount();
        }finally{
            if(cursor != null) cursor.close();
        }

        try{
            String[] whereArgs = new String[]{String.valueOf(idLocal),String.valueOf(2)};
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_ID_LOCAL + " AND " + SQLConstantes.WHERE_CLAUSE_CAJA_TIPO,whereArgs,null,null,null);
            adicionales =  cursor.getCount();
        }finally{
            if(cursor != null) cursor.close();
        }

        try{
            if(cursor != null) cursor.close();
            String[] whereArgs = new String[]{String.valueOf(idLocal),String.valueOf(3)};
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_ID_LOCAL + " AND " + SQLConstantes.WHERE_CLAUSE_CAJA_TIPO,whereArgs,null,null,null);
            cursor.moveToFirst();
            localRes = new LocalRes(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_idsede)),
                    cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_ccdd)),
                    cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idlocal)),
                    cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_local)),
                    aplicacion,adicionales,1,0,0,0,0,0,0);
        }finally{
            if(cursor != null) cursor.close();
        }
        return localRes;
    }

    public ArrayList<Caja> getAllCajas(){
        ArrayList<Caja> cajas = new ArrayList<Caja>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, null,null,null,null,null);
            while (cursor.moveToNext()){
                Caja caja =  new Caja();
                caja.setCod_barra_caja(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_cod_barra_caja)));
                caja.setIdnacional(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idnacional)));
                caja.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_idsede)));
                caja.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idlocal)));
                caja.setTipo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_tipo)));
                caja.setNlado(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_nlado)));
                cajas.add(caja);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return cajas;
    }

    public ArrayList<Asistencia> getAllAsistencia(int idlocal){
        ArrayList<Asistencia>  asistencias = new ArrayList<Asistencia>();
        Cursor cursor = null;
        String[] whereArgs = new String[]{String.valueOf(idlocal)};
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablaasistencia, null, SQLConstantes.WHERE_CLAUSE_ID_LOCAL,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                Asistencia asistencia =  new Asistencia();
                asistencia.setDni(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_dni)));
                asistencia.setIdnacional(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_idnacional)));
                asistencia.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ccdd)));
                asistencia.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_idsede)));
                asistencia.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.asistencia_idlocal)));
                asistencia.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_nombres)));
                asistencia.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ape_paterno)));
                asistencia.setApe_materno(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_ape_materno)));
                asistencia.setPrioridad(cursor.getString(cursor.getColumnIndex(SQLConstantes.asistencia_prioridad)));
                asistencias.add(asistencia);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return asistencias;
    }

    public ArrayList<Inventario> getAllInventario(){
        ArrayList<Inventario>  inventarios = new ArrayList<Inventario>();
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablainventario, null, null,null,null,null,null);
            while (cursor.moveToNext()){
                Inventario inventario =  new Inventario();
                inventario.setCodigo(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_codigo)));
                inventario.setTipo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.inventario_tipo)));
                inventario.setIdnacional(cursor.getInt(cursor.getColumnIndex(SQLConstantes.inventario_idnacional)));
                inventario.setCcdd(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_ccdd)));
                inventario.setIdsede(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_idsede)));
                inventario.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.inventario_idlocal)));
                inventario.setDni(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_dni)));
                inventario.setNombres(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_nombres)));
                inventario.setApe_paterno(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_ape_paterno)));
                inventario.setApe_materno(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_ape_materno)));
                inventario.setNaula(cursor.getInt(cursor.getColumnIndex(SQLConstantes.inventario_naula)));
                inventario.setCodpagina(cursor.getString(cursor.getColumnIndex(SQLConstantes.inventario_codpagina)));
                inventarios.add(inventario);
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return inventarios;
    }


    public ArrayList<String> getIdsLocales(){
        ArrayList<String> locales = new ArrayList<>();
        String[] whereArgs = new String[]{String.valueOf(3)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_CAJA_TIPO,whereArgs,null,null,null);
            while (cursor.moveToNext()){
                locales.add(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idlocal))+"");
            }
        }finally{
            if(cursor != null) cursor.close();
        }
        return locales;
    }

    public int getNroCajasxSede(String idSede,int tipo){
        int numero = 0;
        String[] whereArgs = new String[]{idSede,String.valueOf(tipo)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_ID_SEDE + " AND " + SQLConstantes.WHERE_CLAUSE_CAJA_TIPO,whereArgs,null,null,null);
            numero = cursor.getCount();
        }finally{
            if(cursor != null) cursor.close();
        }
        return numero;
    }


    public void deleteAllElementosFromTabla(String nombreTabla){
        sqLiteDatabase.execSQL("delete from "+ nombreTabla);
    }

}
