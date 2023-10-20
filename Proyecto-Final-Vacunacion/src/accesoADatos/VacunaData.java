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
        String sql = "INSERT INTO vacuna (cantidadDosis, marcaVacuna, laboratorio, medida, vencimiento, colocada, antigeno) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vacuna.getCantidadDosis());
            ps.setString(2, vacuna.getMarcaVacuna());
            ps.setString(3, vacuna.getLaboratorio());
            ps.setDouble(4, vacuna.getMedida());
            ps.setDate(5, Date.valueOf(vacuna.getVencimiento()));
            ps.setBoolean(6, false);
            ps.setString(7, vacuna.getAntigeno());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                vacuna.setLote(rs.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public Vacuna buscarVacuna(int lote) {
        String sql = "SELECT * FROM vacuna WHERE Lote=?";
        Vacuna vacuna = null;
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, lote);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacuna = new Vacuna();
                vacuna.setCantidadDosis(rs.getInt("cantidadDosis"));
                vacuna.setMarcaVacuna(rs.getString("marcaVacuna"));
                vacuna.setLaboratorio(rs.getString("laboratorio"));
                vacuna.setMedida(rs.getDouble("medida"));
                vacuna.setVencimiento(rs.getDate("vencimiento").toLocalDate());

                vacuna.setAntigeno(rs.getString("antigeno"));
                vacuna.setColocada(rs.getBoolean("colocada"));
            } else {
                JOptionPane.showMessageDialog(null, "No se encuenta una vacuna con ese numero de Lote.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return vacuna;
    }

    public Vacuna buscarVacunasPorLaboratorio(String nombreLaboratorio) {
        String sql = "SELECT * FROM vacuna WHERE laboratorio=?";
        PreparedStatement ps;
        Vacuna vacuna = new Vacuna();
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreLaboratorio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                vacuna.setCantidadDosis(rs.getInt("cantidadDosis"));
                vacuna.setMarcaVacuna(rs.getString("marcaVacuna"));
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
                vacuna.setCantidadDosis(rs.getInt("cantidadDosis"));
                vacuna.setMarcaVacuna(rs.getString("marcaVacuna"));
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

    public void modificarVacuna(Vacuna vacuna) {
        String sql = "UPDATE vacuna SET marcaVacuna=?, laboratorio=?, medida=?, vencimiento=?, antigeno=?, colocada=? WHERE lote=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, vacuna.getMarcaVacuna());
            ps.setString(2, vacuna.getLaboratorio());
            ps.setDouble(3, vacuna.getMedida());
            ps.setDate(4, Date.valueOf(vacuna.getVencimiento()));
            ps.setString(5, vacuna.getAntigeno());
            ps.setBoolean(6, vacuna.isColocada());
            ps.setInt(7, vacuna.getLote());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Vacuna modificada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna vacuna con el Lote especificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la vacuna: " + ex.getMessage());
        }
    }

    public void borrarVacuna(int lote) {
        String sql = "DELETE FROM vacuna WHERE lote=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, lote);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Vacuna con Lote " + lote + " eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna vacuna con el Lote especificado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la vacuna: " + ex.getMessage());
        }
    }

    public int contarVacunas() {
        String sql = "SELECT COUNT(*) AS total FROM vacuna";
        int totalVacunas = 0;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                totalVacunas = rs.getInt("total");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al contar las vacunas: " + ex.getMessage());
        }

        return totalVacunas;
    }
    
    



}
