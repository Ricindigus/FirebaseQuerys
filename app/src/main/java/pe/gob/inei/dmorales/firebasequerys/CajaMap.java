package pe.gob.inei.dmorales.firebasequerys;

public class CajaMap {
    private int tipo;
    private int check_reg_ingreso;
    private int check_reg_salida;


    public CajaMap(int tipo, int check_reg_ingreso, int check_reg_salida) {
        this.tipo = tipo;
        this.check_reg_ingreso = check_reg_ingreso;
        this.check_reg_salida = check_reg_salida;
    }

    public CajaMap() {
    }

    public int getCheck_reg_salida() {
        return check_reg_salida;
    }

    public void setCheck_reg_salida(int check_reg_salida) {
        this.check_reg_salida = check_reg_salida;
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
