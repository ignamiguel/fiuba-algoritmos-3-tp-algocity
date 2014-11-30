package algo3.algocity.modelo;

public class CentralEolica extends CentralElectrica {

	
	public CentralEolica(){
		this.conectadaARedDeAgua=false;
		this.capacidadDeAbastecimiento=100;
		this.radioDeCovertura=4;
		this.cargarCosto(1000);
		this.cargarSalud(100);
		
	}
	
	
	//metodos publicos
	public int darEnergia() {

	return 0;
	}




	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void brindarServicio(Hectarea hectarea) {
		// no brinda servicio
		
	}	

}
