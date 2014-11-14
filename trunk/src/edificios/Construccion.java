package edificios;

public abstract class Construccion implements Construible{

	private int costo;
	
	public void cargarCosto(int costo){
		this.costo = costo;
	}
	
	public int obtenerCosto(){
		return costo;
	}

	
}
