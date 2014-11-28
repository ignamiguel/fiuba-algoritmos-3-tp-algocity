package algo3.algocity.modelo;
// la uso para testear la creacion de lineas de tension en mapa, provisoria ,Pablo
public class ClasePruebaParaGenerarMapa implements IGeneradorDeMapa {

	private int tamanio;
	
	public ClasePruebaParaGenerarMapa(){
		
		tamanio=5;
	}
	

	public void generarArea(Hectarea[][] area) {
		
		Terreno unTerreno = new Terreno();
		
		for(int x = 0; x< tamanio; x++ ){
			
			for(int y = 0; y< tamanio; y++ ){
				
				area[x][y] = unTerreno;
					
			}
		}
				
		
		
	}
	public int obtenerTamanio() {
		
		return tamanio;
	}

}
