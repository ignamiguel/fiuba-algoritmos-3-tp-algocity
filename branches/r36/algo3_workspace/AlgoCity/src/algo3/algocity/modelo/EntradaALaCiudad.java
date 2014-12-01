package algo3.algocity.modelo;

public class EntradaALaCiudad extends Hectarea{

	@Override
	public void agregarServicio(Conexiones unServicio) {
		// Deberia devolver una excepcion
		
	}

	@Override
	public void quitarServicio(Conexiones unServicio) {
		// Deberia devolver una excepcion
		
	}

	@Override
	public boolean tieneServicio(Conexiones unServicio) {
		return false;
	}

	@Override
	public String obtenerNombre() {
		return "Entrada a la ciudad";
	}

	@Override
	public boolean permite(Construccion construccion) {
		return false;
	}

	@Override
	public boolean tieneAccesoAlTransito() {
		return true;
	}
	
	public void propagarTransito(){
		if(!this.tieneAccesoAlTransito()){
			if(this.tieneServicio(new Ruta())){
				
			}
		}
	}
	
}
