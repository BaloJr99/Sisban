/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.model.dao;

import cl.model.db.DireccionEmpleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LATITUD
 */
public class DireccionEmpleadoDao {
    public DireccionEmpleados buscarDireccion(int idEmpleado){
        DireccionEmpleados direccion = new DireccionEmpleados();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblDireccionEmpleados WHERE Empleado_idEmpleado = ? ORDER BY idDireccionEmpleado DESC");
            pe.setInt(1, idEmpleado);
            ResultSet re = pe.executeQuery();
            if(re.next()){
                direccion.setIdDireccionEmpleado(re.getInt("idDireccionEmpleado"));
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
