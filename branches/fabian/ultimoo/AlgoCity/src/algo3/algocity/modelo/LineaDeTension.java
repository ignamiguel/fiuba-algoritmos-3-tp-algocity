package algo3.algocity.modelo;

public class LineaDeTension extends Conexion {

	public LineaDeTension() {
		this.salud = Configuracion.SALUD_INICIAL;
	}

	// las lineas de tension o estan rotas o funcionan no sirve el parametro
	// salud,Pablo

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

	@Override
	public void reparar() {
		this.salud =+ Configuracion.REPACACION_A_LINEA_DE_TENSION;
		if(this.salud > 100){
			this.salud = 100;
		}
	}

	@Override
	public String obtenerNombre() {
		return "Linea de Tension";
	}

}
