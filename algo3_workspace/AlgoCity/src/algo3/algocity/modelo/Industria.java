package algo3.algocity.modelo;

public class Industria extends Edificio {

	private int puestosDeTrabajo;

	public Industria() {
		super();
		this.consumoElectrico = Configuracion.CONSUMO_ELECTRICO_INDUSTRIA;
		this.puestosDeTrabajo = Configuracion.EMPLEOS_INDUSTRIA;
		this.costo = Configuracion.COSTO_INDUSTRIA;
		this.salud = Configuracion.SALUD_INICIAL;

		this.serviciosNecesarios.add(TipoDeServicio.AccesoAlTransito);
		this.serviciosNecesarios.add(TipoDeServicio.Electrico);
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

	@Override
	public int getPuestosDeTrabajo() {
		// Asumimos que si la Industria esta averiada
		// no puede generar puestos de trabajo
		if (this.estaAveriada()) {
			return 0;
		}

		return this.puestosDeTrabajo;

	}

	@Override
	public void reparar() {
		this.salud += Configuracion.REPARACION_A_INDUSTRIA;
		if (this.salud > 100) {
			this.salud = 100;
		}
	}

	@Override
	public int getCapacidadDeAlojamiento() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getEtiqueta() {
		return Configuracion.ETIQUETA_INDUSTRIA;
	}
}
