/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscc.views;

import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sscc.businesslogic.Sector;

/**
 *
 * @author valquirialbr
 */
public class FrmUpdSector extends javax.swing.JFrame {

    DefaultTableModel dtm = null;
    int idSectorEditado = 0;
    /**
     * Creates new form FrmValidacion
     */
    public FrmUpdSector() {
        initComponents();        
        this.setLocationRelativeTo(null);
        lblEsperar.setVisible(false);
        dtm = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nombre", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        tblSectores.setModel(dtm);
        resetForm();        
    }
    
    private void bloquear(){
        btnGrabar.setEnabled(false);
        btnBuscar.setEnabled(false);
        btnCancel.setEnabled(false);
        lblEsperar.setVisible(true);
    }
    
    private void desbloquear(){
        btnGrabar.setEnabled(true);
        btnCancel.setEnabled(true);
        btnBuscar.setEnabled(true);
        lblEsperar.setVisible(false);
    }
    
    private void resetForm() {
        btnGrabar.setVisible(false);
        btnCancel.setVisible(false);
        txtNombre.setText("");
        txtNombre.setEnabled(false);
        cbEstado.setEnabled(false);  
        idSectorEditado = 0;
        dtm.setNumRows(0);
    }
    
    private void habilitaForm() {
        btnGrabar.setVisible(true);
        btnCancel.setVisible(true);
        txtNombre.setText("");
        txtNombre.setEnabled(true);
        cbEstado.setEnabled(true);
        
    }
    
    private void cargarDatosSector(String dSector) {
        resetForm();
        bloquear();
        Sector sector = new Sector().buscar(dSector);
        if(sector.getIdSector() == 0){
            JOptionPane.showMessageDialog(rootPane, 
                                        "No existe sector", 
                                        "Error al buscar",
                                        JOptionPane.WARNING_MESSAGE);
        }else{
            habilitaForm();
            txtNombre.setText(sector.getDescripcion());
            txtNombre.setEnabled(true);
            idSectorEditado = sector.getIdSector();
            cbEstado.setSelectedItem(sector.getEstado().equals("A")?"Activo":"Inactivo");
        }        
        desbloquear();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblEsperar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<String>();
        btnBuscar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSectores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Actualización de Sectores");

        lblEsperar.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblEsperar.setForeground(new java.awt.Color(255, 0, 51));
        lblEsperar.setText("Espere...");

        jLabel3.setText("Nombre");

        jLabel5.setText("Estado");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));

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

        btnGrabar.setBackground(new java.awt.Color(0, 204, 51));
        btnGrabar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGrabar.setForeground(new java.awt.Color(255, 255, 255));
        btnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sscc/views/images/save.png"))); // NOI18N
        btnGrabar.setText("Actualizar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(51, 204, 0));
        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sscc/views/images/cancel.png"))); // NOI18N
        btnCancel.setText("Cancelar");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tblSectores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSectores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSectoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSectores);
        if (tblSectores.getColumnModel().getColumnCount() > 0) {
            tblSectores.getColumnModel().getColumn(0).setResizable(false);
            tblSectores.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblEsperar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(124, 124, 124)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblEsperar))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnCancel)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        resetForm();
        Sector[] a_sectores = new Sector().buscar();
        if(a_sectores.length == 0){
            JOptionPane.showMessageDialog(rootPane, 
                                        "No hay datos para mostrar", 
                                        "Mensaje",
                                        JOptionPane.INFORMATION_MESSAGE);
        }else{            
            for(int i = 0; i<a_sectores.length;i++){
                dtm.addRow(new Object[]{
                    a_sectores[i].getDescripcion(),
                    a_sectores[i].getEstado()
                });
            }
        }  
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        bloquear();
        Sector sector = new Sector();
        boolean validado = sector.validarU(
                        txtNombre.getText(),
                        idSectorEditado,
                        (String)cbEstado.getSelectedItem());
        if(validado == true){
            boolean grabado = sector.actualizar();
            if(grabado == true){                
                JOptionPane.showMessageDialog(rootPane, "Sector grabado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                
            }else{
                JOptionPane.showMessageDialog(rootPane, "Error al grabar", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Datos incorrectos. Por favor revise", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }    
        desbloquear();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblSectoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSectoresMouseClicked
        Point p = tblSectores.getMousePosition();
        int row = tblSectores.rowAtPoint(p);
        if (evt.getClickCount() >= 2) {
            String dSector = (String)dtm.getValueAt(row, 0);
            cargarDatosSector(dSector);
        }  
    }//GEN-LAST:event_tblSectoresMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmUpdSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmUpdSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmUpdSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmUpdSector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmUpdSector().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEsperar;
    private javax.swing.JTable tblSectores;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    

    
}
