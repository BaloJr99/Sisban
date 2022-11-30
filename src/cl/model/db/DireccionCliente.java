package cl.model.db;

public class DireccionCliente {
    private String calle, numInt, numExt, colonia, codigoPostal;
    private int idDireccionCliente, cliente_idCliente;

    public DireccionCliente(String calle, String numInt, String numExt, String colonia, String codigoPostal, int idDireccionCliente, int cliente_idCliente) {
        this.calle = calle;
        this.numInt = numInt;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.idDireccionCliente = idDireccionCliente;
        this.cliente_idCliente = cliente_idCliente;
    }

    public DireccionCliente(String calle, String numInt, String numExt, String colonia, String codigoPostal, int cliente_idCliente) {
        this.calle = calle;
        this.numInt = numInt;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.cliente_idCliente = cliente_idCliente;
    }

    public DireccionCliente() {
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

    public int getIdDireccionCliente() {
        return idDireccionCliente;
    }

    public void setIdDireccionCliente(int idDireccionCliente) {
        this.idDireccionCliente = idDireccionCliente;
    }

    public int getCliente_idCliente() {
        return cliente_idCliente;
    }

    public void setCliente_idCliente(int cliente_idCliente) {
        this.cliente_idCliente = cliente_idCliente;
    }
    
    
}
