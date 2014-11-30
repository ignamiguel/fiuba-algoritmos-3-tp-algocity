package algo3.algocity.modelo;

public class Residencia extends Edificio{
	
	private int capacidad;
	
	public Residencia(){
		cargarConsumoElectrico(1);
		cargarCapacidad(100);
		cargarCosto(5);
		cargarSalud(100);
	}

	private void cargarCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int obtenerCapacidad() {
		return capacidad;
	}

	public void afectarCon(Godzilla godzilla) {
		this.salud = 0;		
	}

	

	@Override
	public void brindarServicio(Hectarea hectarea) {
		// No hace nada porque no tiene servicios para brindar
		
	}
	
	
}
