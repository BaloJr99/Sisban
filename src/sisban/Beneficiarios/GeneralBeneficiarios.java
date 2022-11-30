package sisban.Beneficiarios;

import cl.model.dao.BeneficiarioDao;
import cl.model.dao.CorreoBeneficiarioDao;
import cl.model.dao.DireccionBeneficiarioDao;
import cl.model.dao.TelefonoBeneficiarioDao;
import cl.model.db.Beneficiario;
import cl.model.db.CorreoBeneficiario;
import cl.model.db.DireccionBeneficiario;
import cl.model.db.TelefonoBeneficiario;
import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Date;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import jpa.TblBeneficiarios;
import jpa.TblCorreoBeneficiarios;
import jpa.TblDireccionBeneficiarios;
import jpa.TblTelefonoBeneficiario;
import misExcepciones.MisExcepciones;

public class GeneralBeneficiarios extends javax.swing.JFrame {

    private int idCliente;
    private int idBeneficiario;
        
    BeneficiarioDao beneficiarioDao;
    TelefonoBeneficiarioDao telefonoDao;
    DireccionBeneficiarioDao direccionDao;
    CorreoBeneficiarioDao correoDao;
    
    Beneficiario beneficiario;
    TelefonoBeneficiario telefono;
    DireccionBeneficiario direccion;
    CorreoBeneficiario correo;

    TblBeneficiarios tblBeneficiario;
    TblDireccionBeneficiarios tblDireccionBeneficiario;
    TblTelefonoBeneficiario tblTelefonoBeneficiario;
    TblCorreoBeneficiarios tblCorreoBeneficiario;
     
    Font letra = new Font("Tw Cen MT", Font.PLAIN, 12);
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
        buscarBeneficiario();
    }
    
    public GeneralBeneficiarios() {
        initComponents();
        setLocationRelativeTo(null);
        txtNumBeneficiario.setEnabled(false);
        dcFechaNacimiento.setFont(letra);
        txtIne.setFont(letra);
        txtCodigoPostal.setFont(letra);
        txtTelefono.setFont(letra);
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
        dcFechaNacimiento = new com.toedter.calendar.JDateChooser();
        cbGenero = new javax.swing.JComboBox<>();
        txtIne = new javax.swing.JFormattedTextField();
        lblParentesco = new javax.swing.JLabel();
        txtParentesco = new javax.swing.JTextField();
        txtNumBeneficiario = new javax.swing.JTextField();
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
        btnModificarDatos = new javax.swing.JButton();
        btnModificarDireccion = new javax.swing.JButton();
        btCambiarDireccion = new javax.swing.JButton();
        btnCambiarTelefono = new javax.swing.JButton();
        btnCambiarCorreo = new javax.swing.JButton();
        tbNuevoBeneficiario = new javax.swing.JToggleButton();
        btnAltaBeneficiario = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

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

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel3.setText("Numero Beneficiario");

        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel5.setText("Apellido Paterno");

        jLabel6.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel6.setText("Apellido Materno");

        jLabel10.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel10.setText("Genero");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        jLabel11.setText("Fecha De Nacimiento");

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
        jLabel1.setText("INE");

        dcFechaNacimiento.setDateFormatString("yyyy-MM-dd");

        cbGenero.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Masculino", "Femenino", "Otro" }));

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

        lblParentesco.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N
        lblParentesco.setText("Parentesco");

        txtParentesco.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

        txtNumBeneficiario.setFont(new java.awt.Font("Tw Cen MT", 0, 12)); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumBeneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblParentesco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(6, 6, 6)
                                .addComponent(cbTipoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 256, Short.MAX_VALUE))
                            .addComponent(txtCorreo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtIne, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(txtNumBeneficiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(dcFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel10))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblParentesco)
                        .addComponent(txtParentesco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTipoTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtIne))))))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 92, 510, 200));

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
                        .addComponent(txtNumInt, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 510, -1));

        btnModificarDatos.setText("MODIFICAR DATOS PERSONALES");
        btnModificarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDatosActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, -1));

        btnModificarDireccion.setText("MODIFICAR DIRECCION");
        btnModificarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(btnModificarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 217, -1));

        btCambiarDireccion.setText("CAMBIO DIRECCION");
        btCambiarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCambiarDireccionActionPerformed(evt);
            }
        });
        jPanel1.add(btCambiarDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 217, -1));

        btnCambiarTelefono.setText("CAMBIAR TELEFONO");
        btnCambiarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarTelefonoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 190, 217, -1));

        btnCambiarCorreo.setText("CAMBIAR CORREO");
        btnCambiarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(btnCambiarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 217, -1));

        tbNuevoBeneficiario.setText("NUEVO BENEFICIARIO");
        tbNuevoBeneficiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNuevoBeneficiarioActionPerformed(evt);
            }
        });
        jPanel1.add(tbNuevoBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 53, -1, -1));

        btnAltaBeneficiario.setText("ALTA BENEFICIARIO");
        btnAltaBeneficiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAltaBeneficiarioActionPerformed(evt);
            }
        });
        jPanel1.add(btnAltaBeneficiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 217, -1));

        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCampos(){
        txtNumBeneficiario.setText("");
        txtNombre.setText("");
        txtApellidoPaterno.setText("");
        txtApellidoMaterno.setText("");
        txtParentesco.setText("");
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
        }else if(cbGenero.getSelectedIndex() == 0){
            flag = true;
            throw new MisExcepciones(11);
        }else if(txtParentesco.getText().trim().isEmpty()){
            flag = true;
            throw new MisExcepciones(24);
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
    
    private void buscarBeneficiario(){
        try {
            beneficiarioDao = new BeneficiarioDao();
            if(beneficiarioDao.buscarBeneficiario(idCliente)){
                String genero = "";
                tbNuevoBeneficiario.setSelected(false);
                tbNuevoBeneficiarioActionPerformed(null);
                beneficiario = (Beneficiario)beneficiarioDao.buscarDatosBeneficiario(idCliente);
                this.idBeneficiario = beneficiario.getIdBeneficiario();
                txtNombre.setText(beneficiario.getNombre());
                txtNumBeneficiario.setText(String.valueOf(beneficiario.getIdBeneficiario()));
                txtApellidoPaterno.setText(beneficiario.getApellidoPaterno());
                txtApellidoMaterno.setText(beneficiario.getApellidoMaterno());
                txtParentesco.setText(beneficiario.getParentesco());
                
                switch(beneficiario.getGenero()){
                    case "M":
                        genero = "Masculino";
                        break;
                    case "F":
                        genero = "Femenino";
                        break;
                    case "O":
                        genero = "Otro";
                        break;
                }
                dcFechaNacimiento.setDate(beneficiario.getFechaNacimiento());
                cbGenero.setSelectedItem(genero);
                txtIne.setText(beneficiario.getIne());
                telefonoDao = new TelefonoBeneficiarioDao();
                telefono = (TelefonoBeneficiario)telefonoDao.buscarTelefono(idBeneficiario);
                txtTelefono.setText(telefono.getNumTelefonoBeneficiario());
                cbTipoTelefono.setSelectedItem(telefono.getTipoTelefonoBeneficiario());
                correoDao = new CorreoBeneficiarioDao();
                correo = (CorreoBeneficiario)correoDao.buscarCorreo(idBeneficiario);
                txtCorreo.setText(correo.getCorreoBeneficiario());
                direccionDao = new DireccionBeneficiarioDao();
                direccion = (DireccionBeneficiario)direccionDao.buscarDireccion(idBeneficiario);
                txtCalle.setText(direccion.getCalle());
                txtCodigoPostal.setText(direccion.getCodigoPostal());
                txtColonia.setText(direccion.getColonia());
                txtNumInt.setText(direccion.getNumInt());
                txtNumExt.setText(direccion.getNumExt());
                Query qf = entma.createNamedQuery("TblBeneficiarios.findByIdBeneficiario");
                qf.setParameter("idBeneficiario", Integer.valueOf(txtNumBeneficiario.getText()));
                tblBeneficiario = (TblBeneficiarios)qf.getSingleResult();
           }else{
                tbNuevoBeneficiario.setSelected(true);
                tbNuevoBeneficiarioActionPerformed(null);
           }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void txtNumExtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExtKeyTyped
        char c = evt.getKeyChar();

        if(Character.isLetter(c) || c == ' ' || txtNumExt.getText().length() > 3){
            evt.consume();
        }
    }//GEN-LAST:event_txtNumExtKeyTyped

    private void btnModificarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDatosActionPerformed
        try {
            if(!camposVacios()){
                entma.getTransaction().begin();
                
                tblBeneficiario.setFechaNacimiento(new Date(dcFechaNacimiento.getDate().getTime()));
                tblBeneficiario.setNombre(txtNombre.getText());
                tblBeneficiario.setApellidoPaterno(txtApellidoPaterno.getText());
                tblBeneficiario.setApellidoMaterno(txtApellidoMaterno.getText());
                tblBeneficiario.setParentesco(txtParentesco.getText());
                char genero = 0;

                switch(cbGenero.getSelectedIndex()){
                    case 1:
                    genero = 'M';
                    break;
                    case 2:
                    genero = 'F';
                    break;
                    case 3:
                    genero = 'O';
                    break;
                }
                tblBeneficiario.setGenero(genero);
                tblBeneficiario.setIne(txtIne.getText());
                entma.getTransaction().commit();
                tbNuevoBeneficiario.setSelected(false);
                tbNuevoBeneficiarioActionPerformed(null);
                JOptionPane.showMessageDialog(this, "Se ha modificado con exito el beneficiario");
            }
        } catch (HeadlessException | MisExcepciones me) {
            JOptionPane.showMessageDialog(this, me.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnModificarDatosActionPerformed

    private void btnModificarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarDireccionActionPerformed
        try {
            if(!camposVacios()){
                Query qf = entma.createNamedQuery("TblDireccionBeneficiarios.findByIdDireccionBeneficiario");
                qf.setParameter("idDireccionBeneficiario", direccion.getIdDireccionBeneficiario());
                tblDireccionBeneficiario = (TblDireccionBeneficiarios)qf.getSingleResult();
                entma.getTransaction().begin();
                tblDireccionBeneficiario.setCalle(txtCalle.getText());
                tblDireccionBeneficiario.setCodigoPostal(txtCodigoPostal.getText());
                tblDireccionBeneficiario.setColonia(txtColonia.getText());
                tblDireccionBeneficiario.setNumExt(txtNumExt.getText());
                tblDireccionBeneficiario.setNumInt(txtNumInt.getText());
                entma.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Se ha modificado la direccion");
                tbNuevoBeneficiario.setSelected(false);
                tbNuevoBeneficiarioActionPerformed(null);
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
                entma.getTransaction().begin();
                tblDireccionBeneficiario = new TblDireccionBeneficiarios();
                tblDireccionBeneficiario.setCalle(txtCalle.getText());
                tblDireccionBeneficiario.setCodigoPostal(txtCodigoPostal.getText());
                tblDireccionBeneficiario.setColonia(txtColonia.getText());
                tblDireccionBeneficiario.setNumInt(txtNumInt.getText());
                tblDireccionBeneficiario.setNumExt(txtNumExt.getText());
                tblDireccionBeneficiario.setBeneficiariosidBeneficiario(tblBeneficiario);
                entma.persist(tblDireccionBeneficiario);
                entma.getTransaction().commit();
                tbNuevoBeneficiario.setSelected(false);
                tbNuevoBeneficiarioActionPerformed(null);
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
                tblTelefonoBeneficiario = new TblTelefonoBeneficiario();
                tblTelefonoBeneficiario.setNumTelefonoBeneficiario(txtTelefono.getText());
                tblTelefonoBeneficiario.setTipoTelefonoBeneficiario(cbTipoTelefono.getSelectedItem().toString());
                tblTelefonoBeneficiario.setBeneficiariosidBeneficiario(tblBeneficiario);
                entma.persist(tblTelefonoBeneficiario);
                entma.getTransaction().commit();
                tbNuevoBeneficiario.setSelected(false);
                tbNuevoBeneficiarioActionPerformed(null);
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
                tblCorreoBeneficiario = new TblCorreoBeneficiarios();
                tblCorreoBeneficiario.setCorreoBeneficiario(txtCorreo.getText());
                tblCorreoBeneficiario.setBeneficiariosidBeneficiario(tblBeneficiario);
                entma.persist(tblCorreoBeneficiario);
                entma.getTransaction().commit();
                tbNuevoBeneficiario.setSelected(false);
                tbNuevoBeneficiarioActionPerformed(null);
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

    public void generarId(){
        idBeneficiario = new BeneficiarioDao().contarBeneficiarios() + 1;
        txtNumBeneficiario.setText(String.valueOf(idBeneficiario));
    }
    
    private void btnAltaBeneficiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAltaBeneficiarioActionPerformed
        try {
            if(!camposVacios()){
                String genero = "", numInt;

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
                
                beneficiario = new Beneficiario(idBeneficiario, idCliente, txtParentesco.getText(), txtNombre.getText(), txtApellidoPaterno.getText(),
                        txtApellidoMaterno.getText(), genero, txtIne.getText(), new Date(dcFechaNacimiento.getDate().getTime()));
                correo = new CorreoBeneficiario(idBeneficiario, txtCorreo.getText());
                direccion = new DireccionBeneficiario(idBeneficiario, txtCalle.getText(), numInt, txtNumExt.getText(),
                        txtColonia.getText(), txtCodigoPostal.getText());
                telefono = new TelefonoBeneficiario(idBeneficiario, txtTelefono.getText(),
                        cbTipoTelefono.getSelectedItem().toString());
                beneficiarioDao = new BeneficiarioDao();
                beneficiarioDao.insertarBeneficiario(beneficiario, correo, direccion, telefono);
                if(beneficiarioDao.existeId(idBeneficiario)){
                    JOptionPane.showMessageDialog(this, "Registrado");
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
    }//GEN-LAST:event_btnAltaBeneficiarioActionPerformed

    private void tbNuevoBeneficiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNuevoBeneficiarioActionPerformed
        if(tbNuevoBeneficiario.isSelected()){
            btnAltaBeneficiario.setEnabled(true);
            limpiarCampos();
            generarId();
        }else{
            btnAltaBeneficiario.setEnabled(false);
        }
    }//GEN-LAST:event_tbNuevoBeneficiarioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(GeneralBeneficiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralBeneficiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralBeneficiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralBeneficiarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GeneralBeneficiarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCambiarDireccion;
    private javax.swing.JButton btnAltaBeneficiario;
    private javax.swing.JButton btnCambiarCorreo;
    private javax.swing.JButton btnCambiarTelefono;
    private javax.swing.JButton btnModificarDatos;
    private javax.swing.JButton btnModificarDireccion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbGenero;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblParentesco;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JToggleButton tbNuevoBeneficiario;
    private javax.swing.JTextField txtApellidoMaterno;
    private javax.swing.JTextField txtApellidoPaterno;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JFormattedTextField txtCodigoPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtIne;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumBeneficiario;
    private javax.swing.JTextField txtNumExt;
    private javax.swing.JTextField txtNumInt;
    private javax.swing.JTextField txtParentesco;
    private javax.swing.JFormattedTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
