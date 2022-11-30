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
@Table(name = "tblTelefonoBeneficiario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTelefonoBeneficiario.findAll", query = "SELECT t FROM TblTelefonoBeneficiario t")
    , @NamedQuery(name = "TblTelefonoBeneficiario.findByIdTelefonoBeneficiario", query = "SELECT t FROM TblTelefonoBeneficiario t WHERE t.idTelefonoBeneficiario = :idTelefonoBeneficiario")
    , @NamedQuery(name = "TblTelefonoBeneficiario.findByNumTelefonoBeneficiario", query = "SELECT t FROM TblTelefonoBeneficiario t WHERE t.numTelefonoBeneficiario = :numTelefonoBeneficiario")
    , @NamedQuery(name = "TblTelefonoBeneficiario.findByTipoTelefonoBeneficiario", query = "SELECT t FROM TblTelefonoBeneficiario t WHERE t.tipoTelefonoBeneficiario = :tipoTelefonoBeneficiario")})
public class TblTelefonoBeneficiario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idTelefonoBeneficiario")
    private Integer idTelefonoBeneficiario;
    @Basic(optional = false)
    @Column(name = "numTelefonoBeneficiario")
    private String numTelefonoBeneficiario;
    @Basic(optional = false)
    @Column(name = "tipoTelefonoBeneficiario")
    private String tipoTelefonoBeneficiario;
    @JoinColumn(name = "beneficiarios_idBeneficiario", referencedColumnName = "idBeneficiario")
    @ManyToOne(optional = false)
    private TblBeneficiarios beneficiariosidBeneficiario;

    public TblTelefonoBeneficiario() {
    }

    public TblTelefonoBeneficiario(Integer idTelefonoBeneficiario) {
        this.idTelefonoBeneficiario = idTelefonoBeneficiario;
    }

    public TblTelefonoBeneficiario(Integer idTelefonoBeneficiario, String numTelefonoBeneficiario, String tipoTelefonoBeneficiario) {
        this.idTelefonoBeneficiario = idTelefonoBeneficiario;
        this.numTelefonoBeneficiario = numTelefonoBeneficiario;
        this.tipoTelefonoBeneficiario = tipoTelefonoBeneficiario;
    }

    public Integer getIdTelefonoBeneficiario() {
        return idTelefonoBeneficiario;
    }

    public void setIdTelefonoBeneficiario(Integer idTelefonoBeneficiario) {
        this.idTelefonoBeneficiario = idTelefonoBeneficiario;
    }

    public String getNumTelefonoBeneficiario() {
        return numTelefonoBeneficiario;
    }

    public void setNumTelefonoBeneficiario(String numTelefonoBeneficiario) {
        this.numTelefonoBeneficiario = numTelefonoBeneficiario;
    }

    public String getTipoTelefonoBeneficiario() {
        return tipoTelefonoBeneficiario;
    }

    public void setTipoTelefonoBeneficiario(String tipoTelefonoBeneficiario) {
        this.tipoTelefonoBeneficiario = tipoTelefonoBeneficiario;
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
        hash += (idTelefonoBeneficiario != null ? idTelefonoBeneficiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTelefonoBeneficiario)) {
            return false;
        }
        TblTelefonoBeneficiario other = (TblTelefonoBeneficiario) object;
        if ((this.idTelefonoBeneficiario == null && other.idTelefonoBeneficiario != null) || (this.idTelefonoBeneficiario != null && !this.idTelefonoBeneficiario.equals(other.idTelefonoBeneficiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblTelefonoBeneficiario[ idTelefonoBeneficiario=" + idTelefonoBeneficiario + " ]";
    }
    
}
