package cl.model.dao;


import cl.model.db.CorreoEmpleado;
import cl.model.db.DireccionEmpleados;
import cl.model.db.Empleado;
import cl.model.db.TelefonoEmpleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpleadoDao {
    public void insertarEmpleado(Empleado empleado, CorreoEmpleado correoEmpleado,
            DireccionEmpleados direccionEmpleado, TelefonoEmpleado telefonoEmpleado){
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_EMPLEADO (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ");

            csta.setString(1, empleado.getNombre());
            csta.setString(2, empleado.getApellidoPaterno());
            csta.setString(3, empleado.getApellidoMaterno());
            csta.setString(4, empleado.getPuesto());
            csta.setString(5, empleado.getNss());
            csta.setString(6, empleado.getRfc());
            csta.setString(7, empleado.getCurp());
            csta.setDate(8, empleado.getFechaIngreso());
            csta.setString(9, empleado.getBanco_sucursal());
            csta.setDate(10, empleado.getFechaNacimiento());
            csta.setString(11, empleado.getGenero());
            csta.setString(12, correoEmpleado.getCorreoEmpleado());
            csta.setInt(13, empleado.getIdEmpleado());
            csta.setString(14, direccionEmpleado.getCalle());
            csta.setString(15, direccionEmpleado.getNumInt());
            csta.setString(16, direccionEmpleado.getNumExt());
            csta.setString(17, direccionEmpleado.getColonia());
            csta.setString(18, direccionEmpleado.getCodigoPostal());
            csta.setString(19, telefonoEmpleado.getNumTelefonoEmpleado());
            csta.setString(20, telefonoEmpleado.getTipoTelefono());
            csta.setDate(21, empleado.getFechaTerminacion());
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
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblEmpleado WHERE idEmpleado = ?");
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
    
    public int contarEmpleados(){
        int nuevo = 0;
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT COUNT(*) FROM tblEmpleado");
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
                nuevo = re.getInt(1);
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return nuevo;
    }
    
    public ArrayList<Empleado> listaEmpleado(){
        Empleado empleados = null;
        ArrayList<Empleado> empleado = new ArrayList<>();
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT idEmpleado, nombre, apellidoPaterno, apellidoMaterno FROM tblEmpleado WHERE fechaTerminacion IS NULL");
            ResultSet re = pe.executeQuery();
            
            while(re.next()){
                empleados = new Empleado(re.getInt("idEmpleado"), re.getString("nombre"), re.getString("apellidoPaterno"), re.getString("apellidoMaterno"));
                empleado.add(empleados);
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return empleado;
    }
    
    public boolean buscarRFC(String rfc, int idEmpleado){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblEmpleado WHERE rfc = ?");
            pe.setString(1, rfc);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
               if(re.getInt("idEmpleado") != idEmpleado){
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
    
    public boolean buscarCURP(String curp, int idEmpleado){
        boolean flag = false;
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblEmpleado WHERE curp = ?");
            pe.setString(1, curp);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
               if(re.getInt("idEmpleado") != idEmpleado){
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
