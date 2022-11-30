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
@Table(name = "tblTelefonoClientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTelefonoClientes.findAll", query = "SELECT t FROM TblTelefonoClientes t")
    , @NamedQuery(name = "TblTelefonoClientes.findByIdTelefonoCliente", query = "SELECT t FROM TblTelefonoClientes t WHERE t.idTelefonoCliente = :idTelefonoCliente")
    , @NamedQuery(name = "TblTelefonoClientes.findByNumTelefonoCliente", query = "SELECT t FROM TblTelefonoClientes t WHERE t.numTelefonoCliente = :numTelefonoCliente")
    , @NamedQuery(name = "TblTelefonoClientes.findByTipoTelefonoCliente", query = "SELECT t FROM TblTelefonoClientes t WHERE t.tipoTelefonoCliente = :tipoTelefonoCliente")})
public class TblTelefonoClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefonoCliente")
    private Integer idTelefonoCliente;
    @Basic(optional = false)
    @Column(name = "numTelefonoCliente")
    private String numTelefonoCliente;
    @Basic(optional = false)
    @Column(name = "tipoTelefonoCliente")
    private String tipoTelefonoCliente;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private TblCliente clienteidCliente;

    public TblTelefonoClientes() {
    }

    public TblTelefonoClientes(Integer idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
    }

    public TblTelefonoClientes(Integer idTelefonoCliente, String numTelefonoCliente, String tipoTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
        this.numTelefonoCliente = numTelefonoCliente;
        this.tipoTelefonoCliente = tipoTelefonoCliente;
    }

    public Integer getIdTelefonoCliente() {
        return idTelefonoCliente;
    }

    public void setIdTelefonoCliente(Integer idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
    }

    public String getNumTelefonoCliente() {
        return numTelefonoCliente;
    }

    public void setNumTelefonoCliente(String numTelefonoCliente) {
        this.numTelefonoCliente = numTelefonoCliente;
    }

    public String getTipoTelefonoCliente() {
        return tipoTelefonoCliente;
    }

    public void setTipoTelefonoCliente(String tipoTelefonoCliente) {
        this.tipoTelefonoCliente = tipoTelefonoCliente;
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
        hash += (idTelefonoCliente != null ? idTelefonoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTelefonoClientes)) {
            return false;
        }
        TblTelefonoClientes other = (TblTelefonoClientes) object;
        if ((this.idTelefonoCliente == null && other.idTelefonoCliente != null) || (this.idTelefonoCliente != null && !this.idTelefonoCliente.equals(other.idTelefonoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblTelefonoClientes[ idTelefonoCliente=" + idTelefonoCliente + " ]";
    }
    
}
