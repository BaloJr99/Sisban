package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblEmpleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblDireccionEmpleados.class)
public class TblDireccionEmpleados_ { 

    public static volatile SingularAttribute<TblDireccionEmpleados, String> numInt;
    public static volatile SingularAttribute<TblDireccionEmpleados, String> numExt;
    public static volatile SingularAttribute<TblDireccionEmpleados, String> codigoPostal;
    public static volatile SingularAttribute<TblDireccionEmpleados, String> calle;
    public static volatile SingularAttribute<TblDireccionEmpleados, Integer> idDireccionEmpleado;
    public static volatile SingularAttribute<TblDireccionEmpleados, TblEmpleado> empleadoidEmpleado;
    public static volatile SingularAttribute<TblDireccionEmpleados, String> colonia;

}