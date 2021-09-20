/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorEstudianteAsignatura;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.parser.TokenType;

/**
 *
 * @author Pavilion dv4
 */
public class FrmNomina extends javax.swing.JFrame {

    /**
     * Creates new form FrmNomina
     */
    public FrmNomina() {
        initComponents();
        cargarAsignatura();
    }

    String path=new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
    ControladorEstudianteAsignatura cea=new ControladorEstudianteAsignatura();
    
    int indexA=-1;
    
    public void cargarAsignatura()
    {
        cea.leer(path+"\\Notas.txt");
        cbxAsignatura.removeAllItems();
        for (int i = 0; i < cea.lstEs.size(); i++) {
            cbxAsignatura.addItem(cea.lstEs.get(i).getAsignatura().getNombre());
        }
    }
    
    
    
    
    public void cargarNomina()
    {
        cea.leer(path+"\\Notas.txt");
        indexA = cbxAsignatura.getSelectedIndex();
        String materia=cbxAsignatura.getSelectedItem().toString();
        DefaultTableModel model = (DefaultTableModel) tblParam.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
        if(indexA >= 0)
        {
            txtDocente.setText(cea.lstEs.get(indexA).getAsignatura().getDocente().getNombre()+" "+cea.lstEs.get(indexA).getAsignatura().getDocente().getApellido());
            
            model.addColumn("Estudiante");
            for (int j = 0; j < cea.lstEs.get(indexA).getAsignatura().getNom_param().size(); j++) {
                model.addColumn(cea.lstEs.get(indexA).getAsignatura().getNom_param().get(j));
            }
            model.addColumn("Promedio");
            for (int j = 0; j < cea.lstEs.size(); j++) {
                int np=cea.lstEs.get(j).getParametrosNota().size();
                if(np==1 && cea.lstEs.get(j).getAsignatura().getNombre().equals(materia))
                {
                    model.addRow
                    (
                        new Object[]
                        {
                            cea.lstEs.get(j).getEstudiante().getApellido()+" "+cea.lstEs.get(j).getEstudiante().getNombre(),
                            cea.lstEs.get(j).getParametrosNota().get(0),
                            cea.lstEs.get(j).getNotaGlobal()
                        }
                    );
                }
                if(np==2 && cea.lstEs.get(j).getAsignatura().getNombre().equals(materia))
                {
                    model.addRow
                    (
                        new Object[]
                        {
                            cea.lstEs.get(j).getEstudiante().getApellido()+" "+cea.lstEs.get(j).getEstudiante().getNombre(),
                            cea.lstEs.get(j).getParametrosNota().get(0),
                            cea.lstEs.get(j).getParametrosNota().get(1),
                            cea.lstEs.get(j).getNotaGlobal()
                        }
                    );
                }
                if(np==3 && cea.lstEs.get(j).getAsignatura().getNombre().equals(materia))
                {
                    model.addRow
                    (
                        new Object[]
                        {
                            cea.lstEs.get(j).getEstudiante().getApellido()+" "+cea.lstEs.get(j).getEstudiante().getNombre(),
                            cea.lstEs.get(j).getParametrosNota().get(0),
                            cea.lstEs.get(j).getParametrosNota().get(1),
                            cea.lstEs.get(j).getParametrosNota().get(2),
                            cea.lstEs.get(j).getNotaGlobal()
                        }
                    );
                }
                if(np==4 && cea.lstEs.get(j).getAsignatura().getNombre().equals(materia))
                {
                    model.addRow
                    (
                        new Object[]
                        {
                            cea.lstEs.get(j).getEstudiante().getApellido()+" "+cea.lstEs.get(j).getEstudiante().getNombre(),
                            cea.lstEs.get(j).getParametrosNota().get(0),
                            cea.lstEs.get(j).getParametrosNota().get(1),
                            cea.lstEs.get(j).getParametrosNota().get(2),
                            cea.lstEs.get(j).getParametrosNota().get(3),
                            cea.lstEs.get(j).getNotaGlobal()
                        }
                    );
                }
                if(np==5 && cea.lstEs.get(j).getAsignatura().getNombre().equals(materia))
                {
                    model.addRow
                    (
                        new Object[]
                        {
                            cea.lstEs.get(j).getEstudiante().getApellido()+" "+cea.lstEs.get(j).getEstudiante().getNombre(),
                            cea.lstEs.get(j).getParametrosNota().get(0),
                            cea.lstEs.get(j).getParametrosNota().get(1),
                            cea.lstEs.get(j).getParametrosNota().get(2),
                            cea.lstEs.get(j).getParametrosNota().get(3),
                            cea.lstEs.get(j).getParametrosNota().get(4),
                            cea.lstEs.get(j).getNotaGlobal()
                        }
                    );
                }
            }
        }
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCerrar = new javax.swing.JButton();
        lblNombreAsignatura7 = new javax.swing.JLabel();
        lblNombreDocente7 = new javax.swing.JLabel();
        txtDocente = new javax.swing.JTextField();
        lblListado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblParam = new javax.swing.JTable();
        cbxAsignatura = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCerrar.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        lblNombreAsignatura7.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        lblNombreAsignatura7.setText("Nombre Asignatura   : ");

        lblNombreDocente7.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        lblNombreDocente7.setText("Nombre Docente       :  ");

        txtDocente.setEditable(false);
        txtDocente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocenteActionPerformed(evt);
            }
        });

        lblListado.setFont(new java.awt.Font("Vani", 0, 14)); // NOI18N
        lblListado.setText("Listado   : ");

        tblParam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblParam);

        cbxAsignatura.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxAsignaturaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombreDocente7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNombreAsignatura7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(468, 468, 468))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblListado)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(btnCerrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreAsignatura7)
                    .addComponent(cbxAsignatura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDocente7)
                    .addComponent(txtDocente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(lblListado)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocenteActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void cbxAsignaturaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxAsignaturaItemStateChanged
        // TODO add your handling code here:
        cargarNomina();
    }//GEN-LAST:event_cbxAsignaturaItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JComboBox<String> cbxAsignatura;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListado;
    private javax.swing.JLabel lblNombreAsignatura7;
    private javax.swing.JLabel lblNombreDocente7;
    private javax.swing.JTable tblParam;
    private javax.swing.JTextField txtDocente;
    // End of variables declaration//GEN-END:variables
}
