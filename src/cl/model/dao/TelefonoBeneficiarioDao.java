package cl.model.dao;

import cl.model.db.TelefonoBeneficiario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelefonoBeneficiarioDao {
    public TelefonoBeneficiario buscarTelefono(int idBeneficiario){
        TelefonoBeneficiario telefono = null;
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblTelefonoBeneficiario WHERE beneficiarios_idBeneficiario = ? ORDER BY idTelefonoBeneficiario DESC");
            pe.setInt(1, idBeneficiario);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                telefono = new TelefonoBeneficiario(re.getInt("idTelefonoBeneficiario"), re.getString("numTelefonoBeneficiario"), re.getString("tipoTelefonoBeneficiario"));
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return telefono;
    }
}
