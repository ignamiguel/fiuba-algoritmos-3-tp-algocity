package algo3.algocity.modelo;

public class Residencia extends Edificios{
	
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

	public void afectarseCon(Godzilla godzilla) {
		this.salud -= 100;
		if(this.salud < 0){
			this.salud = 0;
		}
	}
	
	
	

	
	
}
