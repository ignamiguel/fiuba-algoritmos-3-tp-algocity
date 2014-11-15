package algo3.algocity.modelo;

public class Industria extends Edificios{
	
	private int puestosDeTrabajo;
	
	public Industria(){
		cargarConsumoElectrico(5);
		cargarPuestosDeTrabajo(25);
		cargarCosto(10);
	}

	private void cargarPuestosDeTrabajo(int puestosDeTrabajo) {
		this.puestosDeTrabajo = puestosDeTrabajo;
	}

	public int obtenerPuestosDeTrabajo() {
		return this.puestosDeTrabajo;
	}
}
