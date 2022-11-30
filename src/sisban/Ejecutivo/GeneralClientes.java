package sisban.Ejecutivo;

import cl.model.dao.ClienteDao;
import cl.model.dao.CorreoClienteDao;
import cl.model.dao.CuentaDao;
import cl.model.dao.DireccionClienteDao;
import cl.model.dao.TarjetaDao;
import cl.model.dao.TelefonoClienteDao;
import cl.model.db.Cliente;
import cl.model.db.CorreoCliente;
import cl.model.db.Cuenta;
import cl.model.db.DireccionCliente;
import cl.model.db.Tarjeta;
import cl.model.db.TelefonoCliente;
import clases.Procesos;
import clases.ReportePdf;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import jpa.TblCliente;
import jpa.TblCorreoClientes;
import jpa.TblCuentas;
import jpa.TblDireccionCliente;
import jpa.TblEmpleado;
import jpa.TblTarjetas;
import jpa.TblTelefonoClientes;
import jpa.TblUsuariosClientes;
import misExcepciones.MisExcepciones;
import sisban.Beneficiarios.GeneralBeneficiarios;
import sisban.CrearUsuario;

public class GeneralClientes extends javax.swing.JFrame {

    Cliente cliente;
    CorreoCliente correo;
    DireccionCliente direccion;
    TelefonoCliente telefono;
    Cuenta cuenta;
    Tarjeta tarjeta;
    
    ClienteDao clienteDao;
    TelefonoClienteDao telefonoDao;
    DireccionClienteDao direccionDao;
    CorreoClienteDao correoDao;
    CuentaDao cuentaDao;
    TarjetaDao tarjetaDao;
    
    TblCliente tblCliente = new TblCliente();
    TblDireccionCliente tblDireccionCliente = new TblDireccionCliente();
    TblUsuariosClientes tblUsuarioC;
    TblEmpleado tblEmpleado;
    TblCuentas tblCuentas;
    TblTarjetas tblTarjetas;
    
    GeneralBeneficiarios general = new GeneralBeneficiarios();
    
    Font letra = new Font("Tw Cen MT", Font.PLAIN, 12);
    
    private int idEmpleado;
    
    public GeneralClientes() {
        initComponents();
    }

    public GeneralClientes(int idEmpleado) {
        initComponents();
        configuracionInicial();
        generarIdCliente();
        this.idEmpleado = idEmpleado;
        Query qf = entma.createNamedQuery("TblEmpleado.findByIdEmpleado");
        qf.setParameter("idEmpleado", idEmpleado);
        tblEmpleado = (TblEmpleado)qf.getSingleResult();
    }
    
    public GeneralClientes(int idEmpleado, int idCliente) {
        initComponents();
        configuracionInicial();
        this.idEmpleado = idEmpleado;
        txtNumCliente.setText(String.valueOf(idCliente));
        txtNumClienteFocusLost(null);
        tbBuscarCliente.setSelected(true);
        btnAltaCliente.setEnabled(false);
        Query qf = entma.createNamedQuery("TblEmpleado.findByIdEmpleado");
        qf.setParameter("idEmpleado", idEmpleado);
        tblEmpleado = (TblEmpleado)qf.getSingleResult();
    }
    
    public GeneralClientes(int idEmpleado, int idCliente, String numCuenta, String numTarjeta) {
        initComponents();
        configuracionInicial();                
        this.idEmpleado = idEmpleado;
        txtNumCliente.setText(String.valueOf(idCliente));
        txtNumClienteFocusLost(null);
        tbBuscarCliente.setSelected(true);
        btnAltaCliente.setEnabled(false);
        txtCuenta.setText(numCuenta);
        txtTarjeta.setText(numTarjeta);
        buscarCuenta();
        buscarTarjeta();
        Query qf = entma.createNamedQuery("TblEmpleado.findByIdEmpleado");
        qf.setParameter("idEmpleado", idEmpleado);
        tblEmpleado = (TblEmpleado)qf.getSingleResult();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entma = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SISBANPU").createEntityManager();
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
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
        cbRegimen = new javax.swing.JComboBox<>();
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtRfc = new javax.swing.JFormattedTextField();
        txtCurp = new javax.swing.JFormattedTextField();
        cbGenero = new javax.swing.JComboBox<>();
        txtIne = new javax.swing.JFormattedTextField();
        txtNumCliente = new javax.swing.JFormattedTextField();
        txtTelefono = new javax.swing.JFormattedTextField();
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
        btnAltaCliente = new javax.swing.JButton();
        btnModificarDatos = new javax.swing.JButton();
        btnModificarDireccion = new javax.swing.JButton();
        btnBajaCliente = new javax.swing.JButton();
        btCambiarDireccion = new javax.swing.JButton();
        btnCambiarTelefono = new javax.swing.JButton();
        btnCambiarCorreo = new javax.swing.JButton();
        tbBuscarCliente = new javax.swing.JToggleButton();
        btnBeneficiarios = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cbTipoCuenta = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtCuenta = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtTarjeta = new javax.swing.JFormattedTextField();
        btnNuevaCuenta = new javax.swing.JButton();
        btnAsignarTarjeta = new javax.swing.JButton();
        btnCuentasTarjetas = new javax.swing.JButton();
        btnBajaCuenta = new javax.swing.JButton();
        btnBajaTarjeta = new javax.swing.JButton();
        btnEstadoCuenta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 0, 153));
        lblTitulo.setText("SISBAN");
        jPanel1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(304, 20, -1, -1));

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/banco (1).png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(234, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS PERSONALES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel3.setText("Numero de cliente");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel4.setText("Nombre");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 50, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel5.setText("Apellido Paterno");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 78, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel6.setText("Apellido Materno");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 78, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel8.setText("Regimen Fiscal");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 107, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel9.setText("CURP");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 141, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel10.setText("Genero");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 141, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel11.setText("Fecha De Nacimiento");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 24, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 46, 441, -1));

        txtApellidoPaterno.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jPanel2.add(txtApellidoPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 74, 151, -1));

        txtApellidoMaterno.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jPanel2.add(txtApellidoMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 74, 152, -1));

        jLabel12.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel12.setText("Telefono");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 170, -1, -1));

        jLabel13.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel13.setText("Correo");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 170, -1, -1));

        txtCorreo.setFont(new java.awt.Font("Tw Cen MT", 2, 12)); // NOI18N
        jPanel2.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(241, 166, 258, -1));

        cbTipoTelefono.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbTipoTelefono.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Casa", "Oficina", "Movil" }));
        jPanel2.add(cbTipoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 196, 139, -1));

        jLabel19.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel19.setText("Tipo Telefono");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 197, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel1.setText("INE");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(227, 201, -1, -1));

        cbRegimen.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbRegimen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Persona Fisica", "Persona Moral", "NA" }));
        cbRegimen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRegimenActionPerformed(evt);
            }
        });
        jPanel2.add(cbRegimen, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 102, 163, -1));

        dcFechaNacimiento.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(dcFechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 16, 179, 22));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel7.setText("RFC");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 109, -1, -1));

        txtRfc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRfcFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRfcFocusLost(evt);
            }
        });
        jPanel2.add(txtRfc, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 102, 220, 26));

        try {
            txtCurp.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("UUUU######UUUUUU**")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCurp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCurpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCurpFocusLost(evt);
            }
        });
        jPanel2.add(txtCurp, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 134, 232, 26));

        cbGenero.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Masculino", "Femenino", "Otro" }));
        jPanel2.add(cbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 136, 175, -1));

        try {
            txtIne.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#############")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtIne.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIneFocusGained(evt);
            }
        });
        jPanel2.add(txtIne, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 197, 250, -1));

        try {
            txtNumCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNumCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNumClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNumClienteFocusLost(evt);
            }
        });
        jPanel2.add(txtNumCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 20, 99, -1));

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
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 166, 138, 24));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, 510, 230));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIRECCION", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel14.setText("Colonia");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 26, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel15.setText("Calle");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 54, -1, -1));

        jLabel16.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel16.setText("Numero Exterior");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 82, -1, -1));

        jLabel17.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel17.setText("Numero Interior");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 82, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel18.setText("Codigo Postal");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(341, 54, -1, -1));

        txtColonia.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jPanel3.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 22, 446, -1));

        txtCalle.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jPanel3.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 50, 293, -1));

        txtNumExt.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        txtNumExt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumExtKeyTyped(evt);
            }
        });
        jPanel3.add(txtNumExt, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 78, 135, -1));

        txtNumInt.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jPanel3.add(txtNumInt, new org.netbeans.lib.awtextra.AbsoluteConstraints(318, 78, 181, -1));

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
        jPanel3.add(txtCodigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(413, 50, 86, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 510, 110));

        btnAltaCliente.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnAltaCliente.setText("ALTA CLIENTE");
        btnAltaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnAltaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 240, -1));

        btnModificarDatos.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnModificarDatos.setText("MODIFICAR DATOS PERSONALES");
        btnModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, 240, -1));

        btnModificarDireccion.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnModificarDireccion.setText("MODIFICAR DIRECCION");
        btnModificarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 240, -1));

        btnBajaCliente.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnBajaCliente.setText("BAJA CLIENTE");
        btnBajaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaClienteActionPerformed(evt);
            }
        });
        jPanel1.add(btnBajaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 240, -1));

        btCambiarDireccion.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btCambiarDireccion.setText("CAMBIO DIRECCION");
        btCambiarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCambiarDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(btCambiarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 240, -1));

        btnCambiarTelefono.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnCambiarTelefono.setText("CAMBIAR TELEFONO");
        btnCambiarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 240, -1));

        btnCambiarCorreo.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnCambiarCorreo.setText("CAMBIAR CORREO");
        btnCambiarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 240, -1));

        tbBuscarCliente.setText("BUSCAR CLIENTE");
        tbBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarClienteActionPerformed(evt);
            }
        });
        jPanel1.add(tbBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 53, -1, -1));

        btnBeneficiarios.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnBeneficiarios.setText("BENEFICIARIOS");
        btnBeneficiarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBeneficiariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnBeneficiarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 240, -1));

        btnMenu.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnMenu.setText("MENU");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        jPanel1.add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CUENTAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel25.setText("Tipo Cuenta");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 59, -1, -1));

        cbTipoCuenta.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbTipoCuenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Débito", "Crédito" }));
        jPanel4.add(cbTipoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 54, 125, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel2.setText("#Cuenta");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 26, -1, -1));

        try {
            txtCuenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###########")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCuenta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCuentaFocusLost(evt);
            }
        });
        jPanel4.add(txtCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 22, 125, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 240, 90));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "TARJETAS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tw Cen MT", 1, 12))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel20.setText("#Tarjeta");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 39, -1, -1));

        try {
            txtTarjeta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jPanel5.add(txtTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 35, 148, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 460, 240, 90));

        btnNuevaCuenta.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnNuevaCuenta.setText("NUEVA CUENTA");
        btnNuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnNuevaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 560, 200, -1));

        btnAsignarTarjeta.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnAsignarTarjeta.setText("ASIGNAR TARJETA");
        btnAsignarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarTarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAsignarTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 560, 200, -1));

        btnCuentasTarjetas.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnCuentasTarjetas.setText("CUENTAS/TARJETAS");
        btnCuentasTarjetas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuentasTarjetasActionPerformed(evt);
            }
        });
        jPanel1.add(btnCuentasTarjetas, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 450, 240, -1));

        btnBajaCuenta.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnBajaCuenta.setText("BAJA CUENTA");
        btnBajaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBajaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 490, 240, -1));

        btnBajaTarjeta.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnBajaTarjeta.setText("BAJA TARJETA");
        btnBajaTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBajaTarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(btnBajaTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 530, 240, -1));

        btnEstadoCuenta.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        btnEstadoCuenta.setText("ESTADO CUENTA");
        btnEstadoCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoCuentaActionPerformed(evt);
            }
        });
        jPanel1.add(btnEstadoCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 240, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void configuracionInicial(){
        setLocationRelativeTo(null);
        txtNumCliente.setEnabled(false);
        txtRfc.setEnabled(false);
        txtCurp.setEnabled(false);
        txtCuenta.setEnabled(false);
        txtTarjeta.setEnabled(false);
        txtRfc.setFont(letra);
        txtCurp.setFont(letra);
        dcFechaNacimiento.setFont(letra);
        txtIne.setFont(letra);
        txtCodigoPostal.setFont(letra);
        txtNumCliente.setFont(letra);
        txtTelefono.setFont(letra);
    }
    
    private void buscarCuenta(){
        try {
            Query qf = entma.createNamedQuery("TblCuentas.findByNumeroCuenta");
            qf.setParameter("numeroCuenta", txtCuenta.getText());
            tblCuentas = (TblCuentas)qf.getSingleResult();
            cbTipoCuenta.setSelectedItem(tblCuentas.getTipoCuenta());
            btnNuevaCuenta.setEnabled(false);
            cbTipoCuenta.setEnabled(false);
        } catch (Exception e) {
            
        }
    }
    
    private void buscarTarjeta(){
        try {
            Query qf = entma.createNamedQuery("TblTarjetas.findByNumTarjeta");
            qf.setParameter("numTarjeta", txtTarjeta.getText());
            tblTarjetas = (TblTarjetas)qf.getSingleResult();
            btnAsignarTarjeta.setEnabled(false);
        } catch (Exception e) {
            
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
        }else if(dcFechaNacimiento.getDate() == null){
            flag = true;
            throw new MisExcepciones(7);
        }else if(cbRegimen.getSelectedIndex() == 0){
            flag = true;
            throw new MisExcepciones(8);
        }else if(cbRegimen.getSelectedIndex() == 1){
            if(txtRfc.getText().trim().isEmpty()){
                flag = true;
                throw new MisExcepciones(9);
            }else if(txtCurp.getText().trim().isEmpty()){
                flag = true;
                throw new MisExcepciones(10);
            }else if(!txtRfc.getText().trim().substring(0, 10).equals(txtCurp.getText().trim().substring(0, 10))){
                flag = true;
                throw new MisExcepciones(20);
            }
        }else if(cbRegimen.getSelectedIndex() == 2){
            if(txtRfc.getText().trim().isEmpty()){
                flag = true;
                throw new MisExcepciones(9);
            }
        }else if(cbRegimen.getSelectedIndex() == 3){
             if(txtCurp.getText().trim().isEmpty()){
                flag = true;
                throw new MisExcepciones(10);
            }
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
        }else if(txtIne.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(15);
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
    
    private int generarIdCliente(){
        int id = 0;
        String num;
        try {
            clienteDao = new ClienteDao();
            
            do{
                id = 0;
                num = "";
                
                for(int i = 0; i < 8; i++){
                    num += String.valueOf(Math.floor(Math.random() * 8 + 1)).charAt(0);
                }
                
                id = Integer.valueOf(num);
                
            }while(clienteDao.existeId(id));
            
            txtNumCliente.setText(num);
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, ne.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        return id;
    }
    
    private String generarIdCuenta(){
        String num = "";
        try {
            cuentaDao = new CuentaDao();
            
            do{
                num = "";
                
                for(int i = 0; i < 11; i++){
                    num += String.valueOf(Math.floor(Math.random() * 8 + 1)).charAt(0);
                }
                
            }while(cuentaDao.existeId(num));
            
            txtCuenta.setText(num);
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, ne.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        return num;
    }
    
    private String generarTarjeta(){
        String num = "";
        try {
            tarjetaDao = new TarjetaDao();
            
            do{
                num = "";
                
                for(int i = 0; i < 16; i++){
                    num += String.valueOf(Math.floor(Math.random() * 8 + 1)).charAt(0);
                }
            
                txtTarjeta.setText(num);
                
            }while(tarjetaDao.existeId(txtTarjeta.getText()));
        } catch (NumberFormatException ne) {
            JOptionPane.showMessageDialog(this, ne.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        return num;
    }
    
    private void limpiarCampos(){
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        cbRegimen.setSelectedIndex(0);
        txtRfc.setText("");
        txtRfc.setEnabled(false);
        txtCurp.setText("");
        txtCurp.setEnabled(false);
        cbGenero.setSelectedIndex(0);
        txtTelefono.setText("");
        txtIne.setText("");
        cbTipoTelefono.setSelectedIndex(0);
        txtCorreo.setText("");
        txtCalle.setText("");
        txtColonia.setText("");
        txtCodigoPostal.setText("");
        txtNumExt.setText("");
        txtNumInt.setText("");
        dcFechaNacimiento.setDate(null);
        txtCuenta.setText("");
        cbTipoCuenta.setSelectedIndex(0);
        txtTarjeta.setText("");
        cbTipoCuenta.setEnabled(true);
        btnNuevaCuenta.setEnabled(true);
    }
    
    private void btnAltaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaClienteActionPerformed
        try {
            String rfc = null, curp = null, numInt;
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

                switch(cbRegimen.getSelectedIndex()){
                    case 1:
                        rfc = txtRfc.getText();
                        curp = txtCurp.getText();
                        break;
                    case 2:
                        rfc = txtRfc.getText();
                        curp = null;
                        break;
                    case 3:
                        rfc = null;
                        curp = txtCurp.getText();
                        break;
                }
                
                if(txtNumInt.getText().trim().isEmpty()){
                    numInt = null;
                }else{
                    numInt = txtNumInt.getText();
                }
                
                cliente = new Cliente(Integer.valueOf(txtNumCliente.getText()), txtNombre.getText(), 
                        txtApellidoPaterno.getText(), txtApellidoMaterno.getText(), txtIne.getText(),
                        rfc, curp, cbRegimen.getSelectedItem().toString(),
                        genero, "Activo", new Date(dcFechaNacimiento.getDate().getTime()));
                correo = new CorreoCliente(Integer.valueOf(txtNumCliente.getText()), txtCorreo.getText());
                direccion = new DireccionCliente(txtCalle.getText(), numInt, txtNumExt.getText(),
                        txtColonia.getText(), txtCodigoPostal.getText(), Integer.valueOf(txtNumCliente.getText()));
                telefono = new TelefonoCliente(Integer.valueOf(txtNumCliente.getText()), txtTelefono.getText(),
                        cbTipoTelefono.getSelectedItem().toString());
                clienteDao = new ClienteDao();
                clienteDao.insertarCliente(cliente, correo, direccion, telefono);
                if(clienteDao.existeId(Integer.valueOf(txtNumCliente.getText()))){
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
    }//GEN-LAST:event_btnAltaClienteActionPerformed
    
    public void usuarios(){
        try {
            cuentaDao = new CuentaDao();
            if(!cuentaDao.buscarCuentasE(Integer.valueOf(txtNumCliente.getText())).isEmpty()){
                Query qf = entma.createNamedQuery("TblUsuariosClientes.findByTblClienteidCliente");
                qf.setParameter("tblClienteidCliente", Integer.valueOf(txtNumCliente.getText()));
                tblUsuarioC = (TblUsuariosClientes)qf.getSingleResult();
                if(JOptionPane.showConfirmDialog(this, "Olvido su contraseña??") == JOptionPane.YES_OPTION){
                    CrearUsuario crear = new CrearUsuario(txtNumCliente.getText(), "Cliente", true);
                    crear.setVisible(true);
                }
            }
        } catch (NoResultException ne) {
            if(JOptionPane.showConfirmDialog(this, "Desea crear un usuario??") == JOptionPane.YES_OPTION){
                CrearUsuario crear = new CrearUsuario(txtNumCliente.getText(), "Cliente", false);
                crear.setVisible(true);
            }
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void tbBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarClienteActionPerformed
        if(tbBuscarCliente.isSelected()){
            txtNumCliente.setText("");
            txtNumCliente.setEnabled(true);
            btnAltaCliente.setEnabled(false);
        }else{
            generarIdCliente();
            txtNumCliente.setEnabled(false);
            btnAltaCliente.setEnabled(true);
            limpiarCampos();  
        }
    }//GEN-LAST:event_tbBuscarClienteActionPerformed

    private void cbRegimenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRegimenActionPerformed
        try {
            switch(cbRegimen.getSelectedIndex()){
                case 0:
                    txtRfc.setEnabled(false);
                    txtCurp.setEnabled(false);
                    txtRfc.setText("");
                    txtCurp.setText("");
                    break;
                case 1:
                    txtRfc.setEnabled(true);
                    txtRfc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("UUUU######***")));
                    txtCurp.setEnabled(true); 
                    txtRfc.setText("");
                    txtCurp.setText("");
                    break;
                case 2:
                    txtRfc.setEnabled(true);
                    txtCurp.setEnabled(false);
                    txtRfc.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("UUU######***")));
                    txtRfc.setText("");
                    txtCurp.setText("");
                    break;
                case 3:
                    txtRfc.setEnabled(false);
                    txtCurp.setEnabled(true);
                    txtRfc.setText("");
                    txtCurp.setText("");
                    break;                
            }
        } catch (ParseException pe) {
            JOptionPane.showMessageDialog(this, pe.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_cbRegimenActionPerformed

    private void txtNumExtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExtKeyTyped
        char c = evt.getKeyChar();
        
        if(Character.isLetter(c) || c == ' ' || txtNumExt.getText().length() > 3){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumExtKeyTyped

    private void txtRfcFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRfcFocusLost
        if(!txtRfc.getText().trim().isEmpty()){
            clienteDao = new ClienteDao();
            if(clienteDao.buscarRFC(txtRfc.getText(), Integer.valueOf(txtNumCliente.getText()))){
                JOptionPane.showMessageDialog(this, "Ese RFC ya se encuentra registrado con otro cliente");
                txtRfc.setText("");
            }
        }
    }//GEN-LAST:event_txtRfcFocusLost

    private void txtCurpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCurpFocusLost
        if(btnAltaCliente.isEnabled()){
            if(!txtCurp.getText().trim().isEmpty()){
                clienteDao = new ClienteDao();
                if(clienteDao.buscarCURP(txtCurp.getText(), Integer.valueOf(txtNumCliente.getText()))){
                    JOptionPane.showMessageDialog(this, "Ese CURP ya se encuentra registrado");
                    txtCurp.setText("");
               }
            }
        }
    }//GEN-LAST:event_txtCurpFocusLost

    private void btnBajaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaClienteActionPerformed
        try {
            if(txtNumCliente.getText().trim().isEmpty()){
                throw new MisExcepciones(21);
            }else if(JOptionPane.showConfirmDialog(this, "Si se da de baja el Cliente, se daran de baja sus cuentas\nDesea continuar??") == JOptionPane.YES_OPTION){
                entma.getTransaction().begin();
                tblCliente.setEstatus("Inactivo");
                entma.getTransaction().commit();
                limpiarCampos();
                generarIdCliente();
                tbBuscarCliente.setSelected(false);
                tbBuscarClienteActionPerformed(null);
                JOptionPane.showMessageDialog(this, "Se ha dado de baja con exito");
            }else{
                JOptionPane.showMessageDialog(this, "Se ha cancelado la baja");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBajaClienteActionPerformed

    private void txtNumClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumClienteFocusLost
        try {
            if(txtNumCliente.getText().trim().isEmpty()){
                tbBuscarCliente.setSelected(false);
                tbBuscarClienteActionPerformed(null);
                throw new MisExcepciones(23);
            }else{
                Query qf = entma.createNamedQuery("TblCliente.findByIdCliente");
                qf.setParameter("idCliente", Integer.valueOf(txtNumCliente.getText()));
                tblCliente = (TblCliente)qf.getSingleResult();
                if(tblCliente.getEstatus().equals("Inactivo")){
                    JOptionPane.showMessageDialog(this, "El cliente se encuentra inactivo");
                }else{
                    txtNumCliente.setEnabled(false);
                    dcFechaNacimiento.setDate(tblCliente.getFechaNacimiento());
                    txtNombre.setText(tblCliente.getNombre());
                    txtApellidoPaterno.setText(tblCliente.getApellidoPaterno());
                    txtApellidoMaterno.setText(tblCliente.getApellidoMaterno());
                    cbRegimen.setSelectedItem(tblCliente.getRegimenFiscal());
                    cbRegimenActionPerformed(null);
                    switch(tblCliente.getRegimenFiscal()){
                        case "Persona Fisica":
                            txtRfc.setText(tblCliente.getRfc());
                            txtRfc.setEnabled(true);
                            txtCurp.setText(tblCliente.getCurp());
                            txtCurp.setEnabled(true);
                            break;
                        case "Persona Moral":
                            txtRfc.setText(tblCliente.getRfc());
                            txtRfc.setEnabled(true);
                            break;
                        case "NA":
                            txtCurp.setText(tblCliente.getCurp());
                            txtCurp.setEnabled(true);
                            break;
                    }
                    switch(tblCliente.getGenero()){
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
                    txtIne.setText(tblCliente.getIne());
                    telefonoDao = new TelefonoClienteDao();
                    telefono = telefonoDao.buscarTelefono(Integer.valueOf(txtNumCliente.getText()));
                    txtTelefono.setText(telefono.getNumTelefonoCliente());
                    cbTipoTelefono.setSelectedItem(telefono.getTipoTelefonoCliente());
                    direccionDao = new DireccionClienteDao();
                    direccion = direccionDao.buscarDireccion(Integer.valueOf(txtNumCliente.getText()));
                    txtCalle.setText(direccion.getCalle());
                    txtColonia.setText(direccion.getColonia());
                    txtCodigoPostal.setText(direccion.getCodigoPostal());
                    txtNumInt.setText(direccion.getNumInt());
                    txtNumExt.setText(direccion.getNumExt());
                    correoDao = new CorreoClienteDao();
                    correo = correoDao.buscarCorreo(Integer.valueOf(txtNumCliente.getText()));
                    txtCorreo.setText(correo.getCorreoCliente());
                    usuarios();
                }
            }
        } catch (NoResultException ne) {
            JOptionPane.showMessageDialog(this, "No se encontro al cliente");
            tbBuscarCliente.setSelected(false);
            tbBuscarClienteActionPerformed(null);
        } catch (NumberFormatException | MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtNumClienteFocusLost

    private void txtNumClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNumClienteFocusGained
        txtNumCliente.setText("");
    }//GEN-LAST:event_txtNumClienteFocusGained

    private void btnModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDatosActionPerformed
        try {
            String rfc = null, curp = null;
            if(txtNumCliente.getText().isEmpty()){
                throw new MisExcepciones(21);
            }else{
                if(!camposVacios()){
                    entma.getTransaction().begin();
                    tblCliente.setFechaNacimiento(new Date(dcFechaNacimiento.getDate().getTime()));
                    tblCliente.setNombre(txtNombre.getText());
                    tblCliente.setApellidoPaterno(txtApellidoPaterno.getText());
                    tblCliente.setApellidoMaterno(txtApellidoMaterno.getText());
                    tblCliente.setRegimenFiscal(cbRegimen.getSelectedItem().toString());
                    switch(cbRegimen.getSelectedIndex()){
                        case 1:
                            rfc = txtRfc.getText();
                            curp = txtCurp.getText();
                            break;
                        case 2:
                            rfc = txtRfc.getText();
                            curp = null;
                            break;
                        case 3:
                            rfc = null;
                            curp = txtCurp.getText();
                            break;
                    }
                    
                    tblCliente.setRfc(rfc);
                    tblCliente.setCurp(curp);
                    
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
                    tblCliente.setGenero(genero);
                    tblCliente.setIne(txtIne.getText());
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

    private void btnCambiarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarTelefonoActionPerformed
        try {
            if(!camposVacios()){
                entma.getTransaction().begin();
                TblTelefonoClientes telefonoCliente = new TblTelefonoClientes();
                telefonoCliente.setNumTelefonoCliente(txtTelefono.getText());
                telefonoCliente.setTipoTelefonoCliente(cbTipoTelefono.getSelectedItem().toString());
                telefonoCliente.setClienteidCliente(tblCliente);
                entma.persist(telefonoCliente);
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
                TblCorreoClientes correoClientes = new TblCorreoClientes();
                correoClientes.setCorreoCliente(txtCorreo.getText());
                correoClientes.setClienteidCliente(tblCliente);
                entma.persist(correoClientes);
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

    private void btnModificarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDireccionActionPerformed
        try {
            String numInt;
            if(!camposVacios()){
                Query qf = entma.createNamedQuery("TblDireccionCliente.findByIdDireccionCliente");
                qf.setParameter("idDireccionCliente", direccion.getIdDireccionCliente());
                tblDireccionCliente = (TblDireccionCliente)qf.getSingleResult();
                entma.getTransaction().begin();
                tblDireccionCliente.setCalle(txtCalle.getText());
                tblDireccionCliente.setCodigoPostal(txtCodigoPostal.getText());
                tblDireccionCliente.setColonia(txtColonia.getText());
                tblDireccionCliente.setNumExt(txtNumExt.getText());
                
                if(txtNumInt.getText().trim().isEmpty()){
                    numInt = null;
                }else{
                    numInt = txtNumInt.getText();
                }
                
                tblDireccionCliente.setNumInt(numInt);
                entma.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Se ha modificado la direccion");
            }
            
        } catch (HeadlessException | MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarDireccionActionPerformed

    private void btCambiarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCambiarDireccionActionPerformed
        try {
            if(!camposVacios()){
                String numInt;
                entma.getTransaction().begin();
                TblDireccionCliente direccionClientes = new TblDireccionCliente();
                direccionClientes.setCalle(txtCalle.getText());
                direccionClientes.setCodigoPostal(txtCodigoPostal.getText());
                direccionClientes.setColonia(txtColonia.getText());
                
                if(txtNumInt.getText().trim().isEmpty()){
                    numInt = null;
                }else{
                    numInt = txtNumInt.getText();
                }
                
                direccionClientes.setNumInt(numInt);
                direccionClientes.setNumExt(txtNumExt.getText());
                direccionClientes.setClienteidCliente(tblCliente);
                entma.persist(direccionClientes);
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

    private void btnBeneficiariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBeneficiariosActionPerformed
        try {
            if(!camposVacios()){
                general.setIdCliente(Integer.valueOf(txtNumCliente.getText()));
                general.setVisible(true);
            }
        } catch (HeadlessException | MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBeneficiariosActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        this.dispose();
        Menu menu = new Menu(idEmpleado);
        menu.setVisible(true);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void txtRfcFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRfcFocusGained
        if(txtRfc.getText().trim().isEmpty()){
            txtRfc.setText("");
        }
    }//GEN-LAST:event_txtRfcFocusGained

    private void txtCurpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCurpFocusGained
        if(txtCurp.getText().trim().isEmpty()){
            txtCurp.setText("");
        }
    }//GEN-LAST:event_txtCurpFocusGained

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        if(txtTelefono.getText().trim().isEmpty()){
            txtTelefono.setText("");
        }
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtIneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIneFocusGained
        if(txtIne.getText().trim().isEmpty()){
            txtIne.setText("");
        }
    }//GEN-LAST:event_txtIneFocusGained

    private void txtCodigoPostalFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCodigoPostalFocusGained
        if(txtCodigoPostal.getText().trim().isEmpty()){
            txtCodigoPostal.setText("");
        }
    }//GEN-LAST:event_txtCodigoPostalFocusGained

    private void txtCuentaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCuentaFocusLost
        if(txtCuenta.getText().trim().isEmpty()){
            btnNuevaCuenta.setEnabled(true);
            cbTipoCuenta.setSelectedIndex(0);
        }
    }//GEN-LAST:event_txtCuentaFocusLost

    private void btnNuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaCuentaActionPerformed
        try {
            if(!camposVacios()){
                if(cbTipoCuenta.getSelectedIndex() == 0){
                    throw new MisExcepciones(34);
                }else{
                    if(JOptionPane.showConfirmDialog(this, "Desea crear una nueva cuenta??") == JOptionPane.YES_OPTION){
                        generarIdCuenta();
                        cuenta = new Cuenta(txtCuenta.getText(), cbTipoCuenta.getSelectedItem().toString(),
                                tblEmpleado.getBancosSucursal().getSucursal(), 
                                tblEmpleado.getBancosSucursal().getSucursal() + tblEmpleado.getBancosSucursal().getPlaza() + txtCuenta.getText() + "0", 
                                Integer.valueOf(txtNumCliente.getText()), 0, "Activo");
                        cuentaDao = new CuentaDao();
                        cuentaDao.insertarCuenta(cuenta);
                        if(cuentaDao.existeId(txtCuenta.getText())){
                            JOptionPane.showMessageDialog(this, "Cuenta creada");
                            buscarCuenta();
                        }else{
                            JOptionPane.showMessageDialog(this, "VERIFIQUE LOS DATOS");
                        }
                        cbTipoCuenta.setEnabled(false);
                        btnNuevaCuenta.setEnabled(false);
                    }else{
                        cbTipoCuenta.setSelectedIndex(0);
                    }
                }
            }
        } catch (MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnNuevaCuentaActionPerformed
 
    private void btnAsignarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarTarjetaActionPerformed
        try {
            if(!camposVacios()){
                if(txtCuenta.getText().trim().isEmpty() || txtCuenta.isEnabled()){
                    throw new MisExcepciones(35);
                }else{
                    if(JOptionPane.showConfirmDialog(this, "Desea asignar una tarjeta nueva ??") == JOptionPane.YES_OPTION){
                        generarTarjeta();
                        
                        entma.getTransaction().begin();
                        TblTarjetas tblTarjeta = new TblTarjetas();
                        tblTarjeta.setNumTarjeta(txtTarjeta.getText());
                        tblTarjeta.setCuentasnumCuenta(tblCuentas);
                        tblTarjeta.setEstadoTarjeta("Activa");
                        entma.persist(tblTarjeta);
                        entma.getTransaction().commit();
                        btnAsignarTarjeta.setEnabled(false);
                        
                        if(tarjetaDao.existeId(txtTarjeta.getText())){
                            JOptionPane.showMessageDialog(this, "Tarjeta asignada");
                        }else{
                            JOptionPane.showMessageDialog(this, "VERIFIQUE LOS DATOS");
                        }
                        cbTipoCuenta.setEnabled(false);
                        btnNuevaCuenta.setEnabled(false);
                    }else{
                        cbTipoCuenta.setSelectedIndex(0);
                    }
                }
            }
        } catch (MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnAsignarTarjetaActionPerformed

    private void btnCuentasTarjetasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuentasTarjetasActionPerformed
        try {
            if(!camposVacios()){
                TarjetasCuentas tarjetas = new TarjetasCuentas(Integer.valueOf(txtNumCliente.getText()), idEmpleado);
                tarjetas.setVisible(true);
                this.dispose();
                entma.clear();
                entma.close();
            }
        } catch (MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnCuentasTarjetasActionPerformed

    private void btnBajaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaCuentaActionPerformed
        try {
            if(!camposVacios()){
                if(txtCuenta.getText().trim().isEmpty()){
                    throw new MisExcepciones(35);
                }else{
                    entma.getTransaction().begin();
                    tblCuentas.setEstado("Inactivo");
                    entma.persist(tblCuentas);
                    entma.getTransaction().commit();
                    JOptionPane.showMessageDialog(this, "Se ha dado de baja la cuenta");
                    txtCuenta.setText("");
                    txtTarjeta.setText("");
                    cbTipoCuenta.setSelectedIndex(0);
                    cbTipoCuenta.setEnabled(true);
                    btnNuevaCuenta.setEnabled(true);
                    btnAsignarTarjeta.setEnabled(true);
                }
            }
        } catch (MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBajaCuentaActionPerformed

    private void btnBajaTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBajaTarjetaActionPerformed
        try {
            if(!camposVacios()){
                if(txtTarjeta.getText().equals("    -    -    -    ")){
                    throw new MisExcepciones(35);
                }else{
                    entma.getTransaction().begin();
                    tblTarjetas.setEstadoTarjeta("Inactivo");
                    entma.persist(tblCuentas);
                    entma.getTransaction().commit();
                    JOptionPane.showMessageDialog(this, "Se ha dado de baja la tarjeta");
                    txtTarjeta.setText("");
                    btnAsignarTarjeta.setEnabled(true);
                }
            }
        } catch (MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBajaTarjetaActionPerformed

    private void btnEstadoCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoCuentaActionPerformed
        try {
            if(!camposVacios()){
                ReportePdf reporte = new ReportePdf();
                if(tblEmpleado.getBancosSucursal().getSucursal().equals("106")){
                    reporte.generarReporte("C:\\Users\\baloc\\OneDrive\\Documentos\\NetBeansProjects\\SISBAN\\src\\estadoCuentaGeneral\\" + String.valueOf(tblCliente.getIdCliente()) + "ANUAL" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + ".pdf", "ESTADO CUENTA ANUAL", tblCliente.getIdCliente(), null ,null, "BBVA", true);
                    new Procesos().cargarArchivoG(String.valueOf(tblCliente.getIdCliente()) + "ANUAL" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                }else{
                    reporte.generarReporte("C:\\Users\\baloc\\OneDrive\\Documentos\\NetBeansProjects\\SISBAN\\src\\estadoCuentaGeneral\\" + String.valueOf(tblCliente.getIdCliente()) + "ANUAL" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)) + ".pdf", "ESTADO CUENTA ANUAL", tblCliente.getIdCliente(), null ,null, "HSBC", true);
                    new Procesos().cargarArchivoG(String.valueOf(tblCliente.getIdCliente()) + "ANUAL" + String.valueOf(Calendar.getInstance().get(Calendar.YEAR)));
                }
            }
        } catch (MisExcepciones e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnEstadoCuentaActionPerformed

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
            java.util.logging.Logger.getLogger(GeneralClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneralClientes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCambiarDireccion;
    private javax.swing.JButton btnAltaCliente;
    private javax.swing.JButton btnAsignarTarjeta;
    private javax.swing.JButton btnBajaCliente;
    private javax.swing.JButton btnBajaCuenta;
    private javax.swing.JButton btnBajaTarjeta;
    private javax.swing.JButton btnBeneficiarios;
    private javax.swing.JButton btnCambiarCorreo;
    private javax.swing.JButton btnCambiarTelefono;
    private javax.swing.JButton btnCuentasTarjetas;
    private javax.swing.JButton btnEstadoCuenta;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JButton btnModificarDireccion;
    private javax.swing.JButton btnNuevaCuenta;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbRegimen;
    private javax.swing.JComboBox<String> cbTipoCuenta;
    private javax.swing.JComboBox<String> cbTipoTelefono;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JToggleButton tbBuscarCliente;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JFormattedTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtCuenta;
    private javax.swing.JFormattedTextField txtCurp;
    private javax.swing.JFormattedTextField txtIne;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JFormattedTextField txtNumCliente;
    private javax.swing.JTextField txtNumExt;
    private javax.swing.JTextField txtNumInt;
    private javax.swing.JFormattedTextField txtRfc;
    private javax.swing.JFormattedTextField txtTarjeta;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
