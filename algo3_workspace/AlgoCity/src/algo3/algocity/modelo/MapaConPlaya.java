package algo3.algocity.modelo;

public class MapaConPlaya implements IGeneradorDeMapa {
	
	private int tamanio;
	
	
	public MapaConPlaya(){
		this.tamanio = 25;
	}
	
	public void generarArea(Hectarea[][] area) {
		
		for (int i=0; i < tamanio; i++){
			for (int j=0; j < tamanio; j++){
				if( j < 20){
					area[i][j] = new Terreno();
				}
				else{
					area[i][j] = new Agua();
				}
			}
		}

	}

	
	public int obtenerTamanio() {
		return tamanio;
	}

}
