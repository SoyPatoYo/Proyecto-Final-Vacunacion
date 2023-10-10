package accesoADatos;

import entidades.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class CitaData {

    private Connection conexion = null;

    public CitaData() {
        conexion = Conexion.buscarConexion();
    }
    CiudadanoData cd = new CiudadanoData();
    CentroSaludData csd = new CentroSaludData();
    VacunaData vd = new VacunaData();

    public void guardarCita(Cita cita) {
        String sql = "INSERT INTO cita VALUES (null,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cita.getPersona().getIdCiudadano());
            ps.setInt(2, cita.getCodigoRefuerzo());
            ps.setTimestamp(3, Timestamp.valueOf(cita.getFechaHoraCita()));//al parecer anda.
            ps.setInt(4, cita.getCentroVacunacion().getIdCentro());
            ps.setTimestamp(5, Timestamp.valueOf(cita.getFechaHoraColoca()));//este tambien
            ps.setInt(6, cita.getDosis().getIdDosis());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cita.setCodigo(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cita registrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public Cita buscarCita(int codigo) {
        String sql = "SELECT * FROM cita WHERE codigo=?";
        Cita cita = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cita = new Cita();
                cita.setCodigo(codigo);
                cita.setPersona(cd.buscarCiudadanoPorId(rs.getInt("persona")));
                cita.setCodigoRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getTimestamp("fechahoraCita").toLocalDateTime());
                cita.setCentroVacunacion(csd.buscarCentroSaludPorID(rs.getInt("centroVacunacion")));
                cita.setFechaHoraColoca(rs.getTimestamp("fechahoraColoca").toLocalDateTime());
                cita.setDosis(vd.buscarVacuna(rs.getInt("dosis")));
            } else {
                JOptionPane.showMessageDialog(null, "No se encuenta una Cita con ese codigo.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return cita;
    }

    public void modificarCita(Cita cita) {
        String sql = "UPDATE cita SET persona=?, codRefuerzo=?, fechahoraCita=?, centroVacunacion=?, fechahoraColoca=?, dosis=? WHERE codigo=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cita.getPersona().getIdCiudadano());
            ps.setInt(2, cita.getCodigoRefuerzo());
            ps.setTimestamp(3, Timestamp.valueOf(cita.getFechaHoraCita()));//<---
            ps.setInt(4, cita.getCentroVacunacion().getIdCentro());
            ps.setTimestamp(5, Timestamp.valueOf(cita.getFechaHoraColoca()));//<---
            ps.setInt(6, cita.getDosis().getIdDosis());
            ps.setInt(7, cita.getCodigo());

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Cita modificada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna Cita con el codigo especificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar la cita: " + ex.getMessage());
        }
    }

    public List<Cita> listarCitas() {
        String sql = "SELECT * FROM cita";
        List<Cita> citas = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCodigo(rs.getInt("codigo"));
                cita.setPersona(cd.buscarCiudadanoPorId(rs.getInt("persona")));
                cita.setCodigoRefuerzo(rs.getInt("codRefuerzo"));
                cita.setFechaHoraCita(rs.getTimestamp("fechahoraCita").toLocalDateTime());
                cita.setCentroVacunacion(csd.buscarCentroSaludPorID(rs.getInt("centroVacunacion")));
                cita.setFechaHoraColoca(rs.getTimestamp("fechahoraColoca").toLocalDateTime());
                cita.setDosis(vd.buscarVacuna(rs.getInt("dosis")));
                citas.add(cita);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las citas: " + ex.getMessage());
        }

        return citas;
    }

    public void borrarCita(int codigo) {
        String sql = "DELETE FROM cita WHERE codigo=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codigo);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Cita con código " + codigo + " eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna cita con el código especificado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la cita: " + ex.getMessage());
        }
    }
}
