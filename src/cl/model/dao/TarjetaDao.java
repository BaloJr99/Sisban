package cl.model.dao;

import cl.model.db.Tarjeta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TarjetaDao {
    
    Tarjeta tarjeta;
    
    public boolean existeId(String id){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblTarjetas WHERE numTarjeta = ?");
            pe.setString(1, id);
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
    
    public ArrayList<Tarjeta> buscarTarjetas(String numCuenta) throws SQLException{
        ArrayList<Tarjeta> misTarjetas = new ArrayList<>();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * from tblTarjetas WHERE cuentas_numCuenta = ? AND estadoTarjeta = 'Activa'");
            pe.setString(1, numCuenta);
            ResultSet re = pe.executeQuery();        

            while(re.next()){
                tarjeta = new Tarjeta(re.getString("numTarjeta"), re.getString("cuentas_numCuenta"), re.getString("estadoTarjeta"));
                misTarjetas.add(tarjeta);
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return misTarjetas;
    }
}
