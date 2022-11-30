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
public class CorreoEmpleado {
    private int idCorreoEmpleado,Empleado_idEmpleado;
    private String correoEmpleado;

    public CorreoEmpleado() {
    }

    public CorreoEmpleado(int idCorreoEmpleado, int Empleado_idEmpleado, String correoEmpleado) {
        this.idCorreoEmpleado = idCorreoEmpleado;
        this.Empleado_idEmpleado = Empleado_idEmpleado;
        this.correoEmpleado = correoEmpleado;
    }

    public CorreoEmpleado(int Empleado_idEmpleado, String correoEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
        this.correoEmpleado = correoEmpleado;
    }

    
    public int getIdCorreoEmpleado() {
        return idCorreoEmpleado;
    }

    public void setIdCorreoEmpleado(int idCorreoEmpleado) {
        this.idCorreoEmpleado = idCorreoEmpleado;
    }

    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }

    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
    }

    public String getCorreoEmpleado() {
        return correoEmpleado;
    }

    public void setCorreoEmpleado(String correoEmpleado) {
        this.correoEmpleado = correoEmpleado;
    }
    
    
    
}
