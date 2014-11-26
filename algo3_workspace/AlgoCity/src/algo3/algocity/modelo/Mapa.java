package algo3.algocity.modelo;

public class Mapa {

	private Hectarea area[][];
	
	
	public Mapa(){
		
		//Modifique la creacion para que tenga agua depues de la columna 20
		this.area = new Hectarea[25][25];
			
		for (int i=0; i < area.length; i++){
			for (int j=0; j < area[i].length; j++){
				if(j<20){
					area[i][j] = new Terreno();
				}
				else{
					area[i][j] = new Agua();
				}
			}
		}
	}
	
	public Hectarea obtenerHectarea(Coordenada coordenada) {
		
		return area[coordenada.obtenerX()][coordenada.obtenerY()];
	}
	
}
