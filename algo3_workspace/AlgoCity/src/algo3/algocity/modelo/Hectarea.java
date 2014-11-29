package algo3.algocity.modelo;

import java.util.ArrayList;

public abstract class Hectarea {	
	
	public abstract void agregarServicio(Conexiones unServicio);

	public abstract void quitarServicio(Conexiones unServicio);

	public abstract boolean tieneElServicio(Conexiones unServicio);

	public abstract String obtenerNombre();
	
	public abstract Construccion obtenerSuConstruccion();
	
	public abstract boolean construir(Construccion unaConstruccion);
		
	public abstract boolean permite(Construccion c);	
		
}

