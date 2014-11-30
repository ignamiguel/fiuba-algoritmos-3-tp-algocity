package algo3.algocity.modelo;

public class Juego {

	private Mapa mapa;

	public Juego() {
		this.mapa = new Mapa(new MapaConPlaya());
	}

	public String verMapa(Coordenada coordenada) {
		return this.mapa.obtenerHectarea(coordenada).obtenerNombre();		
	}

}
