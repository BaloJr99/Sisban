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
@Table(name = "tblUsuariosClientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblUsuariosClientes.findAll", query = "SELECT t FROM TblUsuariosClientes t")
    , @NamedQuery(name = "TblUsuariosClientes.findByTblClienteidCliente", query = "SELECT t FROM TblUsuariosClientes t WHERE t.tblClienteidCliente = :tblClienteidCliente")
    , @NamedQuery(name = "TblUsuariosClientes.findByUsuario", query = "SELECT t FROM TblUsuariosClientes t WHERE t.usuario = :usuario")
    , @NamedQuery(name = "TblUsuariosClientes.findByContrasena", query = "SELECT t FROM TblUsuariosClientes t WHERE t.contrasena = :contrasena")})
public class TblUsuariosClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tblCliente_idCliente")
    private Integer tblClienteidCliente;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrasena")
    private String contrasena;
    @JoinColumn(name = "tblCliente_idCliente", referencedColumnName = "idCliente", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private TblCliente tblCliente;

    public TblUsuariosClientes() {
    }

    public TblUsuariosClientes(Integer tblClienteidCliente) {
        this.tblClienteidCliente = tblClienteidCliente;
    }

    public TblUsuariosClientes(Integer tblClienteidCliente, String usuario, String contrasena) {
        this.tblClienteidCliente = tblClienteidCliente;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public Integer getTblClienteidCliente() {
        return tblClienteidCliente;
    }

    public void setTblClienteidCliente(Integer tblClienteidCliente) {
        this.tblClienteidCliente = tblClienteidCliente;
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

    public TblCliente getTblCliente() {
        return tblCliente;
    }

    public void setTblCliente(TblCliente tblCliente) {
        this.tblCliente = tblCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblClienteidCliente != null ? tblClienteidCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuariosClientes)) {
            return false;
        }
        TblUsuariosClientes other = (TblUsuariosClientes) object;
        if ((this.tblClienteidCliente == null && other.tblClienteidCliente != null) || (this.tblClienteidCliente != null && !this.tblClienteidCliente.equals(other.tblClienteidCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblUsuariosClientes[ tblClienteidCliente=" + tblClienteidCliente + " ]";
    }
    
}
