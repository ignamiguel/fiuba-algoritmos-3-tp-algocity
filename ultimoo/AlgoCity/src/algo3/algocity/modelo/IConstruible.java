package algo3.algocity.modelo;

public interface IConstruible extends IAfectable{
	
	public int obtenerCosto(); 
	public String obtenerNombre();
	public boolean puedoEn(Agua agua);
	public boolean puedoEn(Terreno terreno);	
}
