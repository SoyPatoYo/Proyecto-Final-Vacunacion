package accesoADatos;

import entidades.Vacuna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class VacunaData {

    private Connection conexion = null;

    public VacunaData() {
        conexion = Conexion.buscarConexion();
    }

    public void guardarVacuna(Vacuna vacuna) {
        String sql = "INSERT INTO vacuna VALUES (null,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, vacuna.getMarca());
            ps.setString(2, vacuna.getLaboratorio());
            ps.setDouble(3, vacuna.getMedida());
            ps.setDate(4, Date.valueOf(vacuna.getVencimiento()));
            ps.setBoolean(5, false);
            ps.setString(6, vacuna.getAntigeno());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                vacuna.setIdDosis(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Vacuna registrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public Vacuna buscarVacuna(int idDosis) {
        String sql = "SELECT * FROM vacuna WHERE idDosis=?";
        Vacuna vacuna = null;
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDosis);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacuna = new Vacuna();
                vacuna.setIdDosis(rs.getInt("idDosis"));
                vacuna.setMarca(rs.getString("marca"));
                vacuna.setLaboratorio(rs.getString("laboratorio"));
                vacuna.setMedida(rs.getDouble("medida"));
                vacuna.setVencimiento(rs.getDate("vencimiento").toLocalDate());
                vacuna.setAntigeno(rs.getString("antigeno"));
                vacuna.setColocada(rs.getBoolean("colocada"));
            }else{
                JOptionPane.showMessageDialog(null, "No se encuenta una vacuna con ese ID.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return vacuna;
    }
    
    public Vacuna buscarVacunasPorLaboratorio(String nombreLaboratorio) {
    String sql = "SELECT * FROM vacuna WHERE laboratorio=?";
    PreparedStatement ps;
    Vacuna vacuna= new Vacuna();
    try {
        ps = conexion.prepareStatement(sql);
        ps.setString(1, nombreLaboratorio);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            vacuna.setIdDosis(rs.getInt("idDosis"));
            vacuna.setMarca(rs.getString("marca"));
            vacuna.setLaboratorio(rs.getString("laboratorio"));
            vacuna.setMedida(rs.getDouble("medida"));
            vacuna.setVencimiento(rs.getDate("vencimiento").toLocalDate());
            vacuna.setAntigeno(rs.getString("antigeno"));
            vacuna.setColocada(rs.getBoolean("colocada"));
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
    return vacuna;
}


    public List<Vacuna> buscarVacunas() {
        List<Vacuna> vacunas = new ArrayList<>();
        String sql = "SELECT * FROM vacuna";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Vacuna vacuna = new Vacuna();
                vacuna.setIdDosis(rs.getInt("idDosis"));
                vacuna.setMarca(rs.getString("marca"));
                vacuna.setLaboratorio(rs.getString("laboratorio"));
                vacuna.setMedida(rs.getDouble("medida"));
                vacuna.setVencimiento(rs.getDate("vencimiento").toLocalDate());
                vacuna.setAntigeno(rs.getString("antigeno"));
                vacuna.setColocada(rs.getBoolean("colocada"));

                vacunas.add(vacuna);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        return vacunas;
    }

    public void modificarVacuna(int idDosis) {
        String sql = "UPDATE vacuna SET marca=?, laboratorio=?, medida=?, vencimiento=?, antigeno=?, colocada=? WHERE idDosis=?";
        Vacuna vacuna = new Vacuna();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, vacuna.getMarca());
            ps.setString(2, vacuna.getLaboratorio());
            ps.setDouble(3, vacuna.getMedida());
            ps.setDate(4, Date.valueOf(vacuna.getVencimiento()));
            ps.setString(5, vacuna.getAntigeno());
            ps.setBoolean(6, vacuna.isColocada());
            ps.setInt(7, idDosis);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Vacuna modificada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna vacuna con el ID especificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la vacuna: " + ex.getMessage());
        }
    }

}
