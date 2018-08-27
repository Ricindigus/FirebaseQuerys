package pe.gob.inei.dmorales.firebasequerys;

public class Caja {
    private int _id;
    private String cod_barra_caja;
    private int idsede;
    private String sede;
    private int idlocal;
    private String local;
    private int tipo;
    private int acl;

    public Caja(int _id, String cod_barra_caja, int idsede, String sede, int idlocal, String local, int tipo, int acl) {
        this._id = _id;
        this.cod_barra_caja = cod_barra_caja;
        this.idsede = idsede;
        this.sede = sede;
        this.idlocal = idlocal;
        this.local = local;
        this.tipo = tipo;
        this.acl = acl;
    }

    public Caja() {
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getCod_barra_caja() {
        return cod_barra_caja;
    }

    public void setCod_barra_caja(String cod_barra_caja) {
        this.cod_barra_caja = cod_barra_caja;
    }


    public int getIdsede() {
        return idsede;
    }

    public void setIdsede(int idsede) {
        this.idsede = idsede;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getAcl() {
        return acl;
    }

    public void setAcl(int acl) {
        this.acl = acl;
    }
}
