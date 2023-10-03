/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author Matias
 */
public class Vacuna {
    private int numSerie;
    private String marca;
    private String laboratorio;
    private double medida;
    private LocalDate vencimiento;
    private boolean colocada;
    private String antigeno;

    public Vacuna() {
    }

    public Vacuna(int numSerie, String marca, String laboratorio, double medida, LocalDate vencimiento, boolean colocada, String antigeno) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.laboratorio = laboratorio;
        this.medida = medida;
        this.vencimiento = vencimiento;
        this.colocada = colocada;
        this.antigeno = antigeno;
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public double getMedida() {
        return medida;
    }

    public void setMedida(double medida) {
        this.medida = medida;
    }

    public LocalDate getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(LocalDate vencimiento) {
        this.vencimiento = vencimiento;
    }

    public boolean isColocada() {
        return colocada;
    }

    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }

    public String getAntigeno() {
        return antigeno;
    }

    public void setAntigeno(String antigeno) {
        this.antigeno = antigeno;
    }

    @Override
    public String toString() {
        return numSerie + "-" + marca;
    }
    
    
    
}
