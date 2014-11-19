package algo3.algocity.modelo;

public class Mapa {

	private Hectarea area[][];
	
	
	public Mapa(){
		
		this.area = new Hectarea[10][10];
			
		for (int i=0; i < area.length; i++){
			for (int j=0; j < area[i].length; j++){
				area[i][j] = new Terreno();
			}
		}
	}
	
	public Hectarea obtenerHectarea(Coordenada coordenada) {
		
		return area[0][0];
	}
	
}
