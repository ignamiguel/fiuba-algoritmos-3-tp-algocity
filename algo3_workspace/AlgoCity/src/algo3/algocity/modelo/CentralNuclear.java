package algo3.algocity.modelo;

public class CentralNuclear extends CentralElectrica {

	public CentralNuclear(){
		this.conectadaARedDeAgua = false;
		this.capacidadDeAbastecimiento = 1000;
		this.radioDeCovertura = 25;	
		this.cargarCosto(10000);
		this.cargarSalud(100);		
		
	}
	
	//metodos publicos
	public int darEnergia() {
		
		return 0;
	}




	public void brindarServicio(Hectarea hectarea) {
		// TODO Auto-generated method stub
		
	}	

}
