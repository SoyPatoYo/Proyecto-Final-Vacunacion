/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Matias
 */
public class CiudadanoData {

    private Connection conexion = null;

    public CiudadanoData() {
        conexion = Conexion.buscarConexion();
    }

    public void guardarCiudadano(Ciudadano persona) {
        String sql = "INSERT INTO ciudadano VALUES (?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, persona.getDni());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getApellido());
            ps.setString(4, persona.getZona());
            ps.setString(5, persona.getEmail());
            ps.setInt(6, persona.getCelular());
            ps.setString(7, persona.getPatologia());
            ps.setString(8, persona.getAmbitoTrabajo());
            ps.setBoolean(9, persona.isCovid());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ciudadano guardado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

    }
    
    

}
