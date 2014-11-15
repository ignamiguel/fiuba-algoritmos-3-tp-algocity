package algo3.algocity.modelo;

public class Residencia extends Edificios{
	
	private int capacidad;
	
	public Residencia(){
		cargarConsumoElectrico(1);
		cargarCapacidad(100);
		cargarCosto(5);
	}

	private void cargarCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int obtenerCapacidad() {
		return capacidad;
	}
	
}
