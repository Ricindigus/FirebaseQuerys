package pe.gob.inei.dmorales.firebasequerys;

import java.util.HashMap;
import java.util.Map;

public class Asistencia {
    private String dni;
    private String idnacional;
    private String ccdd;
    private String idsede;
    private int idlocal;
    private int naula;
    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private String prioridad;

    public Asistencia(String dni, String idnacional, String ccdd, String idsede, int idlocal, int naula, String nombres, String ape_paterno, String ape_materno, String prioridad) {
        this.dni = dni;
        this.idnacional = idnacional;
        this.ccdd = ccdd;
        this.idsede = idsede;
        this.idlocal = idlocal;
        this.naula = naula;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.prioridad = prioridad;
    }

    public Asistencia() {
    }

    public int getNaula() {
        return naula;
    }

    public void setNaula(int naula) {
        this.naula = naula;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIdnacional() {
        return idnacional;
    }

    public void setIdnacional(String idnacional) {
        this.idnacional = idnacional;
    }

    public String getCcdd() {
        return ccdd;
    }

    public void setCcdd(String ccdd) {
        this.ccdd = ccdd;
    }

    public String getIdsede() {
        return idsede;
    }

    public void setIdsede(String idsede) {
        this.idsede = idsede;
    }

    public int getIdlocal() {
        return idlocal;
    }

    public void setIdlocal(int idlocal) {
        this.idlocal = idlocal;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> asistencia = new HashMap<>();
        asistencia.put("idnacional", idnacional);
        asistencia.put("ccdd", ccdd);
        asistencia.put("idsede", idsede);
        asistencia.put("idlocal", idlocal);
        asistencia.put("nombres", nombres);
        asistencia.put("ape_paterno", ape_paterno);
        asistencia.put("ape_materno", ape_materno);
        asistencia.put("prioridad", prioridad);
        asistencia.put("naula", naula);
        asistencia.put("check_registro_local", 0);
        asistencia.put("check_registro_aula", 0);
        return asistencia;
    }
}
