package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblCliente;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblDireccionCliente.class)
public class TblDireccionCliente_ { 

    public static volatile SingularAttribute<TblDireccionCliente, String> numInt;
    public static volatile SingularAttribute<TblDireccionCliente, String> numExt;
    public static volatile SingularAttribute<TblDireccionCliente, String> codigoPostal;
    public static volatile SingularAttribute<TblDireccionCliente, String> calle;
    public static volatile SingularAttribute<TblDireccionCliente, TblCliente> clienteidCliente;
    public static volatile SingularAttribute<TblDireccionCliente, Integer> idDireccionCliente;
    public static volatile SingularAttribute<TblDireccionCliente, String> colonia;

}