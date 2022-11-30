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
@Table(name = "tblCorreoEmpleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCorreoEmpleado.findAll", query = "SELECT t FROM TblCorreoEmpleado t")
    , @NamedQuery(name = "TblCorreoEmpleado.findByIdCorreoEmpleado", query = "SELECT t FROM TblCorreoEmpleado t WHERE t.idCorreoEmpleado = :idCorreoEmpleado")
    , @NamedQuery(name = "TblCorreoEmpleado.findByCorreoEmpleado", query = "SELECT t FROM TblCorreoEmpleado t WHERE t.correoEmpleado = :correoEmpleado")})
public class TblCorreoEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCorreoEmpleado")
    private Integer idCorreoEmpleado;
    @Column(name = "correoEmpleado")
    private String correoEmpleado;
    @JoinColumn(name = "Empleado_idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne
    private TblEmpleado empleadoidEmpleado;

    public TblCorreoEmpleado() {
    }

    public TblCorreoEmpleado(Integer idCorreoEmpleado) {
        this.idCorreoEmpleado = idCorreoEmpleado;
    }

    public Integer getIdCorreoEmpleado() {
        return idCorreoEmpleado;
    }

    public void setIdCorreoEmpleado(Integer idCorreoEmpleado) {
        this.idCorreoEmpleado = idCorreoEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }

    public TblEmpleado getEmpleadoidEmpleado() {
        return empleadoidEmpleado;
    }

    public void setEmpleadoidEmpleado(TblEmpleado empleadoidEmpleado) {
        this.empleadoidEmpleado = empleadoidEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreoEmpleado != null ? idCorreoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCorreoEmpleado)) {
            return false;
        }
        TblCorreoEmpleado other = (TblCorreoEmpleado) object;
        if ((this.idCorreoEmpleado == null && other.idCorreoEmpleado != null) || (this.idCorreoEmpleado != null && !this.idCorreoEmpleado.equals(other.idCorreoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblCorreoEmpleado[ idCorreoEmpleado=" + idCorreoEmpleado + " ]";
    }
    
}
