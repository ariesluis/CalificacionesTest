/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorEstudianteAsignatura;
import Controlador.ControladorEstudiante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pavilion dv4
 */
public class FrmRegistro extends javax.swing.JFrame {

    /**
     * Creates new form FrmRegistro
     */
    public FrmRegistro() {
        initComponents();
        cargarAsignatura();
    }

    
    String path=new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    ControladorEstudianteAsignatura cea=new ControladorEstudianteAsignatura();
    ControladorEstudiante est=new ControladorEstudiante();
    List<Double> lstNota=new ArrayList<>();
    
    double nota=0;
    int indexA = -1;
    int indexEst= -1;
    
    public void cargarAsignatura()
    {
        cea.cargarAsignaturas(path+"\\Asignatura.txt");
        cbxAsignatura.removeAllItems();
        for (int i = 0; i < cea.lstAsignatura.size(); i++) {
            cbxAsignatura.addItem(cea.lstAsignatura.get(i).getNombre());
        }
        est.leerDEstudiante(path+"\\Estudiante.txt");
    }
    
    public void calcularNota()
    {
        DefaultTableModel model = (DefaultTableModel) tblParam.getModel();
        nota=0;
        int nro_filas = model.getRowCount();
        for (int i = 0; i < nro_filas; i++) {
            lstNota.add(Double.parseDouble(model.getValueAt(i, 1).toString()));
            nota+=Double.parseDouble(model.getValueAt(i, 1).toString());
        }
        txtNota.setText(nota+"");
    }
    
    public void cargarEstudiante()
    {
        String ci=txtCed.getText().trim();
        for (int i = 0; i < est.lst.size(); i++) {
            if(est.lst.get(i).getCedula().equals(ci))
            {
                indexEst=i;
                txtEstudiante.setText(est.lst.get(i).getApellido()+" "+est.lst.get(i).getNombre());
            }
        }
    }
    
    public void cargarParametros()
    {
        indexA = cbxAsignatura.getSelectedIndex();
        if(indexA >= 0)
        {
            txtDocente.setText(cea.lstAsignatura.get(indexA).getDocente().getNombre()+" "+cea.lstAsignatura.get(indexA).getDocente().getApellido());
            DefaultTableModel model = (DefaultTableModel) tblParam.getModel();
            model.setRowCount(0);
            for (int j = 0; j < cea.lstAsignatura.get(indexA).getNom_param().size(); j++) {
                model.addRow(new Object[]{cea.lstAsignatura.get(indexA).getNom_param().get(j), cea.lstAsignatura.get(indexA).getVal_param().get(j)});
            }
        }
    }
    
    public void guardar()
    {
        ControladorEstudiante ce=new ControladorEstudiante();
        ce.setEstudiante(est.lst.get(indexEst));
        cea.getEa().setAsignatura(cea.lstAsignatura.get(indexA));
        cea.getEa().setEstudiante(est.lst.get(indexEst));
        cea.getEa().setNotaGlobal(nota);
        cea.getEa().setParametrosNota(lstNota);
        cea.guardar(cea.getEa(), path+"\\Notas.txt");
        JOptionPane.showMessageDialog(null, "Nota registrada con exito", "Notas", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnGuardar4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnCalcularNota = new javax.swing.JButton();
        lblNotaF = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblParam = new javax.swing.JTable();
        lblParametrosCalificacion2 = new javax.swing.JLabel();
        lblNombreAsignatura3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblNombreDocente4 = new javax.swing.JLabel();
        txtCed = new javax.swing.JTextField();
        txtEstudiante = new javax.swing.JTextField();
        txtDocente = new javax.swing.JLabel();
        cbxAsignatura = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnGuardar4.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        btnGuardar4.setText("Guardar");
        btnGuardar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar4ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnCalcularNota.setFont(new java.awt.Font("Vani", 0, 13)); // NOI18N
        btnCalcularNota.setText("Calcular Nota");
        btnCalcularNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularNotaActionPerformed(evt);
            }
        });

        lblNotaF.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        lblNotaF.setText("Nota         :");

        txtNota.setEditable(false);

        tblParam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Parametros", "Puntaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblParam);

        lblParametrosCalificacion2.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        lblParametrosCalificacion2.setText("Parametros Calificacion");

        lblNombreAsignatura3.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        lblNombreAsignatura3.setText("Nombre Asignatura           :");

        jLabel2.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        jLabel2.setText("CI Estudiante                       :");

        jLabel3.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        jLabel3.setText("Nombre Estudiante         : ");

        lblNombreDocente4.setFont(new java.awt.Font("Vani", 0, 12)); // NOI18N
        lblNombreDocente4.setText("Nombre Docente              : ");

        txtCed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedActionPerformed(evt);
            }
        });

        txtEstudiante.setEditable(false);

        cbxAsignatura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxAsignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAsignaturaItemStateChanged(evt);
            }
        });

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(btnGuardar4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(106, 106, 106))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreAsignatura3)
                                    .addComponent(jLabel2))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(lblNombreDocente4))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEstudiante)
                                    .addComponent(txtDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(lblParametrosCalificacion2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNotaF)
                                .addGap(18, 18, 18)
                                .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCalcularNota))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreAsignatura3)
                    .addComponent(cbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNombreDocente4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDocente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(lblParametrosCalificacion2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNotaF)
                    .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCalcularNota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar4)
                    .addComponent(jButton2))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedActionPerformed

    private void cbxAsignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAsignaturaItemStateChanged
        // TODO add your handling code here:
        cargarParametros();
    }//GEN-LAST:event_cbxAsignaturaItemStateChanged

    private void btnCalcularNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularNotaActionPerformed
        // TODO add your handling code here:
        calcularNota();
    }//GEN-LAST:event_btnCalcularNotaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cargarEstudiante();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnGuardar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar4ActionPerformed
        // TODO add your handling code here:
        guardar();
    }//GEN-LAST:event_btnGuardar4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularNota;
    private javax.swing.JButton btnGuardar4;
    private javax.swing.JComboBox<String> cbxAsignatura;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblNombreAsignatura3;
    private javax.swing.JLabel lblNombreDocente4;
    private javax.swing.JLabel lblNotaF;
    private javax.swing.JLabel lblParametrosCalificacion2;
    private javax.swing.JTable tblParam;
    private javax.swing.JTextField txtCed;
    private javax.swing.JLabel txtDocente;
    private javax.swing.JTextField txtEstudiante;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}