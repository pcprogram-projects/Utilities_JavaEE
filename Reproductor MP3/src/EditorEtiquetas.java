import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldDataInvalidException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.KeyNotFoundException;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;

public class EditorEtiquetas {
    AudioFile file;
    Tag tag;
    JList<String> jListAgregarCanciones;
    ArrayList<String> datos;
    public EditorEtiquetas(JLabel jLabelTitulo,JLabel jLabelGenero,JLabel jLabelComentario,JLabel jLabelGrupo,JLabel jLabelFecha,
            JLabel jLabelAlbum,JList<String> jListAgregarCanciones,ArrayList<String> datos){
        
        this.jListAgregarCanciones=jListAgregarCanciones;
        this.datos=datos;
        
        labelsEdits(jLabelTitulo,"Titulo",FieldKey.TITLE);
        labelsEdits(jLabelGenero,"Genero",FieldKey.GENRE);
        labelsEdits(jLabelComentario,"Comentario",FieldKey.COMMENT);
        labelsEdits(jLabelGrupo,"Grupo",FieldKey.ARTIST);
        labelsEdits(jLabelFecha,"Año",FieldKey.YEAR);
        labelsEdits(jLabelAlbum,"Album",FieldKey.ALBUM);
    }
    public void labelsEdits(JLabel label,String texto, FieldKey filedKey){
        
          
        label.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e){
            
            int indice= jListAgregarCanciones.getSelectedIndex();
            if(indice != -1){
                String cancion=datos.get(indice);
                
                try{
                    file=AudioFileIO.read(new File(cancion));
                    
                }catch(CannotReadException| IOException|TagException|ReadOnlyFileException|
                        InvalidAudioFrameException er){
                    er.printStackTrace();
                }
                tag=file.getTag();
                if(tag!=null){
                    String data=JOptionPane.showInputDialog("introduce el nuevo"+texto);
                    if(data!=null){
                        try{
                           tag.setField(filedKey, data);
                           AudioFileIO.write(file);
                           label.setText(texto +data);
                        }catch(CannotWriteException|  KeyNotFoundException| FieldDataInvalidException e1){
                          e1.printStackTrace();
                        }
                    }
                }
            }   
                }
            });
        
        
    }
    
    
    
    
}
