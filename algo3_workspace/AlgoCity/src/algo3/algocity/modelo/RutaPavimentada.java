package algo3.algocity.modelo;

public class RutaPavimentada extends Conexiones implements IServicio {

	private boolean daniada;
	
	public RutaPavimentada(){	
		this.daniada = false;
	}
	
	public boolean puedoEn(Terreno terreno){
		return true;
	}
	
	public boolean puedoEn(Agua agua){
		return false;
	}
	
	public void afectarCon(Godzilla unGodzilla) {
		this.daniar();
		
	}

	public void afectarCon(Terremoto unTerremoto) {
		this.daniar();		
	}

	public void reparar(int salud) {
		//La reparacion es completa. Por lo tanto al primer llamado de reparacion ya deja de estar daniada
		daniada=true;
		
	}

	@Override
	public boolean estaActivo() {
		
		return (!daniada);
	}

	public String obtenerServicio() {
		return "Ruta";
	}
	
	public boolean estaDaniada(){	
		return daniada;
	}

	private void daniar(){
		daniada = true;	
	}

}
