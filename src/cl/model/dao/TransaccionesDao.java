package cl.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import javax.swing.JOptionPane;

public class TransaccionesDao {
    
    public boolean existeClave(String clave){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblTransacciones WHERE claveRastreo = ?");
            pe.setString(1, clave);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
               flag = true; 
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return flag;
    }
    
    public boolean existeReferencia(String referencia){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblTransacciones WHERE numReferencia = ?");
            pe.setString(1, referencia);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
               flag = true; 
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return flag;
    }
    
    public float promedio(String numCuenta, int mes, int año){
        float promedio = 0;
        
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            CallableStatement csta = con.prepareCall("{? = CALL FT_PROMEDIO(?,?,?)}");
            csta.registerOutParameter(1, Types.FLOAT);
            csta.setString(2, numCuenta);
            csta.setInt(3, mes);
            csta.setInt(4, año);
            csta.execute();
            promedio = csta.getFloat(1);
            csta.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return promedio;
    }
    
    public float promedioGastos(String numCuenta){
        float promedioG = 0;
        
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            CallableStatement csta = con.prepareCall("{? = CALL FT_PROMEDIO_GASTOS(?)}");
            csta.registerOutParameter(1, Types.FLOAT);
            csta.setString(2, numCuenta);
            csta.execute();
            promedioG = csta.getFloat(1);
            csta.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return promedioG;
    }
    
    public float promedioIngresos(String numCuenta){
        float promedioI = 0;
        
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            CallableStatement csta = con.prepareCall("{? = CALL FT_PROMEDIO_INGRESOS(?)}");
            csta.registerOutParameter(1, Types.FLOAT);
            csta.setString(2, numCuenta);
            csta.execute();
            promedioI = csta.getFloat(1);
            csta.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return promedioI;
    }
}
