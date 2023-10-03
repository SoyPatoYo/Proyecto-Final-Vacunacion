/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Matias
 */
public class Ciudadano {
    private int dni;
    private String nombre;
    private String apellido;
    private String zona;
    private String email;
    private int celular;
    private String patologia;
    private String ambitoTrabajo;
    private boolean covid;

    public Ciudadano() {
    }

    public Ciudadano(int dni, String nombre, String apellido, String zona, String email, int celular, String patologia, String ambitoTrabajo, boolean covid) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.zona = zona;
        this.email = email;
        this.celular = celular;
        this.patologia = patologia;
        this.ambitoTrabajo = ambitoTrabajo;
        this.covid = covid;
    }

    public Ciudadano(int dni, String nombre, String apellido, String zona, String email, int celular, String ambitoTrabajo, boolean covid) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.zona = zona;
        this.email = email;
        this.celular = celular;
        this.ambitoTrabajo = ambitoTrabajo;
        this.covid = covid;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getAmbitoTrabajo() {
        return ambitoTrabajo;
    }

    public void setAmbitoTrabajo(String ambitoTrabajo) {
        this.ambitoTrabajo = ambitoTrabajo;
    }

    public boolean isCovid() {
        return covid;
    }

    public void setCovid(boolean covid) {
        this.covid = covid;
    }

    @Override
    public String toString() {
        return dni + "-" + nombre + ", " + apellido;
    }
    
    
}
