package algo3.algocity.modelo;

import java.util.ArrayList;

public class Terreno extends Hectarea{
	
	private ArrayList servicios;
	
	public String obtenerNombre(){
		return "Terreno";
	}

// Esta comentado porque no me funcionaban los tests
/* 
	public void agregarServicio(Conexiones unServicio) {

		servicios.add(unServicio);
		
	}

	
	public void quitarServicio(Conexiones unServicio) {

		servicios.remove(unServicio);
		
	}

	
	public boolean tieneElServicio(Conexiones unServicio) {
		
	return(servicios.contains(unServicio));
	}*/
	
}
