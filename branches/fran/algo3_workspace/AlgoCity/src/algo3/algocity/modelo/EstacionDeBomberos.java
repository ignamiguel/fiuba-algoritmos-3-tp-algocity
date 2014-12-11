package algo3.algocity.modelo;

public class EstacionDeBomberos extends Construccion {

	public EstacionDeBomberos() {
		super();
		this.costo = Configuracion.COSTO_ESTACION_DE_BOMBEROS;		
	}

	public String getEtiqueta() {
		return "Estacion de Bomberos";
	}

	public void reparar(IAfectable afectable) {
		afectable.reparar();
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	@Override
	public void afectarCon(Godzilla unGodzilla) {
		// No es un edificio que sea daniable

	}

	@Override
	public void afectarCon(Terremoto unTerremoto) {
		// No es un edificio que sea daniable

	}

	public int getConsumoElectrico() {
		return 0;
	}

	public void repararAverias(Mapa mapa) {

		for (int i = 0; i < mapa.getTamanio(); i++) {
			for (int j = 0; j < mapa.getTamanio(); j++) {
				Coordenada coordenada = new Coordenada(i, j);
				Hectarea hectarea = mapa.getHectarea(coordenada);
				hectarea.reparar();
			}
		}

	}

	@Override
	public void reparar() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPuestosDeTrabajo() {
		// La estacion de bomberos
		// no ofrece puestos de trabajo
		return 0;
	}

	@Override
	public int getCapacidadDeAlojamiento() {
		// La estacion de bomberos
		// no tiene capacidad de alojamiento
		return 0;
	}

}
