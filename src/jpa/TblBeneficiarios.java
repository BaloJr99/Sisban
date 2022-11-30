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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "tblBeneficiarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblBeneficiarios.findAll", query = "SELECT t FROM TblBeneficiarios t")
    , @NamedQuery(name = "TblBeneficiarios.findByIdBeneficiario", query = "SELECT t FROM TblBeneficiarios t WHERE t.idBeneficiario = :idBeneficiario")
    , @NamedQuery(name = "TblBeneficiarios.findByParentesco", query = "SELECT t FROM TblBeneficiarios t WHERE t.parentesco = :parentesco")
    , @NamedQuery(name = "TblBeneficiarios.findByNombre", query = "SELECT t FROM TblBeneficiarios t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblBeneficiarios.findByApellidoPaterno", query = "SELECT t FROM TblBeneficiarios t WHERE t.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "TblBeneficiarios.findByApellidoMaterno", query = "SELECT t FROM TblBeneficiarios t WHERE t.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "TblBeneficiarios.findByFechaNacimiento", query = "SELECT t FROM TblBeneficiarios t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblBeneficiarios.findByGenero", query = "SELECT t FROM TblBeneficiarios t WHERE t.genero = :genero")
    , @NamedQuery(name = "TblBeneficiarios.findByIne", query = "SELECT t FROM TblBeneficiarios t WHERE t.ine = :ine")})
public class TblBeneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idBeneficiario")
    private Integer idBeneficiario;
    @Basic(optional = false)
    @Column(name = "parentesco")
    private String parentesco;
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
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "genero")
    private Character genero;
    @Basic(optional = false)
    @Column(name = "ine")
    private String ine;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiariosidBeneficiario")
    private Collection<TblDireccionBeneficiarios> tblDireccionBeneficiariosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiariosidBeneficiario")
    private Collection<TblTelefonoBeneficiario> tblTelefonoBeneficiarioCollection;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private TblCliente clienteidCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "beneficiariosidBeneficiario")
    private Collection<TblCorreoBeneficiarios> tblCorreoBeneficiariosCollection;

    public TblBeneficiarios() {
    }

    public TblBeneficiarios(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public TblBeneficiarios(Integer idBeneficiario, String parentesco, String nombre, String apellidoPaterno, String apellidoMaterno, Date fechaNacimiento, Character genero, String ine) {
        this.idBeneficiario = idBeneficiario;
        this.parentesco = parentesco;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.ine = ine;
    }

    public Integer getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(Integer idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    @XmlTransient
    public Collection<TblDireccionBeneficiarios> getTblDireccionBeneficiariosCollection() {
        return tblDireccionBeneficiariosCollection;
    }

    public void setTblDireccionBeneficiariosCollection(Collection<TblDireccionBeneficiarios> tblDireccionBeneficiariosCollection) {
        this.tblDireccionBeneficiariosCollection = tblDireccionBeneficiariosCollection;
    }

    @XmlTransient
    public Collection<TblTelefonoBeneficiario> getTblTelefonoBeneficiarioCollection() {
        return tblTelefonoBeneficiarioCollection;
    }

    public void setTblTelefonoBeneficiarioCollection(Collection<TblTelefonoBeneficiario> tblTelefonoBeneficiarioCollection) {
        this.tblTelefonoBeneficiarioCollection = tblTelefonoBeneficiarioCollection;
    }

    public TblCliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(TblCliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @XmlTransient
    public Collection<TblCorreoBeneficiarios> getTblCorreoBeneficiariosCollection() {
        return tblCorreoBeneficiariosCollection;
    }

    public void setTblCorreoBeneficiariosCollection(Collection<TblCorreoBeneficiarios> tblCorreoBeneficiariosCollection) {
        this.tblCorreoBeneficiariosCollection = tblCorreoBeneficiariosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBeneficiario != null ? idBeneficiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBeneficiarios)) {
            return false;
        }
        TblBeneficiarios other = (TblBeneficiarios) object;
        if ((this.idBeneficiario == null && other.idBeneficiario != null) || (this.idBeneficiario != null && !this.idBeneficiario.equals(other.idBeneficiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblBeneficiarios[ idBeneficiario=" + idBeneficiario + " ]";
    }
    
}
