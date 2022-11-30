/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author baloc
 */
@Entity
@Table(name = "tblSaldos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblSaldos.findAll", query = "SELECT t FROM TblSaldos t")
    , @NamedQuery(name = "TblSaldos.findByIdSaldos", query = "SELECT t FROM TblSaldos t WHERE t.idSaldos = :idSaldos")
    , @NamedQuery(name = "TblSaldos.findBySaldo", query = "SELECT t FROM TblSaldos t WHERE t.saldo = :saldo")
    , @NamedQuery(name = "TblSaldos.findByNumCuenta", query = "SELECT t FROM TblSaldos t WHERE t.numCuenta = :numCuenta")
    , @NamedQuery(name = "TblSaldos.findByBancoSucursal", query = "SELECT t FROM TblSaldos t WHERE t.bancoSucursal = :bancoSucursal")
    , @NamedQuery(name = "TblSaldos.findByFecha", query = "SELECT t FROM TblSaldos t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "TblSaldos.findByHora", query = "SELECT t FROM TblSaldos t WHERE t.hora = :hora")})
public class TblSaldos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idSaldos")
    private Integer idSaldos;
    @Basic(optional = false)
    @Column(name = "saldo")
    private double saldo;
    @Basic(optional = false)
    @Column(name = "numCuenta")
    private String numCuenta;
    @Basic(optional = false)
    @Column(name = "banco_sucursal")
    private String bancoSucursal;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "claveRastreo", referencedColumnName = "claveRastreo")
    @ManyToOne
    private TblTransacciones claveRastreo;

    public TblSaldos() {
    }

    public TblSaldos(Integer idSaldos) {
        this.idSaldos = idSaldos;
    }

    public TblSaldos(Integer idSaldos, double saldo, String numCuenta, String bancoSucursal, Date fecha, Date hora) {
        this.idSaldos = idSaldos;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.bancoSucursal = bancoSucursal;
        this.fecha = fecha;
        this.hora = hora;
    }

    public Integer getIdSaldos() {
        return idSaldos;
    }

    public void setIdSaldos(Integer idSaldos) {
        this.idSaldos = idSaldos;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getBancoSucursal() {
        return bancoSucursal;
    }

    public void setBancoSucursal(String bancoSucursal) {
        this.bancoSucursal = bancoSucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public TblTransacciones getClaveRastreo() {
        return claveRastreo;
    }

    public void setClaveRastreo(TblTransacciones claveRastreo) {
        this.claveRastreo = claveRastreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSaldos != null ? idSaldos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSaldos)) {
            return false;
        }
        TblSaldos other = (TblSaldos) object;
        if ((this.idSaldos == null && other.idSaldos != null) || (this.idSaldos != null && !this.idSaldos.equals(other.idSaldos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblSaldos[ idSaldos=" + idSaldos + " ]";
    }
    
}
