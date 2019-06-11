package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entidades.Editor;

public class VIstaEditor extends JFrame {

	private JPanel contentPane;
	private PanelAcciones panelAcciones;
	private PanelEdicion panelEdicion;
   private Editor editor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VIstaEditor frame = new VIstaEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VIstaEditor() {
		editor=new Editor();
		setTitle("Editor De Texto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panelAcciones = new PanelAcciones(this);
		contentPane.add(panelAcciones, BorderLayout.NORTH);
		
		panelEdicion = new PanelEdicion();
		contentPane.add(panelEdicion, BorderLayout.CENTER);
	}
 
	public void AbrirArchivo() {
		JFileChooser jfch=new JFileChooser();
		if(jfch.showOpenDialog(this)==JFileChooser.APPROVE_OPTION) {
			
			File fabrir=jfch.getSelectedFile();
			try {
				String contenido="";
				contenido = editor.AbrirArchivo(fabrir.getAbsolutePath());
				panelEdicion.RefreshContent(contenido);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this,e.getMessage(),"Editor de Archivos",JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	public void CrearArchivo() {
		editor.CrearArchivo();
		panelEdicion.RefreshContent("");
	}

	public void GuardarArchivo() {
		String ruta="";
		String content="";
		if(editor.ComprovarArchivo()) {
			JFileChooser jfch=new JFileChooser();
			if(jfch.showSaveDialog(this)==JFileChooser.APPROVE_OPTION) {
			 ruta=jfch.getSelectedFile().getAbsolutePath();
		    content=panelEdicion.DarContenido();
			
			}
		}try {
			editor.GuardarArchivo(content, ruta);
			JOptionPane.showMessageDialog(this,"Archivo guardado con exito","Editor de Archivos",JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage(),"Editor de Archivos",JOptionPane.ERROR_MESSAGE);
		}
	}

}
