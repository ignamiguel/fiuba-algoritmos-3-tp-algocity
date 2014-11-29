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


	public boolean puedoEn(Agua agua) {

	return false;
	}


	public boolean puedoEn(Terreno terreno) {

	return true;
	}	

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// TODO Auto-generated method stub
		
	}

	public boolean puedoEn(Hectarea hectarea) {
		// TODO Auto-generated method stub
		return true ;
	}

	public void brindarServicio(Hectarea hectarea) {
		// no brinda servicios
		
	}	

}
