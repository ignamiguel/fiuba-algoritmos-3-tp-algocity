package algo3.algocity.modelo;

import java.util.Random;

public class CaminarDerecho implements ICaminable {

	@Override
	public void caminarMapa(Godzilla godzilla, Mapa mapa) {

		while ((godzilla.obtenerCoordenada()).obtenerY() < mapa.getTamanio()) {
			Hectarea hectarea = mapa.getHectarea(godzilla.obtenerCoordenada());
			hectarea.afectarCon(godzilla);
			godzilla.avanzarEnY();
		}

	}

	public Coordenada generarCoordenadaAleatoria(Mapa mapa) {
		Random aleatorio = new Random();
		int coordX = aleatorio.nextInt(mapa.getTamanio());
		return new Coordenada(coordX,0);
	}

}
