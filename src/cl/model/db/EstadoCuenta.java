package cl.model.db;

import java.sql.Date;

public class EstadoCuenta {
    private int idCliente;
    private String nombre, numeroCuenta, descripcion, cuentaDestino, cuenta_numeroCuenta;
    private float saldo, monto;
    private Date fecha;

    public EstadoCuenta(int idCliente, String nombre, String numeroCuenta, float monto, Date fecha, float saldo, String descripcion, String cuenta_numeroCuenta, String cuentaDestino) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.monto = monto;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cuentaDestino = cuentaDestino;
        this.cuenta_numeroCuenta = cuenta_numeroCuenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getCuenta_numeroCuenta() {
        return cuenta_numeroCuenta;
    }

    public void setCuenta_numeroCuenta(String cuenta_numeroCuenta) {
        this.cuenta_numeroCuenta = cuenta_numeroCuenta;
    }
}
