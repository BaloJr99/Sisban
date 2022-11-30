package cl.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RespuestasDao {
    
    public void insertarRespuestas(int idCliente, String resp1, String resp2, String resp3, String resp4, String resp5){
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_RESPUESTAS (?,?,?,?,?,?)} ");
            csta.setInt(1, idCliente);
            csta.setString(2, resp1);
            csta.setString(3, resp2);
            csta.setString(4, resp3);
            csta.setString(5, resp4);
            csta.setString(6, resp5);
            csta.execute();
            csta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public String buscarRespuesta(int idCliente, int idPregunta){
        String respuesta = "";
        
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT respuesta FROM tblRespuestas WHERE cliente_idCliente = ? AND pregunta_idPregunta = ?");
            pe.setInt(1, idCliente);
            pe.setInt(2, idPregunta);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
                respuesta = re.getString(1);
            }
            re.close();
            pe.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return respuesta;
    }
}
