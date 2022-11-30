package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblCuentas;
import jpa.TblSaldos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblTransacciones.class)
public class TblTransacciones_ { 

    public static volatile SingularAttribute<TblTransacciones, String> bancosSucursal;
    public static volatile SingularAttribute<TblTransacciones, String> claveRastreo;
    public static volatile SingularAttribute<TblTransacciones, Date> fecha;
    public static volatile SingularAttribute<TblTransacciones, Double> monto;
    public static volatile SingularAttribute<TblTransacciones, String> descripción;
    public static volatile SingularAttribute<TblTransacciones, String> numReferencia;
    public static volatile SingularAttribute<TblTransacciones, String> cuentaDestino;
    public static volatile SingularAttribute<TblTransacciones, Date> hora;
    public static volatile CollectionAttribute<TblTransacciones, TblSaldos> tblSaldosCollection;
    public static volatile SingularAttribute<TblTransacciones, String> tipoMovimiento;
    public static volatile SingularAttribute<TblTransacciones, TblCuentas> cuentasnumeroCuenta;
    public static volatile SingularAttribute<TblTransacciones, String> destinatario;

}