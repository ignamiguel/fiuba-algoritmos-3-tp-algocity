package algo3.algocity.modelo;

public abstract class Edificio extends Construccion{
	
	private int consumoElectrico;	
	
	public int obtenerConsumoElectrico(){
		return consumoElectrico;
	}
	
	public void cargarConsumoElectrico(int consumoElectrico){
		this.consumoElectrico = consumoElectrico;		
	}	
	
	public boolean puedoEn(Terreno terreno){
		return true;
	}
	
	public boolean puedoEn(Agua agua){
		return false;
	}
	
	public void afectarCon(Terremoto terremoto) {
		this.salud -= terremoto.obtenerDanio();
		if(this.salud < 0){
			this.salud = 0;
		}
	}
}