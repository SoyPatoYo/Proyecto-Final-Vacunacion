
package entidades;

import java.time.LocalDateTime;


public class Cita {
    private int codigo;
    private Ciudadano persona;
    private int cantRefuerzo;
    private LocalDateTime fechaHoraCita;
    private CentroSalud centroVacunacion;
    private LocalDateTime fechaHoraColoca;
    private Vacuna loteDosis;
    private boolean estado;
    private boolean colocada;

    public Cita() {
    }

    public Cita(int codigo, Ciudadano persona, int cantRefuerzo, LocalDateTime fechaHoraCita, CentroSalud centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna loteDosis, boolean estado, boolean colocada) {
        this.codigo = codigo;
        this.persona = persona;
        this.cantRefuerzo = cantRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.loteDosis = loteDosis;
        this.estado = estado;
        this.colocada = colocada;
    }

    public Cita(Ciudadano persona, int cantRefuerzo, LocalDateTime fechaHoraCita, CentroSalud centroVacunacion, Vacuna loteDosis, boolean estado, boolean colocada) {
        this.persona = persona;
        this.cantRefuerzo = cantRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.loteDosis = loteDosis;
        this.estado = estado;
        this.colocada = colocada;
    }
    
    

    public Cita(Ciudadano persona, int cantRefuerzo, LocalDateTime fechaHoraCita, CentroSalud centroVacunacion, LocalDateTime fechaHoraColoca, Vacuna loteDosis, boolean estado, boolean colocada) {
        this.persona = persona;
        this.cantRefuerzo = cantRefuerzo;
        this.fechaHoraCita = fechaHoraCita;
        this.centroVacunacion = centroVacunacion;
        this.fechaHoraColoca = fechaHoraColoca;
        this.loteDosis = loteDosis;
        this.estado = estado;
        this.colocada = colocada;
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

    public int getCantRefuerzo() {
        return cantRefuerzo;
    }

    public void setCantRefuerzo(int cantRefuerzo) {
        this.cantRefuerzo = cantRefuerzo;
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

    public Vacuna getLoteDosis() {
        return loteDosis;
    }

    public void setLoteDosis(Vacuna loteDosis) {
        this.loteDosis = loteDosis;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isColocada() {
        return colocada;
    }

    public void setColocada(boolean colocada) {
        this.colocada = colocada;
    }
    
    

    @Override
    public String toString() {
        return codigo + "-" + persona + ", " + cantRefuerzo + ", " + centroVacunacion;
    }
    
    
}
