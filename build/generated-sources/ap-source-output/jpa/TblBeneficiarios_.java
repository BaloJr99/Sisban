package jpa;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblCliente;
import jpa.TblCorreoBeneficiarios;
import jpa.TblDireccionBeneficiarios;
import jpa.TblTelefonoBeneficiario;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblBeneficiarios.class)
public class TblBeneficiarios_ { 

    public static volatile SingularAttribute<TblBeneficiarios, String> apellidoPaterno;
    public static volatile SingularAttribute<TblBeneficiarios, String> ine;
    public static volatile SingularAttribute<TblBeneficiarios, Integer> idBeneficiario;
    public static volatile SingularAttribute<TblBeneficiarios, Date> fechaNacimiento;
    public static volatile SingularAttribute<TblBeneficiarios, String> parentesco;
    public static volatile CollectionAttribute<TblBeneficiarios, TblDireccionBeneficiarios> tblDireccionBeneficiariosCollection;
    public static volatile CollectionAttribute<TblBeneficiarios, TblCorreoBeneficiarios> tblCorreoBeneficiariosCollection;
    public static volatile SingularAttribute<TblBeneficiarios, Character> genero;
    public static volatile SingularAttribute<TblBeneficiarios, TblCliente> clienteidCliente;
    public static volatile SingularAttribute<TblBeneficiarios, String> nombre;
    public static volatile SingularAttribute<TblBeneficiarios, String> apellidoMaterno;
    public static volatile CollectionAttribute<TblBeneficiarios, TblTelefonoBeneficiario> tblTelefonoBeneficiarioCollection;

}