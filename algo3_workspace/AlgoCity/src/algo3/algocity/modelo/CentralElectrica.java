package algo3.algocity.modelo;

public abstract class CentralElectrica extends Construccion implements
		IPropagable {

	public CentralElectrica() {

	}

	protected int capacidadDeAbastecimiento;
	protected int radioDeCovertura;
	protected boolean conectadaARedDeAgua;

	public int obtenerRadioDeCovertura() {
		return radioDeCovertura;
	}

	public boolean estaConectada() {
		return conectadaARedDeAgua;
	}

	public void afectarCon(Godzilla unGodzilla) {
		if (this.salud == 0) {
			return;
		}

		int averia = Configuracion.AVERIA_DE_GODZILLA_A_CENTRAL_ELECTRICA;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	public void afectarCon(Terremoto unTerremoto) {
		// TODO Auto-generated method stub

	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	@Override
	public TipoDeServicio obtenerServicioPropagable() {
		return TipoDeServicio.Electrico;
	}

	@Override
	public TipoDeConexion obtenerConexionNecesaria() {
		return TipoDeConexion.LineaDeTension;
	}

	public boolean puedoBrindarleElServicio(Hectarea hectarea) {
		if (this.capacidadDeAbastecimiento >= hectarea.obtenerConsumo()) {
			this.capacidadDeAbastecimiento -= hectarea.obtenerConsumo();
			return true;
		}
		return false;
	}

	public abstract void cargarAbastecimiento();

	public int obtenerConsumoElectrico() {
		return Configuracion.CONSUMO_ELECTRICO_CENTRAL_ELECTRICA;
	}

	public int obtenerCapacidadDeAbastecimiento() {
		return this.capacidadDeAbastecimiento;
	}

}
