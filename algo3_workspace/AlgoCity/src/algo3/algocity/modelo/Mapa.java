package algo3.algocity.modelo;

public class Mapa {

	private Hectarea area[][];
	private int tamanio;
	
	
	public Mapa(IGeneradorDeMapa generadorDeMapa){
		
		this.tamanio = generadorDeMapa.obtenerTamanio();
		area = new Hectarea[tamanio][tamanio];
		generadorDeMapa.generarArea(this.area);
		
	}
	
	public Hectarea obtenerHectarea(Coordenada coordenada) {
		
		return area[coordenada.obtenerX()][coordenada.obtenerY()];
	}
	
}
