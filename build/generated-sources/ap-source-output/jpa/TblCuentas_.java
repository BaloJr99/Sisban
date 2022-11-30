package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblBancos;
import jpa.TblCliente;
import jpa.TblTarjetas;
import jpa.TblTransacciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblCuentas.class)
public class TblCuentas_ { 

    public static volatile CollectionAttribute<TblCuentas, TblTransacciones> tblTransaccionesCollection;
    public static volatile SingularAttribute<TblCuentas, String> estado;
    public static volatile CollectionAttribute<TblCuentas, TblTarjetas> tblTarjetasCollection;
    public static volatile SingularAttribute<TblCuentas, TblCliente> clienteidCliente;
    public static volatile SingularAttribute<TblCuentas, String> tipoCuenta;
    public static volatile SingularAttribute<TblCuentas, String> numeroCuenta;
    public static volatile SingularAttribute<TblCuentas, Double> saldo;
    public static volatile SingularAttribute<TblCuentas, TblBancos> bancoSucursal;
    public static volatile SingularAttribute<TblCuentas, String> clabe;

}