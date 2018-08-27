package pe.gob.inei.dmorales.firebasequerys;

public class Local {
    private int idsede;
    private int idlocal;
    private String local;

    public Local(int idsede, int idlocal, String local) {
        this.idsede = idsede;
        this.idlocal = idlocal;
        this.local = local;
    }

    public Local() {
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

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
