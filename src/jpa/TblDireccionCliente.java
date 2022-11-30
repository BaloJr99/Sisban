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
@Table(name = "tblDireccionCliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDireccionCliente.findAll", query = "SELECT t FROM TblDireccionCliente t")
    , @NamedQuery(name = "TblDireccionCliente.findByIdDireccionCliente", query = "SELECT t FROM TblDireccionCliente t WHERE t.idDireccionCliente = :idDireccionCliente")
    , @NamedQuery(name = "TblDireccionCliente.findByCalle", query = "SELECT t FROM TblDireccionCliente t WHERE t.calle = :calle")
    , @NamedQuery(name = "TblDireccionCliente.findByNumInt", query = "SELECT t FROM TblDireccionCliente t WHERE t.numInt = :numInt")
    , @NamedQuery(name = "TblDireccionCliente.findByNumExt", query = "SELECT t FROM TblDireccionCliente t WHERE t.numExt = :numExt")
    , @NamedQuery(name = "TblDireccionCliente.findByColonia", query = "SELECT t FROM TblDireccionCliente t WHERE t.colonia = :colonia")
    , @NamedQuery(name = "TblDireccionCliente.findByCodigoPostal", query = "SELECT t FROM TblDireccionCliente t WHERE t.codigoPostal = :codigoPostal")})
public class TblDireccionCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccionCliente")
    private Integer idDireccionCliente;
    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;
    @Column(name = "numInt")
    private String numInt;
    @Basic(optional = false)
    @Column(name = "numExt")
    private String numExt;
    @Basic(optional = false)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "codigoPostal")
    private String codigoPostal;
    @JoinColumn(name = "cliente_idCliente", referencedColumnName = "idCliente")
    @ManyToOne(optional = false)
    private TblCliente clienteidCliente;

    public TblDireccionCliente() {
    }

    public TblDireccionCliente(Integer idDireccionCliente) {
        this.idDireccionCliente = idDireccionCliente;
    }

    public TblDireccionCliente(Integer idDireccionCliente, String calle, String numExt, String colonia, String codigoPostal) {
        this.idDireccionCliente = idDireccionCliente;
        this.calle = calle;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionCliente() {
        return idDireccionCliente;
    }

    public void setIdDireccionCliente(Integer idDireccionCliente) {
        this.idDireccionCliente = idDireccionCliente;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumInt() {
        return numInt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
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
        hash += (idDireccionCliente != null ? idDireccionCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDireccionCliente)) {
            return false;
        }
        TblDireccionCliente other = (TblDireccionCliente) object;
        if ((this.idDireccionCliente == null && other.idDireccionCliente != null) || (this.idDireccionCliente != null && !this.idDireccionCliente.equals(other.idDireccionCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblDireccionCliente[ idDireccionCliente=" + idDireccionCliente + " ]";
    }
    
}
