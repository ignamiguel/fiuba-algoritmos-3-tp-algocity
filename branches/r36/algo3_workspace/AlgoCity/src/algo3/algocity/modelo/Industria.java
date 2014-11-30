package algo3.algocity.modelo;

public class Industria extends Edificio{
	
	private int puestosDeTrabajo;
	
	public Industria(){
		cargarConsumoElectrico(5);
		cargarPuestosDeTrabajo(25);
		cargarCosto(10);
		cargarSalud(100);
	}

	private void cargarPuestosDeTrabajo(int puestosDeTrabajo) {
		this.puestosDeTrabajo = puestosDeTrabajo;
	}

	public int obtenerPuestosDeTrabajo() {
		return this.puestosDeTrabajo;
	}

	public void afectarCon(Godzilla godzilla) {
		
		this.salud -= 40;
		if (this.salud < 0){
			this.salud = 0;
		}
		
	}

	public boolean puedoEn(Hectarea hectarea) {
		return true;
	}
	
	public boolean puedoEn(Agua agua) {
		return false;
	}
	
	public boolean puedoEn(Terreno terreno) {
		return true;
	}
	
	

	public void brindarServicio(Hectarea hectarea) {
		// No brinda servicios
		
	}	

}
