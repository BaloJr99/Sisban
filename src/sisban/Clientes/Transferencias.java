package sisban.Clientes;

import cl.model.dao.CuentaDao;
import javax.swing.JOptionPane;
import jpa.TblCuentas;
import sisban.Login;

public class Transferencias extends javax.swing.JFrame {

    int idCliente;
    String numCuenta;
    
    TblCuentas tblCuentas;
    
    public Transferencias() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public Transferencias(int idCliente, String numCuenta) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.numCuenta = numCuenta;
        if(new CuentaDao().contarCuentas(idCliente) < 2){
            btnTransMiCuenta.setEnabled(false);
        }else{
            btnTransMiCuenta.setEnabled(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnMisCuentas = new javax.swing.JButton();
        btnTranferencias = new javax.swing.JButton();
        btnMovimientos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnTransMiCuenta = new javax.swing.JButton();
        btnTransOtraCuenta = new javax.swing.JButton();
        btnTransServicios = new javax.swing.JButton();
        btnSalir2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));

        btnMisCuentas.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnMisCuentas.setText("MIS CUENTAS");
        btnMisCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMisCuentasActionPerformed(evt);
            }
        });

        btnTranferencias.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnTranferencias.setText("TRANSFERENCIAS");
        btnTranferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTranferenciasActionPerformed(evt);
            }
        });

        btnMovimientos.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnMovimientos.setText("MOVIMIENTOS");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnMisCuentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTranferencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMovimientos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMisCuentas)
                    .addComponent(btnTranferencias)
                    .addComponent(btnMovimientos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 380, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("SISBAN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        btnTransMiCuenta.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnTransMiCuenta.setText("A MIS CUENTAS");
        btnTransMiCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransMiCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransMiCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 290, -1));

        btnTransOtraCuenta.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnTransOtraCuenta.setText("A OTRAS CUENTAS O BANCOS");
        btnTransOtraCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransOtraCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransOtraCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 290, -1));

        btnTransServicios.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        btnTransServicios.setText("PAGO DE SERVICIOS");
        btnTransServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransServiciosActionPerformed(evt);
            }
        });
        jPanel1.add(btnTransServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 290, -1));

        btnSalir2.setBackground(new java.awt.Color(255, 255, 204));
        btnSalir2.setText("LOG OUT");
        btnSalir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalir2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

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
        MisCuentas miCuenta = new MisCuentas(idCliente, numCuenta);
        miCuenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMisCuentasActionPerformed

    private void btnTransMiCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransMiCuentaActionPerformed
        TransferenciasAMisCuentas misCuentas = new TransferenciasAMisCuentas(idCliente,numCuenta);
        misCuentas.setVisible(true);
    }//GEN-LAST:event_btnTransMiCuentaActionPerformed

    private void btnTranferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTranferenciasActionPerformed
        JOptionPane.showMessageDialog(this, "Ya estas en Transferencias");
    }//GEN-LAST:event_btnTranferenciasActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        PreMovimientos movimientos = new PreMovimientos(idCliente, numCuenta);
        movimientos.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnTransOtraCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransOtraCuentaActionPerformed
        TranferenciasAOtrasCuentasOBanco otrasCuentas = new TranferenciasAOtrasCuentasOBanco(idCliente, numCuenta);
        otrasCuentas.setVisible(true);
    }//GEN-LAST:event_btnTransOtraCuentaActionPerformed

    private void btnTransServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransServiciosActionPerformed
        PagoDeServicios pago = new PagoDeServicios(idCliente, numCuenta);
        pago.setVisible(true);
    }//GEN-LAST:event_btnTransServiciosActionPerformed

    private void btnSalir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalir2ActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalir2ActionPerformed

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
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transferencias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transferencias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMisCuentas;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSalir1;
    private javax.swing.JButton btnSalir2;
    private javax.swing.JButton btnTranferencias;
    private javax.swing.JButton btnTransMiCuenta;
    private javax.swing.JButton btnTransOtraCuenta;
    private javax.swing.JButton btnTransServicios;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
