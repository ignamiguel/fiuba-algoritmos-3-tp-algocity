package algo3.algocity.modelo;

public class PozoDeAgua extends Construccion implements IPropagable{
	
	private int radioDeCovertura; 
	
	public PozoDeAgua(){
		super();
		this.radioDeCovertura = Configuracion.RADIO_COVERT_POZO_AGUA;
	}

 	public String obtenerNombre(){
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
		//No es un edificio que sea daniable
		
	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		//No es un edificio que sea daniable
		
	}

	@Override
	public TipoDeServicio obtenerServicioPropagable() {
		return TipoDeServicio.Cloacas;
	}

	@Override
	public TipoDeConexion obtenerConexionNecesaria() {
		return TipoDeConexion.Tuberia;
	}

	@Override
	public boolean puedoBrindarleElServicio(Hectarea hectarea) {
		return true;
	}

	public int obtenerConsumoElectrico(){
		return 0;
	}

	
	@Override
	public int obtenerRadioDeCovertura() {		
		return this.radioDeCovertura;
	}
}
