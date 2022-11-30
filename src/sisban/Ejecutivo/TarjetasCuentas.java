package sisban.Ejecutivo;

import cl.model.dao.CuentaDao;
import cl.model.dao.TarjetaDao;
import cl.model.db.Cuenta;
import cl.model.db.Tarjeta;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TarjetasCuentas extends javax.swing.JFrame {

    private int idCliente;
    private int idEmpleado;
    
    CuentaDao cuentaDao;
    
    Cuenta cuenta;
    
    public TarjetasCuentas() {
        initComponents();
    }

    public TarjetasCuentas(int idCliente, int idEmpleado) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        llenarCuentas();
    }
    
    private void llenarCuentas(){
        try {
            ArrayList<Cuenta> listado = new CuentaDao().buscarCuentasE(idCliente);
            DefaultTableModel modelo =  (DefaultTableModel)tblCuentas.getModel();            
            modelo.setNumRows(0);
            Object datos[] = new Object[2];
            
            for(Cuenta cuentas: listado){
                datos[0] = cuentas.getNumeroCuenta();
                datos[1] = cuentas.getSaldo();
                modelo.addRow(datos);
            }
            
            tblCuentas.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void llenarTarjetas(){
        try {
            ArrayList<Tarjeta> listado = new TarjetaDao().buscarTarjetas(tblCuentas.getValueAt(tblCuentas.getSelectedRow(), 0).toString());
            DefaultTableModel modelo =  (DefaultTableModel)tblTarjetas.getModel();
            modelo.setNumRows(0);
            Object datos[] = new Object[1];
            for(Tarjeta tarjeta: listado){
                datos[0] = tarjeta.getNumTarjeta();
                modelo.addRow(datos);
            }
            
            tblTarjetas.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTarjetas = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCuentas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 153));
        jLabel3.setText("SISBAN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        tblTarjetas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarjeta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTarjetas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTarjetasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTarjetas);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 460, 120));

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel2.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, -1));

        tblCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cuenta", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCuentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCuentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuentasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCuentas);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 460, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblCuentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCuentasMouseClicked
        try {
            if(evt.getClickCount() > 1){
                GeneralClientes general = new GeneralClientes(idEmpleado, idCliente, tblCuentas.getValueAt(tblCuentas.getSelectedRow(), 0).toString(), "");
                general.setVisible(true);
                this.dispose();
            }else{
                llenarTarjetas();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tblCuentasMouseClicked

    private void tblTarjetasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTarjetasMouseClicked
        try {
            if(evt.getClickCount() > 1){
                GeneralClientes general = new GeneralClientes(idEmpleado, idCliente, 
                        tblCuentas.getValueAt(tblCuentas.getSelectedRow(), 0).toString(), 
                        tblTarjetas.getValueAt(tblTarjetas.getSelectedRow(), 0).toString());
                general.setVisible(true);
                this.dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_tblTarjetasMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        GeneralClientes general = new GeneralClientes(idEmpleado, idCliente);
        general.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(TarjetasCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarjetasCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarjetasCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarjetasCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarjetasCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCuentas;
    private javax.swing.JTable tblTarjetas;
    // End of variables declaration//GEN-END:variables
}
