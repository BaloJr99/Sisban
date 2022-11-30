package cl.model.db;

public class DireccionBeneficiario {
    private int idDireccionBeneficiario, beneficiarios_idBeneficiario;
    private String calle, numInt, numExt, colonia, codigoPostal;

    public DireccionBeneficiario(int idDireccionBeneficiario, int beneficiarios_idBeneficiario, String calle, String numInt, String numExt, String colonia, String codigoPostal) {
        this.idDireccionBeneficiario = idDireccionBeneficiario;
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
        this.calle = calle;
        this.numInt = numInt;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public DireccionBeneficiario(int beneficiarios_idBeneficiario, String calle, String numInt, String numExt, String colonia, String codigoPostal) {
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
        this.calle = calle;
        this.numInt = numInt;
        this.numExt = numExt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
    }

    public int getBeneficiarios_idBeneficiario() {
        return beneficiarios_idBeneficiario;
    }

    public void setBeneficiarios_idBeneficiario(int beneficiarios_idBeneficiario) {
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
    }

    public int getIdDireccionBeneficiario() {
        return idDireccionBeneficiario;
    }

    public void setIdDireccionBeneficiario(int idDireccionBeneficiario) {
        this.idDireccionBeneficiario = idDireccionBeneficiario;
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
