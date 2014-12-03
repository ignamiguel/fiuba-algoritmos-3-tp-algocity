package algo3.algocity.modelo;

public class EstacionDeBomberos extends Construccion {

	public EstacionDeBomberos() {
		this.costo = Configuracion.COSTO_ESTACION_DE_BOMBEROS;
	}

	public String obtenerNombre() {
		return "Estacion de Bomberos";
	}

	public void reparar(Residencia residencia) {
		residencia.reparar(Configuracion.REPARACION_A_RESIDENCIA);
	}

	public void reparar(Comercio comercio) {
		comercio.reparar(Configuracion.REPARACION_A_COMERCIO);
	}

	public void reparar(Industria industria) {
		industria.reparar(Configuracion.REPARACION_A_INDUSTRIA);
	}

	public void reparar(CentralEolica cEolica) {
		cEolica.reparar(Configuracion.REPARACION_A_CENTRAl_EOLICA);
	}

	public void reparar(CentralMineral cMinera) {
		cMinera.reparar(Configuracion.REPACACION_A_CENTRAL_MINERAL);
	}

	public void reparar(CentralNuclear cNuclear) {
		cNuclear.reparar(Configuracion.REPACACION_A_CENTRAL_NUCELAR);
	}

	public void reparar(Ruta ruta) {
		ruta.reparar(Configuracion.REPACACION_A_RUTA);
	}

	public void reparar(LineaDeTension linea) {
		linea.reparar(Configuracion.REPACACION_A_LINEA_DE_TENSION);
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	@Override
	public void brindarServicio(Hectarea hectarea) {
		// Falta ver que poner en esta parte

	}

	@Override
	public void afectarCon(Godzilla unGodzilla) {
		// No es un edificio que sea daniable

	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// No es un edificio que sea daniable

	}
}
