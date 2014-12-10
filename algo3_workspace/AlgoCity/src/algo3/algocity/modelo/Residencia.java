package algo3.algocity.modelo;

import java.util.ArrayList;

public class Residencia extends Edificio {

	private int capacidadDeAlojamiento;

	public Residencia() {
		this.consumoElectrico = Configuracion.CONSUMO_ELECTRICO_RESIDENCIA;
		this.capacidadDeAlojamiento = Configuracion.ALOJAMIENTO_RESIDENCIA;
		this.costo = Configuracion.COSTO_RESIDENCIA;
		this.salud = Configuracion.SALUD_INICIAL;
		this.serviciosNecesarios = new ArrayList<TipoDeServicio>();
		this.serviciosNecesarios.add(TipoDeServicio.AccesoAlTransito);
		this.serviciosNecesarios.add(TipoDeServicio.Cloacas);
		this.serviciosNecesarios.add(TipoDeServicio.Electrico);

	}

	public int obtenerCapacidad() {
		return capacidadDeAlojamiento;
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

	@Override
	public int getCapacidadDeAlojamiento() {
		// Asumimos que si la Residencia esta averiada
		// no puede dar alojamiento
		if (this.estaAveriada()) {
			return 0;
		}

		return this.capacidadDeAlojamiento;
	}

	@Override
	public void reparar() {
		this.salud += Configuracion.REPARACION_A_RESIDENCIA;
		if (this.salud > 100) {
			this.salud = 100;
		}
	}

	@Override
	public int getPuestosDeTrabajo() {
		// Las Residencias no generan trabajo
		return 0;
	}

	@Override
	public String getEtiqueta() {
		return Configuracion.ETIQUETA_RESIDENCIA;
	}

}
