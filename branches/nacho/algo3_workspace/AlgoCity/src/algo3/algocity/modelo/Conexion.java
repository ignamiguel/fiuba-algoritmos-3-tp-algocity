package algo3.algocity.modelo;

public abstract class Conexion implements IConectable {
	
	protected int salud;
	protected int costo;
	
	public int getSalud() {
		return this.salud;
	}
	
	public abstract boolean estaAveriada();

}
