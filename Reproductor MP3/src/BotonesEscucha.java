import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class BotonesEscucha {
    
    
    public void BotonesIco(String Ruta, JButton boton){
        try{
           boton.setIcon(new ImageIcon(getClass().getResource("Botones/"+Ruta)));
        }catch(NullPointerException e){
            
            e.printStackTrace();
            
        }
    }
       
    public BotonesEscucha(JButton boton,String archivo1,String archivo2){
        
        boton.addMouseListener(new MouseAdapter(){
          @Override
            public void mouseEntered(MouseEvent e){
               BotonesIco(archivo1, boton);
           }
            @Override
             public void mouseExited(MouseEvent e){
                  BotonesIco(archivo2, boton);
             }
        });
    }
    }

