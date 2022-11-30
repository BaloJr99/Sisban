package sisban;

import java.awt.event.KeyEvent;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblUsuariosClientes;
import jpa.TblUsuariosEmpleados;
import misExcepciones.MisExcepciones;
import sisban.Cajero.Operacion;
import sisban.Clientes.MisCuentas;
import sisban.Ejecutivo.GeneralClientes;
import sisban.Ejecutivo.Menu;

public class Login extends javax.swing.JFrame {
    
    CrearUsuario crear = new CrearUsuario();
    
    Imagen img;
    MisCuentas miCuenta;
    Operacion operacion;
    GeneralClientes general;
    Menu menu;
    
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 153));
        lblTitulo.setText("SISBAN");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        lblUsuario.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblUsuario.setText("Usuario");
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        txtUsuario.setFont(new java.awt.Font("Tw Cen MT", 2, 14)); // NOI18N
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 202, -1));

        lblPassword.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        lblPassword.setText("Password");
        jPanel1.add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });
        jPanel1.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 202, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean camposVacios() throws MisExcepciones{
        boolean flag = false;
        
        if(txtUsuario.getText().isEmpty()){
            flag = true;
            throw new MisExcepciones(1);
        }else if(txtPassword.getPassword().length == 0){
            flag = true;
            throw new MisExcepciones(2);
        }
        
        return flag;
    }
    
    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        try {
            if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                if(!camposVacios()){
                    login();
                }
            }  
        }catch (NoResultException ne){
            JOptionPane.showMessageDialog(this, new MisExcepciones(3).getMessage());
        }catch (MisExcepciones me){
            JOptionPane.showMessageDialog(this, me.getMessage());
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtPasswordKeyPressed

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        txtUsuario.setText(txtUsuario.getText().toLowerCase());
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void login() throws MisExcepciones{
        try {
            Query qfU = entma.createNamedQuery("TblUsuariosClientes.findByUsuario");
            qfU.setParameter("usuario", "C" + txtUsuario.getText());
            TblUsuariosClientes usuario = new TblUsuariosClientes();
            usuario = (TblUsuariosClientes)qfU.getSingleResult();
            String contra = new String(txtPassword.getPassword());
            if(usuario.getContrasena().equals(contra)){
                miCuenta = new MisCuentas(usuario.getTblClienteidCliente());
                miCuenta.setVisible(true);
                this.dispose();
            }else{
                throw new MisExcepciones(3);
            }
        }catch (NoResultException ne){
            Query qfE = entma.createNamedQuery("TblUsuariosEmpleados.findByUsuario");
            qfE.setParameter("usuario", "E" + txtUsuario.getText());
            TblUsuariosEmpleados empleado = new TblUsuariosEmpleados();
            empleado = (TblUsuariosEmpleados)qfE.getSingleResult();
            String contra = new String(txtPassword.getPassword());
            
            if(!empleado.getContrasena().equals(contra)){
                throw new MisExcepciones(3);
            }else{
                if(empleado.getTblEmpleado().getPuesto().equals("Cajero")){
                    operacion = new Operacion(empleado.getTblEmpleado().getIdEmpleado());
                    operacion.setVisible(true);
                    this.dispose();
                }else if(empleado.getTblEmpleado().getPuesto().equals("Ejecutivo")){
                    menu = new Menu(empleado.getTblEmpleadoidEmpleado());
                    menu.setVisible(true);
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(this, "Aun no esta configurado");
                    JOptionPane.showMessageDialog(this, "Esta funcion no esta disponible");
                    JOptionPane.showMessageDialog(this, "Por el momento");
                    JOptionPane.showMessageDialog(this, "Cuidate tqm");
                    img = new Imagen();
                    img.setVisible(true);
                }
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }finally{
            entma.clear();
        }
    }
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager entma;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
