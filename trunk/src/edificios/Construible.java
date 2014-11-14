package edificios;

public interface Construible {
	
	public int obtenerCosto(); 
	public boolean puedoEn(Agua agua);
	public boolean puedoEn(Terreno terreno);
}
