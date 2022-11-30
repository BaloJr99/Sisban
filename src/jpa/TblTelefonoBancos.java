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
@Table(name = "tblTelefonoBancos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTelefonoBancos.findAll", query = "SELECT t FROM TblTelefonoBancos t")
    , @NamedQuery(name = "TblTelefonoBancos.findByIdTelefonoBanco", query = "SELECT t FROM TblTelefonoBancos t WHERE t.idTelefonoBanco = :idTelefonoBanco")
    , @NamedQuery(name = "TblTelefonoBancos.findByNumTelefono", query = "SELECT t FROM TblTelefonoBancos t WHERE t.numTelefono = :numTelefono")
    , @NamedQuery(name = "TblTelefonoBancos.findByAreaTelefono", query = "SELECT t FROM TblTelefonoBancos t WHERE t.areaTelefono = :areaTelefono")})
public class TblTelefonoBancos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idTelefonoBanco")
    private Integer idTelefonoBanco;
    @Column(name = "numTelefono")
    private String numTelefono;
    @Basic(optional = false)
    @Column(name = "areaTelefono")
    private String areaTelefono;
    @JoinColumn(name = "bancos_sucursal", referencedColumnName = "sucursal")
    @ManyToOne(optional = false)
    private TblBancos bancosSucursal;

    public TblTelefonoBancos() {
    }

    public TblTelefonoBancos(Integer idTelefonoBanco) {
        this.idTelefonoBanco = idTelefonoBanco;
    }

    public TblTelefonoBancos(Integer idTelefonoBanco, String areaTelefono) {
        this.idTelefonoBanco = idTelefonoBanco;
        this.areaTelefono = areaTelefono;
    }

    public Integer getIdTelefonoBanco() {
        return idTelefonoBanco;
    }

    public void setIdTelefonoBanco(Integer idTelefonoBanco) {
        this.idTelefonoBanco = idTelefonoBanco;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getAreaTelefono() {
        return areaTelefono;
    }

    public void setAreaTelefono(String areaTelefono) {
        this.areaTelefono = areaTelefono;
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
        hash += (idTelefonoBanco != null ? idTelefonoBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTelefonoBancos)) {
            return false;
        }
        TblTelefonoBancos other = (TblTelefonoBancos) object;
        if ((this.idTelefonoBanco == null && other.idTelefonoBanco != null) || (this.idTelefonoBanco != null && !this.idTelefonoBanco.equals(other.idTelefonoBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblTelefonoBancos[ idTelefonoBanco=" + idTelefonoBanco + " ]";
    }
    
}
