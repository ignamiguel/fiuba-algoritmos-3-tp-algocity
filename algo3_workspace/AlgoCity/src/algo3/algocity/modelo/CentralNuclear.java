package algo3.algocity.modelo;

public class CentralNuclear extends CentralElectrica {

	public CentralNuclear() {
		this.conectadaARedDeAgua = false;
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_NUCLEAR;
		this.radioDeCovertura = Configuracion.RADIO_COVERT_CENTRAL_NUCLEAR;
		this.costo = Configuracion.COSTO_CENTRAl_NUCLEAR;
		this.salud = Configuracion.SALUD_INICIAL;

	}

	// metodos publicos
	public int darEnergia() {

		return 0;
	}

	public void brindarServicio(Hectarea hectarea) {
		// TODO Auto-generated method stub

	}

}
