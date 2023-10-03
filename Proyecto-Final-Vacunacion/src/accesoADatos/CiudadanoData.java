/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.Ciudadano;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void modificarCiudadano(Ciudadano persona){
        String sql="UPDATE ciudadano "
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
    
    public Ciudadano buscarCiudadanoPorDni(int dni){
        String sql="SELECT * FROM ciudadano WHERE dni=?";
        Ciudadano persona=null;
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                persona=new Ciudadano();
                persona.setDni(dni);
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setZona(rs.getString("zona"));
                persona.setEmail(rs.getString("email"));
                persona.setCelular(rs.getInt("celular"));
                persona.setPatologia(rs.getString("patologia"));
                persona.setAmbitoTrabajo(rs.getString("ambitoTrabajo"));
                persona.setCovid(rs.getBoolean("covid"));
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return persona;
    }
}
