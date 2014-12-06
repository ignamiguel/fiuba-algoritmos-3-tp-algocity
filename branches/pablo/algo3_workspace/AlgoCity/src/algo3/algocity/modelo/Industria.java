package algo3.algocity.modelo;

import java.util.ArrayList;

public class Industria extends Edificio {

	private int puestosDeTrabajo;

	public Industria() {
		this.consumoElectrico = Configuracion.CONSUMO_ELECTRICO_INDUSTRIA;
		this.puestosDeTrabajo = Configuracion.EMPLEOS_INDUSTRIA;
		this.costo = Configuracion.COSTO_INDUSTRIA;
		this.salud = Configuracion.SALUD_INICIAL;
	}

	public int obtenerPuestosDeTrabajo() {
		return this.puestosDeTrabajo;
	}

	public void afectarCon(Godzilla godzilla) {
		if (this.salud == 0) {
			return;
		}

		int averia = Configuracion.AVERIA_DE_GODZILLA_A_INDUSTRIA;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}

	}

	public boolean puedoEn(Hectarea hectarea) {
		return true;
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	public int calcularPuestosDeTrabajo(ArrayList<TipoDeServicio> servicios) {
		if(salud == Configuracion.SALUD_INICIAL){
			if(this.tieneLosServiciosRequeridos(servicios)){
				return this.puestosDeTrabajo;
			}
		}
		return 0;
		
	}
	
	public boolean tieneLosServiciosRequeridos(ArrayList<TipoDeServicio> servicios) {
		return (servicios.contains(TipoDeServicio.AccesoAlTransito) && servicios.contains(TipoDeServicio.Electrico));
	}

}
