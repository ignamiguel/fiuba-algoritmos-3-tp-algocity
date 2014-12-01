package algo3.algocity.modelo;

public class Ruta extends Conexiones implements IServicio {

	private boolean daniada;
	private boolean accesoTransito;
	
	public Ruta(){	
		this.daniada = false;
		this.accesoTransito = false;
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
		if(this.daniada || !this.accesoTransito){
			return false;
		}
		return true;
	}

	public String obtenerServicio() {
		if(this.estaActivo()) 
			return "transito";
		return "Sin transito";
	}
	
	public boolean estaDaniada(){	
		return daniada;
	}

	private void daniar(){
		daniada = true;	
	}

}
