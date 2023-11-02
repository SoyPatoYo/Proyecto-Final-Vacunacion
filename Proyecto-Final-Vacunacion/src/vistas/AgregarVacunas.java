package vistas;

import accesoADatos.CentroSaludData;
import entidades.CentroSalud;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AgregarVacunas extends javax.swing.JPanel {

    CentroSaludData csD;
    private DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public AgregarVacunas() {
        initComponents();
        armarCabecera();
        tablaCentros.getTableHeader().setReorderingAllowed(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboCentro = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textCantidad = new javax.swing.JTextPane();
        botonAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCentros = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Reabastecer Vacunas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Seleccione Centro");

        comboCentro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centro Norte", "Centro Sur", "Centro Este", "Centro Oeste", "Centro Centro" }));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Seleccione Laboratiorio");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Seleccione Cantidad");

        jScrollPane3.setViewportView(textCantidad);

        botonAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonAgregar.setText("Agregar");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        tablaCentros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCentros);

        jButton1.setText("☻");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("  Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(291, 291, 291))
            .addGroup(layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(botonAgregar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(comboCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(botonAgregar)
                .addGap(22, 22, 22))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        try {
            csD = new CentroSaludData();
            int fila = tablaCentros.getSelectedRow();
            String centro = (String) comboCentro.getSelectedItem();
            String cantidadTexto = textCantidad.getText();

            // Validar que la cantidad sea un número positivo
            if (cantidadTexto.matches("^\\d+$")) {
                int cantidad = Integer.parseInt(cantidadTexto);

                List<CentroSalud> centros = csD.listarCentrosSaludNoNull();
                String nombre = tablaCentros.getValueAt(fila, 0).toString();
                String direccion = tablaCentros.getValueAt(fila, 1).toString();
                String laboratorio = tablaCentros.getValueAt(fila, 2).toString();
                CentroSalud centroSelec = new CentroSalud();
                for (CentroSalud cs : centros) {
                    if (cs.getNombre().equals(nombre) && cs.getDireccion().equals(direccion) && cs.getLaboratorio().getLaboratorio().equals(laboratorio)) {
                        centroSelec = cs;
                    }
                }
                csD.enviarVacunasAlCentro(centroSelec.getIdCentro(), centroSelec.getLaboratorio().getLaboratorio(), cantidad);
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad debe ser un número entero positivo.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_botonAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        borrarFilas();
        csD = new CentroSaludData();
        String centro = (String) comboCentro.getSelectedItem();
        if (centro.equals("Centro Norte")) {
            List<CentroSalud> centros = csD.buscarCentrosSaludPorNombre("Centro Medico Norte");
            for (CentroSalud c : centros) {
                if (null!=c.getLaboratorio().getLaboratorio()) {
                    cargarDatos(c);
                }
            }
        } else if (centro.equals("Centro Sur")) {
            List<CentroSalud> centros = csD.buscarCentrosSaludPorNombre("Centro Medico Sur");
            for (CentroSalud c : centros) {
                if (null!=c.getLaboratorio().getLaboratorio()) {
                    cargarDatos(c);
                }
            }
        } else if (centro.equals("Centro Este")) {
            List<CentroSalud> centros = csD.buscarCentrosSaludPorNombre("Centro Medico Este");
            for (CentroSalud c : centros) {
                if (null!=c.getLaboratorio().getLaboratorio()) {
                    cargarDatos(c);
                }
            }
        } else if (centro.equals("Centro Oeste")) {
            List<CentroSalud> centros = csD.buscarCentrosSaludPorNombre("Centro Medico Oeste");
            for (CentroSalud c : centros) {
                if (null!=c.getLaboratorio().getLaboratorio()) {
                    cargarDatos(c);
                }
            }
        } else if (centro.equals("Centro Centro")) {
            List<CentroSalud> centros = csD.buscarCentrosSaludPorNombre("Centro Medico Centro");
            for (CentroSalud c : centros) {
                if (null!=c.getLaboratorio().getLaboratorio()) {
                    cargarDatos(c);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JComboBox<String> comboCentro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tablaCentros;
    private javax.swing.JTextPane textCantidad;
    // End of variables declaration//GEN-END:variables
    private void armarCabecera() {
        modelo.addColumn("Centro");
        modelo.addColumn("Direccion");
        modelo.addColumn("Laboratorio");
        modelo.addColumn("Cantidad");

        tablaCentros.setModel(modelo);
        tablaCentros.getColumnModel().getColumn(0).setPreferredWidth(120);
    }

    private void cargarDatos(CentroSalud centro) {
        modelo.addRow(new Object[]{centro.getNombre(), centro.getDireccion(), centro.getLaboratorio().getLaboratorio(), centro.getCantDosis()});
    }

    private void borrarFilas() {
        int filas = tablaCentros.getRowCount() - 1;

        for (int i = filas; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }
}
