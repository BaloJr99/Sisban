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
@Table(name = "tblCorreoBeneficiarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblCorreoBeneficiarios.findAll", query = "SELECT t FROM TblCorreoBeneficiarios t")
    , @NamedQuery(name = "TblCorreoBeneficiarios.findByIdCorreoBeneficiario", query = "SELECT t FROM TblCorreoBeneficiarios t WHERE t.idCorreoBeneficiario = :idCorreoBeneficiario")
    , @NamedQuery(name = "TblCorreoBeneficiarios.findByCorreoBeneficiario", query = "SELECT t FROM TblCorreoBeneficiarios t WHERE t.correoBeneficiario = :correoBeneficiario")})
public class TblCorreoBeneficiarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCorreoBeneficiario")
    private Integer idCorreoBeneficiario;
    @Basic(optional = false)
    @Column(name = "correoBeneficiario")
    private String correoBeneficiario;
    @JoinColumn(name = "beneficiarios_idBeneficiario", referencedColumnName = "idBeneficiario")
    @ManyToOne(optional = false)
    private TblBeneficiarios beneficiariosidBeneficiario;

    public TblCorreoBeneficiarios() {
    }

    public TblCorreoBeneficiarios(Integer idCorreoBeneficiario) {
        this.idCorreoBeneficiario = idCorreoBeneficiario;
    }

    public TblCorreoBeneficiarios(Integer idCorreoBeneficiario, String correoBeneficiario) {
        this.idCorreoBeneficiario = idCorreoBeneficiario;
        this.correoBeneficiario = correoBeneficiario;
    }

    public Integer getIdCorreoBeneficiario() {
        return idCorreoBeneficiario;
    }

    public void setIdCorreoBeneficiario(Integer idCorreoBeneficiario) {
        this.idCorreoBeneficiario = idCorreoBeneficiario;
    }

    public String getCorreoBeneficiario() {
        return correoBeneficiario;
    }

    public void setCorreoBeneficiario(String correoBeneficiario) {
        this.correoBeneficiario = correoBeneficiario;
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
        hash += (idCorreoBeneficiario != null ? idCorreoBeneficiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblCorreoBeneficiarios)) {
            return false;
        }
        TblCorreoBeneficiarios other = (TblCorreoBeneficiarios) object;
        if ((this.idCorreoBeneficiario == null && other.idCorreoBeneficiario != null) || (this.idCorreoBeneficiario != null && !this.idCorreoBeneficiario.equals(other.idCorreoBeneficiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblCorreoBeneficiarios[ idCorreoBeneficiario=" + idCorreoBeneficiario + " ]";
    }
    
}
