package sisban.Clientes;

import cl.model.dao.CuentaDao;
import cl.model.db.Cuenta;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblCliente;
import sisban.Login;

public class MisCuentas extends javax.swing.JFrame {
    
    private int idCliente;
    String numCuenta;
    
    TblCliente cliente;
    
    CuentaDao cuentaDao;
    
    public MisCuentas() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public MisCuentas(int idCliente) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        llenarCampos();
    }
    
    public MisCuentas(int idCliente, String numCuenta) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.numCuenta = numCuenta;
        llenarCampos();
    }

    private void llenarCampos(){
        try {
            cbCuentas.removeAllItems();
            Query qf = entma.createNamedQuery("TblCliente.findByIdCliente");
            qf.setParameter("idCliente", idCliente);
            cliente = (TblCliente)qf.getSingleResult();
            lblUsuario.setText(cliente.getNombre().toUpperCase() + " " + cliente.getApellidoPaterno().toUpperCase() + " " + cliente.getApellidoMaterno().toUpperCase());
            ArrayList<Cuenta> miCuenta = new CuentaDao().buscarCuentasC(idCliente);
            for(Cuenta cuentas: miCuenta){
                cbCuentas.addItem(cuentas.getNumeroCuenta());
            }
            this.numCuenta = cbCuentas.getSelectedItem().toString();
            txtTipoCuenta.setText(miCuenta.get(cbCuentas.getSelectedIndex()).getTipoCuenta());
            txtSaldo.setText(String.valueOf(miCuenta.get(cbCuentas.getSelectedIndex()).getSaldo()));
                    
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(this, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMisCuentas = new javax.swing.JButton();
        btnTransferencias = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        txtTipoCuenta = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        cbCuentas = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        btnMisCuentas.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnMisCuentas.setText("MIS CUENTAS");
        btnMisCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisCuentasActionPerformed(evt);
            }
        });

        btnTransferencias.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnTransferencias.setText("TRANSFERENCIAS");
        btnTransferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciasActionPerformed(evt);
            }
        });

        btnMovimientos.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnMovimientos.setText("MOVIMIENTOS");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMisCuentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransferencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMovimientos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMisCuentas)
                    .addComponent(btnTransferencias)
                    .addComponent(btnMovimientos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 380, -1));

        lblUsuario.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 210, 20));

        txtTipoCuenta.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtTipoCuenta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 220, 30));

        txtSaldo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtSaldo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 220, 30));

        cbCuentas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCuentasActionPerformed(evt);
            }
        });
        jPanel1.add(cbCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/tarjeta-de-credito (1).png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("SISBAN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        btnSalir.setBackground(new java.awt.Color(255, 255, 204));
        btnSalir.setText("LOG OUT");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMisCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisCuentasActionPerformed
        JOptionPane.showMessageDialog(this, "Ya estas en Mis Cuentas");
    }//GEN-LAST:event_btnMisCuentasActionPerformed

    private void btnTransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciasActionPerformed
        Transferencias tran = new Transferencias(idCliente, numCuenta);
        tran.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransferenciasActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        PreMovimientos pre = new PreMovimientos(idCliente, numCuenta);
        pre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void cbCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCuentasActionPerformed
        try {
            Query qf = entma.createNamedQuery("TblCliente.findByIdCliente");
            qf.setParameter("idCliente", idCliente);
            cliente = (TblCliente)qf.getSingleResult();
            ArrayList<Cuenta> miCuenta = new CuentaDao().buscarCuentasC(idCliente);
            txtTipoCuenta.setText(miCuenta.get(cbCuentas.getSelectedIndex()).getTipoCuenta());
            txtSaldo.setText(String.valueOf(miCuenta.get(cbCuentas.getSelectedIndex()).getSaldo()));
            numCuenta = cbCuentas.getSelectedItem().toString();
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(this, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cbCuentasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(MisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMisCuentas;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencias;
    private javax.swing.JComboBox<String> cbCuentas;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTipoCuenta;
    // End of variables declaration//GEN-END:variables
}
