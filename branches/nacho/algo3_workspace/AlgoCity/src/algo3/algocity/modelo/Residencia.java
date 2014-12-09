package algo3.algocity.modelo;

import java.util.List;

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

	public int calcularCapacidadDeAlojamiento(List<TipoDeServicio> servicios) {
		if(salud == Configuracion.SALUD_INICIAL){
			if(this.tieneLosServiciosRequeridos(servicios)){
				return this.capacidad;
			}
		}
		return 0;
		
	}
	
	public boolean tieneLosServiciosRequeridos(List<TipoDeServicio> servicios) {
		return (servicios.contains(TipoDeServicio.AccesoAlTransito) && servicios.contains(TipoDeServicio.Cloacas) && servicios.contains(TipoDeServicio.Electrico));
	}
	
	@Override
	public void reparar() {
		this.salud += Configuracion.REPARACION_A_RESIDENCIA;
		if(this.salud > 100){
			this.salud = 100;
		}
	}

}
