package algo3.algocity.modelo;

public abstract class Conexiones implements IAfectable {

	
	public abstract void afectarCon(Godzilla unGodzilla);
		
	public abstract void afectarCon(Terremoto unTerremoto);
	
	public abstract void reparar(int salud);

}
