package entidades;

import java.time.LocalDate;

public class Vacuna {
    private int lote;
    private int cantidadDosis;
    private String marcaVacuna;
    private String laboratorio;
    private double medida;
    private LocalDate vencimiento;
    private boolean colocada;
    private String antigeno;

    public Vacuna() {
    }

    public Vacuna(int cantidadDosis, String marcaVacuna, String laboratorio, double medida, LocalDate vencimiento, String antigeno) {
        this.cantidadDosis = cantidadDosis;
        this.marcaVacuna = marcaVacuna;
        this.laboratorio = laboratorio;
        this.medida = medida;
        this.vencimiento = vencimiento;
        this.antigeno = antigeno;
    }

    public Vacuna(int lote, int cantidadDosis, String marcaVacuna, String laboratorio, double medida, LocalDate vencimiento, boolean colocada, String antigeno) {
        this.lote = lote;
        this.cantidadDosis = cantidadDosis;
        this.marcaVacuna = marcaVacuna;
        this.laboratorio = laboratorio;
        this.medida = medida;
        this.vencimiento = vencimiento;
        this.colocada = colocada;
        this.antigeno = antigeno;
    }

    public int getLote() {
        return lote;
    }

    public void setLote(int lote) {
        this.lote = lote;
    }

   

    public int getCantidadDosis() {
        return cantidadDosis;
    }

    public void setCantidadDosis(int cantidadDosis) {
        this.cantidadDosis = cantidadDosis;
    }

    public String getMarcaVacuna() {
        return marcaVacuna;
    }

    public void setMarcaVacuna(String marcaVacuna) {
        this.marcaVacuna = marcaVacuna;
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
        return cantidadDosis + "-" + marcaVacuna;
    }

}
