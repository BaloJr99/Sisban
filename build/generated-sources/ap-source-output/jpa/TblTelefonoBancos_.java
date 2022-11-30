package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblBancos;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblTelefonoBancos.class)
public class TblTelefonoBancos_ { 

    public static volatile SingularAttribute<TblTelefonoBancos, String> areaTelefono;
    public static volatile SingularAttribute<TblTelefonoBancos, String> numTelefono;
    public static volatile SingularAttribute<TblTelefonoBancos, TblBancos> bancosSucursal;
    public static volatile SingularAttribute<TblTelefonoBancos, Integer> idTelefonoBanco;

}