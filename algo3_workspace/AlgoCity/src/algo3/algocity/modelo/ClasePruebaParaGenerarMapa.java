package algo3.algocity.modelo;

//la uso para testear la creacion de lineas de tension en mapa, provisoria ,Pablo
public class ClasePruebaParaGenerarMapa implements IGeneradorDeMapa {

	private int tamanio;
	
	public ClasePruebaParaGenerarMapa(){
		
		tamanio=5;
	}
	

	public void generarArea(Hectarea[][] area) {
		
		for (int i=0; i < tamanio; i++){
			for (int j=0; j < tamanio; j++){
				
					area[i][j] = new Terreno();
			}
		}
	
	area[0][tamanio / 2] = new EntradaALaCiudad();
				
		
		
	}
	public int obtenerTamanio() {
		
		return tamanio;
	}

}
