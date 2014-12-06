package algo3.algocity.modelo;

public abstract class Construccion implements IConstruible {

	protected int costo;
	protected int salud;

	public int obtenerCosto() {
		return this.costo;
	}

	public int obtenerSalud() {
		return this.salud;
	}

	public abstract int obtenerConsumoElectrico();
}
