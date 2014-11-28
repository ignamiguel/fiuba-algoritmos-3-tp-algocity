package algo3.algocity.modelo;

public class LineaDeTension extends Conexiones implements IServicio{
	
	private boolean daniada;
	
	public LineaDeTension(){
		
		daniada = false;
		
	}
	
	public boolean estaDaniada(){
	
	return daniada;
	}

	private void daniar(){
		
		daniada = true;
		
	}


	// las lineas de tension o estan rotas o funcionan no sirve el parametro salud,Pablo
	public void reparar(int salud) {
		
		daniada = false;
		
	}


	public void afectarCon(Godzilla unGodzilla) {
		
		this.daniar();
	}


	public void afectarCon(Terremoto unTerremoto) {
	
		this.daniar();
	}


	public boolean estaActivo() {
		
	return (!daniada);
	}

	
	public String obtenerServicio() {
	
	return "luz";
	}

	public boolean puedoEn(Terreno terreno){
		return true;
	}
	
	public boolean puedoEn(Agua agua){
		return false;
	}


	
	
	
}
