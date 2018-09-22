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
    public static String cajas_id = "_id";
    public static String cajas_cod_barra = "cod_barra_caja";
    public static String cajas_ccdd = "ccdd";
    public static String cajas_departamento = "departamento";
    public static String cajas_idnacional = "idnacional";
    public static String cajas_idsede = "idsede";
    public static String cajas_nom_sede = "nom_sede";
    public static String cajas_idlocal = "idlocal";
    public static String cajas_nom_local = "nom_local";
    public static String cajas_tipo = "tipo";
    public static String cajas_nlado = "nlado";
    public static String cajas_acl = "acl";
    public static String cajas_direccion = "direccion";


    //TABLA ASISTENCIA
    public static String asistencia_id = "_id";
    public static String asistencia_dni = "dni";
    public static String asistencia_nombres = "nombres";
    public static String asistencia_ape_paterno = "ape_paterno";
    public static String asistencia_ape_materno = "ape_materno";
    public static String asistencia_naula = "naula";
    public static String asistencia_discapacidad = "discapacidad";
    public static String asistencia_prioridad = "prioridad";
    public static String asistencia_idnacional = "idnacional";
    public static String asistencia_idsede = "idsede";
    public static String asistencia_nom_sede = "nom_sede";
    public static String asistencia_ccdd = "ccdd";
    public static String asistencia_departamento = "departamento";
    public static String asistencia_idlocal = "idlocal";
    public static String asistencia_nom_local = "nom_local";
    public static String asistencia_direccion = "direccion";

    //TABLA INVENTARIO
    public static String inventario_id = "_id";
    public static String inventario_codigo = "codigo";
    public static String inventario_tipo = "tipo";
    public static String inventario_ccdd = "ccdd";
    public static String inventario_departamento = "departamento";
    public static String inventario_idnacional = "idnacional";
    public static String inventario_idsede = "idsede";
    public static String inventario_nom_sede = "nom_sede";
    public static String inventario_idlocal = "idlocal";
    public static String inventario_nom_local = "nom_local";
    public static String inventario_dni = "dni";
    public static String inventario_ape_paterno = "ape_paterno";
    public static String inventario_ape_materno = "ape_materno";
    public static String inventario_nombres = "nombres";
    public static String inventario_naula = "naula";
    public static String inventario_codpagina = "codpagina";
    public static String inventario_direccion = "direccion";

    //CLAUSULA WHERE
    public static final String WHERE_CLAUSE_ID = "_id=?";
    public static final String WHERE_CLAUSE_COD_BARRA = "cod_barra_caja=?";
    public static final String WHERE_CLAUSE_CLAVE = "clave=?";
    public static final String WHERE_CLAUSE_ID_SEDE = "idsede=?";
    public static final String WHERE_CLAUSE_ID_LOCAL = "idlocal=?";
    public static final String WHERE_CLAUSE_CAJA_TIPO = "tipo=?";
    public static final String WHERE_CLAUSE_CAJA_NLADO = "nlado=?";



}
