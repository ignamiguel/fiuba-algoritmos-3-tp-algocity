package algo3.algocity.modelo;

public abstract class Edificios extends Construccion implements Afectable{
	
	private int consumoElectrico;
	protected int salud;
	
	public int obtenerConsumoElectrico(){
		return consumoElectrico;
	}
	
	public void cargarConsumoElectrico(int consumoElectrico){
		this.consumoElectrico = consumoElectrico;
		
	}
	
	public void cargarSalud(int salud){
		this.salud = salud;
	}
	
	public int obtenerSalud(){
		return this.salud;
	}
	
	public boolean puedoEn(Terreno terreno){
		return true;
	}
	
	public boolean puedoEn(Agua agua){
		return false;
	}
	
	public void afectarseCon(Terremoto terremoto) {
		this.salud -= terremoto.obtenerDanio();
		if(this.salud < 0){
			this.salud = 0;
		}
	}
}
