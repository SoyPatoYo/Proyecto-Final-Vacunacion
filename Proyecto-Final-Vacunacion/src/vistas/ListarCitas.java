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

public class ListarCitas extends javax.swing.JPanel {

    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    CitaData citaD;
    CiudadanoData cD;
    CentroSaludData centroD;

    public ListarCitas() {
        initComponents();
        citaD = new CitaData();
        cD = new CiudadanoData();
        centroD = new CentroSaludData();
        jTable1.getTableHeader().setReorderingAllowed(false);
        armarCabecera();
        //llenarTabla();
        limpiarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        comboFechaDia = new javax.swing.JComboBox<>();
        colocada = new javax.swing.JButton();
        eliminar1 = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Selecione el dia de la cita a buscar");

        comboFechaDia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        comboFechaDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        comboFechaDia.setAlignmentX(0.1F);
        comboFechaDia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        comboFechaDia.setOpaque(false);
        comboFechaDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFechaDiaActionPerformed(evt);
            }
        });

        colocada.setBackground(new java.awt.Color(255, 255, 255));
        colocada.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        colocada.setText("COLOCADA");
        colocada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        colocada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colocadaActionPerformed(evt);
            }
        });

        eliminar1.setBackground(new java.awt.Color(255, 255, 255));
        eliminar1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        eliminar1.setText("ELIMINAR");
        eliminar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        eliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminar1ActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboFechaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(colocada, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(361, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFechaDia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(colocada, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(123, 123, 123)
                    .addComponent(eliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(305, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboFechaDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFechaDiaActionPerformed
        String diaSeleccionado = comboFechaDia.getSelectedItem().toString();
        int dia = Integer.parseInt(diaSeleccionado);
        limpiarTabla();
        List<Cita> listaCitas = citaD.listarCitas();
        for (Cita cita : listaCitas) {
            LocalDate fechaCita = cita.getFechaHoraCita().toLocalDate();
            if (fechaCita.getDayOfMonth() == dia && cita.isEstado()) {
                cargarDatos(cita);
            }
        }
    }//GEN-LAST:event_comboFechaDiaActionPerformed

    private void colocadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colocadaActionPerformed

        try {
            int fila = jTable1.getSelectedRow();

            if (fila >= 0) {
                int dni = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
                Ciudadano persona = cD.buscarCiudadanoPorDni(dni);
                List<Cita> citas = citaD.listarCitasPorPersona(persona.getIdCiudadano());
                Cita cita = citas.get(0);
                for (Cita c : citas) {
                    cita = c;
                }

                if (!citas.isEmpty()) {

                    citaD.citaColocada(cita.getCodigo());

//                  descontar la dosis del centro de la cita.
                    String centro = jTable1.getValueAt(fila, 3).toString();
                    CentroSalud centroS = (CentroSalud) centroD.buscarCentroSaludPorNombre(centro);
                    if (centroS != null) {
                        centroD.descontarVacunasDelCentro(cita.getCentroVacunacion().getIdCentro(), cita.getCentroVacunacion().getLaboratorio().getLaboratorio(), 1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Centro de salud no encontrado.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron citas para esta persona.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una fila válida en la tabla.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }//GEN-LAST:event_colocadaActionPerformed

    private void eliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminar1ActionPerformed
        int fila = jTable1.getSelectedRow();

        if (fila >= 0) {
            int dni = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
            Ciudadano persona = cD.buscarCiudadanoPorDni(dni);
            List<Cita> citas = citaD.listarCitasPorPersona(persona.getIdCiudadano());

            if (!citas.isEmpty()) {
                Cita cita = citas.get(0);
                for (Cita c : citas) {
                    cita = c;
                }
                citaD.cancelarCita(cita.getCodigo());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron citas para esta persona.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila válida en la tabla.");
        }
    }//GEN-LAST:event_eliminar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colocada;
    private javax.swing.JComboBox<String> comboFechaDia;
    private javax.swing.JButton eliminar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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
            cita.getCentroVacunacion().getNombre(), cita.getFechaHoraCita().getHour() + ":" + cita.getFechaHoraCita().getMinute()});
    }
}
