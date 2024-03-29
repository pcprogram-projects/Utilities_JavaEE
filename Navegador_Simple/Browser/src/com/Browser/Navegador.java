package com.Browser;

import java.awt.BorderLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;


public class Navegador extends JFrame {

	public Navegador() {
		JPanel panelBrowser = new JPanel();
		panelBrowser.setLayout(new BorderLayout());
		final JWebBrowser navegador = new JWebBrowser();
		navegador.navigate("http://www.goolge.es");
		panelBrowser.add(navegador);
		add(panelBrowser);

	}

	public static void main(String[] args) {
		
		NativeInterface.open();
        
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				Navegador nav = new Navegador();
				nav.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				nav.setVisible(true);
                nav.setSize(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
			}
		});
	}

	}
