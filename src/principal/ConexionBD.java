package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ivi
 */
public class ConexionBD {
    
    private Connection conexion;

    public ConexionBD() {
    }
    
    
    public ConexionBD(String PC, String usuario, String password, String db) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://"+PC+"/"+db+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",usuario,password);
        }catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Error de Driver!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            System.out.println(ex.getErrorCode());
            if(ex.getErrorCode()==1045){
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Servidor no encontrado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
  
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public void resultadoEnTabla (String consulta){
        try {
            Statement sentencia=Principal.miConexion.createStatement();
            ResultSet rs=sentencia.executeQuery(consulta);
            ResultSetMetaData metaDatos=rs.getMetaData();

            for (int i=Principal.modelo.getRowCount()-1;i>=0;i--){
                Principal.modelo.removeRow(i);
            }
            
            int numColumnas=metaDatos.getColumnCount(); 
            Object[] etiquetas=new Object[numColumnas];
             
            for(int i=0;i<numColumnas;i++){
                etiquetas[i]=metaDatos.getColumnLabel(i+1);
            }
            Principal.modelo.setColumnIdentifiers(etiquetas);
            
            while(rs.next()){
                Object[] datosFila=new Object[Principal.modelo.getColumnCount()];
                
                for(int i=0;i<Principal.modelo.getColumnCount();i++){
                    datosFila[i]=rs.getObject(i+1);   
                }
                Principal.modelo.addRow(datosFila);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
}
