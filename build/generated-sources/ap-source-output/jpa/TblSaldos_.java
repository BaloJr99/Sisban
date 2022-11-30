package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblTransacciones;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblSaldos.class)
public class TblSaldos_ { 

    public static volatile SingularAttribute<TblSaldos, Date> fecha;
    public static volatile SingularAttribute<TblSaldos, TblTransacciones> claveRastreo;
    public static volatile SingularAttribute<TblSaldos, Integer> idSaldos;
    public static volatile SingularAttribute<TblSaldos, String> numCuenta;
    public static volatile SingularAttribute<TblSaldos, Date> hora;
    public static volatile SingularAttribute<TblSaldos, Double> saldo;
    public static volatile SingularAttribute<TblSaldos, String> bancoSucursal;

}