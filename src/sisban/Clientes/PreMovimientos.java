package sisban.Clientes;

import cl.model.dao.CuentaDao;
import cl.model.dao.TransaccionesDao;
import java.time.LocalDate;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblCuentas;
import sisban.Login;

public class PreMovimientos extends javax.swing.JFrame {

    int idCliente;
    String numCuenta;
    
    TblCuentas tblCuentas;
    
    public PreMovimientos() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public PreMovimientos(int idCliente, String numCuenta) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.numCuenta = numCuenta;
        iniciar();
    }

    private void iniciar(){
        try {
            Query qf = entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
            qf.setParameter("numeroCuenta", numCuenta);
            tblCuentas = (TblCuentas)qf.getSingleResult();
            lblClabe.setText(tblCuentas.getClabe());
            lblSaldo.setText(String.valueOf(new CuentaDao().saldo(numCuenta)));
            TransaccionesDao transaccionesDao =  new TransaccionesDao();
            lblPromedio.setText(String.valueOf(transaccionesDao.promedio(numCuenta, LocalDate.now().getMonth().getValue(), LocalDate.now().getYear())));
            lblGastos.setText((String.valueOf(transaccionesDao.promedioGastos(numCuenta))));
            lblIngresos.setText((String.valueOf(transaccionesDao.promedioIngresos(numCuenta))));
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnMisCuentas = new javax.swing.JButton();
        btnTransferencias = new javax.swing.JButton();
        btnPremovimientos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnMovimientos = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        lblPromedio = new javax.swing.JLabel();
        lblClabe = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblGastos = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lblIngresos = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        entma.setFlushMode(javax.persistence.FlushModeType.AUTO);

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

        btnTransferencias.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnTransferencias.setText("TRANSFERENCIAS");
        btnTransferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTransferenciasActionPerformed(evt);
            }
        });

        btnPremovimientos.setFont(new java.awt.Font("Tw Cen MT", 1, 12)); // NOI18N
        btnPremovimientos.setText("MOVIMIENTOS");
        btnPremovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPremovimientosActionPerformed(evt);
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
                .addComponent(btnTransferencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPremovimientos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMisCuentas)
                    .addComponent(btnTransferencias)
                    .addComponent(btnPremovimientos))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 380, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("SISBAN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        btnMovimientos.setBackground(new java.awt.Color(255, 255, 204));
        btnMovimientos.setText("SALDO");
        btnMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMovimientosActionPerformed(evt);
            }
        });
        jPanel1.add(btnMovimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 280, -1));

        jLabel3.setText("Saldo Disponible");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabel5.setText("Saldo Promedio");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, -1));

        jLabel9.setText("CLABE");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        lblSaldo.setText("0.00");
        jPanel1.add(lblSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, -1));

        lblPromedio.setText("0.00");
        jPanel1.add(lblPromedio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        lblClabe.setText("000000000000000000");
        jPanel1.add(lblClabe, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, -1));

        jLabel21.setText("Gastos Promedio");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        lblGastos.setText("0.00");
        jPanel1.add(lblGastos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        jLabel23.setText("Ingresos Promedio");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        lblIngresos.setText("0.00");
        jPanel1.add(lblIngresos, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, -1, -1));

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
        MisCuentas miCuenta = new MisCuentas(idCliente, numCuenta);
        miCuenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMisCuentasActionPerformed

    private void btnPremovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPremovimientosActionPerformed
        JOptionPane.showMessageDialog(this, "Ya estas en movimientos");
    }//GEN-LAST:event_btnPremovimientosActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        Movimientos movimiento = new Movimientos(idCliente, numCuenta);
        movimiento.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnTransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciasActionPerformed
        Transferencias trans = new Transferencias(idCliente, numCuenta);
        trans.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransferenciasActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

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
            java.util.logging.Logger.getLogger(PreMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PreMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PreMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PreMovimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PreMovimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMisCuentas;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnPremovimientos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencias;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblClabe;
    private javax.swing.JLabel lblGastos;
    private javax.swing.JLabel lblIngresos;
    private javax.swing.JLabel lblPromedio;
    private javax.swing.JLabel lblSaldo;
    // End of variables declaration//GEN-END:variables
}
