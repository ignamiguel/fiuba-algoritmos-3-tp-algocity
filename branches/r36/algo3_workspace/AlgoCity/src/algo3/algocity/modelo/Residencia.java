package algo3.algocity.modelo;

public class Residencia extends Edificio {

	private int capacidad;

	public Residencia() {
		this.consumoElectrico = Configuracion.CONSUMO_ELECTRICO_RESIDENCIA;
		this.capacidad = Configuracion.ALOJAMIENTO_RESIDENCIA;
		this.costo = Configuracion.COSTO_RESIDENCIA;
		this.salud = Configuracion.SALUD_INICIAL;
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
