package pe.gob.inei.dmorales.firebasequerys;

public class Local {
    private int id_operativa;
    private int idsede;
    private int idlocal;
    private String local;

    public Local(int id_operativa, int idsede, int idlocal, String local) {
        this.id_operativa = id_operativa;
        this.idsede = idsede;
        this.idlocal = idlocal;
        this.local = local;
    }

    public Local() {
    }

    public int getId_operativa() {
        return id_operativa;
    }

    public void setId_operativa(int id_operativa) {
        this.id_operativa = id_operativa;
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
