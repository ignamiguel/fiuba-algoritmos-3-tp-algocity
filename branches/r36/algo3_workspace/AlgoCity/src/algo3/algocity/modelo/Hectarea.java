package algo3.algocity.modelo;

import java.util.ArrayList;

public abstract class Hectarea {

	// atributos de la clase
	protected ArrayList<Conexiones> servicios;
	protected Construccion construccion;

	public abstract void agregarServicio(Conexiones unServicio);

	public abstract void quitarServicio(Conexiones unServicio);

	public abstract boolean tieneServicio(Conexiones unServicio);

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

}
