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
@Table(name = "tblEmpleado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblEmpleado.findAll", query = "SELECT t FROM TblEmpleado t")
    , @NamedQuery(name = "TblEmpleado.findByIdEmpleado", query = "SELECT t FROM TblEmpleado t WHERE t.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "TblEmpleado.findByNombre", query = "SELECT t FROM TblEmpleado t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TblEmpleado.findByApellidoPaterno", query = "SELECT t FROM TblEmpleado t WHERE t.apellidoPaterno = :apellidoPaterno")
    , @NamedQuery(name = "TblEmpleado.findByApellidoMaterno", query = "SELECT t FROM TblEmpleado t WHERE t.apellidoMaterno = :apellidoMaterno")
    , @NamedQuery(name = "TblEmpleado.findByPuesto", query = "SELECT t FROM TblEmpleado t WHERE t.puesto = :puesto")
    , @NamedQuery(name = "TblEmpleado.findByNss", query = "SELECT t FROM TblEmpleado t WHERE t.nss = :nss")
    , @NamedQuery(name = "TblEmpleado.findByRfc", query = "SELECT t FROM TblEmpleado t WHERE t.rfc = :rfc")
    , @NamedQuery(name = "TblEmpleado.findByCurp", query = "SELECT t FROM TblEmpleado t WHERE t.curp = :curp")
    , @NamedQuery(name = "TblEmpleado.findByFechaIngreso", query = "SELECT t FROM TblEmpleado t WHERE t.fechaIngreso = :fechaIngreso")
    , @NamedQuery(name = "TblEmpleado.findByFechaNacimiento", query = "SELECT t FROM TblEmpleado t WHERE t.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "TblEmpleado.findByGenero", query = "SELECT t FROM TblEmpleado t WHERE t.genero = :genero")
    , @NamedQuery(name = "TblEmpleado.findByFechaTerminacion", query = "SELECT t FROM TblEmpleado t WHERE t.fechaTerminacion = :fechaTerminacion")})
public class TblEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idEmpleado")
    private Integer idEmpleado;
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
    @Column(name = "puesto")
    private String puesto;
    @Basic(optional = false)
    @Column(name = "nss")
    private String nss;
    @Basic(optional = false)
    @Column(name = "rfc")
    private String rfc;
    @Basic(optional = false)
    @Column(name = "curp")
    private String curp;
    @Basic(optional = false)
    @Column(name = "fechaIngreso")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "fechaNacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @Column(name = "genero")
    private String genero;
    @Column(name = "fechaTerminacion")
    @Temporal(TemporalType.DATE)
    private Date fechaTerminacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoidEmpleado")
    private Collection<TblDireccionEmpleados> tblDireccionEmpleadosCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "tblEmpleado")
    private TblUsuariosEmpleados tblUsuariosEmpleados;
    @OneToMany(mappedBy = "empleadoidEmpleado")
    private Collection<TblCorreoEmpleado> tblCorreoEmpleadoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleadoidEmpleado")
    private Collection<TblTelefonoEmpleados> tblTelefonoEmpleadosCollection;
    @JoinColumn(name = "bancos_sucursal", referencedColumnName = "sucursal")
    @ManyToOne(optional = false)
    private TblBancos bancosSucursal;

    public TblEmpleado() {
    }

    public TblEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public TblEmpleado(Integer idEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno, String puesto, String nss, String rfc, String curp, Date fechaIngreso, Date fechaNacimiento, String genero) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.puesto = puesto;
        this.nss = nss;
        this.rfc = rfc;
        this.curp = curp;
        this.fechaIngreso = fechaIngreso;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
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

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
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

    public Date getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(Date fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    @XmlTransient
    public Collection<TblDireccionEmpleados> getTblDireccionEmpleadosCollection() {
        return tblDireccionEmpleadosCollection;
    }

    public void setTblDireccionEmpleadosCollection(Collection<TblDireccionEmpleados> tblDireccionEmpleadosCollection) {
        this.tblDireccionEmpleadosCollection = tblDireccionEmpleadosCollection;
    }

    public TblUsuariosEmpleados getTblUsuariosEmpleados() {
        return tblUsuariosEmpleados;
    }

    public void setTblUsuariosEmpleados(TblUsuariosEmpleados tblUsuariosEmpleados) {
        this.tblUsuariosEmpleados = tblUsuariosEmpleados;
    }

    @XmlTransient
    public Collection<TblCorreoEmpleado> getTblCorreoEmpleadoCollection() {
        return tblCorreoEmpleadoCollection;
    }

    public void setTblCorreoEmpleadoCollection(Collection<TblCorreoEmpleado> tblCorreoEmpleadoCollection) {
        this.tblCorreoEmpleadoCollection = tblCorreoEmpleadoCollection;
    }

    @XmlTransient
    public Collection<TblTelefonoEmpleados> getTblTelefonoEmpleadosCollection() {
        return tblTelefonoEmpleadosCollection;
    }

    public void setTblTelefonoEmpleadosCollection(Collection<TblTelefonoEmpleados> tblTelefonoEmpleadosCollection) {
        this.tblTelefonoEmpleadosCollection = tblTelefonoEmpleadosCollection;
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
        hash += (idEmpleado != null ? idEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleado)) {
            return false;
        }
        TblEmpleado other = (TblEmpleado) object;
        if ((this.idEmpleado == null && other.idEmpleado != null) || (this.idEmpleado != null && !this.idEmpleado.equals(other.idEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblEmpleado[ idEmpleado=" + idEmpleado + " ]";
    }
    
}
