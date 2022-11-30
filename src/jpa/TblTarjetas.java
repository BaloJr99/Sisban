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
@Table(name = "tblTarjetas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTarjetas.findAll", query = "SELECT t FROM TblTarjetas t")
    , @NamedQuery(name = "TblTarjetas.findByNumTarjeta", query = "SELECT t FROM TblTarjetas t WHERE t.numTarjeta = :numTarjeta")
    , @NamedQuery(name = "TblTarjetas.findByEstadoTarjeta", query = "SELECT t FROM TblTarjetas t WHERE t.estadoTarjeta = :estadoTarjeta")})
public class TblTarjetas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numTarjeta")
    private String numTarjeta;
    @Column(name = "estadoTarjeta")
    private String estadoTarjeta;
    @JoinColumn(name = "cuentas_numCuenta", referencedColumnName = "numeroCuenta")
    @ManyToOne(optional = false)
    private TblCuentas cuentasnumCuenta;

    public TblTarjetas() {
    }

    public TblTarjetas(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getEstadoTarjeta() {
        return estadoTarjeta;
    }

    public void setEstadoTarjeta(String estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }

    public TblCuentas getCuentasnumCuenta() {
        return cuentasnumCuenta;
    }

    public void setCuentasnumCuenta(TblCuentas cuentasnumCuenta) {
        this.cuentasnumCuenta = cuentasnumCuenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTarjeta != null ? numTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTarjetas)) {
            return false;
        }
        TblTarjetas other = (TblTarjetas) object;
        if ((this.numTarjeta == null && other.numTarjeta != null) || (this.numTarjeta != null && !this.numTarjeta.equals(other.numTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblTarjetas[ numTarjeta=" + numTarjeta + " ]";
    }
    
}
