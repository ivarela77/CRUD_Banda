package principal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ivi
 */
public class Musico {
    
    private int idmusico;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String fechaNacmiento;
    
    public Musico(){
        
    }

    public Musico(int idmusico, String nombre, String apellidos, String direccion, String fechaNacmiento) {
        this.idmusico = idmusico;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaNacmiento = fechaNacmiento;
    }

    public int getIdmusico() {
        return idmusico;
    }

    public void setIdmusico(int idmusico) {
        this.idmusico = idmusico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNacmiento() {
        return fechaNacmiento;
    }

    public void setFechaNacmiento(String fechaNacmiento) {
        this.fechaNacmiento = fechaNacmiento;
    }
    
    public void aniadirMusico(String nombre, String apellidos, String direccion, java.sql.Date fecha, String consulta){
        PreparedStatement ps;
        try {
            ps = Principal.miConexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, direccion);
            ps.setDate(4, fecha);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Músico añadido correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error añadiendo músico.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificarMusico(String nombre, String apellidos, String direccion, java.sql.Date fecha, int id){
            PreparedStatement ps;
            String consulta="UPDATE musico SET nombre=?, apellidos=?, direccion=?, fecha_nac=? WHERE idmusico=?";
        try {
            ps = Principal.miConexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, apellidos);
            ps.setString(3, direccion);
            ps.setDate(4, fecha);
            ps.setInt(5, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Músico modificado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modificando el músico.", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
