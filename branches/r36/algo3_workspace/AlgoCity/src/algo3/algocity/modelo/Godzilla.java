package algo3.algocity.modelo;

public class Godzilla {

	private Coordenada ubicacion;
	private ICaminable caminador;

	public Godzilla() {
		this.ubicacion = new Coordenada(3, 0);
	}

	public Coordenada obtenerCoordenada() {
		return ubicacion;
	}

	public void atacar(Mapa mapa) {

		this.ubicacion = new Coordenada(3, 0); // generar coordeanda aleatoria
		this.caminador = new CaminarDerecho(); // generar caminable aleatorio
		(this.caminador).caminarMapa(this,mapa);
		
	}

	public void caminarEnY() {
		(this.ubicacion).aumentarY(1);
	}

}
