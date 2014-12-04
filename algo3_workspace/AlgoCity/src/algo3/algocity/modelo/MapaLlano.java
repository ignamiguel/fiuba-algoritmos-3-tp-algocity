package algo3.algocity.modelo;

public class MapaLlano implements IGeneradorDeMapa{
	private int tamanio;
	private Coordenada entradaALaCiudad;
	
	public MapaLlano(){
		this.tamanio = 25;
		entradaALaCiudad = new Coordenada(0,12);
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

	@Override
	public Coordenada obtenerEntradaALaCiudad() {
		return entradaALaCiudad;
	}
}
