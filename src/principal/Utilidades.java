package principal;

import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ivi
 */
public class Utilidades {

    public static boolean ComprobarString(String texto){
        boolean resultado=true;
        if(texto.isEmpty()){
            resultado=false;
        }
        return resultado;  
    }
    
    public static boolean ComprobarUserPass(String texto){
        boolean resultado=true;
        if((texto.isEmpty())||(texto.equals("Usuario"))||(texto.equals("Contraseña"))){
            resultado=false;
        }
        return resultado;  
    }
    
    public static void filtrarPorApellido(String nombre){

        try {
            Statement misentencia=Principal.miConexion.createStatement();
            String consulta="SELECT * FROM musico WHERE apellidos LIKE '%"+nombre+"%'";
            misentencia.executeQuery(consulta);
            
            ConexionBD conexion=new ConexionBD();
            conexion.resultadoEnTabla(consulta);
        } catch (SQLException ex) {
            System.out.println("ERROR Statement");
        }
    }
    
        public static void filtrarPorNombre(String nombre){

            try {
                Statement misentencia=Principal.miConexion.createStatement();
                String consulta="SELECT * FROM instrumento WHERE nombre LIKE '%"+nombre+"%'";
                misentencia.executeQuery(consulta);

                ConexionBD conexion=new ConexionBD();
                conexion.resultadoEnTabla(consulta);
            } catch (SQLException ex) {
                System.out.println("ERROR Statement");
            }
    }
    
    public static void eliminar(int id, String consulta){

        try {
            Statement misentencia=Principal.miConexion.createStatement();
            misentencia.executeUpdate(consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Para eliminar un Músico hay que \neliminar sus instrumentos primero", "información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}