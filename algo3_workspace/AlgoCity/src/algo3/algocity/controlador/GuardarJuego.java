package algo3.algocity.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import algo3.algocity.modelo.*;

public class GuardarJuego implements ActionListener {

	private Juego juego;

	public GuardarJuego(Juego juego) {
		this.juego = juego;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser saveFile = new JFileChooser();
		int result = saveFile.showSaveDialog(null);

		if (result == JFileChooser.CANCEL_OPTION)
			return;

		File file = saveFile.getSelectedFile();

		// Fuerzo a que la extension sea xml 
		file = new File(file.toString() + ".xml");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			juego.guardarPartida(file);
			//bw.write(juego.guardarPartida(file));
			bw.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "File Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
