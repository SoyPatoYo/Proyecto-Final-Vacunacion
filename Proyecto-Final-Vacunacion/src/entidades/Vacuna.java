
package entidades;

import java.sql.Date;


public class Vacuna {
    private int numSerie;
    private String marca;
    private String laboratorio;
    private double medida;
    private Date vencimiento;
    private boolean colocada;
    private String antigeno;

    public Vacuna() {
    }

    public Vacuna(int numSerie, String marca, String laboratorio, double medida, Date vencimiento, boolean colocada, String antigeno) {
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

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
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
