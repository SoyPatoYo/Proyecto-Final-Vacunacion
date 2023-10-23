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

    VacunaData vd = new VacunaData();

    public void guardarCentroSalud(CentroSalud centro) {
        String sql = "INSERT INTO centrosalud VALUES (null,?,?,?,?,?)";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, centro.getNombre());
            ps.setString(2, centro.getDireccion());
            ps.setString(3, centro.getZona());
            ps.setString(4, centro.getLaboratorio().getLaboratorio());
            ps.setInt(5, centro.getCantDosis());
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
        String sql = "UPDATE centrosalud SET nombre=?, direccion=?, zona=?, laboratorio=?,laboratorio=?,cantidadDosis=? WHERE idCentro=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setString(1, centro.getNombre());
            ps.setString(2, centro.getDireccion());
            ps.setString(3, centro.getZona());
            ps.setString(4, centro.getLaboratorio().getLaboratorio());

            ps.setInt(6, centro.getCantDosis());
            ps.setInt(7, centro.getIdCentro()); // Usamos el ID para identificar el centro a modificar
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
                centro.setCantDosis(rs.getInt("cantidadDosis"));
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
                centro.setCantDosis(rs.getInt("cantidadDosis"));
                centros.add(centro);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
        return centros;
    }

    public void borrarCentroSalud(int idCentro) {
        String sql = "DELETE FROM centrosalud WHERE idCentro=?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCentro);
            int filasEliminadas = ps.executeUpdate();
            if (filasEliminadas > 0) {
                JOptionPane.showMessageDialog(null, "Centro de Salud con ID " + idCentro + " eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún Centro de Salud con el ID especificado.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el Centro de Salud: " + ex.getMessage());
        }
    }

    public int obtenerCantidadDosisPorCentro(int idCentro, String nombreVacuna) {
        String sql = "SELECT cantidadDosis FROM centrosalud WHERE idCentro = ? AND laboratorio = ?";
        int cantidadDosis = 0;

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, idCentro);
            ps.setString(2, nombreVacuna);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cantidadDosis = rs.getInt("cantidadDosis");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el centro de salud con ID: " + idCentro + " o la vacuna " + nombreVacuna + " no existe en el centro de salud.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }

        return cantidadDosis;
    }

//    public void enviarVacunasAlCentro(int idCentro, String nombreVacuna, int cantidadEnviada) {
//    // Verificar si el centro de salud y la vacuna existen
//    CentroSalud centro = buscarCentroSaludPorID(idCentro);
//    if (centro == null) {
//        JOptionPane.showMessageDialog(null, "No se encontró el centro de salud con ID: " + idCentro);
//        return;
//    }
//    
//    // Verificar si la vacuna existe en el centro de salud
//    int cantidadDosisActual = obtenerCantidadDosisPorCentro(idCentro, nombreVacuna);
//    if (cantidadDosisActual == 0) {
//        JOptionPane.showMessageDialog(null, "La vacuna " + nombreVacuna + " no existe en el centro de salud.");
//        return;
//    }
//    
//    // Calcular la nueva cantidad de dosis después del envío
//    int nuevaCantidad = cantidadDosisActual + cantidadEnviada;
//    
//    // Actualizar la cantidad de dosis en el centro de salud
//    String sql = "UPDATE centrosalud SET cantidadDosis = ? WHERE idCentro = ? AND laboratorio = ?";
//    
//    try {
//        PreparedStatement ps = conexion.prepareStatement(sql);
//        ps.setInt(1, nuevaCantidad);
//        ps.setInt(2, idCentro);
//        ps.setString(3, nombreVacuna);
//        int filasActualizadas = ps.executeUpdate();
//        
//        if (filasActualizadas > 0) {
//            JOptionPane.showMessageDialog(null, "Se enviaron " + cantidadEnviada + " dosis de la vacuna " + nombreVacuna + " al centro de salud ID: " + idCentro);
//        } else {
//            JOptionPane.showMessageDialog(null, "No se pudo realizar el envío de vacunas.");
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
//    }
//}
//    public void descontarVacunasDelCentro(int idCentro, String nombreVacuna, int cantidadDescontada) {
//    // Verificar si el centro de salud y la vacuna existen
//    CentroSalud centro = buscarCentroSaludPorID(idCentro);
//    if (centro == null) {
//        JOptionPane.showMessageDialog(null, "No se encontró el centro de salud con ID: " + idCentro);
//        return;
//    }
//    
//    // Verificar si la vacuna existe en el centro de salud
//    int cantidadDosisActual = obtenerCantidadDosisPorCentro(idCentro, nombreVacuna);
//    if (cantidadDosisActual == 0) {
//        JOptionPane.showMessageDialog(null, "La vacuna " + nombreVacuna + " no existe en el centro de salud.");
//        return;
//    }
//    
//    // Calcular la nueva cantidad de dosis después del descuento
//    int nuevaCantidad = cantidadDosisActual - cantidadDescontada;
//    
//    // Verificar que no se vuelva negativa la cantidad
//    if (nuevaCantidad < 0) {
//        JOptionPane.showMessageDialog(null, "No se pueden descontar más vacunas de las disponibles.");
//        return;
//    }
//    
//    // Actualizar la cantidad de dosis en el centro de salud
//    String sql = "UPDATE centrosalud SET cantidadDosis = ? WHERE idCentro = ? AND laboratorio = ?";
//    
//    try {
//        PreparedStatement ps = conexion.prepareStatement(sql);
//        ps.setInt(1, nuevaCantidad);
//        ps.setInt(2, idCentro);
//        ps.setString(3, nombreVacuna);
//        int filasActualizadas = ps.executeUpdate();
//        
//        if (filasActualizadas > 0) {
//            JOptionPane.showMessageDialog(null, "Se descontaron " + cantidadDescontada + " dosis de la vacuna " + nombreVacuna + " en el centro de salud ID: " + idCentro);
//        } else {
//            JOptionPane.showMessageDialog(null, "No se pudo realizar el descuento de vacunas.");
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
//    }
//}
//    public void enviarVacunasAlCentro(int idCentro, String nombreVacuna, int cantidadEnviada) {
//    // Verificar si el centro de salud y la vacuna existen
//    CentroSalud centro = buscarCentroSaludPorID(idCentro);
//    if (centro == null) {
//        JOptionPane.showMessageDialog(null, "No se encontró el centro de salud con ID: " + idCentro);
//        return;
//    }
//    
//    // Verificar si la vacuna existe en el centro de salud
//    int cantidadDosisActual = obtenerCantidadDosisPorCentro(idCentro, nombreVacuna);
//    if (cantidadDosisActual == 0) {
//        JOptionPane.showMessageDialog(null, "La vacuna " + nombreVacuna + " no existe en el centro de salud.");
//        return;
//    }
//    
//    // Calcular la nueva cantidad de dosis después del envío
//    int nuevaCantidad = cantidadDosisActual + cantidadEnviada;
//    
//    // Actualizar la cantidad de dosis en el centro de salud
//    String sql = "UPDATE centrosalud SET cantidadDosis = ? WHERE idCentro = ? AND laboratorio = ?";
//    
//    try {
//        PreparedStatement ps = conexion.prepareStatement(sql);
//        ps.setInt(1, nuevaCantidad);
//        ps.setInt(2, idCentro);
//        ps.setString(3, nombreVacuna);
//        int filasActualizadas = ps.executeUpdate();
//        
//        if (filasActualizadas > 0) {
//            // Ahora, descontamos la cantidad de vacunas del lote correspondiente en la base de datos de vacunas.
//            descontarVacunasDelLote(nombreVacuna, cantidadEnviada);
//            JOptionPane.showMessageDialog(null, "Se enviaron " + cantidadEnviada + " dosis de la vacuna " + nombreVacuna + " al centro de salud ID: " + idCentro);
//        } else {
//            JOptionPane.showMessageDialog(null, "No se pudo realizar el envío de vacunas.");
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
//    }
//}
    public void descontarVacunasDelLote(int lote, String nombreVacuna, int cantidadDescontada) {
        String sql = "UPDATE vacuna SET cantidadDosis = cantidadDosis - ? WHERE laboratorio = ?  AND Lote = ?";
        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, cantidadDescontada);
            ps.setString(2, nombreVacuna);
            ps.setInt(3, lote);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al descontar vacunas del lote: " + ex.getMessage());
        }
    }

}
