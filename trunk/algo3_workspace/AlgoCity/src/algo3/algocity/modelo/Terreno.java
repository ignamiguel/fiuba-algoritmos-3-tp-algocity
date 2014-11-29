package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Terreno extends Hectarea{
	
	private ArrayList<Conexiones> servicios;
	private Construccion construccion;
	
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

	@Override
	public boolean puedoConstruirEdificio() {

	 return (construccion==null);
	}

	@Override
	public Construccion obtenerSuConstruccion() {
		// TODO Auto-generated method stub
		return this.construccion;
	}
}
