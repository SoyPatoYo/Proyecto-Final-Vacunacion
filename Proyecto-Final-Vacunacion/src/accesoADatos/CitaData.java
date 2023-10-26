package accesoADatos;

import entidades.Cita;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        String sql = "INSERT INTO cita(persona, cantRefuerzo, fechahoraCita, centroVacunacion, estado, colocada) VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cita.getPersona().getIdCiudadano());
            ps.setInt(2, cita.getCantRefuerzo());
            ps.setTimestamp(3, Timestamp.valueOf(cita.getFechaHoraCita()));//Timestamp entra en un DateTime.
            ps.setInt(4, cita.getCentroVacunacion().getIdCentro());
            ps.setBoolean(5, cita.isEstado());
            ps.setBoolean(6, cita.isColocada());

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
        String sql = "SELECT persona, cantRefuerzo, fechahoraCita, centroVacunacion, estado, colocada FROM cita WHERE codigo=?";
        Cita cita = null;
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cita = new Cita();
                cita.setCodigo(codigo);
                cita.setPersona(cd.buscarCiudadanoPorId(rs.getInt("persona")));
                cita.setCantRefuerzo(rs.getInt("cantRefuerzo"));
                cita.setFechaHoraCita(rs.getTimestamp("fechahoraCita").toLocalDateTime());
                cita.setCentroVacunacion(csd.buscarCentroSaludPorID(rs.getInt("centroVacunacion")));
                //cita.setFechaHoraColoca(rs.getTimestamp("fechahoraColoca").toLocalDateTime()); Daba error si la fecha era null.
                cita.setEstado(rs.getBoolean("estado"));
                cita.setColocada(rs.getBoolean("colocada"));

            } else {
                JOptionPane.showMessageDialog(null, "No se encuenta una Cita con ese codigo.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return cita;
    }

    public void modificarCita(Cita cita) {
        String sql = "UPDATE cita SET persona=?, cantRefuerzo=?, fechahoraCita=?, centroVacunacion=?, fechahoraColoca=?, estado=?, colocada=? WHERE codigo=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cita.getPersona().getIdCiudadano());
            ps.setInt(2, cita.getCantRefuerzo());
            ps.setTimestamp(3, Timestamp.valueOf(cita.getFechaHoraCita()));//<---
            ps.setInt(4, cita.getCentroVacunacion().getIdCentro());
            ps.setTimestamp(5, Timestamp.valueOf(cita.getFechaHoraColoca()));//<---
            ps.setBoolean(6, cita.isEstado());
            ps.setBoolean(7, cita.isColocada());
            ps.setInt(8, cita.getCodigo());

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
        String sql = "SELECT codigo, persona, cantRefuerzo, fechahoraCita, centroVacunacion, estado, colocada FROM cita";
        List<Cita> citas = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCodigo(rs.getInt("codigo"));
                cita.setPersona(cd.buscarCiudadanoPorId(rs.getInt("persona")));
                cita.setCantRefuerzo(rs.getInt("cantRefuerzo"));
                cita.setFechaHoraCita(rs.getTimestamp("fechahoraCita").toLocalDateTime());
                cita.setCentroVacunacion(csd.buscarCentroSaludPorID(rs.getInt("centroVacunacion")));
                //cita.setFechaHoraColoca(rs.getTimestamp("fechahoraColoca").toLocalDateTime());
                cita.setEstado(rs.getBoolean("estado"));
                cita.setColocada(rs.getBoolean("colocada"));
                citas.add(cita);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las citas: " + ex.getMessage());
        }

        return citas;
    }

    public List<Cita> listarCitasPorPersona(int idPersona) {
        String sql = "SELECT * FROM cita WHERE persona = ?";
        List<Cita> citas = new ArrayList<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idPersona);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCodigo(rs.getInt("codigo"));
                cita.setPersona(cd.buscarCiudadanoPorId(rs.getInt("persona")));
                cita.setCantRefuerzo(rs.getInt("cantRefuerzo"));
                cita.setFechaHoraCita(rs.getTimestamp("fechahoraCita").toLocalDateTime());
                cita.setCentroVacunacion(csd.buscarCentroSaludPorID(rs.getInt("centroVacunacion")));
                cita.setFechaHoraColoca(rs.getTimestamp("fechahoraColoca").toLocalDateTime());
                cita.setEstado(rs.getBoolean("estado"));
                cita.setColocada(rs.getBoolean("colocada"));
                citas.add(cita);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las citas por persona: " + ex.getMessage());
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

    public void cancelarCita(int codigo) {
        String sql = "UPDATE cita SET estado=? WHERE codigo=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, codigo);

            int filasActualizadas = ps.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Cita con código " + codigo + " cancelada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna cita con el código especificado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cancelar la cita: " + ex.getMessage());
        }
    }

    public List<Cita> listarCitasVencidas() {
        String sql = "SELECT * FROM cita";
        List<Cita> citasVencidas = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Cita cita = new Cita();
                cita.setCodigo(rs.getInt("codigo"));
                cita.setPersona(cd.buscarCiudadanoPorId(rs.getInt("persona")));
                cita.setCantRefuerzo(rs.getInt("cantRefuerzo"));
                cita.setFechaHoraCita(rs.getTimestamp("fechahoraCita").toLocalDateTime());
                cita.setCentroVacunacion(csd.buscarCentroSaludPorID(rs.getInt("centroVacunacion")));
                cita.setEstado(rs.getBoolean("estado"));
                cita.setColocada(rs.getBoolean("colocada"));

                // Comprobar si la cita se ha vencido y no se ha cumplido
                if (cita.getFechaHoraCita().isBefore(now) && cita.isEstado() == true && cita.isColocada() == false) {
                    citasVencidas.add(cita);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar las citas vencidas: " + ex.getMessage());
        }

        return citasVencidas;
    }

    public int contarCiudadanosConVacunaPorNombre(String nombreVacuna) {
        String sql = "SELECT COUNT(DISTINCT c.persona) AS cantidad "
                + "FROM cita c "
                + "JOIN vacuna v ON c.dosis = v.lote "
                + "WHERE v.marcaVacuna = ?";
        int cantidadCiudadanos = 0;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, nombreVacuna);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cantidadCiudadanos = rs.getInt("cantidad");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al contar ciudadanos con vacuna específica: " + ex.getMessage());
        }

        return cantidadCiudadanos;
    }

    public Map<String, Integer> contarDosisAplicadasPorCentroColocadas() {
        String sql = "SELECT c.nombre AS centro, COUNT(*) AS cantidad_dosis "
                + "FROM cita ci "
                + "JOIN centrosalud c ON ci.centroVacunacion = c.idCentro "
                + "WHERE ci.colocada = true "
                + "GROUP BY ci.centroVacunacion";

        Map<String, Integer> dosisPorCentro = new HashMap<>();

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String nombreCentro = rs.getString("centro");
                int cantidadDosis = rs.getInt("cantidad_dosis");
                dosisPorCentro.put(nombreCentro, cantidadDosis);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al contar dosis aplicadas por centro: " + ex.getMessage());
        }

        return dosisPorCentro;
    }

}
