package algo3.algocity.modelo;

public class PozoDeAgua extends Construccion implements IPropagable {

	private int radioDeCovertura;

	public PozoDeAgua() {
		super();
		this.radioDeCovertura = Configuracion.RADIO_COVERT_POZO_AGUA;	
		this.costo = Configuracion.COSTO_POZO_DE_AGUA;
	}

	public String getEtiqueta() {
		return "Pozo de Agua";
	}

	public boolean puedoEn(Agua agua) {
		return true;
	}

	public boolean puedoEn(Terreno terreno) {
		return false;
	}

	@Override
	public void afectarCon(Godzilla unGodzilla) {
		// Asumimos que el Pozo de Agua
		// no es afectable por Godzilla.
	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// Asumimos que el Pozo de Agua
		// no es afectable por un Terremoto.

	}

	@Override
	public TipoDeServicio getServicioPropagable() {
		return TipoDeServicio.Cloacas;
	}

	@Override
	public TipoDeConexion getConexionNecesaria() {
		return TipoDeConexion.Tuberia;
	}

	@Override
	public boolean puedoBrindarleElServicio(Hectarea hectarea) {
		// Asummismo que los pozos siempre pueden
		// brindar el servicio de cloacas
		return true;
	}

	public int getConsumoElectrico() {
		return Configuracion.CONSUMO_ELECTRICO_POZO;
	}

	@Override
	public int getRadioDeCovertura() {
		return this.radioDeCovertura;
	}

	@Override
	public void reparar() {

	}

	@Override
	public int getPuestosDeTrabajo() {
		// Los Pozos no generan puestos de trabajo
		return 0;
	}

	@Override
	public int getCapacidadDeAlojamiento() {
		// Los pozos no pueden alojar a ciudadanos
		return 0;
	}

}
