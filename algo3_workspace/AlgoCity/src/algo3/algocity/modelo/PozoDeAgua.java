package algo3.algocity.modelo;

public class PozoDeAgua extends Construccion implements IPropagable{

	public String obtenerNombre(){
		return "Pozo de Agua";
	}

	public void brindarServicio(Hectarea hectarea){
        // TODO: re implementar 
		// utilizando la nueva forma de conexiones y servicios
		
		// hectarea.agregarServicio(new Tuberia());
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
	public boolean consumirse(Hectarea hectarea) {
		return true;
	}

	public int obtenerConsumoElectrico(){
		return 0;
	}
}
