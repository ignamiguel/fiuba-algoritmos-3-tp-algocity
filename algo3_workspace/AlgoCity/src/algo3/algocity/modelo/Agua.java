package algo3.algocity.modelo;

import java.util.ArrayList;

public class Agua extends Hectarea{

	private ArrayList servicios;
	
	public Agua(){
		
		servicios = new ArrayList();
		
	}
		
	public String obtenerNombre() {
		
		return "Agua";
	}


	public void agregarServicio(Conexiones unServicio) {
		
		servicios.add(unServicio);
		
	}

	
	public void quitarServicio(Conexiones unServicio) {
		
		servicios.remove(unServicio);
		
	}

	
	public boolean tieneElServicio(Conexiones unServicio) {

	return(servicios.contains(unServicio));
	}
	

}
