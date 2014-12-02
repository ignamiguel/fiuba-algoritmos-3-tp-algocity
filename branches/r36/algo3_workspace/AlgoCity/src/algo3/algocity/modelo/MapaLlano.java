package algo3.algocity.modelo;

public class MapaLlano implements IGeneradorDeMapa{
	private int tamanio;
	
	public MapaLlano(){
		this.tamanio = 25;
	}
	
	public void generarArea(Hectarea area[][]){
		
		for (int i=0; i < tamanio; i++){
			for (int j=0; j < tamanio; j++){
				Terreno unTerreno = new Terreno();
				unTerreno.guardarUbicacion(new Coordenada(i,j));
				area[i][j] = unTerreno;
			}
		}
	}

	public int obtenerTamanio() {
		return tamanio;
	}
}
