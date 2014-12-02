package algo3.algocity.modelo;

public class Tuberia extends Conexion {

	public Tuberia() {

	}

	public String obtenerServicio() {
		return "Tuberia";
	}

	@Override
	public void afectarCon(Godzilla unGodzilla) {
		if (this.salud == 0) {
			return;
		}

		int averia = (Configuracion.AVERIA_DE_GODZILLA_A_TUBERIA * this.salud) / 100;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// Nunca es afectada por el Terremoto (por el momento)

	}

	@Override
	public void reparar(int salud) {
		// No es reparable porque no se afecta

	}

	@Override
	public boolean estaActiva() {
		// Siempre esta activa.
		return true;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void brindarServicio(Hectarea hectarea) {
		// TODO Auto-generated method stub

	}

}
