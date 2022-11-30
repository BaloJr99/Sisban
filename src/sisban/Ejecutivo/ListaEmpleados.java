package sisban.Ejecutivo;

import cl.model.dao.EmpleadoDao;
import cl.model.db.Empleado;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ListaEmpleados extends javax.swing.JFrame {

    EmpleadoDao empleadoDao;
    int idEmpleado;
    
    public ListaEmpleados() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public ListaEmpleados(int idEmpleado) {
        initComponents();
        setLocationRelativeTo(null);
        agregarEmpleados();
        this.idEmpleado = idEmpleado;
    }
    
    public void agregarEmpleados(){
        empleadoDao = new EmpleadoDao();
        ArrayList<Empleado> empleado = empleadoDao.listaEmpleado();
        Object datos[] = new Object[4];
        DefaultTableModel modelo = (DefaultTableModel)tbEmpleados.getModel();
        modelo.setNumRows(0);
        
        for(Empleado e: empleado){
            datos[0] = e.getIdEmpleado();
            datos[1] = e.getNombre();
            datos[2] = e.getApellidoPaterno();
            datos[3] = e.getApellidoMaterno();
            modelo.addRow(datos);
        }
        
        tbEmpleados.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SISBANPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        tblEmpleadoQuery = java.beans.Beans.isDesignTime() ? null : SISBANPUEntityManager.createQuery("SELECT t FROM TblEmpleado t");
        tblEmpleadoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : tblEmpleadoQuery.getResultList();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 153));
        lblTitulo.setText("SISBAN");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 16, -1, -1));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 6, -1, -1));

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#Empleado", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ));
        tbEmpleados.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 88, 530, 271));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed", 2, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));
        jLabel1.setText("EMPLEADOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(415, 44, 105, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 369, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        GeneralEmpleados general = new GeneralEmpleados(tbEmpleados.getSelectedRow() + 1, idEmpleado, false);
        general.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tbEmpleadosMouseClicked

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
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SISBANPUEntityManager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tbEmpleados;
    private java.util.List<jpa.TblEmpleado> tblEmpleadoList;
    private javax.persistence.Query tblEmpleadoQuery;
    // End of variables declaration//GEN-END:variables
}
