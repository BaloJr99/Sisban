
package sisban.Cajero;

import cl.model.dao.CuentaDao;
import cl.model.dao.TransaccionesDao;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblCuentas;
import jpa.TblEmpleado;
import jpa.TblTarjetas;
import jpa.TblTransacciones;
import misExcepciones.MisExcepciones;
import sisban.Login;


public class Operacion extends javax.swing.JFrame {
    TblCuentas tblcuenta;
    TblTarjetas tbltarjeta;
    TblEmpleado tblEmpleado;
    
    TransaccionesDao transaccionesDao;    
    CuentaDao cuentaDao;
    
    public Operacion() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public Operacion(int idEmpleado) {
        initComponents();
        setLocationRelativeTo(null);
        Query qf = entma.createNamedQuery("TblEmpleado.findByIdEmpleado");
        qf.setParameter("idEmpleado", idEmpleado);
        tblEmpleado = (TblEmpleado)qf.getSingleResult();
        txtCliente.setEnabled(false);
    }

    private boolean camposVacios() throws MisExcepciones{
        boolean flag = false;
        if(txtCuenta.isEnabled() && txtCuenta.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(36);
        }else if (txtTarjeta.isEnabled()&& txtTarjeta.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(37);
        }else if (txtCliente.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(38);
        }else if(txtCantidad.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(39);
        }else if(cbMovimiento.getSelectedIndex()==0){
            flag = true;
            throw new MisExcepciones(4);
        }
        return flag;
    }
    
    private void limpiarCampos(){
        cbMovimiento.setSelectedIndex(0);
        txtCuenta.setText("");
        txtCuenta.setEnabled(true);
        txtTarjeta.setText("");
        txtTarjeta.setEnabled(true);
        txtCliente.setText("");
        txtCantidad.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel2 = new javax.swing.JPanel();
        cbMovimiento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnOperacion = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        txtCuenta = new javax.swing.JFormattedTextField();
        txtTarjeta = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbMovimiento.setFont(new java.awt.Font("Tw Cen MT", 2, 14)); // NOI18N
        cbMovimiento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione..", "Deposito", "Retiro" }));
        jPanel2.add(cbMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 116, 272, -1));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("SISBAN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 21, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 11, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel3.setText("Movimiento");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 94, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Numero de cuenta ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 154, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel5.setText("Numero de Tarjeta");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Cliente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 270, -1, -1));

        txtCliente.setFont(new java.awt.Font("Tw Cen MT", 2, 14)); // NOI18N
        jPanel2.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 289, 283, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 325, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Tw Cen MT", 2, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 347, 272, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        btnOperacion.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnOperacion.setText("REALIZAR OPERACION");
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnLimpiar.setText("OPERACION NUEVA");

        btnSalir.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnSalir.setText("SALIR");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOperacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOperacion)
                    .addComponent(btnLimpiar)
                    .addComponent(btnSalir))
                .addContainerGap())
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 389, -1, -1));

        try {
            txtCuenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCuentaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCuentaFocusLost(evt);
            }
        });
        jPanel2.add(txtCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 182, 283, -1));

        try {
            txtTarjeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTarjeta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTarjetaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTarjetaFocusLost(evt);
            }
        });
        jPanel2.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 242, 283, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCuentaFocusLost
        try {
            Query qf = entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
            qf.setParameter("numeroCuenta", txtCuenta.getText());
            tblcuenta = (TblCuentas)qf.getSingleResult();
            if(tblcuenta.getEstado().equals("Activo")){
                txtCliente.setText(tblcuenta.getClienteidCliente().getNombre()+" "+ tblcuenta.getClienteidCliente().getApellidoPaterno()+" "+tblcuenta.getClienteidCliente().getApellidoMaterno());
                txtTarjeta.setEnabled(false);
            }else{
                JOptionPane.showMessageDialog(this, "Esa cuenta se encuentra inactiva");
            }
        } catch (NoResultException e) {
            txtTarjeta.setEnabled(true);
            txtCuenta.setText("");
            txtCliente.setText("");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_txtCuentaFocusLost

    private void txtTarjetaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTarjetaFocusLost
        try {
            Query qf = entma.createNamedQuery("TblTarjetas.findByNumTarjeta");
            qf.setParameter("numTarjeta", txtTarjeta.getText());
            tbltarjeta = (TblTarjetas)qf.getSingleResult();
            txtCliente.setText(tbltarjeta.getCuentasnumCuenta().getClienteidCliente().getNombre()+" "+ tbltarjeta.getCuentasnumCuenta().getClienteidCliente().getApellidoPaterno()+" "+tbltarjeta.getCuentasnumCuenta().getClienteidCliente().getApellidoMaterno());
            txtCuenta.setEnabled(false);
        } catch (NoResultException e) {
            txtCuenta.setText("");
            txtCliente.setText("");
            txtCuenta.setEnabled(true);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_txtTarjetaFocusLost

    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
        try {
            String tipoMovimiento = "";
            if(!camposVacios()){
                if(txtCuenta.isEnabled()){
                    if(new CuentaDao().saldo(txtCuenta.getText()) >= Float.valueOf(txtCantidad.getText()) || cbMovimiento.getSelectedIndex() == 1){
                        entma.getTransaction().begin();
                        TblTransacciones tblTransacciones = new TblTransacciones();
                        tblTransacciones.setClaveRastreo(generarClaveRastreo());
                        tblTransacciones.setDescripción(cbMovimiento.getSelectedItem().toString() + " A NOMBRE DE " + txtCliente.getText());
                        tblTransacciones.setMonto(Float.valueOf(txtCantidad.getText()));
                        tblTransacciones.setNumReferencia(generarReferencia());
                        if(cbMovimiento.getSelectedIndex() == 1){
                            tblTransacciones.setCuentaDestino(tblcuenta.getNumeroCuenta());
                        }else if(cbMovimiento.getSelectedIndex() == 2){
                            tblTransacciones.setCuentaDestino(null);
                        }
                        tblTransacciones.setDestinatario(txtCliente.getText());
                        switch(cbMovimiento.getSelectedIndex()){
                            case 1:
                                tipoMovimiento = "Abono";
                                break;
                            case 2:
                                tipoMovimiento = "Cargo";
                                break;
                        }
                        tblTransacciones.setTipoMovimiento(tipoMovimiento);
                        tblTransacciones.setBancosSucursal(tblEmpleado.getBancosSucursal().getSucursal());
                        tblTransacciones.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));
                        tblTransacciones.setHora(new Time(Calendar.getInstance().getTimeInMillis()));
                        if(cbMovimiento.getSelectedIndex() == 1){
                            tblTransacciones.setCuentasnumeroCuenta(null);
                        }else if(cbMovimiento.getSelectedIndex() == 2){
                            tblTransacciones.setCuentasnumeroCuenta(tblcuenta);
                        }
                        entma.persist(tblTransacciones);
                        entma.getTransaction().commit();
                        limpiarCampos();
                        JOptionPane.showMessageDialog(this, "Operacion realizada");
                    }else{
                        JOptionPane.showMessageDialog(this, "No hay fondos suficientes");
                    }
                }
            }
        } catch (NumberFormatException | MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnOperacionActionPerformed

    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if((!Character.isDigit(c) && c != '.') || txtCantidad.getText().contains(".")){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void txtCuentaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCuentaFocusGained
        if(txtCuenta.getText().trim().isEmpty()){
            txtCuenta.setText("");
        }
    }//GEN-LAST:event_txtCuentaFocusGained

    private void txtTarjetaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTarjetaFocusGained
        if(txtTarjeta.getText().equals("    -    -    -    ")){
            txtTarjeta.setText("");
        }
    }//GEN-LAST:event_txtTarjetaFocusGained

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private String generarClaveRastreo(){
        String clave = "";
        try {
            transaccionesDao = new TransaccionesDao();
            
            do{
                clave = "";
                
                for(int i = 0; i < 30; i++){
                    clave += String.valueOf(Math.floor(Math.random() * 8 + 1)).charAt(0);
                }
            }while(transaccionesDao.existeClave(clave));            
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, ne.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        return clave;
    }
    
    private String generarReferencia(){
        String referencia = "";
        try {
            transaccionesDao = new TransaccionesDao();
            
            do{
                referencia = "";
                
                for(int i = 0; i < 7; i++){
                    referencia += String.valueOf(Math.floor(Math.random() * 8 + 1)).charAt(0);
                }
            }while(transaccionesDao.existeReferencia(referencia));            
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, ne.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        return referencia;
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
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Operacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Operacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnOperacion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cbMovimiento;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JFormattedTextField txtCuenta;
    private javax.swing.JFormattedTextField txtTarjeta;
    // End of variables declaration//GEN-END:variables
}
