package cl.model.dao;

import cl.model.db.Cliente;
import cl.model.db.CorreoCliente;
import cl.model.db.DireccionCliente;
import cl.model.db.TelefonoCliente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClienteDao {
    
    public void insertarCliente(Cliente cliente, CorreoCliente correoCliente,
    DireccionCliente direccionCliente, TelefonoCliente telefonoCliente){
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_CLIENTE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ");
            csta.setInt(1, cliente.getIdCliente());
            csta.setString(2, cliente.getNombre());
            csta.setString(3, cliente.getApellidoPaterno());
            csta.setString(4, cliente.getApellidoMaterno());
            csta.setString(5, cliente.getIne());
            csta.setString(6, cliente.getRfc());
            csta.setString(7, cliente.getCurp());
            csta.setString(8, cliente.getRegimenFiscal());
            csta.setDate(9, cliente.getFechaNacimiento());
            csta.setString(10, cliente.getGenero());
            csta.setString(11, cliente.getStatus());
            csta.setString(12, correoCliente.getCorreoCliente());
            csta.setString(13, direccionCliente.getCalle());
            csta.setString(14, direccionCliente.getNumInt());
            csta.setString(15, direccionCliente.getNumExt());
            csta.setString(16, direccionCliente.getColonia());
            csta.setString(17, direccionCliente.getCodigoPostal());
            csta.setString(18, telefonoCliente.getNumTelefonoCliente());
            csta.setString(19, telefonoCliente.getTipoTelefonoCliente());
            csta.execute();
            csta.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public boolean existeId(int id){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblCliente WHERE idCliente = ?");
            pe.setInt(1, id);
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
    
    public boolean buscarRFC(String rfc, int idCliente){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblCliente WHERE rfc = ?");
            pe.setString(1, rfc);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
               if(re.getInt("idCliente") != idCliente){
                   flag = true;
               }
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
    
    public boolean buscarCURP(String curp, int idCliente){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblCliente WHERE curp = ?");
            pe.setString(1, curp);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
               if(re.getInt("idCliente") != idCliente){
                   flag = true;
               }
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
}
