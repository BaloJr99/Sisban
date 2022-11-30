
package sisban.Clientes;

import cl.model.dao.CuentaDao;
import cl.model.dao.PreguntasDao;
import cl.model.dao.RespuestasDao;
import cl.model.dao.TransaccionesDao;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblCuentas;
import jpa.TblEmpleado;
import jpa.TblTarjetas;
import jpa.TblTransacciones;
import misExcepciones.MisExcepciones;
import sisban.Login;


public class PagoDeServicios extends javax.swing.JFrame {
    TblCuentas tblcuenta;
    TblCuentas tblcuenta2;
    TblTarjetas tbltarjeta;
    TblEmpleado tblEmpleado;
    
    TransaccionesDao transaccionesDao; 
    CuentaDao cuentaDao;
    
    int idCliente;
    String numCuenta;
    
    public PagoDeServicios() {
        initComponents();
    }
    
    public PagoDeServicios(int idCliente, String numCuenta) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.numCuenta = numCuenta;
        Query qf = entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
        qf.setParameter("numeroCuenta",numCuenta);
        tblcuenta = (TblCuentas)qf.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnOperacion = new javax.swing.JButton();
        tbEnergia = new javax.swing.JToggleButton();
        tbAgua = new javax.swing.JToggleButton();
        tbGas = new javax.swing.JToggleButton();
        tbInternet = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("SISBAN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 31, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 21, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel6.setText("Cliente");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 183, -1, -1));

        txtCliente.setFont(new java.awt.Font("Tw Cen MT", 2, 14)); // NOI18N
        jPanel2.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 202, 272, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 238, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Tw Cen MT", 2, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(106, 260, 272, -1));

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        btnOperacion.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnOperacion.setText("REALIZAR OPERACION");
        btnOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOperacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnOperacion)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOperacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 302, 436, -1));

        tbEnergia.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(tbEnergia);
        tbEnergia.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbEnergia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/idea.png"))); // NOI18N
        tbEnergia.setText("Energia");
        tbEnergia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbEnergiaActionPerformed(evt);
            }
        });
        jPanel2.add(tbEnergia, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 107, -1, 46));

        tbAgua.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(tbAgua);
        tbAgua.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbAgua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/soltar.png"))); // NOI18N
        tbAgua.setText("Agua");
        tbAgua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbAguaActionPerformed(evt);
            }
        });
        jPanel2.add(tbAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 107, -1, 46));

        tbGas.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(tbGas);
        tbGas.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbGas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/gas.png"))); // NOI18N
        tbGas.setText("Gas");
        tbGas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbGasActionPerformed(evt);
            }
        });
        jPanel2.add(tbGas, new org.netbeans.lib.awtextra.AbsoluteConstraints(222, 107, -1, 46));

        tbInternet.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(tbInternet);
        tbInternet.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbInternet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/wifi.png"))); // NOI18N
        tbInternet.setText("Internet");
        tbInternet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbInternetActionPerformed(evt);
            }
        });
        jPanel2.add(tbInternet, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 107, -1, 46));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean camposVacios() throws MisExcepciones{
        boolean flag = false;
         if (txtCliente.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(38);
        }else if(txtCantidad.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(39);
        }else if (buttonGroup1.getSelection()==null){
           flag = true;
           throw new MisExcepciones(40);
        }
        return flag;
    }
    
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
     
    
    private void txtCantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadKeyTyped
        char c = evt.getKeyChar();
        if((!Character.isDigit(c) && c != '.') || txtCantidad.getText().contains(".")){
            evt.consume();
        }
    }//GEN-LAST:event_txtCantidadKeyTyped

    private void btnOperacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOperacionActionPerformed
        try {
            if(!camposVacios()){
                if(buttonGroup1.getSelection()!= null){
                    PreguntasDao preguntasDao = new PreguntasDao();
                    RespuestasDao respuestaDao = new RespuestasDao();
                    int strikes = 0;
                    boolean flag = false;
                    String respuestaIngresada;

                    while(strikes < 3 && !flag){
                        ArrayList pregunta = preguntasDao.pregunta();
                        respuestaIngresada = JOptionPane.showInputDialog(this, pregunta.get(1));
                        if(respuestaIngresada.equals(respuestaDao.buscarRespuesta(idCliente, Integer.valueOf(pregunta.get(0).toString())))){
                            flag = true;
                        }else{
                            strikes++;
                            JOptionPane.showMessageDialog(this, "Respuesta incorrecta, tiene " + (3 - strikes) + " intentos");
                        }
                    }

                    if(flag){
                        entma.getTransaction().begin();
                        TblTransacciones tblTransacciones = new TblTransacciones();
                        tblTransacciones.setClaveRastreo(generarClaveRastreo());
                        tblTransacciones.setDescripción("TRANSFERENCIA A SERVICIO DE: " + tblcuenta2.getClienteidCliente().getNombre());
                        tblTransacciones.setMonto(Float.valueOf(txtCantidad.getText()));
                        tblTransacciones.setNumReferencia(generarReferencia());
                        tblTransacciones.setCuentaDestino(tblcuenta2.getNumeroCuenta());
                        tblTransacciones.setDestinatario(txtCliente.getText());
                        tblTransacciones.setTipoMovimiento("Cargo");
                        tblTransacciones.setBancosSucursal(tblcuenta2.getBancoSucursal().getSucursal());
                        tblTransacciones.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));
                        tblTransacciones.setHora(new Time(Calendar.getInstance().getTimeInMillis()));
                        tblTransacciones.setCuentasnumeroCuenta(tblcuenta);
                        entma.persist(tblTransacciones);
                        entma.getTransaction().commit();
                        JOptionPane.showMessageDialog(this, "Operacion realizada");
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "Se han hecho 3 intentos vuelva despues");
                    }
                }
            }
        } catch (NumberFormatException | MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnOperacionActionPerformed

    private void tbEnergiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbEnergiaActionPerformed
        try {
            if(tbEnergia.isSelected()){
                Query qf2 =  entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
                qf2.setParameter("numeroCuenta", "78753622388");
                tblcuenta2= (TblCuentas)qf2.getSingleResult();
                txtCliente.setText(tblcuenta2.getClienteidCliente().getNombre());
            }else{
                txtCliente.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbEnergiaActionPerformed

    private void tbAguaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbAguaActionPerformed
        try {
            if(tbAgua.isSelected()){
                Query qf2 =  entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
                qf2.setParameter("numeroCuenta", "18481541337");
                tblcuenta2= (TblCuentas)qf2.getSingleResult();
                txtCliente.setText(tblcuenta2.getClienteidCliente().getNombre());
            }else{
                txtCliente.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbAguaActionPerformed

    private void tbGasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbGasActionPerformed
        try {
            if(tbGas.isSelected()){
                Query qf2 =  entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
                qf2.setParameter("numeroCuenta", "61435814212");
                tblcuenta2= (TblCuentas)qf2.getSingleResult();
                txtCliente.setText(tblcuenta2.getClienteidCliente().getNombre());
            }else{
                txtCliente.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbGasActionPerformed

    private void tbInternetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbInternetActionPerformed
        try {
            if(tbInternet.isSelected()){
                Query qf2 =  entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
                qf2.setParameter("numeroCuenta", "32281281714");
                tblcuenta2= (TblCuentas)qf2.getSingleResult();
                txtCliente.setText(tblcuenta2.getClienteidCliente().getNombre());
            }else{
                txtCliente.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tbInternetActionPerformed

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
            java.util.logging.Logger.getLogger(PagoDeServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagoDeServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagoDeServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagoDeServicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagoDeServicios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOperacion;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToggleButton tbAgua;
    private javax.swing.JToggleButton tbEnergia;
    private javax.swing.JToggleButton tbGas;
    private javax.swing.JToggleButton tbInternet;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables
}
