package algo3.algocity.modelo;

public abstract class Conexion implements IConectable {
	
	protected int salud;
	protected int costo;
	
	public Object obtenerSalud() {
		return this.salud;
	}

}
