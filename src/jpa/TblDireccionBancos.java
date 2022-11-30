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
@Table(name = "tblDireccionBancos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDireccionBancos.findAll", query = "SELECT t FROM TblDireccionBancos t")
    , @NamedQuery(name = "TblDireccionBancos.findByIdDireccionBancos", query = "SELECT t FROM TblDireccionBancos t WHERE t.idDireccionBancos = :idDireccionBancos")
    , @NamedQuery(name = "TblDireccionBancos.findByCalle", query = "SELECT t FROM TblDireccionBancos t WHERE t.calle = :calle")
    , @NamedQuery(name = "TblDireccionBancos.findByNumInt", query = "SELECT t FROM TblDireccionBancos t WHERE t.numInt = :numInt")
    , @NamedQuery(name = "TblDireccionBancos.findByNumExt", query = "SELECT t FROM TblDireccionBancos t WHERE t.numExt = :numExt")
    , @NamedQuery(name = "TblDireccionBancos.findByColonia", query = "SELECT t FROM TblDireccionBancos t WHERE t.colonia = :colonia")
    , @NamedQuery(name = "TblDireccionBancos.findByCodigoPostal", query = "SELECT t FROM TblDireccionBancos t WHERE t.codigoPostal = :codigoPostal")})
public class TblDireccionBancos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDireccionBancos")
    private Integer idDireccionBancos;
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
    @JoinColumn(name = "bancos_sucursal", referencedColumnName = "sucursal")
    @ManyToOne(optional = false)
    private TblBancos bancosSucursal;

    public TblDireccionBancos() {
    }

    public TblDireccionBancos(Integer idDireccionBancos) {
        this.idDireccionBancos = idDireccionBancos;
    }

    public TblDireccionBancos(Integer idDireccionBancos, String calle, String numExt, String colonia, String codigoPostal) {
        this.idDireccionBancos = idDireccionBancos;
        this.calle = calle;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionBancos() {
        return idDireccionBancos;
    }

    public void setIdDireccionBancos(Integer idDireccionBancos) {
        this.idDireccionBancos = idDireccionBancos;
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

    public TblBancos getBancosSucursal() {
        return bancosSucursal;
    }

    public void setBancosSucursal(TblBancos bancosSucursal) {
        this.bancosSucursal = bancosSucursal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionBancos != null ? idDireccionBancos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDireccionBancos)) {
            return false;
        }
        TblDireccionBancos other = (TblDireccionBancos) object;
        if ((this.idDireccionBancos == null && other.idDireccionBancos != null) || (this.idDireccionBancos != null && !this.idDireccionBancos.equals(other.idDireccionBancos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblDireccionBancos[ idDireccionBancos=" + idDireccionBancos + " ]";
    }
    
}
