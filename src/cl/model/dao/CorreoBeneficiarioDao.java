package cl.model.dao;

import cl.model.db.CorreoBeneficiario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CorreoBeneficiarioDao {
    public CorreoBeneficiario buscarCorreo(int idBeneficiario){
        CorreoBeneficiario correo = null;
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblCorreoBeneficiarios WHERE beneficiarios_idBeneficiario = ? ORDER BY idCorreoBeneficiario DESC");
            pe.setInt(1, idBeneficiario);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                correo = new CorreoBeneficiario(re.getInt("idCorreoBeneficiario"), re.getString("correoBeneficiario"));
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return correo;
    }
}
