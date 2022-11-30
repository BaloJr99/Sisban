package cl.model.dao;

import cl.model.db.CorreoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CorreoClienteDao {
    
    public CorreoCliente buscarCorreo(int idCliente){
        CorreoCliente correo = new CorreoCliente();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblCorreoClientes WHERE cliente_idCliente = ? ORDER BY idCorreo DESC");
            pe.setInt(1, idCliente);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                correo.setCorreoCliente(re.getString("correoCliente"));
                correo.setIdCorreoCliente(re.getInt("idCorreo"));
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
