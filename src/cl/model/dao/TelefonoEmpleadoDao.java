/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.dao;

import cl.model.db.TelefonoEmpleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LATITUD
 */
public class TelefonoEmpleadoDao {
    
        
    public TelefonoEmpleado buscarTelefonoEmp(int idEmpleado){
        TelefonoEmpleado telefono = new TelefonoEmpleado();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblTelefonoEmpleados WHERE Empleado_idEmpleado = ? ORDER BY idTelefonoEmpleado DESC");
            pe.setInt(1, idEmpleado);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                telefono.setIdTelefonoEmpleado(re.getInt("idTelefonoEmpleado"));
                telefono.setNumTelefonoEmpleado(re.getString("numTelefonoEmpleado"));
                telefono.setTipoTelefono(re.getString("tipoTelefono"));
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
