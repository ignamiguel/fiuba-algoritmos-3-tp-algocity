package algo3.algocity.modelo;

public class EntradaAlaCiudad extends Construccion implements IPropagable{

	public EntradaAlaCiudad(){
		this.costo = 0;
		this.salud = 100;
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
		// TODO Auto-generated method stub

	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// TODO Auto-generated method stub

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
}
