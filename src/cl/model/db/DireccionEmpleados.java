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
public class DireccionEmpleados {
    private int idDireccionEmpleado,Empleado_idEmpleado;
    private String calle,numInt,numExt,colonia,codigoPostal;

    public DireccionEmpleados() {
    }
    
    public DireccionEmpleados(int idDireccionEmpleado, int Empleado_idEmpleado, String calle, String numInt, String numExt, String colonia, String codigoPostal) {
        this.idDireccionEmpleado = idDireccionEmpleado;
        this.Empleado_idEmpleado = Empleado_idEmpleado;
        this.calle = calle;
        this.numInt = numInt;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public DireccionEmpleados(int Empleado_idEmpleado, String calle, String numInt, String numExt, String colonia, String codigoPostal) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
        this.calle = calle;
        this.numInt = numInt;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    

    public int getIdDireccionEmpleado() {
        return idDireccionEmpleado;
    }

    public void setIdDireccionEmpleado(int idDireccionEmpleado) {
        this.idDireccionEmpleado = idDireccionEmpleado;
    }

    public int getEmpleado_idEmpleado() {
        return Empleado_idEmpleado;
    }

    public void setEmpleado_idEmpleado(int Empleado_idEmpleado) {
        this.Empleado_idEmpleado = Empleado_idEmpleado;
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
    
    
}

