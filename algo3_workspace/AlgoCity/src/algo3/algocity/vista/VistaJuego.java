package algo3.algocity.vista;

import java.awt.Container;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import algo3.algocity.modelo.Coordenada;
import algo3.algocity.modelo.Juego;

public class VistaJuego extends JFrame implements Observer {

	private Juego juego;
	private Container contenedor;

	private static final long serialVersionUID = 6156376075508293279L;

	public VistaJuego(Juego juego) {
		this.juego = juego;
		this.juego.addObserver(this);
		this.setTitle("AlgoCity");
		contenedor = getContentPane();
		GridLayout layoutMapa = new GridLayout(
				juego.getMapa().obtenerTamanio(), juego.getMapa()
						.obtenerTamanio());
		contenedor.setLayout(layoutMapa);

		int at = 0;

		for (int x = 0; x < juego.getMapa().obtenerTamanio(); x++) {

			for (int y = 0; y < juego.getMapa().obtenerTamanio(); y++) {

				contenedor.add(new VistaHectarea(juego.getMapa()
						.obtenerHectarea(new Coordenada(x, y))), at);
				at++;
			}
		}

		this.inicializarVentana();
	}

	private void inicializarVentana() {

		this.setSize(800, 700);

		this.setLocation(8, 0);

		this.setVisible(true);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void update(){
		this.update(null, null);
	}
	
	@Override
	public void update(Observable o, Object arg) {

		int at = 0;
		for (int x = 0; x < juego.getMapa().obtenerTamanio(); x++) {

			for (int y = 0; y < juego.getMapa().obtenerTamanio(); y++) {
				((VistaHectarea) contenedor.getComponent(at)).updateVista();
				at++;
			}
		}

	}

}
