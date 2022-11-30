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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author baloc
 */
@Entity
@Table(name = "tblUsuariosEmpleados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuariosEmpleados.findAll", query = "SELECT t FROM TblUsuariosEmpleados t")
    , @NamedQuery(name = "TblUsuariosEmpleados.findByTblEmpleadoidEmpleado", query = "SELECT t FROM TblUsuariosEmpleados t WHERE t.tblEmpleadoidEmpleado = :tblEmpleadoidEmpleado")
    , @NamedQuery(name = "TblUsuariosEmpleados.findByUsuario", query = "SELECT t FROM TblUsuariosEmpleados t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "TblUsuariosEmpleados.findByContrasena", query = "SELECT t FROM TblUsuariosEmpleados t WHERE t.contrasena = :contrasena")})
public class TblUsuariosEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tblEmpleado_idEmpleado")
    private Integer tblEmpleadoidEmpleado;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "tblEmpleado_idEmpleado", referencedColumnName = "idEmpleado", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblEmpleado tblEmpleado;

    public TblUsuariosEmpleados() {
    }

    public TblUsuariosEmpleados(Integer tblEmpleadoidEmpleado) {
        this.tblEmpleadoidEmpleado = tblEmpleadoidEmpleado;
    }

    public TblUsuariosEmpleados(Integer tblEmpleadoidEmpleado, String usuario, String contrasena) {
        this.tblEmpleadoidEmpleado = tblEmpleadoidEmpleado;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Integer getTblEmpleadoidEmpleado() {
        return tblEmpleadoidEmpleado;
    }

    public void setTblEmpleadoidEmpleado(Integer tblEmpleadoidEmpleado) {
        this.tblEmpleadoidEmpleado = tblEmpleadoidEmpleado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public TblEmpleado getTblEmpleado() {
        return tblEmpleado;
    }

    public void setTblEmpleado(TblEmpleado tblEmpleado) {
        this.tblEmpleado = tblEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblEmpleadoidEmpleado != null ? tblEmpleadoidEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuariosEmpleados)) {
            return false;
        }
        TblUsuariosEmpleados other = (TblUsuariosEmpleados) object;
        if ((this.tblEmpleadoidEmpleado == null && other.tblEmpleadoidEmpleado != null) || (this.tblEmpleadoidEmpleado != null && !this.tblEmpleadoidEmpleado.equals(other.tblEmpleadoidEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblUsuariosEmpleados[ tblEmpleadoidEmpleado=" + tblEmpleadoidEmpleado + " ]";
    }
    
}
