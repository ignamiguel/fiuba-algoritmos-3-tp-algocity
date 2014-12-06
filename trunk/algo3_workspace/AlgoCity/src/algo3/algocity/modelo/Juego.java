package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.JFrame;

import algo3.algocity.vista.VistaJuego;

public class Juego extends Observable {

	private Mapa mapa;

	private ArrayList<Coordenada> coordenadasConCentral;

	private ArrayList<Coordenada> coordenadasConPozo;

	private ArrayList<Coordenada> coordenadasConBomberos;

	private ArrayList<Coordenada> coordenadasResidenciales;

	private ArrayList<Coordenada> coordenadasIndustriales;

	private ArrayList<Coordenada> coordenadasComerciales;
	
	private ArrayList<Coordenada> coordenadasConConexiones;

	private Coordenada coordenadaEntradaALaCiudad;

	private int dinero;

	private int turno;

	private int habitantes;

	public Juego() {
		this.mapa = new Mapa(new MapaConPlaya());

		this.coordenadasResidenciales = new ArrayList<Coordenada>();
		this.coordenadasIndustriales = new ArrayList<Coordenada>();
		this.coordenadasComerciales = new ArrayList<Coordenada>();

		this.coordenadasConCentral = new ArrayList<Coordenada>();
		this.coordenadasConPozo = new ArrayList<Coordenada>();
		this.coordenadasConBomberos = new ArrayList<Coordenada>();
		this.coordenadasConConexiones = new ArrayList<Coordenada>();

		this.coordenadaEntradaALaCiudad = this.mapa.obtenerEntradaALaCiudad();

		this.dinero = Configuracion.DINERO_INICIAL;
		this.turno = 1;
		this.habitantes = 0;
	}

	public String verMapa(Coordenada coordenada) {
		return this.mapa.obtenerHectarea(coordenada).obtenerNombre();
	}

	private boolean construir(Construccion construccion, Coordenada coordenada) {
		return this.mapa.construir(construccion, coordenada);
	}

	private boolean conectar(Conexion conexion, Coordenada coordenada) {
		return this.mapa.conectar(conexion, coordenada);
	}

	public boolean insertar(Residencia residencia, Coordenada coordenada) {
		if (!this.sePuedeInsertar(residencia, coordenada))
			return false;
		this.coordenadasResidenciales.add(coordenada);
		return true;
	}

	public boolean insertar(CentralElectrica central, Coordenada coordenada) {
		if (!this.sePuedeInsertar(central, coordenada))
			return false;
		this.coordenadasConCentral.add(coordenada);
		return true;
	}

	public boolean insertar(PozoDeAgua pozo, Coordenada coordenada) {
		if (!this.sePuedeInsertar(pozo, coordenada))
			return false;
		this.coordenadasConPozo.add(coordenada);
		return true;
	}

	public boolean insertar(EstacionDeBomberos bomberos, Coordenada coordenada) {
		if (!this.sePuedeInsertar(bomberos, coordenada))
			return false;
		this.coordenadasConBomberos.add(coordenada);
		return true;
	}

	public boolean insertar(Industria industria, Coordenada coordenada) {
		if (!this.sePuedeInsertar(industria, coordenada))
			return false;
		this.coordenadasIndustriales.add(coordenada);
		return true;
	}

	public boolean insertar(Comercio comercio, Coordenada coordenada) {
		if (!this.sePuedeInsertar(comercio, coordenada))
			return false;
		this.coordenadasComerciales.add(coordenada);
		return true;

	}

	public boolean insertar(IConectable conectable, Coordenada coordenada) {
		if (!this.sePuedeInsertar(conectable, coordenada))
			return false;
		if (!this.coordenadasConConexiones.contains(coordenada)) {
			this.coordenadasConConexiones.add(coordenada);
		}
		return true;
	}

	public boolean sePuedeInsertar(IConectable conectable, Coordenada coordenada) {
		if (this.dinero < conectable.obtenerCosto()) {
			return false;
		}

		if (!this.conectar((Conexion) conectable, coordenada)) {
			return false;
		}

		this.dinero -= conectable.obtenerCosto();
		return true;
	}

	public boolean sePuedeInsertar(IConstruible construible,
			Coordenada coordenada) {
		if (this.dinero < construible.obtenerCosto()) {
			return false;
		}

		if (!this.construir((Construccion) construible, coordenada)) {
			return false;
		}

		this.dinero -= construible.obtenerCosto();
		return true;
	}

	public int verDinero() {
		return this.dinero;
	}

	public void iniciar() {

		this.inicializarModeloDato();
	}

	public void setModeloDato(Coordenada coordenada, int dato) {
		// modeloDatos[posicion.x][posicion.y] = dato;
		// setChanged();
		// this.notifyObservers();
	}

	public void inicializarModeloDato() {

		setChanged();

		this.notifyObservers();
	}

	public boolean esTerreno(Coordenada coordenada) {
		Hectarea h = mapa.obtenerHectarea(coordenada);
		if (h.obtenerNombre() == "Terreno") {
			return true;
		}
		return false;
	}

	public Mapa getMapa() {
		return this.mapa;
	}

	public ArrayList<Coordenada> obtenerCoordenadasResidenciales() {
		return this.coordenadasResidenciales;
	}

	public ArrayList<Coordenada> obtenerCoordenadasIndustriales() {
		return this.coordenadasIndustriales;
	}

	public ArrayList<Coordenada> obtenerCoordenadasComerciales() {
		return this.coordenadasComerciales;
	}

	public ArrayList<Coordenada> obtenerCoordenadasConCentral() {
		return this.coordenadasConCentral;
	}


	public ArrayList<Coordenada> obtenerCoordenadasConPozo() {
		return this.coordenadasConPozo;
	}

	public int obtenerTurno() {
		return this.turno;
	}

	public void pasarTurno() {

		this.turno++;

		if (turno % Configuracion.TURNO_RECAUDADOR == 0) {
			dinero += this.habitantes * 10;
		}

		this.desconectarServicios();

		// Ataque de godilla o terremoto - ALEATORIO
		
		// Reparacion de bomberos
		
		this.propagarServicioDeAgua();
		this.propagarServicioElectrico();
		this.propagarServicioDeTransito();

		this.mudarHabitantes();

	}

	public void desconectarServicios() {
		mapa.desconectarServicios();
	}

	private void mudarHabitantes() {

		int capacidadDeAlojamiento = 0;
		int capacidadDeTrabajo = 0;
		int habitantesAMudar = 0;

		Iterator<Coordenada> i = coordenadasResidenciales.iterator();
		while (i.hasNext()) {
			Hectarea hectarea = mapa.obtenerHectarea(i.next());
			capacidadDeAlojamiento += hectarea.obtenerCapacidadDeAlojamiento();
		}

		Iterator<Coordenada> j = coordenadasIndustriales.iterator();
		while (j.hasNext()) {
			Hectarea hectarea = mapa.obtenerHectarea(j.next());
			capacidadDeTrabajo += hectarea.obtenerCapacidadDeTrabajo();
		}

		habitantesAMudar = ((capacidadDeTrabajo - this.habitantes) * Configuracion.PORCENTAJE_DE_MUDANZA) / 100;
		if(habitantesAMudar + this.habitantes > capacidadDeAlojamiento){
			this.habitantes = capacidadDeAlojamiento;
		}
		if(habitantesAMudar + this.habitantes < 0){
			this.habitantes = 0;
		}
		this.habitantes = habitantesAMudar + this.habitantes;
		
	}

	private void propagarServicioDeTransito() {
		this.mapa.propagarServicio(coordenadaEntradaALaCiudad);
	}

	private void propagarServicioDeAgua() {
		Iterator<Coordenada> i = coordenadasConPozo.iterator();
		while (i.hasNext()) {
			Coordenada c = i.next();
			mapa.propagarServicio(c);
		}

	}

	private void propagarServicioElectrico() {
		Iterator<Coordenada> i = coordenadasConCentral.iterator();
		while (i.hasNext()) {
			Coordenada c = i.next();
			mapa.propagarServicio(c);
		}
	}

	public int obtenerHabitantes() {
		return this.habitantes;
	}

	public void conectarServicios() {
		this.mapa.conectarServicios();
	}

	public ArrayList<Coordenada> obtenerCoordenadasConBomberos() {
		return this.coordenadasConBomberos;
	}

	public ArrayList<Coordenada> obtenerCoordenadasConConexiones() {
		return this.coordenadasConConexiones;
	}

}
