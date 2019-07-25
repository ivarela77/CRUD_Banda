package principal;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ivi
 */
public class Instrumento {
    
    private int idinstrumento;
    private String nombre;
    private String descripcion;
    private Musico musico;

    public Instrumento() {
    }

    public Instrumento(int idinstrumento, String nombre, String descripcion, Musico musico) {
        this.idinstrumento = idinstrumento;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.musico = musico;
    }

    public int getIdinstrumento() {
        return idinstrumento;
    }

    public void setIdinstrumento(int idinstrumento) {
        this.idinstrumento = idinstrumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Musico getMusico() {
        return musico;
    }

    public void setMusico(Musico musico) {
        this.musico = musico;
    }
    
    public void aniadirInstrumento(String nombre, String descripcion, int id, String consulta){
        PreparedStatement ps;
        try {
            ps = Principal.miConexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setInt(3, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Instrumento añadido correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error añadiendo el instrumento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void modificarInstrumento(String nombre, String descripcion,int idi,int idm){
        PreparedStatement ps;
        String consulta="UPDATE instrumento SET nombre=?, descripcion=?, idmusico=? WHERE idinstrumento=?";
        try {
            ps = Principal.miConexion.prepareStatement(consulta);
            ps.setString(1, nombre);
            ps.setString(2, descripcion);
            ps.setInt(3, idm);
            ps.setInt(4, idi);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Instrumento modificado correctamente.", "información", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error modificando el instrumento.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}
