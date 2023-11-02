package accesoADatos;

import entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class CiudadanoData {

    private Connection conexion = null;

    public CiudadanoData() {
        conexion = Conexion.buscarConexion();
    }

    public void guardarCiudadano(Ciudadano persona) {
        String sql = "INSERT INTO ciudadano(dni,nombre,apellido,zona,email,celular,patologia,ambitoTrabajo,covid,estado)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, persona.getDni());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getZona());
            ps.setString(5, persona.getEmail());
            ps.setInt(6, persona.getCelular());
            ps.setString(7, persona.getPatologia());
            ps.setString(8, persona.getAmbitoTrabajo());
            ps.setBoolean(9, persona.isCovid());
            ps.setBoolean(10, true);

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                persona.setIdCiudadano(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ciudadano guardado.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

    }

    public void modificarCiudadano(Ciudadano persona) {
        String sql = "UPDATE ciudadano "
                + "SET nombre=?,apellido=?,zona=?,email=?,celular=?,patologia=?,ambitoTrabajo=?,covid=? WHERE dni=?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getZona());
            ps.setString(4, persona.getEmail());
            ps.setInt(5, persona.getCelular());
            ps.setString(6, persona.getPatologia());
            ps.setString(7, persona.getAmbitoTrabajo());
            ps.setBoolean(8, persona.isCovid());
            ps.setInt(9, persona.getDni());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Datos modificado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    public Ciudadano buscarCiudadanoPorDni(int dni) {
        String sql = "SELECT * FROM ciudadano WHERE dni=? AND estado=true";
        Ciudadano persona = null;
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Ciudadano();
                persona.setDni(dni);
                persona.setIdCiudadano(rs.getInt("idCiudadano"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setZona(rs.getString("zona"));
                persona.setEmail(rs.getString("email"));
                persona.setCelular(rs.getInt("celular"));
                persona.setPatologia(rs.getString("patologia"));
                persona.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                persona.setCovid(rs.getBoolean("covid"));
                persona.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return persona;
    }

    public Ciudadano buscarCiudadanoPorId(int id) {
        String sql = "SELECT * FROM ciudadano WHERE idCiudadano=?";
        Ciudadano persona = null;
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Ciudadano();
                persona.setDni(rs.getInt("dni"));
                persona.setIdCiudadano(rs.getInt("idCiudadano"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setZona(rs.getString("zona"));
                persona.setEmail(rs.getString("email"));
                persona.setCelular(rs.getInt("celular"));
                persona.setPatologia(rs.getString("patologia"));
                persona.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                persona.setCovid(rs.getBoolean("covid"));
                persona.setEstado(rs.getBoolean("estado"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return persona;
    }

    public List<Ciudadano> listarCiudadanos() {
        String sql = "SELECT * FROM ciudadano";
        ArrayList<Ciudadano> ciudadanos = new ArrayList<>();
        Ciudadano persona;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                persona = new Ciudadano();
                persona.setIdCiudadano(rs.getInt("idCiudadano"));
                persona.setDni(rs.getInt("dni"));
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setZona(rs.getString("zona"));
                persona.setEmail(rs.getString("email"));
                persona.setCelular(rs.getInt("celular"));
                persona.setPatologia(rs.getString("patologia"));
                persona.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                persona.setCovid(rs.getBoolean("covid"));
                persona.setEstado(rs.getBoolean("estado"));

                ciudadanos.add(persona);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error " + ex.getMessage());
        }
        return ciudadanos;
    }

    public void borrarCiudadanoPorDni(int dni) {
        String sql = "UPDATE ciudadano "
                + "SET estado=? WHERE dni=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setBoolean(1, false);
            ps.setInt(2, dni);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Ciudadano con DNI " + dni + " eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún ciudadano con DNI " + dni + ".");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    public void borrarCiudadanoPorId(int idCiudadano){
        String sql = "DELETE FROM ciudadano WHERE idCiudadano=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCiudadano);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Ciudadano con ID " + idCiudadano + " eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún ciudadano con ID " + idCiudadano + ".");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

}
