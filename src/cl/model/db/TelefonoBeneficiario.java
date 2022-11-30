package cl.model.db;

public class TelefonoBeneficiario {
    private int idTelefonoBeneficiario, beneficiarios_idBeneficiario;
    private String numTelefonoBeneficiario, tipoTelefonoBeneficiario;

    public TelefonoBeneficiario(int idTelefonoBeneficiario, int beneficiarios_idBeneficiario, String numTelefonoBeneficiario, String tipoTelefonoBeneficiario) {
        this.idTelefonoBeneficiario = idTelefonoBeneficiario;
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
        this.numTelefonoBeneficiario = numTelefonoBeneficiario;
        this.tipoTelefonoBeneficiario = tipoTelefonoBeneficiario;
    }

    public TelefonoBeneficiario(int beneficiarios_idBeneficiario, String numTelefonoBeneficiario, String tipoTelefonoBeneficiario) {
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
        this.numTelefonoBeneficiario = numTelefonoBeneficiario;
        this.tipoTelefonoBeneficiario = tipoTelefonoBeneficiario;
    }

    public int getBeneficiarios_idBeneficiario() {
        return beneficiarios_idBeneficiario;
    }

    public void setBeneficiarios_idBeneficiario(int beneficiarios_idBeneficiario) {
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
    }

    public int getIdTelefonoBeneficiario() {
        return idTelefonoBeneficiario;
    }

    public void setIdTelefonoBeneficiario(int idTelefonoBeneficiario) {
        this.idTelefonoBeneficiario = idTelefonoBeneficiario;
    }

    public String getNumTelefonoBeneficiario() {
        return numTelefonoBeneficiario;
    }

    public void setNumTelefonoBeneficiario(String numTelefonoBeneficiario) {
        this.numTelefonoBeneficiario = numTelefonoBeneficiario;
    }

    public String getTipoTelefonoBeneficiario() {
        return tipoTelefonoBeneficiario;
    }

    public void setTipoTelefonoBeneficiario(String tipoTelefonoBeneficiario) {
        this.tipoTelefonoBeneficiario = tipoTelefonoBeneficiario;
    }
    
    
}
