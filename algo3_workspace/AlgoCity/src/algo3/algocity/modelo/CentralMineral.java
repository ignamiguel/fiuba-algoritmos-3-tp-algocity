package algo3.algocity.modelo;

public class CentralMineral extends CentralElectrica {

	
	public CentralMineral(){
		this.conectadaARedDeAgua = false;
		this.capacidadDeAbastecimiento = 400;
		this.radioDeCovertura = 10;
		this.cargarCosto(3000);
		this.cargarSalud(100);		
	}
	
	
	
	//metodos publicos
	public int darEnergia() {
		
	return 0;
	}






	@Override
	public void brindarServicio(Hectarea hectarea) {
		// TODO Auto-generated method stub
		
	}


}
