package cl.model.dao;

import cl.model.db.DireccionCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DireccionClienteDao {
    
    public DireccionCliente buscarDireccion(int idCliente){
        DireccionCliente direccion = new DireccionCliente();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblDireccionCliente WHERE cliente_idCliente = ? ORDER BY idDireccionCliente DESC");
            pe.setInt(1, idCliente);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                direccion.setIdDireccionCliente(re.getInt("idDireccionCliente"));
                direccion.setCalle(re.getString("calle"));
                direccion.setNumInt(re.getString("numInt"));
                direccion.setNumExt(re.getString("numExt"));
                direccion.setColonia(re.getString("colonia"));
                direccion.setCodigoPostal(re.getString("codigoPostal"));
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
