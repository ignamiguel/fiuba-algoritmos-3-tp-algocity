package algo3.algocity.modelo;

public class Godzilla {
	
	private Coordenada ubicacion;
	
	public Godzilla(){
		this.ubicacion = new Coordenada(0,0);
	}

	public Coordenada obtenerCoordenada() {
		return ubicacion;
	}
}
