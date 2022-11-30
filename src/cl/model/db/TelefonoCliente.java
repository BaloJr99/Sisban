package cl.model.db;

public class TelefonoCliente {
    private int idTelefonoCliente, cliente_idCliente;
    private String numTelefonoCliente, tipoTelefonoCliente;

    public TelefonoCliente(int idTelefonoCliente, int cliente_idCliente, String numTelefonoCliente, String tipoTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
        this.cliente_idCliente = cliente_idCliente;
        this.numTelefonoCliente = numTelefonoCliente;
        this.tipoTelefonoCliente = tipoTelefonoCliente;
    }

    public TelefonoCliente(int cliente_idCliente, String numTelefonoCliente, String tipoTelefonoCliente) {
        this.cliente_idCliente = cliente_idCliente;
        this.numTelefonoCliente = numTelefonoCliente;
        this.tipoTelefonoCliente = tipoTelefonoCliente;
    }
    
    public TelefonoCliente() {
    }

    public int getIdTelefonoCliente() {
        return idTelefonoCliente;
    }

    public void setIdTelefonoCliente(int idTelefonoCliente) {
        this.idTelefonoCliente = idTelefonoCliente;
    }

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }

    public String getNumTelefonoCliente() {
        return numTelefonoCliente;
    }

    public void setNumTelefonoCliente(String numTelefonoCliente) {
        this.numTelefonoCliente = numTelefonoCliente;
    }

    public String getTipoTelefonoCliente() {
        return tipoTelefonoCliente;
    }

    public void setTipoTelefonoCliente(String tipoTelefonoCliente) {
        this.tipoTelefonoCliente = tipoTelefonoCliente;
    }
        
}
