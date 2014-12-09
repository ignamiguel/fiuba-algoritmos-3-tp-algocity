package algo3.algocity.modelo;

public class CentralMineral extends CentralElectrica {

	public CentralMineral() {
		this.conectadaARedDeAgua = false;
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_MINERAL;
		this.radioDeCovertura = Configuracion.RADIO_COVERT_CENTRAL_MINERAL;
		this.costo = Configuracion.COSTO_CENTRAl_MINERAL;
		this.salud = Configuracion.SALUD_INICIAL;
	}


	@Override
	public void cargarAbastecimiento() {
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_MINERAL;
		
	}

	@Override
	public void reparar() {
		this.salud += Configuracion.REPACACION_A_CENTRAL_MINERAL;
		if(this.salud > 100){
			this.salud = 100;
		}
	}


	public String obtenerNombre() {
		return "Central Mineral";
	}

}
