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
@Table(name = "tblTelefonoEmpleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTelefonoEmpleados.findAll", query = "SELECT t FROM TblTelefonoEmpleados t")
    , @NamedQuery(name = "TblTelefonoEmpleados.findByIdTelefonoEmpleado", query = "SELECT t FROM TblTelefonoEmpleados t WHERE t.idTelefonoEmpleado = :idTelefonoEmpleado")
    , @NamedQuery(name = "TblTelefonoEmpleados.findByNumTelefonoEmpleado", query = "SELECT t FROM TblTelefonoEmpleados t WHERE t.numTelefonoEmpleado = :numTelefonoEmpleado")
    , @NamedQuery(name = "TblTelefonoEmpleados.findByTipoTelefono", query = "SELECT t FROM TblTelefonoEmpleados t WHERE t.tipoTelefono = :tipoTelefono")})
public class TblTelefonoEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefonoEmpleado")
    private Integer idTelefonoEmpleado;
    @Basic(optional = false)
    @Column(name = "numTelefonoEmpleado")
    private String numTelefonoEmpleado;
    @Basic(optional = false)
    @Column(name = "tipoTelefono")
    private String tipoTelefono;
    @JoinColumn(name = "Empleado_idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private TblEmpleado empleadoidEmpleado;

    public TblTelefonoEmpleados() {
    }

    public TblTelefonoEmpleados(Integer idTelefonoEmpleado) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
    }

    public TblTelefonoEmpleados(Integer idTelefonoEmpleado, String numTelefonoEmpleado, String tipoTelefono) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
        this.numTelefonoEmpleado = numTelefonoEmpleado;
        this.tipoTelefono = tipoTelefono;
    }

    public Integer getIdTelefonoEmpleado() {
        return idTelefonoEmpleado;
    }

    public void setIdTelefonoEmpleado(Integer idTelefonoEmpleado) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
    }

    public String getNumTelefonoEmpleado() {
        return numTelefonoEmpleado;
    }

    public void setNumTelefonoEmpleado(String numTelefonoEmpleado) {
        this.numTelefonoEmpleado = numTelefonoEmpleado;
    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
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
        hash += (idTelefonoEmpleado != null ? idTelefonoEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTelefonoEmpleados)) {
            return false;
        }
        TblTelefonoEmpleados other = (TblTelefonoEmpleados) object;
        if ((this.idTelefonoEmpleado == null && other.idTelefonoEmpleado != null) || (this.idTelefonoEmpleado != null && !this.idTelefonoEmpleado.equals(other.idTelefonoEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblTelefonoEmpleados[ idTelefonoEmpleado=" + idTelefonoEmpleado + " ]";
    }
    
}
