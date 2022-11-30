package cl.model.dao;

import cl.model.db.DireccionBeneficiario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DireccionBeneficiarioDao {
    public DireccionBeneficiario buscarDireccion(int idBeneficiario){
        DireccionBeneficiario direccion = null;
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblDireccionBeneficiarios WHERE beneficiarios_idBeneficiario = ? ORDER BY idDireccionBeneficiario DESC");
            pe.setInt(1, idBeneficiario);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                direccion = new DireccionBeneficiario(re.getInt("idDireccionBeneficiario"), re.getString("calle"), 
                        re.getString("numInt"), re.getString("numExt"), re.getString("colonia"), re.getString("codigoPostal"));
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return direccion;
    }
}
