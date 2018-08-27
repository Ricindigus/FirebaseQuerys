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

    public ArrayList<Caja> getAllCajasxSede(int idSede){
        ArrayList<Caja> cajas = new ArrayList<Caja>();
        String[] whereArgs = new String[]{String.valueOf(idSede)};
        Cursor cursor = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_ID_SEDE,whereArgs,null,null,null);
            while(cursor.moveToNext()){
                Caja caja = new Caja();
                caja.set_id(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_id)));
                caja.setCod_barra_caja(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_cod_barra_caja)));
                caja.setIdsede(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idsede)));
                caja.setSede(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_sede)));
                caja.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idlocal)));
                caja.setLocal(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_local)));
                caja.setTipo(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_tipo)));
                caja.setAcl(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_acl)));
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
            localRes = new LocalRes(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idsede)),
                    cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_ccdd)),
                    cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idlocal)),
                    cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_local)),
                    aplicacion,adicionales,1,0,0,0,0,0,0);
        }finally{
            if(cursor != null) cursor.close();
        }
        return localRes;
    }

    public ArrayList<LocalRes> getAllCajasLocalResumen(int idLocal){
        ArrayList<LocalRes> localResArrayList = new ArrayList<LocalRes>();
        String[] whereArgs = new String[]{String.valueOf(idLocal),"1"};
        String[] whereArgs1 = new String[]{String.valueOf(idLocal),"2"};
        String[] whereArgs2 = new String[]{String.valueOf(idLocal),"3"};
        Cursor cursor = null;
        Cursor cursor1 = null;
        Cursor cursor2 = null;
        try{
            cursor = sqLiteDatabase.query(SQLConstantes.tablacajas, null, SQLConstantes.WHERE_CLAUSE_ID_LOCAL + " AND " + SQLConstantes.WHERE_CLAUSE_CAJA_TIPO,whereArgs,null,null,null);
            int aplicacion = cursor.getCount();
            cursor.moveToNext();
            LocalRes localRes = new LocalRes();
            localRes.setIdsede(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idsede)));
            localRes.setIdlocal(cursor.getInt(cursor.getColumnIndex(SQLConstantes.caja_idlocal)));
            localRes.setLocal(cursor.getString(cursor.getColumnIndex(SQLConstantes.caja_local)));
            localRes.setTotal_ap_imprenta(aplicacion);
            localResArrayList.add(localRes);
        }finally{
            if(cursor != null) cursor.close();
        }
        return localResArrayList;
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

    public int getNroCajasxSede(int idSede,int tipo){
        int numero = 0;
        String[] whereArgs = new String[]{String.valueOf(idSede),String.valueOf(tipo)};
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
