package cl.model.db;

import java.util.ArrayList;

public class Cuenta {
    private String numeroCuenta, tipoCuenta, banco_sucursal, clabe, estado;
    private int cliente_idCliente;
    private float saldo;

    public Cuenta(String numeroCuenta, String tipoCuenta, String banco_sucursal, String clabe, int cliente_idCliente, float saldo, String estado) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.banco_sucursal = banco_sucursal;
        this.clabe = clabe;
        this.cliente_idCliente = cliente_idCliente;
        this.saldo = saldo;
        this.estado = estado;
    }

    public Cuenta(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public String getBanco_sucursal() {
        return banco_sucursal;
    }

    public void setBanco_sucursal(String banco_sucursal) {
        this.banco_sucursal = banco_sucursal;
    }

    public String getClabe() {
        return clabe;
    }

    public void setClabe(String clabe) {
        this.clabe = clabe;
    }

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
