package algo3.algocity.modelo;

public class CentralNuclear extends CentralElectrica {

	public CentralNuclear() {
		super();
		this.conectadaARedDeAgua = false;
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_NUCLEAR;
		this.radioDeCovertura = Configuracion.RADIO_COVERT_CENTRAL_NUCLEAR;
		this.costo = Configuracion.COSTO_CENTRAl_NUCLEAR;
		this.salud = Configuracion.SALUD_INICIAL;

	}

	@Override
	public void cargarAbastecimiento() {
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_NUCLEAR;
	}

	@Override
	public void reparar() {
		this.salud += Configuracion.REPACACION_A_CENTRAL_NUCLEAR;
		if (this.salud > 100) {
			this.salud = 100;
		}
	}

	@Override
	public String getEtiqueta() {
		return Configuracion.ETIQUETA_CENTRAL_NUCLEAR;
	}

}
