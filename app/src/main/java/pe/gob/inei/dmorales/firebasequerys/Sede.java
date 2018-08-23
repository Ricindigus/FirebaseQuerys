package pe.gob.inei.dmorales.firebasequerys;

public class Sede {
    private int id_operativa;
    private int idsede;
    private String sede;

    public Sede(int id_operativa, int idsede, String sede) {
        this.id_operativa = id_operativa;
        this.idsede = idsede;
        this.sede = sede;
    }

    public Sede() {
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

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }
}
