package accesoADatos;

import entidades.Vacuna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class VacunaData {

    private Connection conexion = null;

    public VacunaData() {
        conexion = Conexion.buscarConexion();
    }

    public void guardarVacuna(Vacuna vacuna) {

        String sql = "INSERT INTO vacuna VALUES (?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, vacuna.getNumSerie());
            ps.setString(2, vacuna.getMarca());
            ps.setString(3, vacuna.getLaboratorio());
            ps.setDouble(4, vacuna.getMedida());
            ps.setDate(5, vacuna.getVencimiento());
            ps.setBoolean(6, vacuna.isColocada());
            ps.setString(7, vacuna.getAntigeno());
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ciudadano guardado.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

    }

}
