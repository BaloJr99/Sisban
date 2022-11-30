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
@Table(name = "tblDireccionEmpleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDireccionEmpleados.findAll", query = "SELECT t FROM TblDireccionEmpleados t")
    , @NamedQuery(name = "TblDireccionEmpleados.findByIdDireccionEmpleado", query = "SELECT t FROM TblDireccionEmpleados t WHERE t.idDireccionEmpleado = :idDireccionEmpleado")
    , @NamedQuery(name = "TblDireccionEmpleados.findByCalle", query = "SELECT t FROM TblDireccionEmpleados t WHERE t.calle = :calle")
    , @NamedQuery(name = "TblDireccionEmpleados.findByNumInt", query = "SELECT t FROM TblDireccionEmpleados t WHERE t.numInt = :numInt")
    , @NamedQuery(name = "TblDireccionEmpleados.findByNumExt", query = "SELECT t FROM TblDireccionEmpleados t WHERE t.numExt = :numExt")
    , @NamedQuery(name = "TblDireccionEmpleados.findByColonia", query = "SELECT t FROM TblDireccionEmpleados t WHERE t.colonia = :colonia")
    , @NamedQuery(name = "TblDireccionEmpleados.findByCodigoPostal", query = "SELECT t FROM TblDireccionEmpleados t WHERE t.codigoPostal = :codigoPostal")})
public class TblDireccionEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccionEmpleado")
    private Integer idDireccionEmpleado;
    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numInt")
    private String numInt;
    @Basic(optional = false)
    @Column(name = "numExt")
    private String numExt;
    @Basic(optional = false)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @JoinColumn(name = "Empleado_idEmpleado", referencedColumnName = "idEmpleado")
    @ManyToOne(optional = false)
    private TblEmpleado empleadoidEmpleado;

    public TblDireccionEmpleados() {
    }

    public TblDireccionEmpleados(Integer idDireccionEmpleado) {
        this.idDireccionEmpleado = idDireccionEmpleado;
    }

    public TblDireccionEmpleados(Integer idDireccionEmpleado, String calle, String numExt, String colonia, String codigoPostal) {
        this.idDireccionEmpleado = idDireccionEmpleado;
        this.calle = calle;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionEmpleado() {
        return idDireccionEmpleado;
    }

    public void setIdDireccionEmpleado(Integer idDireccionEmpleado) {
        this.idDireccionEmpleado = idDireccionEmpleado;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumInt() {
        return numInt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
        hash += (idDireccionEmpleado != null ? idDireccionEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDireccionEmpleados)) {
            return false;
        }
        TblDireccionEmpleados other = (TblDireccionEmpleados) object;
        if ((this.idDireccionEmpleado == null && other.idDireccionEmpleado != null) || (this.idDireccionEmpleado != null && !this.idDireccionEmpleado.equals(other.idDireccionEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblDireccionEmpleados[ idDireccionEmpleado=" + idDireccionEmpleado + " ]";
    }
    
}
