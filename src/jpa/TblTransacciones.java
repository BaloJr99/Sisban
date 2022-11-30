package jpa;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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

@Entity
@Table(name = "tblTransacciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblTransacciones.findAll", query = "SELECT t FROM TblTransacciones t")
    , @NamedQuery(name = "TblTransacciones.findByClaveRastreo", query = "SELECT t FROM TblTransacciones t WHERE t.claveRastreo = :claveRastreo")
    , @NamedQuery(name = "TblTransacciones.findByDescripci\u00f3n", query = "SELECT t FROM TblTransacciones t WHERE t.descripci\u00f3n = :descripci\u00f3n")
    , @NamedQuery(name = "TblTransacciones.findByMonto", query = "SELECT t FROM TblTransacciones t WHERE t.monto = :monto")
    , @NamedQuery(name = "TblTransacciones.findByNumReferencia", query = "SELECT t FROM TblTransacciones t WHERE t.numReferencia = :numReferencia")
    , @NamedQuery(name = "TblTransacciones.findByCuentaDestino", query = "SELECT t FROM TblTransacciones t WHERE t.cuentaDestino = :cuentaDestino")
    , @NamedQuery(name = "TblTransacciones.findByDestinatario", query = "SELECT t FROM TblTransacciones t WHERE t.destinatario = :destinatario")
    , @NamedQuery(name = "TblTransacciones.findByTipoMovimiento", query = "SELECT t FROM TblTransacciones t WHERE t.tipoMovimiento = :tipoMovimiento")
    , @NamedQuery(name = "TblTransacciones.findByBancosSucursal", query = "SELECT t FROM TblTransacciones t WHERE t.bancosSucursal = :bancosSucursal")
    , @NamedQuery(name = "TblTransacciones.findByFecha", query = "SELECT t FROM TblTransacciones t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "TblTransacciones.findByHora", query = "SELECT t FROM TblTransacciones t WHERE t.hora = :hora")})
public class TblTransacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "claveRastreo")
    private String claveRastreo;
    @Basic(optional = false)
    @Column(name = "descripci\u00f3n")
    private String descripción;
    @Basic(optional = false)
    @Column(name = "monto")
    private double monto;
    @Basic(optional = false)
    @Column(name = "numReferencia")
    private String numReferencia;
    @Basic(optional = false)
    @Column(name = "cuentaDestino")
    private String cuentaDestino;
    @Basic(optional = false)
    @Column(name = "destinatario")
    private String destinatario;
    @Basic(optional = false)
    @Column(name = "tipoMovimiento")
    private String tipoMovimiento;
    @Basic(optional = false)
    @Column(name = "bancos_sucursal")
    private String bancosSucursal;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @JoinColumn(name = "cuentas_numeroCuenta", referencedColumnName = "numeroCuenta")
    @ManyToOne
    private TblCuentas cuentasnumeroCuenta;
    @OneToMany(mappedBy = "claveRastreo")
    private Collection<TblSaldos> tblSaldosCollection;

    public TblTransacciones() {
    }

    public TblTransacciones(String claveRastreo) {
        this.claveRastreo = claveRastreo;
    }

    public TblTransacciones(String claveRastreo, String descripción, double monto, String numReferencia, String cuentaDestino, String destinatario, String tipoMovimiento, String bancosSucursal, Date fecha, Date hora) {
        this.claveRastreo = claveRastreo;
        this.descripción = descripción;
        this.monto = monto;
        this.numReferencia = numReferencia;
        this.cuentaDestino = cuentaDestino;
        this.destinatario = destinatario;
        this.tipoMovimiento = tipoMovimiento;
        this.bancosSucursal = bancosSucursal;
        this.fecha = fecha;
        this.hora = hora;
    }

    public String getClaveRastreo() {
        return claveRastreo;
    }

    public void setClaveRastreo(String claveRastreo) {
        this.claveRastreo = claveRastreo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(String numReferencia) {
        this.numReferencia = numReferencia;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getBancosSucursal() {
        return bancosSucursal;
    }

    public void setBancosSucursal(String bancosSucursal) {
        this.bancosSucursal = bancosSucursal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public TblCuentas getCuentasnumeroCuenta() {
        return cuentasnumeroCuenta;
    }

    public void setCuentasnumeroCuenta(TblCuentas cuentasnumeroCuenta) {
        this.cuentasnumeroCuenta = cuentasnumeroCuenta;
    }

    @XmlTransient
    public Collection<TblSaldos> getTblSaldosCollection() {
        return tblSaldosCollection;
    }

    public void setTblSaldosCollection(Collection<TblSaldos> tblSaldosCollection) {
        this.tblSaldosCollection = tblSaldosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveRastreo != null ? claveRastreo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTransacciones)) {
            return false;
        }
        TblTransacciones other = (TblTransacciones) object;
        if ((this.claveRastreo == null && other.claveRastreo != null) || (this.claveRastreo != null && !this.claveRastreo.equals(other.claveRastreo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.TblTransacciones[ claveRastreo=" + claveRastreo + " ]";
    }
    
}
