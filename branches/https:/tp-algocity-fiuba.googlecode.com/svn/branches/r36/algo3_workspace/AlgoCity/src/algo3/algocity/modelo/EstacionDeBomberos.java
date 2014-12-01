package algo3.algocity.modelo;

public class EstacionDeBomberos extends Construccion {

	public String obtenerNombre(){
		return "Estacion de Bomberos";
	}

	public void reparar(Residencia residencia) {		
		residencia.reparar(10);		
	}

	public void reparar(Comercio comercio) {
		comercio.reparar(7);		
	}

	public void reparar(Industria industria) {
		industria.reparar(3);		
	}

	public void reparar(CentralEolica cEolica) {
		cEolica.reparar(15);		
	}

	public void reparar(CentralMineral cMinera) {
		cMinera.reparar(10);		
	}

	public void reparar(CentralNuclear cNuclear) {
		cNuclear.reparar(3);		
	}
	
	public boolean puedoEn(Agua agua){
		return false;
	}
	
	public boolean puedoEn(Terreno terreno){
		return true;
	}

	@Override
	public void brindarServicio(Hectarea hectarea) {
		// Falta ver que poner en esta parte
		
	}
}
