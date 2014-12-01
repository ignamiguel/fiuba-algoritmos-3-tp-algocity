package algo3.algocity.modelo;

public class Tuberia extends Conexiones{

	public Tuberia(){
		
	}
	
	public String obtenerServicio(){
		return "Tuberia";
	}

	@Override
	public void afectarCon(Godzilla unGodzilla) {
		// Nunca es afectada por Godzilla (por el momento)
		
	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// Nunca es afectada por el Terremoto (por el momento)
		
	}

	@Override
	public void reparar(int salud) {
		// No es reparable porque no se afecta
		
	}

	@Override
	public boolean estaActivo() {
		// Siempre esta activa. 
		return true;
	}

	@Override
	public boolean puedoEn(Agua agua) {
		return true;
	}

	@Override
	public boolean puedoEn(Terreno terreno) {
		return true;
	}

}
