package edificios;

public class Edificios extends Construccion{
	
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
}
