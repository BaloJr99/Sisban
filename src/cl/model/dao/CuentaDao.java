package cl.model.dao;

import cl.model.db.Cuenta;
import cl.model.db.EstadoCuenta;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CuentaDao {
    
    Cuenta cuenta;
    
    public void insertarCuenta (Cuenta cuenta){
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_CUENTA (?,?,?,?,?,?,?)} ");
            csta.setString(1, cuenta.getNumeroCuenta());
            csta.setString(2, cuenta.getTipoCuenta());
            csta.setInt(3, cuenta.getCliente_idCliente());
            csta.setFloat(4, cuenta.getSaldo());
            csta.setString(5, cuenta.getBanco_sucursal());
            csta.setString(6, cuenta.getClabe());
            csta.setString(7, cuenta.getEstado());
            csta.execute();
            csta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ArrayList<Cuenta> buscarCuentasC(int idCliente) throws SQLException{
        ArrayList<Cuenta> misCuentas = new ArrayList<>();
       
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * from tblCuentas WHERE cliente_idCliente = ? AND estado = 'Activo'");
            pe.setInt(1, idCliente);
            ResultSet re = pe.executeQuery();        

            while(re.next()){
                cuenta = new Cuenta(re.getString("numeroCuenta"), re.getString("tipoCuenta"), re.getString("banco_sucursal"),
                re.getString("clabe"), re.getInt("cliente_idCliente"), re.getFloat("saldo"), re.getString("estado"));
                misCuentas.add(cuenta);
            }
                
            re.close();
            pe.close();
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return misCuentas;
    }
    
    public ArrayList<Cuenta> buscarCuentasE(int idCliente) throws SQLException{
        ArrayList<Cuenta> misCuentas = new ArrayList<>();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * from tblCuentas WHERE cliente_idCliente = ? AND estado = 'Activo'");
            pe.setInt(1, idCliente);
            ResultSet re = pe.executeQuery();        

            while(re.next()){
                cuenta = new Cuenta(re.getString("numeroCuenta"), re.getString("tipoCuenta"), re.getString("banco_sucursal"),
                re.getString("clabe"), re.getInt("cliente_idCliente"), re.getFloat("saldo"), re.getString("estado"));
                misCuentas.add(cuenta);
            }

            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return misCuentas;
    }
    
    public boolean existeId(String id){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblCuentas WHERE numeroCuenta = ?");
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
    
    public int contarCuentas(int idCliente){
        int num = 0;
        
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT COUNT(*) FROM tblCuentas WHERE cliente_idCliente = ? AND estado = 'Activo'");
            pe.setInt(1, idCliente);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
                num = re.getInt(1);
            }
            
            re.close();
            pe.close();
            con.close();
                        
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return num;
    }
    
    public ArrayList<EstadoCuenta> estadoCuenta(int idCliente, Date fecha, String numCuenta){
        EstadoCuenta estado = null;
        ArrayList<EstadoCuenta> estadoCuenta = new ArrayList<>();
        
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM FN_MOVIMIENTOS_MENSUALES(?,?,?)");
            pe.setInt(1, idCliente);
            pe.setDate(2, fecha);
            pe.setString(3, numCuenta);
            
            ResultSet re = pe.executeQuery();
            
            while(re.next()){
                estado = new EstadoCuenta(re.getInt(1), re.getString(2), re.getString(3), re.getFloat(4), re.getDate(5), re.getFloat(6), re.getString(7), re.getString(8), re.getString(9));
                estadoCuenta.add(estado);
            }
            
            re.close();
            pe.close();
            con.close();
                        
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return estadoCuenta;
    }
    
    public ArrayList<EstadoCuenta> estadoCuentaGeneral(int idCliente){
        EstadoCuenta estado = null;
        ArrayList<EstadoCuenta> estadoCuenta = new ArrayList<>();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM VW_ESTADO_CUENTA WHERE cliente_idCliente = ?");
            pe.setInt(1, idCliente);
            
            ResultSet re = pe.executeQuery();
            
            while(re.next()){
                estado = new EstadoCuenta(re.getInt(1), re.getString(2), re.getString(3), re.getFloat(4), re.getDate(5), re.getFloat(6), re.getString(7), re.getString(8), re.getString(9));
                estadoCuenta.add(estado);
            }
            
            re.close();
            pe.close();
            con.close();
                        
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return estadoCuenta;
    }
    
    public float saldo(String numCuenta){
        float saldo = 0;
        
        try {
            Connection con = new Conexion("Clientes", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT saldo FROM tblCuentas WHERE numeroCuenta = ?");
            pe.setString(1, numCuenta);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
                saldo = re.getFloat(1);
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return saldo;
    }
}
