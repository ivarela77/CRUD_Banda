package recursos;

/**
 *
 * @author IvI
 */
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
 
public class MyIcon implements Icon{
 
    private String ruta;
    
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Image image = new ImageIcon(getClass().getResource(ruta)).getImage();
        g.drawImage(image, x, y, c);
    }
 
    @Override
    public int getIconWidth() {
        return 64;
    }
 
    @Override
    public int getIconHeight() {
        return 64;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
 
    
}