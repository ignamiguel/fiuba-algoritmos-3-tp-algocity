package algo3.algocity.modelo;

	
public class Comercio extends Edificios{
	
	public Comercio(){
		cargarConsumoElectrico(2);
		cargarCosto(5);
		cargarSalud(100);
	}

	public void afectarseCon(Godzilla godzilla) {
		this.salud -= 75;
		if (this.salud < 0 ){
			this.salud = 0;
		}
		
	}
}
