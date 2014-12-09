package algo3.algocity.modelo;

public class EstacionDeBomberos extends Construccion {

	public EstacionDeBomberos() {
		this.costo = Configuracion.COSTO_ESTACION_DE_BOMBEROS;
	}

	public String obtenerNombre() {
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
	
	public int obtenerConsumoElectrico(){
		return 0;
	}

	public void repararDanios(Mapa mapa) {
		
		for(int i=0; i < mapa.obtenerTamanio();i++ ){
			for(int j=0; j < mapa.obtenerTamanio(); j++){
				Coordenada coordenada = new Coordenada(i,j);
				Hectarea hectarea = mapa.obtenerHectarea(coordenada);
				hectarea.reparar();
			}
		}
		
	}

	@Override
	public void reparar() {
		// TODO Auto-generated method stub
		
	}

}
