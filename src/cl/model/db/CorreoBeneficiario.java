package cl.model.db;

public class CorreoBeneficiario {
    private int idCorreoBeneficiario, beneficiarios_idBeneficiario;
    private String correoBeneficiario;

    public CorreoBeneficiario(int idCorreoBeneficiario, int beneficiarios_idBeneficiario, String correoBeneficiario) {
        this.idCorreoBeneficiario = idCorreoBeneficiario;
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
        this.correoBeneficiario = correoBeneficiario;
    }

    public CorreoBeneficiario(int beneficiarios_idBeneficiario, String correoBeneficiario) {
        this.beneficiarios_idBeneficiario = beneficiarios_idBeneficiario;
        this.correoBeneficiario = correoBeneficiario;
    }

    public CorreoBeneficiario(String correoBeneficiario) {
        this.correoBeneficiario = correoBeneficiario;
    }

    public int getIdCorreoBeneficiario() {
        return idCorreoBeneficiario;
    }

    public void setIdCorreoBeneficiario(int idCorreoBeneficiario) {
        this.idCorreoBeneficiario = idCorreoBeneficiario;
    }

    public String getCorreoBeneficiario() {
        return correoBeneficiario;
    }

    public void setCorreoBeneficiario(String correoBeneficiario) {
        this.correoBeneficiario = correoBeneficiario;
    }
    
    
}
