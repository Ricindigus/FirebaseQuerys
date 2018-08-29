package pe.gob.inei.dmorales.firebasequerys;

public class Caja {
    private String cod_barra_caja;
    private int idnacional;
    private int ccdd;
    private int idsede;
    private int idlocal;
    private int tipo;
    private int check_reg_ingreso;
    private int check_reg_salida;


    public Caja(String cod_barra_caja, int idnacional, int ccdd, int idsede, int idlocal, int tipo) {
        this.cod_barra_caja = cod_barra_caja;
        this.idnacional = idnacional;
        this.ccdd = ccdd;
        this.idsede = idsede;
        this.idlocal = idlocal;
        this.tipo = tipo;
        this.check_reg_ingreso = 0;
        this.check_reg_salida = 0;
    }

    public Caja() {
    }


    public int getCcdd() {
        return ccdd;
    }

    public void setCcdd(int ccdd) {
        this.ccdd = ccdd;
    }

    public int getCheck_reg_ingreso() {
        return check_reg_ingreso;
    }

    public void setCheck_reg_ingreso(int check_reg_ingreso) {
        this.check_reg_ingreso = check_reg_ingreso;
    }

    public int getCheck_reg_salida() {
        return check_reg_salida;
    }

    public void setCheck_reg_salida(int check_reg_salida) {
        this.check_reg_salida = check_reg_salida;
    }

    public String getCod_barra_caja() {
        return cod_barra_caja;
    }

    public void setCod_barra_caja(String cod_barra_caja) {
        this.cod_barra_caja = cod_barra_caja;
    }

    public int getIdnacional() {
        return idnacional;
    }

    public void setIdnacional(int idnacional) {
        this.idnacional = idnacional;
    }

    public int getIdsede() {
        return idsede;
    }

    public void setIdsede(int idsede) {
        this.idsede = idsede;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
