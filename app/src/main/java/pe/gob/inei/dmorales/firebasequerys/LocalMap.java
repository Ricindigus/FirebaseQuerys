package pe.gob.inei.dmorales.firebasequerys;

public class LocalMap {
    private int idlocal;
    private String local;

    public LocalMap(int idlocal, String local) {
        this.idlocal = idlocal;
        this.local = local;
    }

    public LocalMap() {
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
}
