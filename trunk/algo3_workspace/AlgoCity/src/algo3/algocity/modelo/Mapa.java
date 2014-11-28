package algo3.algocity.modelo;

import java.util.ArrayList;

public class Mapa {

	private Hectarea area[][];
	private int tamanio;
	// para hacer el refresh de cada turno recorre la lista y le dice a cada linea actualizate,Pablo
	private ArrayList<LineaDeTension> lineasDelMapa; 
	
	public Mapa(IGeneradorDeMapa generadorDeMapa){
		
		this.tamanio = generadorDeMapa.obtenerTamanio();
		area = new Hectarea[tamanio][tamanio];
		generadorDeMapa.generarArea(this.area);
		
		lineasDelMapa = new ArrayList<LineaDeTension>();
		
	}
	
	public Hectarea obtenerHectarea(Coordenada coordenada) {
		
		return area[coordenada.obtenerX()][coordenada.obtenerY()];
	}

	public void crearLineaDeTensionDesdeHasta(Coordenada coordenada,
			Coordenada coordenada2) {
		
		LineaDeTension unaLinea = new LineaDeTension();
		
		this.lineasDelMapa.add(unaLinea);
		
		for(int x = (coordenada.obtenerX()); x<= (coordenada2.obtenerX()); x++ ){
			
			for(int y = (coordenada.obtenerY()); y<= (coordenada2.obtenerY()); y++ ){
				
				(area[x][y]).agregarServicio(unaLinea);
					
			}
		}
		
	}
	
}
