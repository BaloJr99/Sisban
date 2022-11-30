package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblBancos;
import jpa.TblCorreoEmpleado;
import jpa.TblDireccionEmpleados;
import jpa.TblTelefonoEmpleados;
import jpa.TblUsuariosEmpleados;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblEmpleado.class)
public class TblEmpleado_ { 

    public static volatile SingularAttribute<TblEmpleado, String> apellidoPaterno;
    public static volatile SingularAttribute<TblEmpleado, TblBancos> bancosSucursal;
    public static volatile CollectionAttribute<TblEmpleado, TblCorreoEmpleado> tblCorreoEmpleadoCollection;
    public static volatile SingularAttribute<TblEmpleado, Date> fechaNacimiento;
    public static volatile CollectionAttribute<TblEmpleado, TblTelefonoEmpleados> tblTelefonoEmpleadosCollection;
    public static volatile SingularAttribute<TblEmpleado, TblUsuariosEmpleados> tblUsuariosEmpleados;
    public static volatile SingularAttribute<TblEmpleado, String> nombre;
    public static volatile SingularAttribute<TblEmpleado, String> rfc;
    public static volatile CollectionAttribute<TblEmpleado, TblDireccionEmpleados> tblDireccionEmpleadosCollection;
    public static volatile SingularAttribute<TblEmpleado, String> apellidoMaterno;
    public static volatile SingularAttribute<TblEmpleado, String> nss;
    public static volatile SingularAttribute<TblEmpleado, String> puesto;
    public static volatile SingularAttribute<TblEmpleado, Date> fechaIngreso;
    public static volatile SingularAttribute<TblEmpleado, Integer> idEmpleado;
    public static volatile SingularAttribute<TblEmpleado, String> genero;
    public static volatile SingularAttribute<TblEmpleado, Date> fechaTerminacion;
    public static volatile SingularAttribute<TblEmpleado, String> curp;

}