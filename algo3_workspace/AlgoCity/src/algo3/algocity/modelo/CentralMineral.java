package algo3.algocity.modelo;

public class CentralMineral extends CentralElectrica {

	
	public CentralMineral(){
		this.conectadaARedDeAgua=false;
		this.capacidadDeAbastecimiento=400;
		this.radioDeCovertura=10;
		this.cargarCosto(3000);
				
		
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
