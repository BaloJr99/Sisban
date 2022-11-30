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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "tblCorreoClientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCorreoClientes.findAll", query = "SELECT t FROM TblCorreoClientes t")
    , @NamedQuery(name = "TblCorreoClientes.findByIdCorreo", query = "SELECT t FROM TblCorreoClientes t WHERE t.idCorreo = :idCorreo")
    , @NamedQuery(name = "TblCorreoClientes.findByCorreoCliente", query = "SELECT t FROM TblCorreoClientes t WHERE t.correoCliente = :correoCliente")})
public class TblCorreoClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCorreo")
    private Integer idCorreo;
    @Basic(optional = false)
    @Column(name = "correoCliente")
    private String correoCliente;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private TblCliente clienteidCliente;

    public TblCorreoClientes() {
    }

    public TblCorreoClientes(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public TblCorreoClientes(Integer idCorreo, String correoCliente) {
        this.idCorreo = idCorreo;
        this.correoCliente = correoCliente;
    }

    public Integer getIdCorreo() {
        return idCorreo;
    }

    public void setIdCorreo(Integer idCorreo) {
        this.idCorreo = idCorreo;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public TblCliente getClienteidCliente() {
        return clienteidCliente;
    }

    public void setClienteidCliente(TblCliente clienteidCliente) {
        this.clienteidCliente = clienteidCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCorreo != null ? idCorreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCorreoClientes)) {
            return false;
        }
        TblCorreoClientes other = (TblCorreoClientes) object;
        if ((this.idCorreo == null && other.idCorreo != null) || (this.idCorreo != null && !this.idCorreo.equals(other.idCorreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblCorreoClientes[ idCorreo=" + idCorreo + " ]";
    }
    
}
