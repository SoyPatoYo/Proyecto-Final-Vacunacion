package accesoADatos;

import entidades.CentroSalud;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CentroSaludData {

    private Connection conexion = null;

    public CentroSaludData() {
        conexion = Conexion.buscarConexion();
    }
    
    VacunaData vd=new VacunaData();

    public void guardarCentroSalud(CentroSalud centro) {
        String sql = "INSERT INTO centrosalud VALUES (null,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, centro.getNombre());
            ps.setString(2, centro.getDireccion());
            ps.setString(3, centro.getZona());
            ps.setString(4, centro.getLaboratorio().getLaboratorio());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                centro.setIdCentro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Centro de Salud registrado.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public void modificarCentroSalud(CentroSalud centro) {
        String sql = "UPDATE centrosalud SET nombre=?, direccion=?, zona=?, laboratorio=? WHERE idCentro=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, centro.getNombre());
            ps.setString(2, centro.getDireccion());
            ps.setString(3, centro.getZona());
            ps.setString(4, centro.getLaboratorio().getLaboratorio());
            ps.setInt(5, centro.getIdCentro()); // Usamos el ID para identificar el centro a modificar
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Centro de Salud modificado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el centro de salud con ID: " + centro.getIdCentro());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public CentroSalud buscarCentroSaludPorID(int idCentro) {
        String sql = "SELECT * FROM centrosalud WHERE idCentro=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCentro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                CentroSalud centro = new CentroSalud();
                centro.setIdCentro(rs.getInt("idCentro"));
                centro.setNombre(rs.getString("nombre"));
                centro.setDireccion(rs.getString("direccion"));
                centro.setZona(rs.getString("zona"));
                centro.setLaboratorio(vd.buscarVacunasPorLaboratorio(rs.getString("laboratorio")));
                return centro;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el centro de salud con ID: " + idCentro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return null;
    }

    public List<CentroSalud> listarCentrosSalud() {
        List<CentroSalud> centros = new ArrayList<>();
        String sql = "SELECT * FROM centrosalud";
        
        try {
            Statement statement = conexion.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                CentroSalud centro = new CentroSalud();
                centro.setIdCentro(rs.getInt("idCentro"));
                centro.setNombre(rs.getString("nombre"));
                centro.setDireccion(rs.getString("direccion"));
                centro.setZona(rs.getString("zona"));
                centro.setLaboratorio(vd.buscarVacunasPorLaboratorio(rs.getString("laboratorio")));
                centros.add(centro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return centros;
    }

}
