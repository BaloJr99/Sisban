package cl.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private String bd = "DB_PROYECTO";
    //private String url="jdbc:sqlserver://DESKTOP-CZENIA\\SQLSERVER268:1433;databaseName="+bd;
    private String url = "jdbc:sqlserver://BALOJR999\\SQLSERVER267:1433;databaseName=" + bd;
    
    private Connection con = null;

    public Conexion(String user, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.con = (Connection)DriverManager.getConnection(url, user, password);
            System.out.println("Conexion a la base de datos: " + url + " ...ok");
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public Connection getCon(){
        return con;
    }
    
    public void setCon(Connection con){
        this.con = con;
    }
}
