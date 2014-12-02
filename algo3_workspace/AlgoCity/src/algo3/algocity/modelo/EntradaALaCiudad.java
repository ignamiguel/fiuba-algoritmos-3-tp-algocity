package algo3.algocity.modelo;

public class EntradaALaCiudad extends Hectarea {
		
	@Override
	public String obtenerNombre() {
		return "Entrada a la ciudad";
	}

	@Override
	public boolean permite(Construccion construccion) {
		return false;
	}

	public boolean tieneAccesoAlTransito() {
		return true;
	}

	public void propagarTransito() {
		// TODO: implementar
	}

}
