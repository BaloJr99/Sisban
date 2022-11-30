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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tblCuentas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCuentas.findAll", query = "SELECT t FROM TblCuentas t")
    , @NamedQuery(name = "TblCuentas.findByNumeroCuenta", query = "SELECT t FROM TblCuentas t WHERE t.numeroCuenta = :numeroCuenta")
    , @NamedQuery(name = "TblCuentas.findByTipoCuenta", query = "SELECT t FROM TblCuentas t WHERE t.tipoCuenta = :tipoCuenta")
    , @NamedQuery(name = "TblCuentas.findBySaldo", query = "SELECT t FROM TblCuentas t WHERE t.saldo = :saldo")
    , @NamedQuery(name = "TblCuentas.findByClabe", query = "SELECT t FROM TblCuentas t WHERE t.clabe = :clabe")
    , @NamedQuery(name = "TblCuentas.findByEstado", query = "SELECT t FROM TblCuentas t WHERE t.estado = :estado")})
public class TblCuentas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "numeroCuenta")
    private String numeroCuenta;
    @Basic(optional = false)
    @Column(name = "tipoCuenta")
    private String tipoCuenta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @Basic(optional = false)
    @Column(name = "clabe")
    private String clabe;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @OneToMany(mappedBy = "cuentasnumeroCuenta")
    private Collection<TblTransacciones> tblTransaccionesCollection;
    @JoinColumn(name = "banco_sucursal", referencedColumnName = "sucursal")
    @ManyToOne
    private TblBancos bancoSucursal;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private TblCliente clienteidCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuentasnumCuenta")
    private Collection<TblTarjetas> tblTarjetasCollection;

    public TblCuentas() {
    }

    public TblCuentas(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public TblCuentas(String numeroCuenta, String tipoCuenta, String clabe, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.clabe = clabe;
        this.estado = estado;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<TblTransacciones> getTblTransaccionesCollection() {
        return tblTransaccionesCollection;
    }

    public void setTblTransaccionesCollection(Collection<TblTransacciones> tblTransaccionesCollection) {
        this.tblTransaccionesCollection = tblTransaccionesCollection;
    }

    public TblBancos getBancoSucursal() {
        return bancoSucursal;
    }

    public void setBancoSucursal(TblBancos bancoSucursal) {
        this.bancoSucursal = bancoSucursal;
    }

    public TblCliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(TblCliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @XmlTransient
    public Collection<TblTarjetas> getTblTarjetasCollection() {
        return tblTarjetasCollection;
    }

    public void setTblTarjetasCollection(Collection<TblTarjetas> tblTarjetasCollection) {
        this.tblTarjetasCollection = tblTarjetasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numeroCuenta != null ? numeroCuenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCuentas)) {
            return false;
        }
        TblCuentas other = (TblCuentas) object;
        if ((this.numeroCuenta == null && other.numeroCuenta != null) || (this.numeroCuenta != null && !this.numeroCuenta.equals(other.numeroCuenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblCuentas[ numeroCuenta=" + numeroCuenta + " ]";
    }
    
}
