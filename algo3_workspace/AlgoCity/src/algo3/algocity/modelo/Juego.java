package algo3.algocity.modelo;

import java.util.ArrayList;

public class Juego {

	private Mapa mapa;

	private ArrayList<Edificio> edificios;

	private ArrayList<CentralElectrica> centrales;

	private ArrayList<PozoDeAgua> pozos;

	public Juego() {
		this.mapa = new Mapa(new MapaConPlaya());
	}

	public String verMapa(Coordenada coordenada) {
		return this.mapa.obtenerHectarea(coordenada).obtenerNombre();
	}

	private boolean construir(Construccion construccion, Coordenada coordenada) {

		return this.mapa.construir(construccion, coordenada);

	}

	public boolean insertar(Edificio edificio, Coordenada coordenada) {
		if (!this.construir(edificio, coordenada)) {

			return false;
		}

		// TODO: agregar la coordenada a la lista
		this.edificios.add(edificio);
		return true;
	}

	public boolean insertar(CentralElectrica central, Coordenada coordenada) {
		if (!this.construir(central, coordenada)) {
			return false;
		}

		this.centrales.add(central);
		return true;

	}

	public boolean insertar(PozoDeAgua pozo, Coordenada coordenada) {
		if (!this.construir(pozo, coordenada)) {
			return false;
		}

		this.pozos.add(pozo);
		return true;
	}

}
