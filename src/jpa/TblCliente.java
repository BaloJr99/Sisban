/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author baloc
 */
@Entity
@Table(name = "tblCliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCliente.findAll", query = "SELECT t FROM TblCliente t")
    , @NamedQuery(name = "TblCliente.findByIdCliente", query = "SELECT t FROM TblCliente t WHERE t.idCliente = :idCliente")
    , @NamedQuery(name = "TblCliente.findByNombre", query = "SELECT t FROM TblCliente t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblCliente.findByApellidoPaterno", query = "SELECT t FROM TblCliente t WHERE t.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "TblCliente.findByApellidoMaterno", query = "SELECT t FROM TblCliente t WHERE t.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "TblCliente.findByIne", query = "SELECT t FROM TblCliente t WHERE t.ine = :ine")
    , @NamedQuery(name = "TblCliente.findByRfc", query = "SELECT t FROM TblCliente t WHERE t.rfc = :rfc")
    , @NamedQuery(name = "TblCliente.findByCurp", query = "SELECT t FROM TblCliente t WHERE t.curp = :curp")
    , @NamedQuery(name = "TblCliente.findByRegimenFiscal", query = "SELECT t FROM TblCliente t WHERE t.regimenFiscal = :regimenFiscal")
    , @NamedQuery(name = "TblCliente.findByFechaNacimiento", query = "SELECT t FROM TblCliente t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblCliente.findByGenero", query = "SELECT t FROM TblCliente t WHERE t.genero = :genero")
    , @NamedQuery(name = "TblCliente.findByEstatus", query = "SELECT t FROM TblCliente t WHERE t.estatus = :estatus")})
public class TblCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idCliente")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidoPaterno")
    private String apellidoPaterno;
    @Basic(optional = false)
    @Column(name = "apellidoMaterno")
    private String apellidoMaterno;
    @Basic(optional = false)
    @Column(name = "INE")
    private String ine;
    @Column(name = "rfc")
    private String rfc;
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @Column(name = "regimenFiscal")
    private String regimenFiscal;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @Column(name = "estatus")
    private String estatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private Collection<TblCuentas> tblCuentasCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblCliente")
    private TblUsuariosClientes tblUsuariosClientes;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private Collection<TblDireccionCliente> tblDireccionClienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private Collection<TblCorreoClientes> tblCorreoClientesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private Collection<TblTelefonoClientes> tblTelefonoClientesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private Collection<TblBeneficiarios> tblBeneficiariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteidCliente")
    private Collection<TblRespuestas> tblRespuestasCollection;

    public TblCliente() {
    }

    public TblCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public TblCliente(Integer idCliente, String nombre, String apellidoPaterno, String apellidoMaterno, String ine, String regimenFiscal, Date fechaNacimiento, String genero, String estatus) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.ine = ine;
        this.regimenFiscal = regimenFiscal;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.estatus = estatus;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRegimenFiscal() {
        return regimenFiscal;
    }

    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @XmlTransient
    public Collection<TblCuentas> getTblCuentasCollection() {
        return tblCuentasCollection;
    }

    public void setTblCuentasCollection(Collection<TblCuentas> tblCuentasCollection) {
        this.tblCuentasCollection = tblCuentasCollection;
    }

    public TblUsuariosClientes getTblUsuariosClientes() {
        return tblUsuariosClientes;
    }

    public void setTblUsuariosClientes(TblUsuariosClientes tblUsuariosClientes) {
        this.tblUsuariosClientes = tblUsuariosClientes;
    }

    @XmlTransient
    public Collection<TblDireccionCliente> getTblDireccionClienteCollection() {
        return tblDireccionClienteCollection;
    }

    public void setTblDireccionClienteCollection(Collection<TblDireccionCliente> tblDireccionClienteCollection) {
        this.tblDireccionClienteCollection = tblDireccionClienteCollection;
    }

    @XmlTransient
    public Collection<TblCorreoClientes> getTblCorreoClientesCollection() {
        return tblCorreoClientesCollection;
    }

    public void setTblCorreoClientesCollection(Collection<TblCorreoClientes> tblCorreoClientesCollection) {
        this.tblCorreoClientesCollection = tblCorreoClientesCollection;
    }

    @XmlTransient
    public Collection<TblTelefonoClientes> getTblTelefonoClientesCollection() {
        return tblTelefonoClientesCollection;
    }

    public void setTblTelefonoClientesCollection(Collection<TblTelefonoClientes> tblTelefonoClientesCollection) {
        this.tblTelefonoClientesCollection = tblTelefonoClientesCollection;
    }

    @XmlTransient
    public Collection<TblBeneficiarios> getTblBeneficiariosCollection() {
        return tblBeneficiariosCollection;
    }

    public void setTblBeneficiariosCollection(Collection<TblBeneficiarios> tblBeneficiariosCollection) {
        this.tblBeneficiariosCollection = tblBeneficiariosCollection;
    }

    @XmlTransient
    public Collection<TblRespuestas> getTblRespuestasCollection() {
        return tblRespuestasCollection;
    }

    public void setTblRespuestasCollection(Collection<TblRespuestas> tblRespuestasCollection) {
        this.tblRespuestasCollection = tblRespuestasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCliente)) {
            return false;
        }
        TblCliente other = (TblCliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblCliente[ idCliente=" + idCliente + " ]";
    }
    
}
