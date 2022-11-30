/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author baloc
 */
@Entity
@Table(name = "tblRespuestas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRespuestas.findAll", query = "SELECT t FROM TblRespuestas t")
    , @NamedQuery(name = "TblRespuestas.findByIdRespuestas", query = "SELECT t FROM TblRespuestas t WHERE t.idRespuestas = :idRespuestas")
    , @NamedQuery(name = "TblRespuestas.findByRespuesta", query = "SELECT t FROM TblRespuestas t WHERE t.respuesta = :respuesta")})
public class TblRespuestas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idRespuestas")
    private Integer idRespuestas;
    @Basic(optional = false)
    @Column(name = "respuesta")
    private String respuesta;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private TblCliente clienteidCliente;
    @JoinColumn(name = "pregunta_idPregunta", referencedColumnName = "idPregunta")
    @ManyToOne(optional = false)
    private TblPreguntas preguntaidPregunta;

    public TblRespuestas() {
    }

    public TblRespuestas(Integer idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    public TblRespuestas(Integer idRespuestas, String respuesta) {
        this.idRespuestas = idRespuestas;
        this.respuesta = respuesta;
    }

    public Integer getIdRespuestas() {
        return idRespuestas;
    }

    public void setIdRespuestas(Integer idRespuestas) {
        this.idRespuestas = idRespuestas;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public TblCliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(TblCliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    public TblPreguntas getPreguntaidPregunta() {
        return preguntaidPregunta;
    }

    public void setPreguntaidPregunta(TblPreguntas preguntaidPregunta) {
        this.preguntaidPregunta = preguntaidPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuestas != null ? idRespuestas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRespuestas)) {
            return false;
        }
        TblRespuestas other = (TblRespuestas) object;
        if ((this.idRespuestas == null && other.idRespuestas != null) || (this.idRespuestas != null && !this.idRespuestas.equals(other.idRespuestas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblRespuestas[ idRespuestas=" + idRespuestas + " ]";
    }
    
}
