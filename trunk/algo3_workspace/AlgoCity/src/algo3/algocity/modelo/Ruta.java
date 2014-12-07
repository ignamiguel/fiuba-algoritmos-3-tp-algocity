package algo3.algocity.modelo;

public class Ruta extends Conexion {

	public Ruta() {
		this.salud = Configuracion.SALUD_INICIAL;
		this.costo = Configuracion.COSTO_RUTA;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	public void afectarCon(Godzilla unGodzilla) {
		if (this.salud == 0) {
			return;
		}

		int averia = Configuracion.AVERIA_DE_GODZILLA_A_RUTA;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}

	}

	public void afectarCon(Terremoto unTerremoto) {
		// TODO: implementar
	}

	public void reparar(int salud) {
		this.salud = salud;
	}

	public boolean estaDaniada() {
		return (this.salud < Configuracion.SALUD_INICIAL);
	}

	@Override
	public TipoDeConexion obtenerTipo() {
		return TipoDeConexion.Ruta;
	}

	@Override
	public int obtenerCosto() {
		return this.costo;
	}
	
	@Override
	public void reparar() {
		this.salud += Configuracion.REPACACION_A_RUTA;
		if(this.salud > 100){
			this.salud = 100;
		}
	}

}
