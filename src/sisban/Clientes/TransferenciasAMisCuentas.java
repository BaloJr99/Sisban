
package sisban.Clientes;

import cl.model.dao.CuentaDao;
import cl.model.dao.TransaccionesDao;
import cl.model.db.Cuenta;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import jpa.TblCuentas;
import jpa.TblEmpleado;
import jpa.TblTarjetas;
import jpa.TblTransacciones;
import misExcepciones.MisExcepciones;

public class TransferenciasAMisCuentas extends javax.swing.JFrame {
    TblCuentas tblcuenta;
    TblTarjetas tbltarjeta;
    TblEmpleado tblEmpleado;
    
    TransaccionesDao transaccionesDao; 
    CuentaDao cuentaDao;
    
    int idCliente;
    String numCuenta;
    
    public TransferenciasAMisCuentas() {
        initComponents();
    }
    
    public TransferenciasAMisCuentas(int idCliente,String numCuenta) {
        initComponents();
        setLocationRelativeTo(null);
        this.idCliente = idCliente;
        this.numCuenta = numCuenta;
        Query qf = entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
        qf.setParameter("numeroCuenta",numCuenta);
        tblcuenta = (TblCuentas)qf.getSingleResult();
        conseguirCuentas();
    }

    private void conseguirCuentas(){
        try {
            cuentaDao =  new CuentaDao();
            DefaultListModel modelo = new DefaultListModel();
            modelo.setSize(0);
            
            ArrayList<Cuenta> cuenta= cuentaDao.buscarCuentasC(idCliente);
            for(Cuenta lista : cuenta ){
                if(!lista.getNumeroCuenta().equals(numCuenta)){
                    modelo.addElement(lista.getNumeroCuenta());
                }
            }
            
            listaCuenta.setModel(modelo);
            
        } catch (Exception e) {
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnOperacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaCuenta = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("SISBAN");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 16, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 6, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel4.setText("Numero de cuenta ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 95, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        jLabel7.setText("Cantidad");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 198, -1, -1));

        txtCantidad.setFont(new java.awt.Font("Tw Cen MT", 2, 14)); // NOI18N
        txtCantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCantidadKeyTyped(evt);
            }
        });
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 220, 272, -1));

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
                .addGap(113, 113, 113))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOperacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 262, 407, -1));

        listaCuenta.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaCuenta);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 113, 272, 79));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean camposVacios() throws MisExcepciones{
        boolean flag = false;
        if(txtCantidad.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(39);
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
                if(listaCuenta.getSelectedIndex()!= -1){
                    if(new CuentaDao().saldo(numCuenta) >= Float.valueOf(txtCantidad.getText())){
                        entma.getTransaction().begin();
                        TblTransacciones tblTransacciones = new TblTransacciones();
                        tblTransacciones.setClaveRastreo(generarClaveRastreo());
                        tblTransacciones.setDescripción("TRANSFERENCIA ENTRE CUENTAS");
                        tblTransacciones.setMonto(Float.valueOf(txtCantidad.getText()));
                        tblTransacciones.setNumReferencia(generarReferencia());
                        tblTransacciones.setCuentaDestino(listaCuenta.getSelectedValue());
                        tblTransacciones.setDestinatario(tblcuenta.getClienteidCliente().getNombre() + " " + tblcuenta.getClienteidCliente().getApellidoPaterno()+ " " +tblcuenta.getClienteidCliente().getApellidoMaterno());
                        tblTransacciones.setTipoMovimiento("Cargo");
                        tblTransacciones.setBancosSucursal(tblcuenta.getBancoSucursal().getSucursal());
                        tblTransacciones.setFecha(new Date(Calendar.getInstance().getTimeInMillis()));
                        tblTransacciones.setHora(new Time(Calendar.getInstance().getTimeInMillis()));
                        tblTransacciones.setCuentasnumeroCuenta(tblcuenta);
                        entma.persist(tblTransacciones);
                        entma.getTransaction().commit();
                        JOptionPane.showMessageDialog(this, "Operacion realizada"); 
                        this.dispose();
                    }else{
                        JOptionPane.showMessageDialog(this, "No hay fondos suficientes");
                    }
                }
            }
        } catch (RollbackException re) {
            JOptionPane.showMessageDialog(this, re.getMessage());
        } catch (NumberFormatException | MisExcepciones | HeadlessException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnOperacionActionPerformed

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
            java.util.logging.Logger.getLogger(TransferenciasAMisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransferenciasAMisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransferenciasAMisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransferenciasAMisCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransferenciasAMisCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOperacion;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaCuenta;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
