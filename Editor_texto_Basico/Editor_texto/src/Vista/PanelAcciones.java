package Vista;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class PanelAcciones extends JPanel implements ActionListener{
	
	public static final String CREAR="CREAR";
	public static final String ABRIR="ABRIR";
	public static final String GUARDAR="GUARDAR";
	
	private JButton btnAbrir;
	private JButton btnCrear;
	private JButton btnGuardar;
    private  VIstaEditor vista;
	
	public PanelAcciones( VIstaEditor vista) {
		this();
		this.vista=vista;
	}
	
	
	
	public PanelAcciones() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new GridLayout(1, 0, 0, 0));
		
		btnAbrir = new JButton("Abrir Archivo");
		btnAbrir.setActionCommand(ABRIR);
		btnAbrir.addActionListener(this);
		add(btnAbrir);
		
		btnCrear = new JButton("Crear Archivo");
		btnCrear.setActionCommand(CREAR);
		btnCrear.addActionListener(this);
		add(btnCrear);
		
		btnGuardar = new JButton("Guardar Archivo");
		btnGuardar.setActionCommand(GUARDAR);
		btnGuardar.addActionListener(this);
		add(btnGuardar);

	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getActionCommand().equals(ABRIR)) {
          vista.AbrirArchivo();
		} else if (evento.getActionCommand().equals(CREAR)) {
           vista.CrearArchivo();
		} else if (evento.getActionCommand().equals(GUARDAR)) {
			vista.GuardarArchivo();
		}
	}
}
