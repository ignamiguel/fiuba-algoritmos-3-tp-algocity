// Comentario
package algo3.algocity.modelo;

import java.util.ArrayList;

public class Juego {

	private Mapa mapa;

	private ArrayList<Hectarea> hectareasConCentral;

	private ArrayList<Hectarea> hectareasConPozo;

	private ArrayList<Hectarea> hectareasConBomberos;

	private ArrayList<Hectarea> hectareasResidenciales; 
	
	private ArrayList<Hectarea> hectareasIndustriales;

	private ArrayList<Hectarea> hectareasComerciales;

	private Hectarea hectareaEntradaALaCiudad;
	
	private int dinero;

	
	public Juego() {
		this.mapa = new Mapa(new MapaConPlaya());
		
		this.hectareasResidenciales = new ArrayList<Hectarea>();
		this.hectareasIndustriales = new ArrayList<Hectarea>();
		this.hectareasComerciales = new ArrayList<Hectarea>();
		
		this.hectareasConCentral = new ArrayList<Hectarea>();
		this.hectareasConPozo = new ArrayList<Hectarea>();
		this.hectareasConBomberos = new ArrayList<Hectarea>();
		
		this.hectareaEntradaALaCiudad = this.mapa.obtenerHectarea(mapa.obtenerEntradaALaCiudad());
		
		this.dinero = Configuracion.DINERO_INICIAL;
	}

	public String verMapa(Coordenada coordenada) {
		return this.mapa.obtenerHectarea(coordenada).obtenerNombre();
	}

	private boolean construir(Construccion construccion, Coordenada coordenada) {
		return this.mapa.construir(construccion, coordenada);
	}

	public boolean insertar(Residencia residencia, Coordenada coordenada) {
		if(!this.sePuedeInsertar(residencia, coordenada)) return false;
		this.hectareasResidenciales.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	public boolean insertar(CentralElectrica central, Coordenada coordenada) {
		if(!this.sePuedeInsertar(central, coordenada)) return false;
		this.hectareasConCentral.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	public boolean insertar(PozoDeAgua pozo, Coordenada coordenada) {
		if(!this.sePuedeInsertar(pozo, coordenada)) return false;
		this.hectareasConPozo.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	
	public boolean insertar(EstacionDeBomberos bomberos, Coordenada coordenada) {
		if(!this.sePuedeInsertar(bomberos, coordenada)) return false;
		this.hectareasConBomberos.add(mapa.obtenerHectarea(coordenada));
		return true;
	}
	
	public boolean insertar(Industria industria, Coordenada coordenada) {
		if(!this.sePuedeInsertar(industria, coordenada)) return false;
		this.hectareasIndustriales.add(mapa.obtenerHectarea(coordenada));
		return true;
		
	}

	public boolean insertar(Comercio comercio, Coordenada coordenada) {
		if(!this.sePuedeInsertar(comercio, coordenada)) return false;
		this.hectareasComerciales.add(mapa.obtenerHectarea(coordenada));
		return true;
		
	}
	
	public boolean sePuedeInsertar(IConstruible construible, Coordenada coordenada){
		if(this.dinero < construible.obtenerCosto()){
			return false;
		}
		
		if (!this.construir((Construccion)construible, coordenada)) {
			return false;
		}
		
		this.dinero -= construible.obtenerCosto();
		return true;
	}
	
	public int verDinero() {
		return this.dinero;
	}

}
