package cl.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class PreguntasDao {
   public ArrayList pregunta(){
       ArrayList pregunta = new ArrayList();
       int idPregunta = new Random().nextInt(5) + 1;
       try {
           Connection con = new Conexion("Clientes", "123456").getCon();
           PreparedStatement pe = con.prepareStatement("SELECT pregunta FROM tblPreguntas WHERE idPregunta = ?");
           pe.setInt(1, idPregunta);
           
           ResultSet re = pe.executeQuery();
           
           if(re.next()){
               pregunta.add(idPregunta);
               pregunta.add(re.getString(1));
           }
           
           re.close();
           pe.close();
           con.close();
           
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       
       return pregunta;
   }
}
