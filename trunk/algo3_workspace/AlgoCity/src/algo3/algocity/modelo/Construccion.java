package algo3.algocity.modelo;

public abstract class Construccion implements IConstruible{

	protected int costo;
	protected int salud;
	
	public void cargarCosto(int costo){
		this.costo = costo;
	}
	
	public int obtenerCosto(){
		return costo;
	}
	
	public void cargarSalud(int salud){
		this.salud = salud;
	}
	
	public int obtenerSalud(){
		return this.salud;
	}

	public void reparar(int salud) {
		this.salud += salud;
		
	}	
	
}
