package algo3.algocity.modelo;


public abstract class Hectarea {
	
	
	public abstract void agregarServicio(Conexiones unServicio);
	
	public abstract void quitarServicio(Conexiones unServicio);
	
	public abstract boolean tieneElServicio(Conexiones unServicio);
	
	public abstract String obtenerNombre();
	
}
