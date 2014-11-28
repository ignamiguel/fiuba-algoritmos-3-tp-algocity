package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Terreno extends Hectarea{
	
	private ArrayList servicios;
	
	public Terreno(){
		
		servicios = new ArrayList();
	}
	
	public String obtenerNombre(){
		return "Terreno";
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

	public boolean tieneLuz(){
		
		Iterator item = servicios.iterator();
		while(item.hasNext()){
			
			IServicio unServicio = (IServicio)item.next();
			if(unServicio.obtenerServicio()=="luz"){
				
				return (unServicio.estaActivo());
			}
			
		}
	return false;
	}


}
