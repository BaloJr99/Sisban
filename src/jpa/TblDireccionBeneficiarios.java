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
@Table(name = "tblDireccionBeneficiarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblDireccionBeneficiarios.findAll", query = "SELECT t FROM TblDireccionBeneficiarios t")
    , @NamedQuery(name = "TblDireccionBeneficiarios.findByIdDireccionBeneficiario", query = "SELECT t FROM TblDireccionBeneficiarios t WHERE t.idDireccionBeneficiario = :idDireccionBeneficiario")
    , @NamedQuery(name = "TblDireccionBeneficiarios.findByCalle", query = "SELECT t FROM TblDireccionBeneficiarios t WHERE t.calle = :calle")
    , @NamedQuery(name = "TblDireccionBeneficiarios.findByNumInt", query = "SELECT t FROM TblDireccionBeneficiarios t WHERE t.numInt = :numInt")
    , @NamedQuery(name = "TblDireccionBeneficiarios.findByNumExt", query = "SELECT t FROM TblDireccionBeneficiarios t WHERE t.numExt = :numExt")
    , @NamedQuery(name = "TblDireccionBeneficiarios.findByColonia", query = "SELECT t FROM TblDireccionBeneficiarios t WHERE t.colonia = :colonia")
    , @NamedQuery(name = "TblDireccionBeneficiarios.findByCodigoPostal", query = "SELECT t FROM TblDireccionBeneficiarios t WHERE t.codigoPostal = :codigoPostal")})
public class TblDireccionBeneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDireccionBeneficiario")
    private Integer idDireccionBeneficiario;
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
    @JoinColumn(name = "beneficiarios_idBeneficiario", referencedColumnName = "idBeneficiario")
    @ManyToOne(optional = false)
    private TblBeneficiarios beneficiariosidBeneficiario;

    public TblDireccionBeneficiarios() {
    }

    public TblDireccionBeneficiarios(Integer idDireccionBeneficiario) {
        this.idDireccionBeneficiario = idDireccionBeneficiario;
    }

    public TblDireccionBeneficiarios(Integer idDireccionBeneficiario, String calle, String numExt, String colonia, String codigoPostal) {
        this.idDireccionBeneficiario = idDireccionBeneficiario;
        this.calle = calle;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public Integer getIdDireccionBeneficiario() {
        return idDireccionBeneficiario;
    }

    public void setIdDireccionBeneficiario(Integer idDireccionBeneficiario) {
        this.idDireccionBeneficiario = idDireccionBeneficiario;
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

    public TblBeneficiarios getBeneficiariosidBeneficiario() {
        return beneficiariosidBeneficiario;
    }

    public void setBeneficiariosidBeneficiario(TblBeneficiarios beneficiariosidBeneficiario) {
        this.beneficiariosidBeneficiario = beneficiariosidBeneficiario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccionBeneficiario != null ? idDireccionBeneficiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDireccionBeneficiarios)) {
            return false;
        }
        TblDireccionBeneficiarios other = (TblDireccionBeneficiarios) object;
        if ((this.idDireccionBeneficiario == null && other.idDireccionBeneficiario != null) || (this.idDireccionBeneficiario != null && !this.idDireccionBeneficiario.equals(other.idDireccionBeneficiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblDireccionBeneficiarios[ idDireccionBeneficiario=" + idDireccionBeneficiario + " ]";
    }
    
}
