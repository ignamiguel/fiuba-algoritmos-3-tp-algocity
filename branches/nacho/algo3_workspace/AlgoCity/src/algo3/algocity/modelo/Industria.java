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

	public void brindarServicio(Hectarea hectarea) {
		// No brinda servicios

	}

	public int calcularCapacidad(ArrayList<TipoDeServicio> servicios) {
		int puestosADevolver = this.puestosDeTrabajo;
		if(!servicios.contains(TipoDeServicio.AccesoAlTransito))
			puestosADevolver -= 25;
		if(!servicios.contains(TipoDeServicio.Electrico))
			puestosADevolver -= 25;
		if(salud != Configuracion.SALUD_INICIAL)
			puestosADevolver -= 25;
		return puestosADevolver;
	}

}
