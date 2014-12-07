package algo3.algocity.controlador;

import java.util.Observable;
import java.util.Observer;

import algo3.algocity.modelo.Juego;
import algo3.algocity.vista.EstadoJuego;

public class ControladorEstadoJuego implements Observer {

	private EstadoJuego estadoJuego;

	public ControladorEstadoJuego(EstadoJuego estadoJuego) {
		this.estadoJuego = estadoJuego;
	}

	@Override
	public void update(Observable observable, Object arg) {
		Juego juego = (Juego) observable;
		estadoJuego.actualizarDia(juego.obtenerTurno());
		estadoJuego.actualizarDinero(juego.verDinero());
		estadoJuego.actualizarJugador("Pepito");
		estadoJuego.actualizarPoblacion(juego.obtenerHabitantes());
	}

	public EstadoJuego getEstadoJuego() {
		return estadoJuego;
	}

}
