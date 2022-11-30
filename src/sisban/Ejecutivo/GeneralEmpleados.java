
package sisban.Ejecutivo;

import cl.model.dao.CorreoEmpleadoDao;
import cl.model.dao.DireccionEmpleadoDao;
import cl.model.dao.EmpleadoDao;
import cl.model.dao.TelefonoEmpleadoDao;
import cl.model.db.CorreoEmpleado;
import cl.model.db.DireccionEmpleados;
import cl.model.db.Empleado;
import cl.model.db.TelefonoEmpleado;
import java.awt.HeadlessException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblBancos;
import jpa.TblCorreoEmpleado;
import jpa.TblDireccionEmpleados;
import jpa.TblEmpleado;
import jpa.TblTelefonoEmpleados;
import jpa.TblUsuariosEmpleados;
import misExcepciones.MisExcepciones;
import sisban.CrearUsuario;
import sisban.Login;


public class GeneralEmpleados extends javax.swing.JFrame {
    
    Empleado empleado; 
    TelefonoEmpleado telefono;
    DireccionEmpleados direccion;
    CorreoEmpleado correo;
    EmpleadoDao empleadoDao;
    int numEmpleado, idEmpleado;
    
    EmpleadoDao EmpleadoDao;
    TelefonoEmpleadoDao telefonoDao;
    DireccionEmpleadoDao direccionDao;
    CorreoEmpleadoDao correoDao;
    
    TblEmpleado tblEmpleado = new TblEmpleado();
    TblDireccionEmpleados tblDireccionEmpleado = new TblDireccionEmpleados();
    TblBancos tblBancos;
    TblUsuariosEmpleados tblUsuarioE;

    public GeneralEmpleados() {
        initComponents();
        setLocationRelativeTo(null);
        generarId();
        txtNumEmpleado.setEnabled(false);
    }
    
    public GeneralEmpleados(int numEmpleado, int idEmpleado, boolean menu) {
        initComponents();
        setLocationRelativeTo(null);
        if(menu){
            generarId();
            txtNumEmpleado.setEnabled(false);
            this.idEmpleado = idEmpleado;
        }else{
            this.idEmpleado = idEmpleado;
            this.numEmpleado = numEmpleado;
            txtNumEmpleado.setText(String.valueOf(numEmpleado));
            txtNumEmpleadoFocusLost(null);
        }
    }

    private boolean camposVacios() throws MisExcepciones{
        boolean flag = false;
        if(txtNombre.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(4);
        }else if(txtApellidoPaterno.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(5);
        }else if(txtApellidoMaterno.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(6);
        }else if(dcFechaIngreso.getDate() == null){
            flag = true;
            throw new MisExcepciones(25);
        }else if(cbPuesto.getSelectedIndex() == 0){
            flag = true;
            throw new MisExcepciones(26);
        }else if(txtNss.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(27);
        }else if(txtCurp.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(10);
        }else if(txtRfc.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(9);
        }else if(!txtRfc.getText().trim().substring(0, 10).equals(txtCurp.getText().trim().substring(0, 10))){
            flag = true;
            throw new MisExcepciones(20);
        }else if(dcFechaNacimiento.getDate() == null){
            flag = true;
            throw new MisExcepciones(7);
        }else if(cbGenero.getSelectedIndex() == 0){
            flag = true;
            throw new MisExcepciones(11);
        }else if(txtTelefono.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(12);
        }else if(txtCorreo.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(13);
        }else if(cbTipoTelefono.getSelectedIndex() == 0){
            flag = true;
            throw new MisExcepciones(14);
        }else if(txtCalle.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(16);
        }else if(txtColonia.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(17);
        }else if(txtCodigoPostal.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(18);
        }else if(txtNumExt.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(19);
        }
        return flag; 
    }
    
    private void limpiarCampos(){
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        cbPuesto.setSelectedIndex(0);
        txtRfc.setText("");
        txtCurp.setText("");
        txtNss.setText("");
        cbGenero.setSelectedIndex(0);
        txtTelefono.setText("");
        cbTipoTelefono.setSelectedIndex(0);
        txtCorreo.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtCodigoPostal.setText("");
        txtNumExt.setText("");
        txtNumInt.setText("");
        dcFechaIngreso.setDate(null);
        dcFechaNacimiento.setDate(null);
        txtSucursal.setText("");
    }
    
    public void generarId(){
        numEmpleado = new EmpleadoDao().contarEmpleados() + 1;
        txtNumEmpleado.setText(String.valueOf(numEmpleado));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblNoEmpelado = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellidoPaterno = new javax.swing.JTextField();
        txtApellidoMaterno = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        cbTipoTelefono = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbPuesto = new javax.swing.JComboBox<>();
        dcFechaIngreso = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtNss = new javax.swing.JFormattedTextField();
        cbGenero = new javax.swing.JComboBox<>();
        txtTelefono = new javax.swing.JFormattedTextField();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtCurp = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JFormattedTextField();
        txtSucursal = new javax.swing.JTextField();
        txtNumEmpleado = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        txtCalle = new javax.swing.JTextField();
        txtNumExt = new javax.swing.JTextField();
        txtNumInt = new javax.swing.JTextField();
        txtCodigoPostal = new javax.swing.JFormattedTextField();
        btnAltaEmpleado = new javax.swing.JButton();
        btnModificarDatos = new javax.swing.JButton();
        btnModificarDireccion = new javax.swing.JButton();
        btnBajaCliente = new javax.swing.JButton();
        btCambiarDireccion = new javax.swing.JButton();
        btnCambiarTelefono = new javax.swing.JButton();
        btnCambiarCorreo = new javax.swing.JButton();
        tbBuscarEmpleado = new javax.swing.JToggleButton();
        btnLogin = new javax.swing.JButton();
        btnListaEmpleados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 153));
        lblTitulo.setText("SISBAN");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PERSONALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N

        lblNoEmpelado.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        lblNoEmpelado.setText("Numero de Empleado");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel5.setText("Apellido Paterno");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel6.setText("Apellido Materno");

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel8.setText("Puesto");

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel9.setText("Fecha de Nacimiento");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel10.setText("Genero");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel11.setText("Fecha de Ingreso");

        txtNombre.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

        txtApellidoPaterno.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

        txtApellidoMaterno.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel12.setText("Telefono");

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel13.setText("Correo");

        txtCorreo.setFont(new java.awt.Font("Tw Cen MT", 2, 12)); // NOI18N

        cbTipoTelefono.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbTipoTelefono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Casa", "Oficina", "Movil" }));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel19.setText("Tipo Telefono");

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel1.setText("Sucursal");

        cbPuesto.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Ejecutivo", "Cajero", "Otro" }));

        dcFechaIngreso.setDateFormatString("yyyy-MM-dd");

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel7.setText("NSS");

        try {
            txtNss.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNss.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNssFocusGained(evt);
            }
        });

        cbGenero.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Masculino", "Femenino", "Otro" }));

        try {
            txtTelefono.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
        });

        dcFechaNacimiento.setDateFormatString("yyyy-MM-dd");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel2.setText("CURP");

        try {
            txtCurp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUU######UUUUUU**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCurp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCurpFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel3.setText("RFC");

        try {
            txtRfc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUU######***")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRfcFocusLost(evt);
            }
        });

        txtNumEmpleado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumEmpleadoFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(6, 6, 6)
                                .addComponent(cbTipoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo)
                            .addComponent(txtSucursal))))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNoEmpelado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(6, 6, 6)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(6, 6, 6)
                                .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel6)
                                .addGap(6, 6, 6)
                                .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCurp))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNss, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcFechaIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoEmpelado)
                            .addComponent(jLabel11)
                            .addComponent(txtNumEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNss, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCurp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtRfc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(27, 27, 27))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 510, 260));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIRECCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel14.setText("Colonia");

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel15.setText("Calle");

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel16.setText("Numero Exterior");

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel17.setText("Numero Interior");

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel18.setText("Codigo Postal");

        txtColonia.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

        txtCalle.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

        txtNumExt.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        txtNumExt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumExtKeyTyped(evt);
            }
        });

        txtNumInt.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

        try {
            txtCodigoPostal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCodigoPostal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCodigoPostalFocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtColonia))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCalle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumExt, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(9, 9, 9)
                        .addComponent(txtNumInt, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(txtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtNumExt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(txtNumInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 510, -1));

        btnAltaEmpleado.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnAltaEmpleado.setText("ALTA EMPLEADOS");
        btnAltaEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(btnAltaEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 217, -1));

        btnModificarDatos.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnModificarDatos.setText("MODIFICAR DATOS PERSONALES");
        btnModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 182, 220, 30));

        btnModificarDireccion.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnModificarDireccion.setText("MODIFICAR DIRECCION");
        btnModificarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 217, -1));

        btnBajaCliente.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnBajaCliente.setText("BAJA EMPLEADOS");
        btnBajaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnBajaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 217, -1));

        btCambiarDireccion.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btCambiarDireccion.setText("CAMBIO DIRECCION");
        btCambiarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCambiarDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(btCambiarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 217, -1));

        btnCambiarTelefono.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnCambiarTelefono.setText("CAMBIAR TELEFONO");
        btnCambiarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 260, 217, -1));

        btnCambiarCorreo.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnCambiarCorreo.setText("CAMBIAR CORREO");
        btnCambiarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 217, -1));

        tbBuscarEmpleado.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        tbBuscarEmpleado.setText("BUSCAR EMPLEADO");
        tbBuscarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(tbBuscarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 220, -1));

        btnLogin.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnLogin.setText("MENU");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, -1, -1));

        btnListaEmpleados.setBackground(new java.awt.Color(204, 204, 255));
        btnListaEmpleados.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnListaEmpleados.setText("LISTA DE EMPLEADOS");
        btnListaEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaEmpleadosActionPerformed(evt);
            }
        });
        jPanel1.add(btnListaEmpleados, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 260, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNssFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNssFocusGained
        if(txtNss.getText().trim().isEmpty()){
            txtNss.setText("");
        }
    }//GEN-LAST:event_txtNssFocusGained

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        if(txtTelefono.getText().trim().isEmpty()){
            txtTelefono.setText("");
        }
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtNumExtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExtKeyTyped
        char c = evt.getKeyChar();

        if(Character.isLetter(c) || c == ' ' || txtNumExt.getText().length() > 3){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumExtKeyTyped

    private void txtCodigoPostalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoPostalFocusGained
        if(txtCodigoPostal.getText().trim().isEmpty()){
            txtCodigoPostal.setText("");
        }
    }//GEN-LAST:event_txtCodigoPostalFocusGained

    private void btnAltaEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaEmpleadoActionPerformed
        try {
            String  numInt;
            
            if(!camposVacios()){
                String genero = "";

                switch(cbGenero.getSelectedIndex()){
                    case 1:
                    genero = "M";
                    break;
                    case 2:
                    genero = "F";
                    break;
                    case 3:
                    genero = "O";
                    break;
                }

                if(txtNumInt.getText().trim().isEmpty()){
                    numInt = null;
                }else{
                    numInt = txtNumInt.getText();
                }                
                
                empleado = new Empleado(Integer.valueOf(txtNumEmpleado.getText()), 
                        txtNombre.getText(),txtApellidoPaterno.getText(), txtApellidoMaterno.getText(), 
                        cbPuesto.getSelectedItem().toString(),txtNss.getText(),txtRfc.getText(),txtCurp.getText(),
                        txtSucursal.getText(),genero, new Date(dcFechaIngreso.getDate().getTime())
                        ,new Date(dcFechaNacimiento.getDate().getTime()), null);
                correo = new CorreoEmpleado(Integer.valueOf(txtNumEmpleado.getText()), txtCorreo.getText());
                direccion = new DireccionEmpleados (Integer.valueOf(txtNumEmpleado.getText()),txtCalle.getText(), 
                        numInt, txtNumExt.getText(),txtColonia.getText(), txtCodigoPostal.getText());
                telefono = new TelefonoEmpleado(Integer.valueOf(txtNumEmpleado.getText()), txtTelefono.getText(),
                    cbTipoTelefono.getSelectedItem().toString());
                empleadoDao = new EmpleadoDao();
                empleadoDao.insertarEmpleado(empleado, correo, direccion, telefono);
                if(empleadoDao.existeId(Integer.valueOf(txtNumEmpleado.getText()))){
                    JOptionPane.showMessageDialog(this, "Registrado");
                    usuarios();
                }else{
                    JOptionPane.showMessageDialog(this, "VERIFIQUE LOS DATOS");
                }
            }
        } catch (MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (HeadlessException | NumberFormatException ve) {
            JOptionPane.showMessageDialog(this, ve.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAltaEmpleadoActionPerformed

    public void usuarios(){
        try {
            Query qf = entma.createNamedQuery("TblUsuariosEmpleados.findByTblEmpleadoidEmpleado");
            qf.setParameter("tblEmpleadoidEmpleado", Integer.valueOf(txtNumEmpleado.getText()));
            tblUsuarioE = (TblUsuariosEmpleados)qf.getSingleResult();
            if(JOptionPane.showConfirmDialog(this, "Olvido su contraseña??") == JOptionPane.YES_OPTION){
                CrearUsuario crear = new CrearUsuario(txtNumEmpleado.getText(), "Empleado", true);
                crear.setVisible(true);
            }
        } catch (NoResultException ne) {
            if(JOptionPane.showConfirmDialog(this, "Desea crear un usuario??") == JOptionPane.YES_OPTION){
                CrearUsuario crear = new CrearUsuario(txtNumEmpleado.getText(), "Empleado", false);
                crear.setVisible(true);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void btnModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDatosActionPerformed
        try {
            if(txtNumEmpleado.getText().isEmpty()){
                throw new MisExcepciones(21);
            }else{
                if(!camposVacios()){
                    entma.getTransaction().begin();
                    tblEmpleado.setFechaIngreso(new Date(dcFechaIngreso.getDate().getTime()));
                    tblEmpleado.setNombre(txtNombre.getText());
                    tblEmpleado.setApellidoPaterno(txtApellidoPaterno.getText());
                    tblEmpleado.setApellidoMaterno(txtApellidoMaterno.getText());
                    tblEmpleado.setPuesto(cbPuesto.getSelectedItem().toString());
                    tblEmpleado.setNss(txtNss.getText());
                    tblEmpleado.setRfc(txtRfc.getText());
                    tblEmpleado.setCurp(txtCurp.getText());
                    tblEmpleado.setFechaNacimiento(new Date(dcFechaNacimiento.getDate().getTime()));
                    Query qf = entma.createNamedQuery("TblBancos.findBySucursal");
                    qf.setParameter("sucursal",txtSucursal.getText());
                    tblBancos=(TblBancos)qf.getSingleResult();
                    tblEmpleado.setBancosSucursal(tblBancos);
                    String genero = "";
                    switch(cbGenero.getSelectedIndex()){
                        case 1:
                        genero = "M";
                        break;
                        case 2:
                        genero = "F";
                        break;
                        case 3:
                        genero = "O";
                        break;
                    }
                    tblEmpleado.setGenero(genero);
                    entma.getTransaction().commit();
                    JOptionPane.showMessageDialog(this, "Se ha modificado con exito el cliente");
                }
            }
        } catch (HeadlessException | MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarDatosActionPerformed

    private void btnModificarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDireccionActionPerformed
        try {
            String numInt;
            if(!camposVacios()){
                Query qf = entma.createNamedQuery("TblDireccionEmpleados.findByIdDireccionEmpleado");
                qf.setParameter("idDireccionEmpleado", direccion.getIdDireccionEmpleado());
                tblDireccionEmpleado = (TblDireccionEmpleados)qf.getSingleResult();
                entma.getTransaction().begin();
                tblDireccionEmpleado.setCalle(txtCalle.getText());
                tblDireccionEmpleado.setCodigoPostal(txtCodigoPostal.getText());
                tblDireccionEmpleado.setColonia(txtColonia.getText());
                tblDireccionEmpleado.setNumExt(txtNumExt.getText());

                if(txtNumInt.getText().trim().isEmpty()){
                    numInt = null;
                }else{
                    numInt = txtNumInt.getText();
                }

                tblDireccionEmpleado.setNumInt(numInt);
                entma.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Se ha modificado la direccion");
            }

        } catch (HeadlessException | MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarDireccionActionPerformed

    private void btnBajaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaClienteActionPerformed
       
        try {
            if(txtNumEmpleado.getText().trim().isEmpty()){
                throw new MisExcepciones(21);
            }else{
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaTerminacion = new Date(sdf.parse(JOptionPane.showInputDialog(this, "Ingrese la fecha en formato yyyy-MM-dd")).getTime());
                entma.getTransaction().begin();
                tblEmpleado.setFechaTerminacion(fechaTerminacion);
                entma.getTransaction().commit();
                limpiarCampos();
                generarId();
                tbBuscarEmpleado.setSelected(false);
                tbBuscarEmpleadoActionPerformed(null);
                JOptionPane.showMessageDialog(this, "Se ha dado de baja con exito");
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_btnBajaClienteActionPerformed

    private void btCambiarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCambiarDireccionActionPerformed
        try {
            if(!camposVacios()){
                String numInt;
                entma.getTransaction().begin();
                TblDireccionEmpleados direccionEmpleado = new TblDireccionEmpleados();
                direccionEmpleado.setCalle(txtCalle.getText());
                direccionEmpleado.setCodigoPostal(txtCodigoPostal.getText());
                direccionEmpleado.setColonia(txtColonia.getText());

                if(txtNumInt.getText().trim().isEmpty()){
                    numInt = null;
                }else{
                    numInt = txtNumInt.getText();
                }

                direccionEmpleado.setNumInt(numInt);
                direccionEmpleado.setNumExt(txtNumExt.getText());
                direccionEmpleado.setEmpleadoidEmpleado(tblEmpleado);
                entma.persist(direccionEmpleado);
                entma.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Se ha agregado una nueva direccion");
            }else{
                throw new MisExcepciones(21);
            }
        } catch (MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btCambiarDireccionActionPerformed

    private void btnCambiarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTelefonoActionPerformed
        try {
            if(!camposVacios()){
                entma.getTransaction().begin();
                TblTelefonoEmpleados telefonoEmpleado = new TblTelefonoEmpleados();
                telefonoEmpleado.setNumTelefonoEmpleado(txtTelefono.getText());
                telefonoEmpleado.setTipoTelefono(cbTipoTelefono.getSelectedItem().toString());
                telefonoEmpleado.setEmpleadoidEmpleado(tblEmpleado);
                entma.persist(telefonoEmpleado);
                entma.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo numero de telefono");
            }else{
                throw new MisExcepciones(21);
            }
        } catch (MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnCambiarTelefonoActionPerformed

    private void btnCambiarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarCorreoActionPerformed
        try {
            if(!camposVacios()){
                entma.getTransaction().begin();
                TblCorreoEmpleado correoEmpleado = new TblCorreoEmpleado();
                correoEmpleado.setCorreoEmpleado(txtCorreo.getText());
                correoEmpleado.setEmpleadoidEmpleado(tblEmpleado);
                entma.persist(correoEmpleado);
                entma.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Se ha agregado un nuevo correo");
            }else{
                throw new MisExcepciones(21);
            }
        } catch (MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnCambiarCorreoActionPerformed

    private void tbBuscarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarEmpleadoActionPerformed
        if(tbBuscarEmpleado.isSelected()){
            txtNumEmpleado.setText("");
            txtNumEmpleado.setEnabled(true);
            btnAltaEmpleado.setEnabled(false);
            limpiarCampos();
        }else{
            generarId();
            txtNumEmpleado.setEnabled(false);
            btnAltaEmpleado.setEnabled(true);
            limpiarCampos();
        }
    }//GEN-LAST:event_tbBuscarEmpleadoActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        Menu log = new Menu(idEmpleado);
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnListaEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaEmpleadosActionPerformed
        ListaEmpleados ListaEmpleados = new ListaEmpleados(idEmpleado);
        ListaEmpleados.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnListaEmpleadosActionPerformed

    private void txtNumEmpleadoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumEmpleadoFocusLost
        try {
            if(txtNumEmpleado.getText().trim().isEmpty()){
                tbBuscarEmpleado.setSelected(false);
                tbBuscarEmpleadoActionPerformed(null);
                throw new MisExcepciones(28);
            }else{
                Query qf = entma.createNamedQuery("TblEmpleado.findByIdEmpleado");
                qf.setParameter("idEmpleado", Integer.valueOf(txtNumEmpleado.getText()));
                tblEmpleado = (TblEmpleado)qf.getSingleResult();
                if(tblEmpleado.getFechaTerminacion() == null){
                    txtNumEmpleado.setEnabled(false);
                    switch(tblEmpleado.getGenero()){
                        case "M":
                            cbGenero.setSelectedItem("Masculino");
                            break;
                        case "F":
                            cbGenero.setSelectedItem("Femenino");
                            break;
                        case "O":
                            cbGenero.setSelectedItem("Otro");
                            break;
                    }
                    dcFechaIngreso.setDate(tblEmpleado.getFechaIngreso());
                    txtNombre.setText(tblEmpleado.getNombre());
                    txtApellidoPaterno.setText(tblEmpleado.getApellidoPaterno());
                    txtApellidoMaterno.setText(tblEmpleado.getApellidoMaterno());
                    cbPuesto.setSelectedItem(tblEmpleado.getPuesto());
                    txtNss.setText(tblEmpleado.getNss());
                    txtCurp.setText(tblEmpleado.getCurp());
                    txtRfc.setText(tblEmpleado.getRfc());
                    txtSucursal.setText(tblEmpleado.getBancosSucursal().getSucursal());
                    dcFechaNacimiento.setDate(tblEmpleado.getFechaNacimiento());
                    telefonoDao = new TelefonoEmpleadoDao();
                    telefono = telefonoDao.buscarTelefonoEmp(Integer.valueOf(txtNumEmpleado.getText()));
                    txtTelefono.setText(telefono.getNumTelefonoEmpleado());
                    cbTipoTelefono.setSelectedItem(telefono.getTipoTelefono());
                    direccionDao = new DireccionEmpleadoDao();
                    direccion = direccionDao.buscarDireccion(Integer.valueOf(txtNumEmpleado.getText()));
                    txtCalle.setText(direccion.getCalle());
                    txtColonia.setText(direccion.getColonia());
                    txtCodigoPostal.setText(direccion.getCodigoPostal());
                    txtNumInt.setText(direccion.getNumInt());
                    txtNumExt.setText(direccion.getNumExt());
                    correoDao = new CorreoEmpleadoDao();
                    correo = correoDao.buscarCorreo(Integer.valueOf(txtNumEmpleado.getText()));
                    txtCorreo.setText(correo.getCorreoEmpleado());
                    usuarios();
                }else{
                    JOptionPane.showMessageDialog(this, "Ese empleado esta dado de baja");
                }
            }
        } catch (NoResultException ne) {
            JOptionPane.showMessageDialog(this, "No se encontro al empleado");
            tbBuscarEmpleado.setSelected(false);
            tbBuscarEmpleadoActionPerformed(null);
        } catch (NumberFormatException | MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtNumEmpleadoFocusLost

    private void txtRfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRfcFocusLost
        if(!txtRfc.getText().trim().isEmpty()){
            empleadoDao = new EmpleadoDao();
            if(empleadoDao.buscarRFC(txtRfc.getText(), Integer.valueOf(txtNumEmpleado.getText()))){
                JOptionPane.showMessageDialog(this, "Ese RFC ya se encuentra registrado con otro empleado");
                txtRfc.setText("");
            }
        }
    }//GEN-LAST:event_txtRfcFocusLost

    private void txtCurpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCurpFocusLost
        if(!txtCurp.getText().trim().isEmpty()){
            empleadoDao = new EmpleadoDao();
            if(empleadoDao.buscarCURP(txtCurp.getText(), Integer.valueOf(txtNumEmpleado.getText()))){
                JOptionPane.showMessageDialog(this, "Ese CURP ya se encuentra registrado");
                txtCurp.setText("");
            }
        }
    }//GEN-LAST:event_txtCurpFocusLost

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
            java.util.logging.Logger.getLogger(GeneralEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneralEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCambiarDireccion;
    private javax.swing.JButton btnAltaEmpleado;
    private javax.swing.JButton btnBajaCliente;
    private javax.swing.JButton btnCambiarCorreo;
    private javax.swing.JButton btnCambiarTelefono;
    private javax.swing.JButton btnListaEmpleados;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JButton btnModificarDireccion;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbPuesto;
    private javax.swing.JComboBox<String> cbTipoTelefono;
    private com.toedter.calendar.JDateChooser dcFechaIngreso;
    private com.toedter.calendar.JDateChooser dcFechaNacimiento;
    private javax.persistence.EntityManager entma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblNoEmpelado;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JToggleButton tbBuscarEmpleado;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JFormattedTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtCurp;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtNss;
    private javax.swing.JTextField txtNumEmpleado;
    private javax.swing.JTextField txtNumExt;
    private javax.swing.JTextField txtNumInt;
    private javax.swing.JFormattedTextField txtRfc;
    private javax.swing.JTextField txtSucursal;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
