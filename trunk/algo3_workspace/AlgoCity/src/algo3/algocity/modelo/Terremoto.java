package algo3.algocity.modelo;

public class Terremoto {

	private int danio;
	
	public Terremoto(){
	
		this.danio = 100;
		
	}
	
	//Solo para Tests previos a la propagacion del terremoto
	public void cargarDanio(int danio){
		this.danio = danio;
	}
	
	public int obtenerDanio(){
		return this.danio;
	}
}
