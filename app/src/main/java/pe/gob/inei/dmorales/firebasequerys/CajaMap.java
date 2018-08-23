package pe.gob.inei.dmorales.firebasequerys;

public class CajaMap {
    private int cod_barra_caja;
    private int tipo;
    private int check_reg_ingreso;

    public CajaMap(int cod_barra_caja, int tipo, int check_reg_ingreso) {
        this.cod_barra_caja = cod_barra_caja;
        this.tipo = tipo;
        this.check_reg_ingreso = check_reg_ingreso;
    }

    public CajaMap() {
    }

    public int getCod_barra_caja() {
        return cod_barra_caja;
    }

    public void setCod_barra_caja(int cod_barra_caja) {
        this.cod_barra_caja = cod_barra_caja;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getCheck_reg_ingreso() {
        return check_reg_ingreso;
    }

    public void setCheck_reg_ingreso(int check_reg_ingreso) {
        this.check_reg_ingreso = check_reg_ingreso;
    }
}
