package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblCliente;
import jpa.TblPreguntas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblRespuestas.class)
public class TblRespuestas_ { 

    public static volatile SingularAttribute<TblRespuestas, TblCliente> clienteidCliente;
    public static volatile SingularAttribute<TblRespuestas, TblPreguntas> preguntaidPregunta;
    public static volatile SingularAttribute<TblRespuestas, String> respuesta;
    public static volatile SingularAttribute<TblRespuestas, Integer> idRespuesta;

}