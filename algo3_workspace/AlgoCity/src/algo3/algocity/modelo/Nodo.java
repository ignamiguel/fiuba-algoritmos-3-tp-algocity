package algo3.algocity.modelo;

public class Nodo {

	private Coordenada coordenada;

	private int distancia;

	public Nodo(Coordenada h, int distancia){
		this.coordenada = h;
		this.distancia = distancia;
	}

	public Coordenada getCoordenada() {
		return this.coordenada;
	}
	
	public int getDistancia(){
		return this.distancia;
	} 

}
