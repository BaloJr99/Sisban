package sisban;

import cl.model.dao.RespuestasDao;
import java.awt.HeadlessException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblUsuariosClientes;
import jpa.TblUsuariosEmpleados;
import misExcepciones.MisExcepciones;

public class CrearUsuario extends javax.swing.JFrame {

    private String tipo;
    
    TblUsuariosClientes cliente;
    TblUsuariosEmpleados empleado;
    
    RespuestasDao respuestas;
    
    public CrearUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public CrearUsuario(String id, String tipo, boolean recuperar) {
        initComponents();
        setLocationRelativeTo(null);
        this.tipo = tipo;
        txtIdentificacion.setText(id);
        if(recuperar){
            btnCrear.setEnabled(false);
            if(tipo.equals("Cliente")){
                    Query qf = entma.createNamedQuery("TblUsuariosClientes.findByTblClienteidCliente");
                    qf.setParameter("tblClienteidCliente", Integer.valueOf(id));
                    cliente = (TblUsuariosClientes)qf.getSingleResult();
                    txtUsuario.setText(cliente.getUsuario());
                    txtUsuario.setEnabled(false);
                    txtContrasena.setEnabled(false);
                    txtConfContrasena.setEnabled(false);
                } else if(tipo.equals("Empleado")){
                    Query qf = entma.createNamedQuery("TblUsuariosEmpleados.findByTblEmpleadoidEmpleado");
                    qf.setParameter("tblEmpleadoidEmpleado", Integer.valueOf(id));
                    empleado = (TblUsuariosEmpleados)qf.getSingleResult();
                    txtUsuario.setText(empleado.getUsuario());
                    txtUsuario.setEnabled(false);
                    txtContrasena.setEnabled(false);
                    txtConfContrasena.setEnabled(false);
                }
        }else{
            btnRecuperar.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JPasswordField();
        txtConfContrasena = new javax.swing.JPasswordField();
        btnCrear = new javax.swing.JButton();
        btnRecuperar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 153));
        lblTitulo.setText("SISBAN");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 16, -1, -1));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 6, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel1.setText("Numero de identificacion");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 108, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 148, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel3.setText("Password");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 186, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        jLabel4.setText("Confirme password");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 227, -1, -1));

        txtIdentificacion.setFont(new java.awt.Font("Tw Cen MT", 2, 12)); // NOI18N
        txtIdentificacion.setEnabled(false);
        jPanel1.add(txtIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 120, 202, -1));

        txtUsuario.setFont(new java.awt.Font("Tw Cen MT", 2, 12)); // NOI18N
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 160, 203, -1));
        jPanel1.add(txtContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 200, 203, -1));
        jPanel1.add(txtConfContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(146, 247, 203, -1));

        btnCrear.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnCrear.setText("CREAR USUARIO");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 295, -1, -1));

        btnRecuperar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnRecuperar.setText("RECUPERAR CONTRASEÑA");
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 295, -1, -1));

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 351, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public boolean camposVacios() throws MisExcepciones{
        boolean flag = false;
        
        if(txtUsuario.getText().isEmpty()){
                flag = true;
                throw new MisExcepciones(29);
            }else if(txtContrasena.getPassword().length == 0){
                flag = true;
                throw new MisExcepciones(30);
            }else if(txtConfContrasena.getPassword().length == 0){
                flag = true;
                throw new MisExcepciones(31);
            }else if(!new String(txtContrasena.getPassword()).equals(new String(txtConfContrasena.getPassword()))){
                flag = true;
                throw new MisExcepciones(32);
        }
                
        return flag;
    }
    
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        try {
            if(!camposVacios()){
                if(tipo.equals("Cliente")){
                    String resp1, resp2, resp3, resp4, resp5;
                    if(JOptionPane.showConfirmDialog(this, "Para crear un usuario es necesario contestar preguntas de seguridad\n¿Desea continuar?") == JOptionPane.YES_OPTION){
                        resp1 = JOptionPane.showInputDialog(this, "Pregunta 1\n¿Cual es tu animal favorito?");
                        resp2 = JOptionPane.showInputDialog(this, "Pregunta 2\n¿Nombre de tu primer mascota?");
                        resp3 = JOptionPane.showInputDialog(this, "Pregunta 3\n¿Color favorito?");
                        resp4 = JOptionPane.showInputDialog(this, "Pregunta 4\n¿Comida favorita?");
                        resp5 = JOptionPane.showInputDialog(this, "Pregunta 5\n¿Nombre de tu pelicula favorita?");
                        if(!resp1.isEmpty() && !resp2.isEmpty() && !resp3.isEmpty() && !resp4.isEmpty() && !resp5.isEmpty()){
                            respuestas = new RespuestasDao();
                            respuestas.insertarRespuestas(Integer.valueOf(txtIdentificacion.getText()), resp1, resp2, resp3, resp4, resp5);
                            entma.getTransaction().begin();
                            cliente = new TblUsuariosClientes();
                            cliente.setTblClienteidCliente(Integer.valueOf(txtIdentificacion.getText()));
                            cliente.setContrasena(new String(txtContrasena.getPassword()));
                            cliente.setUsuario("C" + txtUsuario.getText());
                            entma.persist(cliente);
                            entma.getTransaction().commit(); 
                            this.dispose(); 
                            JOptionPane.showMessageDialog(this, "Usuario creado con exito");      
                        }else{
                            JOptionPane.showMessageDialog(this, "No fue posible crear el usuario debido a que habia respuestas vacias");
                        }
                    }else{
                        JOptionPane.showMessageDialog(this, "No fue posible crear el usuario");
                    }
                }else{
                    entma.getTransaction().begin();
                    empleado = new TblUsuariosEmpleados();
                    empleado.setTblEmpleadoidEmpleado(Integer.valueOf(txtIdentificacion.getText()));
                    empleado.setContrasena(new String(txtContrasena.getPassword()));
                    empleado.setUsuario("E" + txtUsuario.getText());
                    entma.persist(empleado);
                    entma.getTransaction().commit();
                    this.dispose(); 
                    JOptionPane.showMessageDialog(this, "Usuario creado con exito");
                }
            }
        } catch (NumberFormatException | MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
        try {
            if(JOptionPane.showInputDialog("Ingresar contraseña administrativa").equals("admin")){
                if(tipo.equals("Cliente")){
                    JOptionPane.showMessageDialog(this, cliente.getContrasena());
                    this.dispose(); 
                }else{
                    JOptionPane.showMessageDialog(this, empleado.getContrasena());
                    this.dispose(); 
                }
            }else{
                JOptionPane.showMessageDialog(this, "No tiene autorizacion");
            }
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        try {
            if(!txtUsuario.getText().isEmpty()){
                if(tipo.equals("Cliente")){
                    Query qf = entma.createNamedQuery("TblUsuariosClientes.findByUsuario");
                    qf.setParameter("usuario", "C" + txtUsuario.getText());
                    cliente = (TblUsuariosClientes)qf.getSingleResult();
                    txtUsuario.setText("");
                    JOptionPane.showMessageDialog(this, "Ya existe ese usuario");
                } else if(tipo.equals("Empleado")){
                    Query qf = entma.createNamedQuery("TblUsuariosEmpleados.findByUsuario");
                    qf.setParameter("usuario", "E" + txtUsuario.getText());
                    empleado = (TblUsuariosEmpleados)qf.getSingleResult();
                    txtUsuario.setText("");
                    JOptionPane.showMessageDialog(this, "Ya existe ese usuario");
                }
            }
        } catch (NoResultException e) {
            
        }  catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnRecuperar;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPasswordField txtConfContrasena;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
