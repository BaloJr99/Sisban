package cl.model.dao;

import cl.model.db.TelefonoCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TelefonoClienteDao {
        
    public TelefonoCliente buscarTelefono(int idCliente){
        TelefonoCliente telefono = new TelefonoCliente();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblTelefonoClientes WHERE cliente_idCliente = ? ORDER BY idTelefonoCliente DESC");
            pe.setInt(1, idCliente);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                telefono.setIdTelefonoCliente(re.getInt("idTelefonoCliente"));
                telefono.setNumTelefonoCliente(re.getString("numTelefonoCliente"));
                telefono.setTipoTelefonoCliente(re.getString("tipoTelefonoCliente"));
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
