
package entidades;

import java.time.LocalDateTime;


public class Cita {
    private int codigo;
    private Ciudadano persona;
    private int codigoRefuerzo;
    private LocalDateTime fechaHoraCita;
    private CentroSalud centroVacunacion;
    private LocalDateTime fechaHoraColoca;
    private Vacuna dosis;

    public Cita() {
    }

    public Cita(int codigo, Ciudadano persona, int codigoRefuerzo, LocalDateTime fechaHoraCita, CentroSalud centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna dosis) {
        this.codigo = codigo;
        this.persona = persona;
        this.codigoRefuerzo = codigoRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.dosis = dosis;
    }

    public Cita(Ciudadano persona, int codigoRefuerzo, LocalDateTime fechaHoraCita, CentroSalud centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna dosis) {
        this.persona = persona;
        this.codigoRefuerzo = codigoRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.dosis = dosis;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Ciudadano getPersona() {
        return persona;
    }

    public void setPersona(Ciudadano persona) {
        this.persona = persona;
    }

    public int getCodigoRefuerzo() {
        return codigoRefuerzo;
    }

    public void setCodigoRefuerzo(int codigoRefuerzo) {
        this.codigoRefuerzo = codigoRefuerzo;
    }

    public LocalDateTime getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(LocalDateTime fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public CentroSalud getCentroVacunacion() {
        return centroVacunacion;
    }

    public void setCentroVacunacion(CentroSalud centroVacunacion) {
        this.centroVacunacion = centroVacunacion;
    }

    public LocalDateTime getFechaHoraColoca() {
        return fechaHoraColoca;
    }

    public void setFechaHoraColoca(LocalDateTime fechaHoraColoca) {
        this.fechaHoraColoca = fechaHoraColoca;
    }

    public Vacuna getDosis() {
        return dosis;
    }

    public void setDosis(Vacuna dosis) {
        this.dosis = dosis;
    }

    @Override
    public String toString() {
        return codigo + "-" + persona + ", " + codigoRefuerzo + ", " + centroVacunacion;
    }
    
    
}
