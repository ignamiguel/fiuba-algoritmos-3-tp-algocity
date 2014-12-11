package algo3.algocity.modelo;

import java.util.Random;

public class CaminarZigZag implements ICaminable {

	@Override
	public void caminarMapa(Godzilla godzilla, Mapa mapa) {
		Hectarea hectarea;
		while ((godzilla.getCoordenada()).obtenerY() < mapa.getTamanio()) {
			
			hectarea = mapa.getHectarea(godzilla.getCoordenada());
			hectarea.afectarCon(godzilla);
			godzilla.avanzarEnY();
			godzilla.retrocederEnX();
			
			
			if((godzilla.getCoordenada()).obtenerY() < mapa.getTamanio()){
				hectarea = mapa.getHectarea(godzilla.getCoordenada());
				hectarea.afectarCon(godzilla);
				godzilla.avanzarEnY();
				godzilla.avanzarEnX();
			}
			
			if((godzilla.getCoordenada()).obtenerY() < mapa.getTamanio()){
				hectarea = mapa.getHectarea(godzilla.getCoordenada());
				hectarea.afectarCon(godzilla);
				godzilla.avanzarEnY();
				godzilla.avanzarEnX();
			}
			
			if((godzilla.getCoordenada()).obtenerY() < mapa.getTamanio()){
				hectarea = mapa.getHectarea(godzilla.getCoordenada());
				hectarea.afectarCon(godzilla);
				godzilla.avanzarEnY();
				godzilla.retrocederEnX();
			}
		}

	}

	public Coordenada generarCoordenadaAleatoria(Mapa mapa) {
		Random aleatorio = new Random();
		int coordX = 2 + aleatorio.nextInt(mapa.getTamanio() - 2);
		return new Coordenada(coordX,0);
	}
	
}
