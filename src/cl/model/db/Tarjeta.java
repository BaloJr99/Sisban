package cl.model.db;

public class Tarjeta {
    private String numTarjeta, numCuenta, estadoTarjeta;

    public Tarjeta(String numTarjeta, String numCuenta, String estadoTarjeta) {
        this.numTarjeta = numTarjeta;
        this.numCuenta = numCuenta;
        this.estadoTarjeta = estadoTarjeta;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public String getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getEstadoTarjeta() {
        return estadoTarjeta;
    }

    public void setEstadoTarjeta(String estadoTarjeta) {
        this.estadoTarjeta = estadoTarjeta;
    }
    
}
