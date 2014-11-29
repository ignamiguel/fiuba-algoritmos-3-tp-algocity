package algo3.algocity.modelo;

public class Tuberia extends Conexiones implements IServicio{

	public Tuberia(){
		
	}
	
	public String obtenerNombre(){
		return "Tuberia";
	}

	@Override
	public void afectarCon(Godzilla unGodzilla) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reparar(int salud) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean estaActivo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String obtenerServicio() {
		// TODO Auto-generated method stub
		return null;
	}

}
