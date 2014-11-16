package algo3.algocity.modelo;

public class CentralEolica extends CentralElectrica {

	
	public CentralEolica(){
		this.conectadaARedDeAgua=false;
		this.capacidadDeAbastecimiento=100;
		this.radioDeCovertura=4;
		this.cargarCosto(1000);
		
	}
	
	
	//metodos publicos
	public int darEnergia() {

	return 0;
	}


	public boolean puedoEn(Agua agua) {
		
	return false;
	}


	public boolean puedoEn(Terreno terreno) {
	
	return true;
	}


	public int obtenerRadioDeCovertura() {
	
	return radioDeCovertura;
	}


	public int obtenerCapacidadDeAbastecimiento() {
	
	return capacidadDeAbastecimiento;
	}


	public boolean estaConectada() {
		
	return conectadaARedDeAgua;
	}

}
