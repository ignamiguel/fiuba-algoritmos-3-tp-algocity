package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Hectarea {

	// atributos de la clase
	protected ArrayList<Conexiones> servicios;
	protected ArrayList<String> serviciosActivos;
	protected Construccion construccion;

	public abstract void agregarServicio(Conexiones unServicio);

	public abstract void quitarServicio(Conexiones unServicio);

	public void activarServicio(Conexiones unServicio){
		serviciosActivos.add(unServicio.obtenerServicio());
	}

	public void desactivarServicios(){
		serviciosActivos.clear();
	}
	
	public abstract boolean tieneServicio(Conexiones unServicio);

	public abstract boolean tieneAccesoAlTransito();
	
	public abstract String obtenerNombre();

	public boolean estaVacia() {
		return (construccion == null);

	}

	public boolean construir(Construccion construccion) {
		if (!this.estaVacia()) {
			return false;
		}
			
		if (!this.permite(construccion)) {
			return false;
		}
		
		this.construccion = construccion;
		construccion.brindarServicio(this);
		return true;		

	}
	
	public abstract boolean permite(Construccion construccion); 

	public Construccion obtenerConstruccion() {
		return this.construccion;
	}

	public void afectarCon(Godzilla godzilla) {
    	
		if(construccion != null){
		((IConstruible) this.construccion).afectarCon(godzilla);
    	}
		
		if(servicios != null){
			Iterator<Conexiones> i = servicios.iterator();
		      while(i.hasNext()) {
		         ((IServicio) i.next()).afectarCon(godzilla);
		}
		
	}
}
	
}
