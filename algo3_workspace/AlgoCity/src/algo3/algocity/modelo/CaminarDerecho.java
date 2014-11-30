package algo3.algocity.modelo;

public class CaminarDerecho implements ICaminable {

	@Override
	public void caminarMapa(Godzilla godzilla, Mapa mapa) {

		while ((godzilla.obtenerCoordenada()).obtenerY() < mapa.obtenerTamanio()) {
			(mapa.obtenerHectarea(godzilla.obtenerCoordenada())).afectarCon(godzilla);
			godzilla.caminarEnY();
		}

	}

}
