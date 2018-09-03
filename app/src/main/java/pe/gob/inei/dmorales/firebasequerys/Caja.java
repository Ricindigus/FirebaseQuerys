package pe.gob.inei.dmorales.firebasequerys;

import java.util.HashMap;
import java.util.Map;

public class Caja {
    private String cod_barra_caja;
    private int idnacional;
    private String ccdd;
    private String idsede;
    private int idlocal;
    private int tipo;
    private int nlado;
    private int check_reg_ingreso;
    private int check_reg_salida;


    public Caja(String cod_barra_caja, int idnacional, String ccdd, String idsede, int idlocal, int tipo, int nlado, int check_reg_ingreso, int check_reg_salida) {
        this.cod_barra_caja = cod_barra_caja;
        this.idnacional = idnacional;
        this.ccdd = ccdd;
        this.idsede = idsede;
        this.idlocal = idlocal;
        this.tipo = tipo;
        this.nlado = nlado;
        this.check_reg_ingreso = check_reg_ingreso;
        this.check_reg_salida = check_reg_salida;
    }

    public Caja() {
    }


    public int getNlado() {
        return nlado;
    }

    public void setNlado(int nlado) {
        this.nlado = nlado;
    }

    public String getIdsede() {
        return idsede;
    }

    public String getCcdd() {
        return ccdd;
    }

    public void setCcdd(String ccdd) {
        this.ccdd = ccdd;
    }

    public void setIdsede(String idsede) {
        this.idsede = idsede;
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


    public Map<String, Object> toMap(){
        Map<String, Object> caja = new HashMap<>();
        caja.put("idnacional", idnacional);
        caja.put("ccdd", ccdd);
        caja.put("idsede", idsede);
        caja.put("idlocal", idlocal);
        caja.put("tipo", tipo);
        caja.put("nlado", nlado);
        caja.put("check_reg_ingreso", 0);
        caja.put("check_reg_salida", 0);
        return caja;
    }
}
