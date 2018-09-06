package pe.gob.inei.dmorales.firebasequerys;

import java.util.HashMap;
import java.util.Map;

public class Inventario {
    private String codigo;
    private int tipo;
    private int idnacional;
    private String ccdd;
    private String idsede;
    private int idlocal;
    private String dni;
    private String nombres;
    private String ape_paterno;
    private String ape_materno;
    private int naula;
    private String codpagina;

    public Inventario(String codigo, int tipo, int idnacional, String ccdd, String idsede, int idlocal, String dni, String nombres, String ape_paterno, String ape_materno, int naula, String codpagina) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.idnacional = idnacional;
        this.ccdd = ccdd;
        this.idsede = idsede;
        this.idlocal = idlocal;
        this.dni = dni;
        this.nombres = nombres;
        this.ape_paterno = ape_paterno;
        this.ape_materno = ape_materno;
        this.naula = naula;
        this.codpagina = codpagina;
    }

    public Inventario() {
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdnacional() {
        return idnacional;
    }

    public void setIdnacional(int idnacional) {
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public int getNaula() {
        return naula;
    }

    public void setNaula(int naula) {
        this.naula = naula;
    }

    public String getCodpagina() {
        return codpagina;
    }

    public void setCodpagina(String codpagina) {
        this.codpagina = codpagina;
    }

    public Map<String, Object> toMap(){
        Map<String, Object> inventario = new HashMap<>();
        inventario.put("idnacional", idnacional);
        inventario.put("ccdd", ccdd);
        inventario.put("idsede", idsede);
        inventario.put("idlocal", idlocal);
        inventario.put("naula", naula);
        inventario.put("dni", dni);
        inventario.put("nombres", nombres);
        inventario.put("ape_paterno", ape_paterno);
        inventario.put("ape_materno", ape_materno);
        inventario.put("tipo", tipo);
        inventario.put("check_registro", 0);
        return inventario;
    }
}
