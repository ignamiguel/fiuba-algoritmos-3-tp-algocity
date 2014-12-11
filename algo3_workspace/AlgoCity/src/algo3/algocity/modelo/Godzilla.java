package algo3.algocity.modelo;



public class Godzilla {

	private Coordenada ubicacion;
	private ICaminable caminador;

	public Godzilla() {
	
	}

	public Coordenada getCoordenada() {
		return ubicacion;
	}

	public void avanzarEnY() {
		(this.ubicacion).aumentarY(1);
	}

	public void retrocederEnX() {
		(this.ubicacion).disminuirX(1);

	}

	public void avanzarEnX() {
		(this.ubicacion).aumentarX(1);

	}

	public void atacar(Mapa mapa, IAtaqueGodzilla ataqueGodzilla) {
		this.ubicacion = ataqueGodzilla.getUbicacion();
		this.caminador = ataqueGodzilla.getCaminador();
		(this.caminador).caminarMapa(this, mapa);

	}

}
