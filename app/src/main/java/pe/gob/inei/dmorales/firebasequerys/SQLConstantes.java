package pe.gob.inei.dmorales.firebasequerys;

public class SQLConstantes {
    public static String DB_PATH = "/data/data/pe.gob.inei.dmorales.firebasequerys/databases/";
    public static String DB_NAME = "mydatabase.sqlite";

    public static String tablacajas = "cajas";
    public static String tablaasistencia = "asistencia";
    public static String tablainventario = "inventario";

    public static String tablausuariolocal = "usuario_local";

    //TABLA USUARIO LOCAL
    public static String usuario_local_id = "_id";
    public static String usuario_local_usuario = "usuario";
    public static String usuario_local_clave = "clave";
    public static String usuario_local_rol = "rol";
    public static String usuario_local_nro_local = "nro_local";
    public static String usuario_local_nombreLocal = "nombreLocal";
    public static String usuario_local_naulas = "naulas";
    public static String usuario_local_ncontingencia = "ncontingencia";
    public static String usuario_local_codsede = "codsede";
    public static String usuario_local_sede = "sede";
    public static String usuario_local_nombre = "nombre";

    //TABLA CAJAS
    public static String caja_id = "_id";
    public static String caja_cod_barra_caja = "cod_barra_caja";
    public static String caja_idnacional = "idnacional";
    public static String caja_ccdd = "ccdd";
    public static String caja_departamento = "departamento";
    public static String caja_idsede = "idsede";
    public static String caja_sede = "sede";
    public static String caja_idlocal = "idlocal";
    public static String caja_local = "local";
    public static String caja_tipo= "tipo";
    public static String caja_nlado = "nlado";
    public static String caja_acl = "acl";



    public static String asistencia_dni = "dni";
    public static String asistencia_idnacional = "idnacional";
    public static String asistencia_ccdd = "ccdd";
    public static String asistencia_idsede = "idsede";
    public static String asistencia_idlocal = "idlocal";
    public static String asistencia_nombres = "nombres";
    public static String asistencia_ape_paterno = "ape_paterno";
    public static String asistencia_ape_materno = "ape_materno";
    public static String asistencia_prioridad = "prioridad";
    public static String asistencia_naula = "naula";



    public static String inventario_codigo = "codigo";
    public static String inventario_tipo = "tipo";
    public static String inventario_idnacional = "idnacional";
    public static String inventario_ccdd = "ccdd";
    public static String inventario_idsede = "idsede";
    public static String inventario_idlocal = "idlocal";
    public static String inventario_dni = "dni";
    public static String inventario_nombres = "nombres";
    public static String inventario_ape_paterno = "ape_paterno";
    public static String inventario_ape_materno = "ape_materno";
    public static String inventario_naula = "naula";
    public static String inventario_codpagina = "codpagina";

    //CLAUSULA WHERE
    public static final String WHERE_CLAUSE_ID = "_id=?";
    public static final String WHERE_CLAUSE_COD_BARRA = "cod_barra_caja=?";
    public static final String WHERE_CLAUSE_CLAVE = "clave=?";
    public static final String WHERE_CLAUSE_ID_SEDE = "idsede=?";
    public static final String WHERE_CLAUSE_ID_LOCAL = "idlocal=?";
    public static final String WHERE_CLAUSE_CAJA_TIPO = "tipo=?";


}
