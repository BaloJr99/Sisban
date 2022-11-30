package cl.model.dao;

import cl.model.db.Beneficiario;
import cl.model.db.CorreoBeneficiario;
import cl.model.db.DireccionBeneficiario;
import cl.model.db.TelefonoBeneficiario;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class BeneficiarioDao {
    
    public void insertarBeneficiario(Beneficiario beneficiario, CorreoBeneficiario correoBeneficiario,
            DireccionBeneficiario direccionBeneficiario, TelefonoBeneficiario telefonoBeneficiario){
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            CallableStatement csta = con.prepareCall("{CALL SP_INSERTAR_BENEFICIARIO (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ");
            csta.setInt(1, beneficiario.getIdBeneficiario());
            csta.setInt(2, beneficiario.getCliente_idCliente());
            csta.setString(3, beneficiario.getNombre());
            csta.setString(4, beneficiario.getApellidoPaterno());
            csta.setString(5, beneficiario.getApellidoMaterno());
            csta.setString(6, beneficiario.getIne());
            csta.setString(7, beneficiario.getParentesco());
            csta.setDate(8, beneficiario.getFechaNacimiento());
            csta.setString(9, beneficiario.getGenero());
            csta.setString(10, correoBeneficiario.getCorreoBeneficiario());
            csta.setString(11, direccionBeneficiario.getCalle());
            csta.setString(12, direccionBeneficiario.getNumInt());
            csta.setString(13, direccionBeneficiario.getNumExt());
            csta.setString(14, direccionBeneficiario.getColonia());
            csta.setString(15, direccionBeneficiario.getCodigoPostal());
            csta.setString(16, telefonoBeneficiario.getNumTelefonoBeneficiario());
            csta.setString(17, telefonoBeneficiario.getTipoTelefonoBeneficiario());
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
            PreparedStatement pe = con.prepareStatement("SELECT * FROM tblBeneficiarios WHERE idBeneficiario = ?");
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
    
    public boolean buscarBeneficiario(int idCliente){
        boolean flag = false;
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT TOP 1 * FROM tblBeneficiarios WHERE cliente_idCliente = ? ORDER BY idBeneficiario DESC");
            pe.setInt(1, idCliente);
            ResultSet re = pe.executeQuery();
            
            if(re.next()){
                flag = true;
            }
            
            re.close();
            pe.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return flag;
    }
    
    public Beneficiario buscarDatosBeneficiario(int idCliente){
        Beneficiario beneficiario = null;
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            CallableStatement csta = con.prepareCall("{CALL SP_BUSCAR_BENEFICIARIO (?)}");
            csta.setInt(1, idCliente);
            ResultSet re = csta.executeQuery();
            
            if(re.next()){
                beneficiario = new Beneficiario(re.getInt("idBeneficiario"), re.getString("parentesco"), re.getString("nombre"),
                re.getString("apellidoPaterno"), re.getString("apellidoMaterno"), re.getString("genero"), re.getString("ine"),
                re.getDate("fechaNacimiento"));
            }
            
            re.close();
            csta.close();
            con.close();
            
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null, se.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        return beneficiario;
    }
    
    public int contarBeneficiarios(){
        int nuevo = 0;
        
        try {
            Connection con = new Conexion("Ejecutivos", "123456").getCon();
            PreparedStatement pe = con.prepareStatement("SELECT COUNT(*) FROM tblBeneficiarios");
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
}
