package algo3.algocity.modelo;

public class Comercio extends Edificio{
	
	public Comercio(){
		cargarConsumoElectrico(2);
		cargarCosto(5);
		cargarSalud(100);
	}

	public void afectarCon(Godzilla godzilla) {
		
		this.salud -= 75;
		
		if (this.salud < 0 ){
			this.salud = 0;
		}
		
	}

	public boolean puedoEn(Hectarea hectarea) {
		return true;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}
	
	public boolean puedoEn(Agua agua) {
		return false;
	}
	@Override
	public void brindarServicio(Hectarea hectarea) {
		// No brinda servicios 
		
	}	
}
