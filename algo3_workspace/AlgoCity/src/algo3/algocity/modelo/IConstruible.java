package algo3.algocity.modelo;

public interface IConstruible {
	
	public int obtenerCosto(); 
	public boolean puedoEn(Agua agua);
	public boolean puedoEn(Terreno terreno);
	public boolean puedoEn(Hectarea hectarea);
	public void brindarServicio(Hectarea hectarea);
}
