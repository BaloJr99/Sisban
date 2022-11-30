package jpa;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import jpa.TblRespuestas;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-01-24T23:18:12")
@StaticMetamodel(TblPreguntas.class)
public class TblPreguntas_ { 

    public static volatile CollectionAttribute<TblPreguntas, TblRespuestas> tblRespuestasCollection;
    public static volatile SingularAttribute<TblPreguntas, Integer> idPregunta;
    public static volatile SingularAttribute<TblPreguntas, String> pregunta;

}