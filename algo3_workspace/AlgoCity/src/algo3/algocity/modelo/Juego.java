package algo3.algocity.modelo;

import java.util.ArrayList;

public class Juego {

	private Mapa mapa;

	private ArrayList<Edificio> edificios;

	private ArrayList<CentralElectrica> centrales;

	private ArrayList<PozoDeAgua> pozos;
	
	private ArrayList<EstacionDeBomberos> bomberos;
	
	private int dinero; 

	public Juego() {
		this.mapa = new Mapa(new MapaConPlaya());
		this.edificios = new ArrayList<Edificio>();
		this.centrales = new ArrayList<CentralElectrica>();
		this.pozos = new ArrayList<PozoDeAgua>();
		this.dinero = Configuracion.DINERO_INICIAL;
	}

	public String verMapa(Coordenada coordenada) {
		return this.mapa.obtenerHectarea(coordenada).obtenerNombre();
	}

	private boolean construir(Construccion construccion, Coordenada coordenada) {
		return this.mapa.construir(construccion, coordenada);
	}

	public boolean insertar(Edificio edificio, Coordenada coordenada) {
		if(this.dinero < edificio.obtenerCosto()){
			return false;
		}
		
		if (!this.construir(edificio, coordenada)) {
			return false;
		}
		
		this.dinero -= edificio.obtenerCosto();

		// TODO: agregar la coordenada a la lista
		this.edificios.add(edificio);
		
		return true;
	}

	public boolean insertar(CentralElectrica central, Coordenada coordenada) {
		if(this.dinero < central.obtenerCosto()){
			return false;
		}
		
		if (!this.construir(central, coordenada)) {
			return false;
		}

		this.dinero -= central.obtenerCosto();
		this.centrales.add(central);
		return true;

	}

	public boolean insertar(PozoDeAgua pozo, Coordenada coordenada) {
		if (!this.construir(pozo, coordenada)) {
			return false;
		}

		this.pozos.add(pozo);
		return true;
	}

	
	public boolean insertar(EstacionDeBomberos bomberos, Coordenada coordenada) {
		if(this.dinero < bomberos.obtenerCosto()){
			return false;
		}
		
		if (!this.construir(bomberos, coordenada)) {
			return false;
		}
		
		this.dinero -= bomberos.obtenerCosto();

		// TODO: Ver que se hace con los bomberos		
		
		return true;
	}
	
	public int verDinero() {
		return this.dinero;
	}

}
