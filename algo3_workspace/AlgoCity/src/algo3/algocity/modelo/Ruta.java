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

		int averia = (Configuracion.AVERIA_DE_GODZILLA_A_RUTA * this.salud) / 100;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}

	}

	public void afectarCon(Terremoto unTerremoto) {
		// TODO: implementar
	}

	public void reparar(int salud) {
		// Asumimos que la reparacion es completa.
		this.salud = salud;
	}

	@Override
	public boolean estaActiva() {

		return true;
	}

	public String obtenerServicio() {
		if (this.estaActiva())
			return "transito";
		return "Sin transito";
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
	public void brindarServicio(Hectarea hectarea) {
		// TODO Auto-generated method stub

	}

}
