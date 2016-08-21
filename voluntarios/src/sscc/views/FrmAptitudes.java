/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscc.views;

import java.text.SimpleDateFormat;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sscc.businesslogic.Voluntario;

/**
 *
 * @author valquirialbr
 */
public class FrmAptitudes extends javax.swing.JFrame {

    DefaultTableModel dtm = null;
    /**
     * Creates new form FrmVoluntario
     */
    public FrmAptitudes() {
        initComponents();
        setBackground(new java.awt.Color(51, 51, 255));
        this.repaint();
        this.setLocationRelativeTo(null);
        DefaultListModel dlm = new DefaultListModel();
        lAptitudes.setModel(dlm);
        dtm = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Identificacion", "Nombre", "Fecha de Ingreso", "Fecha de Actualización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        tblVoluntarios.setModel(dtm);
        resetForm();
    }
    
    private void bloquear() {
        lblEsperar.setVisible(true);
        btnAdd.setEnabled(false);
        btnRem.setEnabled(false);
    }
    
    private void desbloquear() {
        lblEsperar.setVisible(false);
        btnAdd.setEnabled(true);
        btnRem.setEnabled(true);
    }
    
    private void resetForm() {
        txtAptitud.setText("");   
        ((DefaultListModel)lAptitudes.getModel()).clear();
        lblEsperar.setVisible(false);
        dtm.setRowCount(0);        
    }

    private void habilitaForm() {
        btnAdd.setEnabled(true);
        btnRem.setEnabled(true);
        txtAptitud.setText("");
        txtAptitud.setEnabled(true);
        ((DefaultListModel)lAptitudes.getModel()).clear();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAptitud = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lAptitudes = new javax.swing.JList<String>();
        btnRem = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVoluntarios = new javax.swing.JTable();
        lblEsperar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 255));
        setIconImage(sscc.views.images.ImageLoader.obtenerImagen("favicon.ico"));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Búsqueda por Aptitudes");

        jLabel10.setText("Aptitud");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sscc/views/images/add.png"))); // NOI18N
        btnAdd.setToolTipText("Agregar a la lista");
        btnAdd.setBorder(null);
        btnAdd.setBorderPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        lAptitudes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lAptitudes);

        btnRem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sscc/views/images/remove.png"))); // NOI18N
        btnRem.setToolTipText("Quitar de la lista");
        btnRem.setBorder(null);
        btnRem.setBorderPainted(false);
        btnRem.setContentAreaFilled(false);
        btnRem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(51, 204, 0));
        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sscc/views/images/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tblVoluntarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Nombre", "Fecha de Ingreso", "Fecha de Actualización"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblVoluntarios);

        lblEsperar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblEsperar.setForeground(new java.awt.Color(255, 0, 51));
        lblEsperar.setText("Espere...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 637, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEsperar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtAptitud, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblEsperar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRem)
                    .addComponent(btnAdd)
                    .addComponent(txtAptitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel10))
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        bloquear();     
        if (((DefaultListModel)lAptitudes.getModel()).getSize() > 0){                    
            Voluntario[] a_voluntarios = new Voluntario().buscarPorAptitudes(
            ((DefaultListModel)lAptitudes.getModel()).toArray());
            if(a_voluntarios.length == 0){
                JOptionPane.showMessageDialog(rootPane, 
                                            "No hay datos para mostrar", 
                                            "Mensaje",
                                            JOptionPane.INFORMATION_MESSAGE);
            }else{
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                for(int i = 0; i<a_voluntarios.length;i++){
                    dtm.addRow(new Object[]{
                        a_voluntarios[i].getIdentificacion(),
                        a_voluntarios[i].getNombre(),
                        sdf.format(a_voluntarios[i].getFechaIngreso()),
                        sdf.format(a_voluntarios[i].getFechaActualizacion())
                    });
                }
            } 
        }else{
            JOptionPane.showMessageDialog(rootPane, 
                                            "Ingrese aptitudes", 
                                            "Mensaje",
                                            JOptionPane.INFORMATION_MESSAGE);
        }
        desbloquear();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(txtAptitud.getText().trim().equals(""))       
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar una aptitud", "Mensaje", JOptionPane.WARNING_MESSAGE);
        else{
            DefaultListModel dlm = (DefaultListModel)lAptitudes.getModel();
            if(!dlm.contains(txtAptitud.getText()))
                dlm.addElement(txtAptitud.getText());
            else
                JOptionPane.showMessageDialog(rootPane, "Aptitud ya existe", "Mensaje", JOptionPane.WARNING_MESSAGE);
            txtAptitud.setText("");
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemActionPerformed
        if(lAptitudes.getSelectedIndex() < 0)       
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una aptitud", "Mensaje", JOptionPane.WARNING_MESSAGE);
        else{
            DefaultListModel dlm = (DefaultListModel)lAptitudes.getModel();
            dlm.removeElementAt(lAptitudes.getSelectedIndex());
        }
    }//GEN-LAST:event_btnRemActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAptitudes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lAptitudes;
    private javax.swing.JLabel lblEsperar;
    private javax.swing.JTable tblVoluntarios;
    private javax.swing.JTextField txtAptitud;
    // End of variables declaration//GEN-END:variables
}