package vistas;

import accesoADatos.CentroSaludData;
import accesoADatos.CitaData;
import accesoADatos.CiudadanoData;
import entidades.CentroSalud;
import entidades.Cita;
import entidades.Ciudadano;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ColocadasCanceladas extends javax.swing.JPanel {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    CitaData citaD;
    CiudadanoData cD;
    CentroSaludData centroD;

    public ColocadasCanceladas() {
        initComponents();
        citaD = new CitaData();
        cD = new CiudadanoData();
        centroD = new CentroSaludData();
        armarCabecera();
        llenarTabla();
        limpiarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbColocadas = new javax.swing.JButton();
        jbCanceladas = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Listado de Citas");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "DNI", "NOMBRE", "APELLIDO", "CENTRO", "FECHA"
            }
        ));
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTable1);

        jbColocadas.setText("Colocadas");
        jbColocadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbColocadasActionPerformed(evt);
            }
        });

        jbCanceladas.setText("Canceladas");
        jbCanceladas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCanceladasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jbColocadas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCanceladas, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbColocadas)
                    .addComponent(jbCanceladas))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbColocadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbColocadasActionPerformed
        limpiarTabla();
        cargarDatosColocada();

    }//GEN-LAST:event_jbColocadasActionPerformed

    private void jbCanceladasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCanceladasActionPerformed
        limpiarTabla();
        cargarDatosCancelada();
    }//GEN-LAST:event_jbCanceladasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton jbCanceladas;
    private javax.swing.JButton jbColocadas;
    // End of variables declaration//GEN-END:variables
     private void armarCabecera() {
        modelo.addColumn("DNI");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("CENTRO");
        modelo.addColumn("FECHA");

        jTable1.setModel(modelo);
    }

    private void limpiarTabla() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    }

    private void llenarTabla() {
        limpiarTabla();
        List<Cita> listaCitas = citaD.listarCitas();
        for (Cita c : listaCitas) {
            cargarDatos(c);
        }
    }

    private void cargarDatos(Cita cita) {
        modelo.addRow(new Object[]{cita.getPersona().getDni(), cita.getPersona().getNombre(), cita.getPersona().getApellido(),
            cita.getCentroVacunacion().getNombre(), cita.getFechaHoraCita().toLocalDate()});
    }
    
    private void cargarDatosColocada(){
        List<Cita> listaCitas = citaD.listarCitasColocadas();
        for(Cita c : listaCitas){
            cargarDatos(c);
        }
    }
    
    private void cargarDatosCancelada(){
        List<Cita> listaCitasCanceladas=citaD.listarCitasCanceladas();
        for(Cita c: listaCitasCanceladas){
            cargarDatos(c);
        }
    }
}
