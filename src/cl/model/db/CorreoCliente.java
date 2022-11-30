package cl.model.db;

public class CorreoCliente {
    private int idCorreoCliente, cliente_idCliente;
    private String correoCliente;

    public CorreoCliente(int idCorreoCliente, int cliente_idCliente, String correoCliente) {
        this.idCorreoCliente = idCorreoCliente;
        this.cliente_idCliente = cliente_idCliente;
        this.correoCliente = correoCliente;
    }

    public CorreoCliente(int cliente_idCliente, String correoCliente) {
        this.cliente_idCliente = cliente_idCliente;
        this.correoCliente = correoCliente;
    }

    public CorreoCliente() {
    }

    public int getIdCorreoCliente() {
        return idCorreoCliente;
    }

    public void setIdCorreoCliente(int idCorreoCliente) {
        this.idCorreoCliente = idCorreoCliente;
    }

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
}
