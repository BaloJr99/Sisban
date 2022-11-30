package sisban.Clientes;

import cl.model.dao.CuentaDao;
import cl.model.db.EstadoCuenta;
import clases.Procesos;
import clases.ReportePdf;
import com.itextpdf.layout.Document;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import jpa.TblCuentas;
import sisban.Login;

public class Movimientos extends javax.swing.JFrame {

    public String mes = "";
    
    int idCliente;
    String numCuenta;
    
    TblCuentas tblCuenta;
    
    public Movimientos() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public Movimientos(int idCliente, String numCuenta) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.numCuenta = numCuenta;
        llenarTabla(); 
    }
    
    private void llenarTabla(){
        try {
            ArrayList<EstadoCuenta> estadoCuenta = new CuentaDao().estadoCuenta(idCliente, new Date(Calendar.getInstance().getTimeInMillis()), numCuenta);
            Object datos[] = new Object[5];
            DefaultTableModel modelo = (DefaultTableModel)tbMovimientos.getModel();
            modelo.setRowCount(0);
            
            for(EstadoCuenta estado: estadoCuenta){
                datos[0] = estado.getFecha();
                datos[1] = estado.getDescripcion();
                
                if(estado.getNumeroCuenta().equals(estado.getCuenta_numeroCuenta())){
                    datos[2] = estado.getMonto();
                }else{
                    datos[2] = "0";
                }
                
                if(estado.getNumeroCuenta().equals(estado.getCuentaDestino())){
                    datos[3] = estado.getMonto();
                }else{
                    datos[3] = "0";
                }
                
                datos[4] = estado.getSaldo();
                modelo.addRow(datos);
            }
            
            tbMovimientos.setModel(modelo);
            
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
        btnMovimientos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbMovimientos = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();
        btnEstadoCuenta = new javax.swing.JButton();

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
                .addGap(58, 58, 58)
                .addComponent(btnMisCuentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTransferencias)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMovimientos)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMisCuentas)
                    .addComponent(btnTransferencias)
                    .addComponent(btnMovimientos))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 312, 480, 40));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setText("SISBAN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        tbMovimientos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Descripción", "Cargo", "Abono", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tbMovimientos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 460, 170));

        btnSalir.setBackground(new java.awt.Color(255, 255, 204));
        btnSalir.setText("LOG OUT");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        btnEstadoCuenta.setText("ESTADO DE CUENTA");
        btnEstadoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstadoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

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

    private void btnMisCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMisCuentasActionPerformed
        MisCuentas miCuenta = new MisCuentas(idCliente, numCuenta);
        miCuenta.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMisCuentasActionPerformed

    private void btnTransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTransferenciasActionPerformed
        Transferencias trans = new Transferencias(idCliente, numCuenta);
        trans.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnTransferenciasActionPerformed

    private void btnMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMovimientosActionPerformed
        PreMovimientos pre = new PreMovimientos(idCliente, numCuenta);
        pre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnMovimientosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEstadoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoCuentaActionPerformed
        try {
            this.mes = JOptionPane.showInputDialog(this, "Ingrese el mes a generar").toLowerCase();
            switch(mes){
                case "enero":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 1){
                        generarEstado("1");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }                    
                    break;
                case "febrero":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 2){        
                        generarEstado("2");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "marzo":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 3){        
                        generarEstado("3");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "abril":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 4){        
                        generarEstado("4");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "mayo":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 5){        
                        generarEstado("5");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "junio":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 6){      
                        generarEstado("6");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));  
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "julio":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 7){  
                        generarEstado("7");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "agosto":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 8){ 
                        generarEstado("8");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));      
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "septiembre":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 9){        
                        generarEstado("9");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "octubre":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 10){  
                        generarEstado("10");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "noviembre":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 11){ 
                        generarEstado("11");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                case "diciembre":
                    if(Calendar.getInstance().get(Calendar.MONTH) + 1 >= 12){        
                        generarEstado("12");
                        new Procesos().cargarArchivoM(numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                    }else{
                        JOptionPane.showMessageDialog(this, "No puede generar estados de cuenta futuros");
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Mes no valido");
                    break;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEstadoCuentaActionPerformed

    private void generarEstado(String mesCuenta) throws SQLException, IOException{
        ReportePdf reporte = new ReportePdf();
        Query qf = entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
        qf.setParameter("numeroCuenta", numCuenta);
        tblCuenta = (TblCuentas)qf.getSingleResult();
        if(tblCuenta.getBancoSucursal().getSucursal().equals("106")){
            reporte.generarReporte("C:\\Users\\baloc\\OneDrive\\Documentos\\NetBeansProjects\\SISBAN\\src\\estadoCuenta\\" + numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + ".pdf", "ESTADO CUENTA: " + String.valueOf(mes).toUpperCase(), idCliente, Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-" + mesCuenta + "-1") ,numCuenta, "BBVA", false);
        }else{
            reporte.generarReporte("C:\\Users\\baloc\\OneDrive\\Documentos\\NetBeansProjects\\SISBAN\\src\\estadoCuenta\\" + numCuenta + mes + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + ".pdf", "ESTADO CUENTA: " + String.valueOf(mes).toUpperCase(), idCliente, Date.valueOf(String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + "-" + mesCuenta + "-1") ,numCuenta, "HSBC", false);
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
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Movimientos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstadoCuenta;
    private javax.swing.JButton btnMisCuentas;
    private javax.swing.JButton btnMovimientos;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnTransferencias;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbMovimientos;
    // End of variables declaration//GEN-END:variables
}
