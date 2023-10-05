package accesoADatos;

import entidades.Vacuna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Vacuna buscarVacunas(int idDosis) {
        String sql = "SELECT * FROM vacuna WHERE idDosis=?";
        Vacuna vacuna = null;
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, idDosis);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            }
        } catch (SQLException ex) {
            Logger.getLogger(VacunaData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vacuna;
    }

}
