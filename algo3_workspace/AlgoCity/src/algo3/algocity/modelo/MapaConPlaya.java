package algo3.algocity.modelo;

public class MapaConPlaya implements IGeneradorDeMapa {
	
	private int tamanio;
	private Coordenada entradaALaCiudad;
	
	public MapaConPlaya(){
		this.tamanio = 25;
		this.entradaALaCiudad = new Coordenada(0,12);
	}
	
	public void generarArea(Hectarea[][] area) {
		
		for (int i=0; i < tamanio; i++){
			for (int j=0; j < tamanio; j++){
				if( j < 20){
					Terreno unTerreno = new Terreno();
					unTerreno.setUbicacion(new Coordenada(i,j));
					area[i][j] = unTerreno;
				}
				else{
					Agua unAgua = new Agua();
					unAgua.setUbicacion(new Coordenada(i,j));
					area[i][j] = unAgua;
				}
			}
		}
	}

	
	public int obtenerTamanio() {
		return tamanio;
	}


	@Override
	public Coordenada obtenerEntradaALaCiudad() {
		return entradaALaCiudad;
	}

}
