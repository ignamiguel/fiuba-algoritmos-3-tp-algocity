package algo3.algocity.modelo;

public interface IServicio {
	
	public boolean estaActivo();
	public String obtenerServicio();
	
	public void afectarCon(Godzilla unGodzilla);
	public void afectarCon(Terremoto unTerremoto);
	public void reparar(int salud);

}
