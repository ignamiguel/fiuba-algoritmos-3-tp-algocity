package algo3.algocity.modelo;

public class Comercio extends Edificio {

	public Comercio() {
		super();
		this.consumoElectrico = Configuracion.CONSUMO_ELECTRICO_COMERCIO;
		this.costo = Configuracion.COSTO_COMERCIO;
		this.salud = Configuracion.SALUD_INICIAL;

		this.serviciosNecesarios.add(TipoDeServicio.AccesoAlTransito);
		this.serviciosNecesarios.add(TipoDeServicio.Cloacas);
		this.serviciosNecesarios.add(TipoDeServicio.Electrico);
	}

	public void afectarCon(Godzilla godzilla) {
		this.salud -= Configuracion.AVERIA_DE_GODZILLA_A_COMERCIO;
		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	@Override
	public void reparar() {
		this.salud += Configuracion.REPARACION_A_COMERCIO;
		if (this.salud > 100) {
			this.salud = 100;
		}
	}

	@Override
	public int getPuestosDeTrabajo() {
		// Un comercio no genera puestos de trabajo
		return 0;
	}

	@Override
	public int getCapacidadDeAlojamiento() {
		// Un comercio tiene capacidad de alojamiento nula
		return 0;
	}

	@Override
	public String getEtiqueta() {
		return Configuracion.ETIQUETA_COMERCIO;
	}

}
