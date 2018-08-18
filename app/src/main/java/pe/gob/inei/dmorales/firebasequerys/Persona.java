package pe.gob.inei.dmorales.firebasequerys;

public class Persona {
    private String dni;
    private String nombre;
    private int edad;
    private int dia;
    private int mes;
    private int anio;


    public Persona(String dni, String nombre, int edad, int dia, int mes, int anio) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    public Persona() {
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
