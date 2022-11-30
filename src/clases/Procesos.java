package clases;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Procesos {
    
    public void cargarArchivoM(String codigo){
        String file = "C:\\Users\\baloc\\OneDrive\\Documentos\\NetBeansProjects\\SISBAN\\src\\estadoCuenta\\" + codigo + ".pdf";
        
        try {
            File objetofile = new File (file);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void cargarArchivoG(String codigo){
        String file = "C:\\Users\\baloc\\OneDrive\\Documentos\\NetBeansProjects\\SISBAN\\src\\estadoCuentaGeneral\\" + codigo + ".pdf";
        
        try {
            File objetofile = new File (file);
            Desktop.getDesktop().open(objetofile);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
