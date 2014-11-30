package algo3.algocity.modelo;

public interface IConstruible{
	
	public int obtenerCosto(); 
	public boolean puedoEn(Agua agua);
	public boolean puedoEn(Terreno terreno);
	public void brindarServicio(Hectarea hectarea);
	public void afectarCon(Godzilla unGodzilla);
	public void afectarCon(Terremoto unTerremoto);
	public void reparar(int salud);
}
