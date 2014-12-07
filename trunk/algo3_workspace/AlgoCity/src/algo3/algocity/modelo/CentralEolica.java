package algo3.algocity.modelo;

public class CentralEolica extends CentralElectrica {

	public CentralEolica() {
		this.conectadaARedDeAgua = false;
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_EOLICA;
		this.radioDeCovertura = Configuracion.RADIO_COVERT_CENTRAL_EOLICA;
		this.costo = Configuracion.COSTO_CENTRAL_EOLICA;
		this.salud = Configuracion.SALUD_INICIAL;

	}

	@Override
	public void cargarAbastecimiento() {
		this.capacidadDeAbastecimiento = Configuracion.CAPACIDAD_ABAS_CENTRAL_EOLICA;
	}

	@Override
	public void reparar() {
		this.salud += Configuracion.REPARACION_A_CENTRAl_EOLICA;
		if(this.salud > 100){
			this.salud = 100;
		}
	}
	
	
}
