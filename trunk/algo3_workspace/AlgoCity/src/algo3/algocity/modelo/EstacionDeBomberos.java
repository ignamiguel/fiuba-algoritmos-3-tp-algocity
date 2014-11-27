package algo3.algocity.modelo;

public class EstacionDeBomberos {

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
	
}
