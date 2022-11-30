package cl.model.db;

import java.sql.Date;

public class Beneficiario {
    private int idBeneficiario, cliente_idCliente;
    private String parentesco, nombre, apellidoPaterno, apellidoMaterno, genero, ine;
    private Date fechaNacimiento;

    public Beneficiario(int idBeneficiario, int cliente_idCliente, String parentesco, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String ine, Date fechaNacimiento) {
        this.idBeneficiario = idBeneficiario;
        this.cliente_idCliente = cliente_idCliente;
        this.parentesco = parentesco;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.ine = ine;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Beneficiario(int idBeneficiario, String parentesco, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, String ine, Date fechaNacimiento) {
        this.idBeneficiario = idBeneficiario;
        this.parentesco = parentesco;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.genero = genero;
        this.ine = ine;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public Beneficiario() {
        
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }
}
