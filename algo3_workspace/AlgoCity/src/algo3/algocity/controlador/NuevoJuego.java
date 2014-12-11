package algo3.algocity.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import algo3.algocity.modelo.Juego;
import algo3.algocity.vista.VistaJuego;

public class NuevoJuego implements ActionListener {

	private Juego juego;
	private VistaJuego vista;
	
	public NuevoJuego(Juego juego, VistaJuego vista){
		this.juego = juego;
		this.vista = vista;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = JOptionPane.showInputDialog(null, "Nombre jugador: ",
				"Nuevo Juego", 1);

		// Este metodo tarda unos segundos hasta que refresca
		if (str != null){
			juego.setJugador(str);
			juego.reiniciar();
			vista.resetVista();
			vista.inicializarMapa();
			vista.update();
		}		
		

	}

}
