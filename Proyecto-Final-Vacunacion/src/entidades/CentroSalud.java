package entidades;

public class CentroSalud {

    private int idCentro;
    private String nombre;
    private String direccion;
    private String zona;
    private Vacuna laboratorio;
    private int cantDosis;

    public CentroSalud() {
    }

    public CentroSalud(int idCentro, String nombre, String direccion, String zona, Vacuna laboratorio, int cantDosis) {
        this.idCentro = idCentro;
        this.nombre = nombre;
        this.direccion = direccion;
        this.zona = zona;
        this.laboratorio = laboratorio;
        this.cantDosis = cantDosis;
    }

    public CentroSalud(String nombre, String direccion, String zona, Vacuna laboratorio, int cantDosis) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.zona = zona;
        this.laboratorio = laboratorio;
        this.cantDosis = cantDosis;
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

    public Vacuna getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Vacuna laboratorio) {
        this.laboratorio = laboratorio;
    }

    public int getCantDosis() {
        return cantDosis;
    }

    public void setCantDosis(int cantDosis) {
        this.cantDosis = cantDosis;
    }

    @Override
    public String toString() {
        return "ID Centro de Salud :"+idCentro + " Nombre :"+ nombre;
    }

}
