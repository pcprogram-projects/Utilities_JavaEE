
import java.io.File;
import java.util.ArrayList;
import javax.swing.JList;

public class AgregarCanciones {
    String agregarCanciones[];
    
    public AgregarCanciones(String agregarCanciones[],File archivo,ArrayList<String> datos,
            JList<String> jListAgregarCanciones){
       
        File RutaDirectorio= archivo;
        agregarCanciones=RutaDirectorio.list();
        
        for(String objeto :  agregarCanciones ){
           
            String extension=objeto.substring(objeto.length()-3, objeto.length());
            if(extension.equals("mp3")){
                datos.add(RutaDirectorio+"/"+objeto);
                
            }
        }
        agregarCanciones=new String[datos.size()];
        int x=0;
        for(String anade : datos){
            File file= new File(anade);
             agregarCanciones[x]=file.getName();
             x++;
        }
        jListAgregarCanciones.setListData(agregarCanciones);
        this.agregarCanciones= agregarCanciones;

    }
    public String[] agregaGet(){
        return agregarCanciones;
    }
    
}
