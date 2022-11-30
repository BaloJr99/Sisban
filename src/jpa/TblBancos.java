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
@Table(name = "tblBancos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBancos.findAll", query = "SELECT t FROM TblBancos t")
    , @NamedQuery(name = "TblBancos.findBySucursal", query = "SELECT t FROM TblBancos t WHERE t.sucursal = :sucursal")
    , @NamedQuery(name = "TblBancos.findByNombreSucursal", query = "SELECT t FROM TblBancos t WHERE t.nombreSucursal = :nombreSucursal")
    , @NamedQuery(name = "TblBancos.findByPlaza", query = "SELECT t FROM TblBancos t WHERE t.plaza = :plaza")
    , @NamedQuery(name = "TblBancos.findByRfc", query = "SELECT t FROM TblBancos t WHERE t.rfc = :rfc")})
public class TblBancos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "sucursal")
    private String sucursal;
    @Basic(optional = false)
    @Column(name = "nombreSucursal")
    private String nombreSucursal;
    @Basic(optional = false)
    @Column(name = "plaza")
    private String plaza;
    @Basic(optional = false)
    @Column(name = "rfc")
    private String rfc;
    @OneToMany(mappedBy = "bancoSucursal")
    private Collection<TblCuentas> tblCuentasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bancosSucursal")
    private Collection<TblDireccionBancos> tblDireccionBancosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bancosSucursal")
    private Collection<TblTelefonoBancos> tblTelefonoBancosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bancosSucursal")
    private Collection<TblEmpleado> tblEmpleadoCollection;

    public TblBancos() {
    }

    public TblBancos(String sucursal) {
        this.sucursal = sucursal;
    }

    public TblBancos(String sucursal, String nombreSucursal, String plaza, String rfc) {
        this.sucursal = sucursal;
        this.nombreSucursal = nombreSucursal;
        this.plaza = plaza;
        this.rfc = rfc;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPlaza() {
        return plaza;
    }

    public void setPlaza(String plaza) {
        this.plaza = plaza;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    @XmlTransient
    public Collection<TblCuentas> getTblCuentasCollection() {
        return tblCuentasCollection;
    }

    public void setTblCuentasCollection(Collection<TblCuentas> tblCuentasCollection) {
        this.tblCuentasCollection = tblCuentasCollection;
    }

    @XmlTransient
    public Collection<TblDireccionBancos> getTblDireccionBancosCollection() {
        return tblDireccionBancosCollection;
    }

    public void setTblDireccionBancosCollection(Collection<TblDireccionBancos> tblDireccionBancosCollection) {
        this.tblDireccionBancosCollection = tblDireccionBancosCollection;
    }

    @XmlTransient
    public Collection<TblTelefonoBancos> getTblTelefonoBancosCollection() {
        return tblTelefonoBancosCollection;
    }

    public void setTblTelefonoBancosCollection(Collection<TblTelefonoBancos> tblTelefonoBancosCollection) {
        this.tblTelefonoBancosCollection = tblTelefonoBancosCollection;
    }

    @XmlTransient
    public Collection<TblEmpleado> getTblEmpleadoCollection() {
        return tblEmpleadoCollection;
    }

    public void setTblEmpleadoCollection(Collection<TblEmpleado> tblEmpleadoCollection) {
        this.tblEmpleadoCollection = tblEmpleadoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sucursal != null ? sucursal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBancos)) {
            return false;
        }
        TblBancos other = (TblBancos) object;
        if ((this.sucursal == null && other.sucursal != null) || (this.sucursal != null && !this.sucursal.equals(other.sucursal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblBancos[ sucursal=" + sucursal + " ]";
    }
    
}
