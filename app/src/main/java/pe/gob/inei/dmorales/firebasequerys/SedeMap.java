package pe.gob.inei.dmorales.firebasequerys;

public class SedeMap {
    private int idsede;
    private String sede;

    public SedeMap(int idsede, String sede) {
        this.idsede = idsede;
        this.sede = sede;
    }

    public SedeMap() {
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
