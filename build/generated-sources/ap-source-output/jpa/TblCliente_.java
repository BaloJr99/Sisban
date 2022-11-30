package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblBeneficiarios;
import jpa.TblCorreoClientes;
import jpa.TblCuentas;
import jpa.TblDireccionCliente;
import jpa.TblRespuestas;
import jpa.TblTelefonoClientes;
import jpa.TblUsuariosClientes;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblCliente.class)
public class TblCliente_ { 

    public static volatile SingularAttribute<TblCliente, String> apellidoPaterno;
    public static volatile SingularAttribute<TblCliente, String> ine;
    public static volatile CollectionAttribute<TblCliente, TblCuentas> tblCuentasCollection;
    public static volatile CollectionAttribute<TblCliente, TblTelefonoClientes> tblTelefonoClientesCollection;
    public static volatile SingularAttribute<TblCliente, Date> fechaNacimiento;
    public static volatile CollectionAttribute<TblCliente, TblRespuestas> tblRespuestasCollection;
    public static volatile SingularAttribute<TblCliente, TblUsuariosClientes> tblUsuariosClientes;
    public static volatile SingularAttribute<TblCliente, String> nombre;
    public static volatile SingularAttribute<TblCliente, String> rfc;
    public static volatile SingularAttribute<TblCliente, String> apellidoMaterno;
    public static volatile CollectionAttribute<TblCliente, TblBeneficiarios> tblBeneficiariosCollection;
    public static volatile SingularAttribute<TblCliente, Integer> idCliente;
    public static volatile SingularAttribute<TblCliente, String> estatus;
    public static volatile CollectionAttribute<TblCliente, TblDireccionCliente> tblDireccionClienteCollection;
    public static volatile SingularAttribute<TblCliente, String> regimenFiscal;
    public static volatile CollectionAttribute<TblCliente, TblCorreoClientes> tblCorreoClientesCollection;
    public static volatile SingularAttribute<TblCliente, String> genero;
    public static volatile SingularAttribute<TblCliente, String> curp;

}