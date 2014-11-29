package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Terreno extends Hectarea{
	
	
	public Terreno(){
		
		servicios = new ArrayList<Conexiones>();
		construccion=null;
	}
	
	public String obtenerNombre(){
		return "Terreno";
	}
 
	public void agregarServicio(Conexiones unServicio) {

		if (!(this.tieneElServicio(unServicio)))
            servicios.add(unServicio);
		
	}

	
	public void quitarServicio(Conexiones unServicio) {

		if(this.tieneElServicio(unServicio))
            servicios.remove(unServicio);
		
	}

	
	public boolean tieneElServicio(Conexiones unServicio) {	
		return(servicios.contains(unServicio));
	}

	public boolean tieneLuz(){
		
		Iterator<Conexiones> item = servicios.iterator();
		while(item.hasNext()){
			
			IServicio unServicio = (IServicio)item.next();
			if(unServicio.obtenerServicio()=="luz"){
				
				return (unServicio.estaActivo());
			}
			
		}
	return false;
	}

	public void construir(Construccion unaConstruccion){
        if (this.puedoConstruirEdificio())
        {
            if(unaConstruccion.puedoEn(this))
                {   construccion= unaConstruccion;
                    unaConstruccion.brindarServicio(this);
                }
        }


	}
}