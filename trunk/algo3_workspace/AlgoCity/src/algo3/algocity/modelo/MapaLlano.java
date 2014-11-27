package algo3.algocity.modelo;

public class MapaLlano implements IGeneradorDeMapa{
	private int tamanio;
	
	public MapaLlano(){
		this.tamanio = 25;
	}
	
	public void generarArea(Hectarea area[][]){
		
		for (int i=0; i < tamanio; i++){
			for (int j=0; j < tamanio; j++){
					area[i][j] = new Terreno();
			}
		}
	}

	public int obtenerTamanio() {
		return tamanio;
	}
}
