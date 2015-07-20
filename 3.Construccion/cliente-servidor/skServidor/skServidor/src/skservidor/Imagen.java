/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package skservidor;

/**
 *
 * @author Jeison  Nisperuza
 */
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author cecil
 */
public class Imagen extends JButton
{
    public String imagen;

    public Imagen(String imagen,int x,int y)
    {
        this.setSize(x,y);
        this.imagen = imagen;
    }

    public void paint(Graphics g) {
     //vars:
      Dimension tamanio = getSize();
      try{
           ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/jcash/resources/"+imagen));
           g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
           setOpaque(false);
           super.paintComponent(g);
        }catch(Exception e){
            try{
              // buscar para modo edicion netbeans
                ImageIcon imagenFondo = new ImageIcon(System.getProperty("user.dir")+"\\src\\jcash\\resources\\"+imagen);
                g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);
                setOpaque(false);
                super.paintComponent(g);
            }catch(Exception ex){}
           //final de buscar para modo edicion netbeans
        }
    }
}
