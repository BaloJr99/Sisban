package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblBancos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblDireccionBancos.class)
public class TblDireccionBancos_ { 

    public static volatile SingularAttribute<TblDireccionBancos, String> numInt;
    public static volatile SingularAttribute<TblDireccionBancos, TblBancos> bancosSucursal;
    public static volatile SingularAttribute<TblDireccionBancos, String> numExt;
    public static volatile SingularAttribute<TblDireccionBancos, Integer> idDireccionBancos;
    public static volatile SingularAttribute<TblDireccionBancos, String> codigoPostal;
    public static volatile SingularAttribute<TblDireccionBancos, String> calle;
    public static volatile SingularAttribute<TblDireccionBancos, String> colonia;

}