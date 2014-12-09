package algo3.algocity.modelo;

public class EntradaAlaCiudad extends Construccion implements IPropagable{

	public EntradaAlaCiudad(){
		this.costo = 0;
		this.salud = Configuracion.SALUD_INICIAL;
	}
	
	@Override
	public boolean puedoEn(Agua agua) {
		return false;
	}

	@Override
	public boolean puedoEn(Terreno terreno) {
		return true;
	}


	@Override
	public void afectarCon(Godzilla unGodzilla) {

	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		
	}

	@Override
	public TipoDeServicio obtenerServicioPropagable() {
		return TipoDeServicio.AccesoAlTransito;
	}

	@Override
	public TipoDeConexion obtenerConexionNecesaria() {
		return TipoDeConexion.Ruta;
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
		return Configuracion.RADIO_COVERT_ENTRADA_CIUDAD;
	}

	@Override
	public void reparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String obtenerNombre() {
		return "Entrada a la Ciudad";
	}
}
