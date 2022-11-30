package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblCuentas;
import jpa.TblDireccionBancos;
import jpa.TblEmpleado;
import jpa.TblTelefonoBancos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblBancos.class)
public class TblBancos_ { 

    public static volatile SingularAttribute<TblBancos, String> plaza;
    public static volatile CollectionAttribute<TblBancos, TblEmpleado> tblEmpleadoCollection;
    public static volatile CollectionAttribute<TblBancos, TblTelefonoBancos> tblTelefonoBancosCollection;
    public static volatile CollectionAttribute<TblBancos, TblCuentas> tblCuentasCollection;
    public static volatile SingularAttribute<TblBancos, String> sucursal;
    public static volatile CollectionAttribute<TblBancos, TblDireccionBancos> tblDireccionBancosCollection;
    public static volatile SingularAttribute<TblBancos, String> nombreSucursal;
    public static volatile SingularAttribute<TblBancos, String> rfc;

}