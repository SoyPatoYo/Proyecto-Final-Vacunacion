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
public class CentroSalud {
    private int idCentro;
    private String nombre;
    private String direccion;
    private String zona;
    private Vacuna provedor;

    public CentroSalud() {
    }

    public CentroSalud(int idCentro, String nombre, String direccion, String zona, Vacuna provedor) {
        this.idCentro = idCentro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.zona = zona;
        this.provedor = provedor;
    }

    public CentroSalud(String nombre, String direccion, String zona, Vacuna provedor) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.zona = zona;
        this.provedor = provedor;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Vacuna getProvedor() {
        return provedor;
    }

    public void setProvedor(Vacuna provedor) {
        this.provedor = provedor;
    }

    
    @Override
    public String toString() {
        return nombre;
    }
    
    
}
