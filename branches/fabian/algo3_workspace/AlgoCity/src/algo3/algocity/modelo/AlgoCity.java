package algo3.algocity.modelo;

import algo3.algocity.vista.*;

public class AlgoCity {

	private Juego juego;
	
	public void iniciar() {
		this.inicializarModelo();

		this.crearVentana();
	}

	private void crearVentana() {
		VentanaInicio vJuego = new VentanaInicio(this.juego);
		vJuego.setVisible(true);
	}

	private void inicializarModelo() {
		this.juego = new Juego();
	}
	
	/* METODOS PARA INTERACTUAR CON EL JUEGO */
	
	public void construirResidencia(Coordenada coordenada) {
		Residencia r = new Residencia();
		juego.insertar(r, coordenada);
	}

}
