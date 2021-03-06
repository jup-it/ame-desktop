/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sscc.views;

import java.awt.Point;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sscc.businesslogic.Aptitud;
import sscc.businesslogic.Sector;
import sscc.businesslogic.Voluntario;

/**
 *
 * @author valquirialbr
 */
public class FrmValidacion extends javax.swing.JFrame {

    DefaultTableModel dtm = null;
    /**
     * Creates new form FrmValidacion
     */
    public FrmValidacion() {
        initComponents();
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
        cargaSectores();
    }
    
    public void cargaSectores(){
        try {
            Sector sector = new Sector();
            DefaultComboBoxModel dcbm = (DefaultComboBoxModel)cbSector.getModel();
            dcbm.removeAllElements();
            for(String descripcion : sector.listar())
                dcbm.addElement(descripcion);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error al cargar Sectores", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void bloquear() {
        lblEsperar.setVisible(true);
        btnAdd.setEnabled(false);
        btnCancel.setEnabled(false);
        btnGrabar.setEnabled(false);
        btnRem.setEnabled(false);
    }
    
    private void desbloquear() {
        lblEsperar.setVisible(false);
        btnAdd.setEnabled(true);
        btnCancel.setEnabled(true);
        btnGrabar.setEnabled(true);
        btnRem.setEnabled(true);
    }
    
    private void resetForm() {
        btnGrabar.setVisible(false);
        btnCancel.setVisible(false);
        btnLimpiar.setVisible(false);
        btnAdd.setEnabled(false);
        btnRem.setEnabled(false);
        txtAptitud.setText("");
        txtAptitud.setEnabled(false);
        txtCorreo.setText("");
        txtCorreo.setEnabled(false);
        txtFechaNac.setText("dd/MM/yyyy");
        txtFechaNac.setEnabled(false);
        txtId.setText("");
        txtNombre.setText("");
        txtNombre.setEnabled(false);
        txtTelefono.setText("");
        txtTelefono.setEnabled(false);
        cbSector.setEnabled(false);
        cbProfesion.setEnabled(false);        
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        rbF.setEnabled(false);        
        rbM.setEnabled(false);        
        rbS.setEnabled(false);        
        rbN.setEnabled(false);
        ((DefaultListModel)lAptitudes.getModel()).clear();
        lblEsperar.setVisible(false);
        dtm.setRowCount(0);        
    }

    private void habilitaForm() {
        btnGrabar.setVisible(true);
        btnCancel.setVisible(true);
        btnLimpiar.setVisible(true);
        btnAdd.setEnabled(true);
        btnRem.setEnabled(true);
        txtAptitud.setText("");
        txtAptitud.setEnabled(true);
        txtCorreo.setText("");
        txtCorreo.setEnabled(true);
        txtFechaNac.setText("dd/MM/yyyy");
        txtFechaNac.setEnabled(true);
        txtId.setText("");
        txtNombre.setText("");
        txtNombre.setEnabled(true);
        txtTelefono.setText("");
        txtTelefono.setEnabled(true);
        cbSector.setEnabled(true);
        cbProfesion.setEnabled(true);        
        rbF.setEnabled(true);        
        rbM.setEnabled(true);        
        rbS.setEnabled(true);        
        rbN.setEnabled(true);
        ((DefaultListModel)lAptitudes.getModel()).clear();
        
    }
    
    private void cargarDatosVoluntario(String identificacion) {
        resetForm();
        bloquear();
        Voluntario voluntario = new Voluntario().buscar(identificacion);
        Aptitud aptitud = new Aptitud();
        if(voluntario.getIdentificacion() == null){
            JOptionPane.showMessageDialog(rootPane, 
                                        "No existe identificación", 
                                        "Error al buscar",
                                        JOptionPane.WARNING_MESSAGE);
        }else{
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            habilitaForm();
            txtId.setText(voluntario.getIdentificacion());
            txtId.setEnabled(false);
            txtCorreo.setText(voluntario.getCorreo());
            txtFechaNac.setText(df.format(voluntario.getFechaNacimiento()));
            txtNombre.setText(voluntario.getNombre());
            txtTelefono.setText(voluntario.getTelefono());
            if(voluntario.getSexo().equals("M"))
                rbM.setSelected(true);
            else
                rbF.setSelected(true);
            if(voluntario.getEsLider().equals("S"))
                rbS.setSelected(true);
            else
                rbN.setSelected(true);
            cbProfesion.setSelectedItem(voluntario.getProfesion());
            Sector sector = new Sector().buscar(voluntario.getIdSector());
            if(sector != null)
                cbSector.setSelectedItem(sector.getDescripcion());
            DefaultListModel dlm = (DefaultListModel)lAptitudes.getModel();
            dlm.clear();
            for(String elemento : aptitud.buscar(txtId.getText())){
                dlm.addElement(elemento);
            }
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAptitud = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txtFechaNac = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbProfesion = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lAptitudes = new javax.swing.JList<>();
        btnBuscar = new javax.swing.JButton();
        btnGrabar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        cbSector = new javax.swing.JComboBox<>();
        btnRem = new javax.swing.JButton();
        rbM = new javax.swing.JRadioButton();
        rbF = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        rbS = new javax.swing.JRadioButton();
        rbN = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVoluntarios = new javax.swing.JTable();
        lblEsperar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Validaciòn de Datos");

        jLabel2.setText("Identificacion");

        jLabel9.setText("Correo");

        txtId.setEditable(false);

        jLabel3.setText("Nombre");

        jLabel10.setText("Aptitud");

        jLabel4.setText("Fecha de Nacimiento");

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

        txtFechaNac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        txtFechaNac.setToolTipText("dd/mm/yyyy");
        txtFechaNac.setValue(new java.util.Date());

        jLabel5.setText("Profesión");

        jLabel6.setText("Sexo");

        cbProfesion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abogado", "Doctor", "Profesor", "Ing. en Sistemas", "Ing. Civil", "Ing. Electronico", "Arquitecto", "Enfermero", "Psicologo", "Adm. de Empresas", "Ing. Comercial", "Quehaceres domésticos", "Mecánico", "Estudiante", "Otro" }));

        lAptitudes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lAptitudes);

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
        btnGrabar.setText("Validar");
        btnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(51, 204, 0));
        btnLimpiar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sscc/views/images/clean.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
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

        jLabel11.setText("Sector");

        cbSector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        buttonGroup1.add(rbM);
        rbM.setText("M");

        buttonGroup1.add(rbF);
        rbF.setText("F");

        jLabel7.setText("Es líder");

        buttonGroup2.add(rbS);
        rbS.setText("Si");

        buttonGroup2.add(rbN);
        rbN.setText("No");

        jLabel8.setText("Teléfono");

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
        tblVoluntarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVoluntariosMouseClicked(evt);
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
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId)
                            .addComponent(txtCorreo)
                            .addComponent(txtNombre)
                            .addComponent(txtFechaNac)
                            .addComponent(txtTelefono)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbM)
                                            .addComponent(rbS))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbF)
                                            .addComponent(rbN))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(22, 22, 22)
                                .addComponent(cbSector, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtAptitud, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRem))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEsperar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblEsperar))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFechaNac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbProfesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rbM)
                            .addComponent(rbF))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(rbS)
                            .addComponent(rbN))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRem)
                            .addComponent(btnAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cbSector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(txtAptitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGrabar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnCancel)
                    .addComponent(btnBuscar))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        resetForm();
        
        Voluntario[] a_voluntarios = new Voluntario().buscarNoValidados();
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
                    (a_voluntarios[i].getFechaActualizacion() != null)?
                        sdf.format(a_voluntarios[i].getFechaActualizacion()):""
                });
            }
        }        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarActionPerformed
        bloquear();
        Voluntario voluntario = new Voluntario();
        DefaultListModel dlm = (DefaultListModel)lAptitudes.getModel();        
        boolean validado = voluntario.validar(txtId.getText(), 
                            txtNombre.getText(), 
                            rbM.isSelected()?"M":"F", 
                            rbS.isSelected()?"S":"N", 
                            txtCorreo.getText(), 
                            txtTelefono.getText(), 
                            txtFechaNac.getText(), 
                            (String)cbSector.getSelectedItem(),
                            (String)cbProfesion.getSelectedItem());
        if(validado == true){
            voluntario.setValidado("S");
            boolean grabado = voluntario.actualizar();
            if(grabado == true){
                if(dlm.getSize() > 0){       
                    new Aptitud().eliminar(voluntario.getIdentificacion());
                    String[] l_apt = new String[dlm.getSize()];
                    for(int i = 0; i< l_apt.length;i++){
                        l_apt[i] = (String)dlm.get(i);
                    }
                    new Aptitud().guardar(l_apt, voluntario.getIdentificacion());
                }
                JOptionPane.showMessageDialog(rootPane, "Voluntario grabado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);                
            }else{
                JOptionPane.showMessageDialog(rootPane, "Error al grabar", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Datos incorrectos. Por favor revise", "Mensaje", JOptionPane.WARNING_MESSAGE);
        }    
        desbloquear();
    }//GEN-LAST:event_btnGrabarActionPerformed

    private void tblVoluntariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVoluntariosMouseClicked
        Point p = tblVoluntarios.getMousePosition();
        int row = tblVoluntarios.rowAtPoint(p);
        if (evt.getClickCount() >= 2) {
            String idVoluntario = (String)dtm.getValueAt(row, 0);
            cargarDatosVoluntario(idVoluntario);                       
        }  
    }//GEN-LAST:event_tblVoluntariosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        resetForm();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmValidacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmValidacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnGrabar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbProfesion;
    private javax.swing.JComboBox<String> cbSector;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lAptitudes;
    private javax.swing.JLabel lblEsperar;
    private javax.swing.JRadioButton rbF;
    private javax.swing.JRadioButton rbM;
    private javax.swing.JRadioButton rbN;
    private javax.swing.JRadioButton rbS;
    private javax.swing.JTable tblVoluntarios;
    private javax.swing.JTextField txtAptitud;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtFechaNac;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    

    
}
