package algo3.algocity.modelo;

import java.util.List;

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

	public int calcularPuestosDeTrabajo(List<TipoDeServicio> servicios) {
		return 0;
	}

	public int calcularCapacidadDeAlojamiento(List<TipoDeServicio> servicios) {
		return 0;
	}
}
