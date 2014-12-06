package algo3.algocity.modelo;

public class LineaDeTension extends Conexion {

	private boolean daniada;

	public LineaDeTension() {
		daniada = false;
	}

	public boolean estaDaniada() {
		return daniada;
	}

	// las lineas de tension o estan rotas o funcionan no sirve el parametro
	// salud,Pablo
	public void reparar(int salud) {
		daniada = false;
	}

	public void afectarCon(Godzilla unGodzilla) {
		if (this.salud == 0) {
			return;
		}

		this.salud -= Configuracion.AVERIA_DE_GODZILLA_A_LINEA_DE_TENSION;;

		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	public void afectarCon(Terremoto unTerremoto) {
		//Terremoto
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	@Override
	public int obtenerCosto() {
		return Configuracion.COSTO_LINEA_DE_TENSION;
	}


	@Override
	public TipoDeConexion obtenerTipo() {
		return TipoDeConexion.LineaDeTension;
	}

}
