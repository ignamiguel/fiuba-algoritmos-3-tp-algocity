package algo3.algocity.modelo;

public class Tuberia extends Conexion {

	public Tuberia() {
		this.salud = Configuracion.SALUD_INICIAL;
		this.costo = Configuracion.COSTO_TUBERIA;
	}

	public String obtenerServicio() {
		return "Tuberia";
	}

	@Override
	public void afectarCon(Godzilla unGodzilla) {
		
	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// Nunca es afectada por el Terremoto (por el momento)

	}

	@Override
	public boolean puedoEn(Agua agua) {
		return true;
	}

	@Override
	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	@Override
	public TipoDeConexion obtenerTipo() {
		return TipoDeConexion.Tuberia;
	}

	@Override
	public int obtenerCosto() {
		return this.costo;
	}

	public boolean estaDaniada() {
		return false;
	}
	
	@Override
	public void reparar() {

	}


}
