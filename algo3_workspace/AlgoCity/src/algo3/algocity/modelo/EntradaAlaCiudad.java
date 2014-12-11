package algo3.algocity.modelo;

public class EntradaAlaCiudad extends Construccion implements IPropagable{

	public EntradaAlaCiudad(){
		super();
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
	public TipoDeServicio getServicioPropagable() {
		return TipoDeServicio.AccesoAlTransito;
	}

	@Override
	public TipoDeConexion getConexionNecesaria() {
		return TipoDeConexion.Ruta;
	}

	@Override
	public boolean puedoBrindarleElServicio(Hectarea hectarea) {
		return true;
	}
	
	public int getConsumoElectrico(){
		return 0;
	}

	@Override
	public int getRadioDeCovertura() {
		return Configuracion.RADIO_COVERT_ENTRADA_CIUDAD;
	}

	@Override
	public void reparar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPuestosDeTrabajo() {
		// La entrada a la ciudad 
		// no genera puestos de trabajo
		return 0;
	}

	@Override
	public int getCapacidadDeAlojamiento() {
		// La entrada a la ciduad no 
		// tiene capacidad de alojamiento
		return 0;
	}

	@Override
	public String getEtiqueta() {
		return Configuracion.ETIQUETA_ENTRADA_A_LA_CIUDAD;
	}
}
