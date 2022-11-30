package cl.model.dao;

import cl.model.db.CorreoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CorreoEmpleadoDao {
    public CorreoEmpleado buscarCorreo(int idEmpleado){
        CorreoEmpleado correo = new CorreoEmpleado();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblCorreoEmpleado WHERE Empleado_idEmpleado = ? ORDER BY idCorreoEmpleado DESC");
            pe.setInt(1, idEmpleado);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                correo.setCorreoEmpleado(re.getString("correoEmpleado"));
                correo.setIdCorreoEmpleado(re.getInt("Empleado_idEmpleado"));
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
