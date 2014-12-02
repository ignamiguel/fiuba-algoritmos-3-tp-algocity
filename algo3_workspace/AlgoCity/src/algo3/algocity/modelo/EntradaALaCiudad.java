package algo3.algocity.modelo;


/*
 * Hay que definir como funcionaria la entrada
La idea es que sea una "fuente" de transito 
y funcione como un pozo de agua pero con el transito
*/
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
