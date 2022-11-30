/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author baloc
 */
@Entity
@Table(name = "tblPreguntas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblPreguntas.findAll", query = "SELECT t FROM TblPreguntas t")
    , @NamedQuery(name = "TblPreguntas.findByIdPregunta", query = "SELECT t FROM TblPreguntas t WHERE t.idPregunta = :idPregunta")
    , @NamedQuery(name = "TblPreguntas.findByPregunta", query = "SELECT t FROM TblPreguntas t WHERE t.pregunta = :pregunta")})
public class TblPreguntas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idPregunta")
    private Integer idPregunta;
    @Basic(optional = false)
    @Column(name = "pregunta")
    private String pregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "preguntaidPregunta")
    private Collection<TblRespuestas> tblRespuestasCollection;

    public TblPreguntas() {
    }

    public TblPreguntas(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public TblPreguntas(Integer idPregunta, String pregunta) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    @XmlTransient
    public Collection<TblRespuestas> getTblRespuestasCollection() {
        return tblRespuestasCollection;
    }

    public void setTblRespuestasCollection(Collection<TblRespuestas> tblRespuestasCollection) {
        this.tblRespuestasCollection = tblRespuestasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblPreguntas)) {
            return false;
        }
        TblPreguntas other = (TblPreguntas) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblPreguntas[ idPregunta=" + idPregunta + " ]";
    }
    
}
