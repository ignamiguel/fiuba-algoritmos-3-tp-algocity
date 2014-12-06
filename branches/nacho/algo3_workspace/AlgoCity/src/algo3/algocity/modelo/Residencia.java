package algo3.algocity.modelo;

import java.util.ArrayList;

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
		if (this.salud == 0) {
			return;
		}

		int averia = Configuracion.AVERIA_DE_GODZILLA_A_RESIDENCIA;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	public int calcularCapacidad(ArrayList<TipoDeServicio> servicios) {
		int capacidadADevolver = this.capacidad;
		if(!servicios.contains(TipoDeServicio.Cloacas))
			capacidadADevolver -= 25;
		if(!servicios.contains(TipoDeServicio.Electrico))
			capacidadADevolver -= 25;
		if(!servicios.contains(TipoDeServicio.AccesoAlTransito))
			capacidadADevolver -= 25;
		if(salud != Configuracion.SALUD_INICIAL)
			capacidadADevolver -= 25;
		
		return capacidadADevolver;
		
	}


}
