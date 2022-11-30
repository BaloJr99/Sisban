/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.db;

/**
 *
 * @author LATITUD
 */
public class TelefonoEmpleado {
    private int idTelefonoEmpleado,Empleado_idEmpleado;
    private String numTelefonoEmpleado,tipoTelefono;

    public TelefonoEmpleado() {
    }
    
    public TelefonoEmpleado(int idTelefonoEmpleado, int Empleado_idEmpleado, String numTelefonoEmpleado, String tipoTelefono) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
        this.Empleado_idEmpleado = Empleado_idEmpleado;
        this.numTelefonoEmpleado = numTelefonoEmpleado;
        this.tipoTelefono = tipoTelefono;
    }

    public TelefonoEmpleado(int Empleado_idEmpleado, String numTelefonoEmpleado, String tipoTelefono) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
        this.numTelefonoEmpleado = numTelefonoEmpleado;
        this.tipoTelefono = tipoTelefono;
    }

    
    
    public int getIdTelefonoEmpleado() {
        return idTelefonoEmpleado;
    }

    public void setIdTelefonoEmpleado(int idTelefonoEmpleado) {
        this.idTelefonoEmpleado = idTelefonoEmpleado;
    }

    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }

    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }

    public String getNumTelefonoEmpleado() {
        return numTelefonoEmpleado;
    }

    public void setNumTelefonoEmpleado(String numTelefonoEmpleado) {
        this.numTelefonoEmpleado = numTelefonoEmpleado;
    }

    public String getTipoTelefono() {
        return tipoTelefono;
    }

    public void setTipoTelefono(String tipoTelefono) {
        this.tipoTelefono = tipoTelefono;
    }
    
    
}
