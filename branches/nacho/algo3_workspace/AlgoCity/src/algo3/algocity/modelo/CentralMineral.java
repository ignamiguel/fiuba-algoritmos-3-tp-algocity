package algo3.algocity.modelo;

public class CentralMineral extends CentralElectrica {

	public CentralMineral() {
		this.conectadaARedDeAgua = false;
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_MINERAL;
		this.radioDeCovertura = Configuracion.RADIO_COVERT_CENTRAL_MINERAL;
		this.costo = Configuracion.COSTO_CENTRAl_MINERAL;
		this.salud = Configuracion.SALUD_INICIAL;
	}

	// metodos publicos
	public int darEnergia() {
		return 0;
	}

	@Override
	public void cargarAbastecimiento() {
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_MINERAL;
		
	}


}
