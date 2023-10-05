package entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Vacuna {

    private int idDosis;
    private String marca;
    private String laboratorio;
    private double medida;
    private LocalDate vencimiento;
    private boolean colocada;
    private String antigeno;

    public Vacuna() {
    }

    public Vacuna(int idDosis, String marca, String laboratorio, double medida, LocalDate vencimiento, boolean colocada, String antigeno) {
        this.idDosis = idDosis;
        this.marca = marca;
        this.laboratorio = laboratorio;
        this.medida = medida;
        this.vencimiento = vencimiento;
        this.colocada = colocada;
        this.antigeno = antigeno;
    }

    public Vacuna(String marca, String laboratorio, double medida, LocalDate vencimiento, String antigeno) {
        this.marca = marca;
        this.laboratorio = laboratorio;
        this.medida = medida;
        this.vencimiento = vencimiento;
        this.colocada=false;
        this.antigeno = antigeno;
    }

    public int getIdDosis() {
        return idDosis;
    }

    public void setIdDosis(int idDosis) {
        this.idDosis = idDosis;
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
        return idDosis + "-" + marca;
    }

}
