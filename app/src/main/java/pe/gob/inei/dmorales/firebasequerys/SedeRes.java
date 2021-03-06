package pe.gob.inei.dmorales.firebasequerys;

public class SedeRes {
    private String idsede;
    private String sede;
    private int total_ap_imprenta;
    private int total_ad_imprenta;
    private int total_cand_imprenta;
    private int avance_ap_ingreso;
    private int avance_ad_ingreso;
    private int avance_cand_ingreso;
    private int avance_ap_salida;
    private int avance_ad_salida;
    private int avance_cand_salida;

    public SedeRes(String idsede, String sede, int total_ap_imprenta, int total_ad_imprenta, int total_cand_imprenta, int avance_ap_ingreso, int avance_ad_ingreso, int avance_cand_ingreso, int avance_ap_salida, int avance_ad_salida, int avance_cand_salida) {
        this.idsede = idsede;
        this.sede = sede;
        this.total_ap_imprenta = total_ap_imprenta;
        this.total_ad_imprenta = total_ad_imprenta;
        this.total_cand_imprenta = total_cand_imprenta;
        this.avance_ap_ingreso = avance_ap_ingreso;
        this.avance_ad_ingreso = avance_ad_ingreso;
        this.avance_cand_ingreso = avance_cand_ingreso;
        this.avance_ap_salida = avance_ap_salida;
        this.avance_ad_salida = avance_ad_salida;
        this.avance_cand_salida = avance_cand_salida;
    }

    public SedeRes() {
    }

    public String getIdsede() {
        return idsede;
    }

    public void setIdsede(String idsede) {
        this.idsede = idsede;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getTotal_ap_imprenta() {
        return total_ap_imprenta;
    }

    public void setTotal_ap_imprenta(int total_ap_imprenta) {
        this.total_ap_imprenta = total_ap_imprenta;
    }

    public int getTotal_ad_imprenta() {
        return total_ad_imprenta;
    }

    public void setTotal_ad_imprenta(int total_ad_imprenta) {
        this.total_ad_imprenta = total_ad_imprenta;
    }

    public int getTotal_cand_imprenta() {
        return total_cand_imprenta;
    }

    public void setTotal_cand_imprenta(int total_cand_imprenta) {
        this.total_cand_imprenta = total_cand_imprenta;
    }

    public int getAvance_ap_ingreso() {
        return avance_ap_ingreso;
    }

    public void setAvance_ap_ingreso(int avance_ap_ingreso) {
        this.avance_ap_ingreso = avance_ap_ingreso;
    }

    public int getAvance_ad_ingreso() {
        return avance_ad_ingreso;
    }

    public void setAvance_ad_ingreso(int avance_ad_ingreso) {
        this.avance_ad_ingreso = avance_ad_ingreso;
    }

    public int getAvance_cand_ingreso() {
        return avance_cand_ingreso;
    }

    public void setAvance_cand_ingreso(int avance_cand_ingreso) {
        this.avance_cand_ingreso = avance_cand_ingreso;
    }

    public int getAvance_ap_salida() {
        return avance_ap_salida;
    }

    public void setAvance_ap_salida(int avance_ap_salida) {
        this.avance_ap_salida = avance_ap_salida;
    }

    public int getAvance_ad_salida() {
        return avance_ad_salida;
    }

    public void setAvance_ad_salida(int avance_ad_salida) {
        this.avance_ad_salida = avance_ad_salida;
    }

    public int getAvance_cand_salida() {
        return avance_cand_salida;
    }

    public void setAvance_cand_salida(int avance_cand_salida) {
        this.avance_cand_salida = avance_cand_salida;
    }
}
