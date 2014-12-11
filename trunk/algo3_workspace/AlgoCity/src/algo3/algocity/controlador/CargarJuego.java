package algo3.algocity.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import algo3.algocity.modelo.Juego;


public class CargarJuego implements ActionListener{

	private Juego juego;
	
	public CargarJuego(Juego juego){
		this.juego = juego;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser loadFile = new JFileChooser();
		int result = loadFile.showOpenDialog(null);

		if (result == JFileChooser.CANCEL_OPTION)
			return;

		File file = loadFile.getSelectedFile();
		
		this.juego.cargarPartida(file);
	}

}
