package algo3.algocity.modelo;

import java.util.ArrayList;

public class Mapa {

	private Hectarea area[][];
	private int tamanio;
	// para hacer el refresh de cada turno recorre la lista y le dice a cada
	// linea actualizate,Pablo
	private ArrayList<LineaDeTension> lineasDelMapa;

	public Mapa(IGeneradorDeMapa generadorDeMapa) {


		this.tamanio = generadorDeMapa.obtenerTamanio();
		area = new Hectarea[tamanio][tamanio];
		generadorDeMapa.generarArea(this.area);

		lineasDelMapa = new ArrayList<LineaDeTension>();

	}

	public Hectarea obtenerHectarea(Coordenada coordenada) {

		return area[coordenada.obtenerX()][coordenada.obtenerY()];
	}

	public Hectarea obtenerHectarea(int coorX, int coorY) {
		return area[coorX][coorY];
	}

	public void crearTuberia(Coordenada coordenada) {
		Tuberia tuberia = new Tuberia();
		Hectarea hectarea = this.obtenerHectarea(coordenada);
		if (!(hectarea.tieneServicio(tuberia))) {
			Coordenada coordenadaAux = new Coordenada(coordenada.obtenerX(),
					coordenada.obtenerY());
			coordenadaAux.aumentarX(1);
			if ((this.estaEnElMapaCoordenada(coordenadaAux))
					&& (this.obtenerHectarea(coordenadaAux)
							.tieneServicio(tuberia)))
				hectarea.agregarServicio(tuberia);
			coordenadaAux.disminuirX(2);
			if ((this.estaEnElMapaCoordenada(coordenadaAux))
					&& (this.obtenerHectarea(coordenadaAux)
							.tieneServicio(tuberia)))
				hectarea.agregarServicio(tuberia);
			coordenadaAux.aumentarX(1);
			coordenadaAux.aumentarY(1);
			if ((this.estaEnElMapaCoordenada(coordenadaAux))
					&& (this.obtenerHectarea(coordenadaAux)
							.tieneServicio(tuberia)))
				hectarea.agregarServicio(tuberia);
			coordenadaAux.disminuirY(2);
			if ((this.estaEnElMapaCoordenada(coordenadaAux))
					&& (this.obtenerHectarea(coordenadaAux)
							.tieneServicio(tuberia)))
				hectarea.agregarServicio(tuberia);
		}

	}

	public boolean construir(Construccion construccion, Coordenada coordenada) {
		Hectarea hectarea = this.obtenerHectarea(coordenada);
		return hectarea.construir(construccion);
	}

	public void crearLineaDeTensionDesdeHasta(Coordenada coordenada,
			Coordenada coordenada2) {

		LineaDeTension unaLinea = new LineaDeTension();

		this.lineasDelMapa.add(unaLinea);

		for (int x = (coordenada.obtenerX()); x <= (coordenada2.obtenerX()); x++) {

			for (int y = (coordenada.obtenerY()); y <= (coordenada2.obtenerY()); y++) {

				(area[x][y]).agregarServicio(unaLinea);

			}
		}

	}

	public boolean estaEnElMapaCoordenada(Coordenada coord) {
		int coorX = coord.obtenerX();
		int coorY = coord.obtenerY();
		if ((coorX >= 0) & (coorX < tamanio) & (coorY >= 0) & (coorY < tamanio))
			return true;
		else
			return false;
	}

	public int obtenerTamanio() {
		return this.tamanio;
	}

}
