// Comentario
package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.JFrame;

import algo3.algocity.vista.VistaJuego;

public class Juego extends Observable {

	private Mapa mapa;

	private ArrayList<Hectarea> hectareasConCentral;

	private ArrayList<Hectarea> hectareasConPozo;

	private ArrayList<Hectarea> hectareasConBomberos;

	private ArrayList<Hectarea> hectareasResidenciales;

	private ArrayList<Hectarea> hectareasIndustriales;

	private ArrayList<Hectarea> hectareasComerciales;

	private Hectarea hectareaEntradaALaCiudad;

	private int dinero;

	private int turno;

	private ArrayList<Hectarea> hectareasConConexiones;
	// Para no recorrer toda la matriz para desconctar
	// Si hacemos el propagar por radio, esto ya no sirve

	private int habitantes;

	public Juego() {
		this.mapa = new Mapa(new MapaConPlaya());

		this.hectareasResidenciales = new ArrayList<Hectarea>();
		this.hectareasIndustriales = new ArrayList<Hectarea>();
		this.hectareasComerciales = new ArrayList<Hectarea>();

		this.hectareasConCentral = new ArrayList<Hectarea>();
		this.hectareasConPozo = new ArrayList<Hectarea>();
		this.hectareasConBomberos = new ArrayList<Hectarea>();

		this.hectareasConConexiones = new ArrayList<Hectarea>();
		this.hectareaEntradaALaCiudad = this.mapa.obtenerHectarea(mapa
				.obtenerEntradaALaCiudad());

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
		this.hectareasResidenciales.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	public boolean insertar(CentralElectrica central, Coordenada coordenada) {
		if (!this.sePuedeInsertar(central, coordenada))
			return false;
		this.hectareasConCentral.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	public boolean insertar(PozoDeAgua pozo, Coordenada coordenada) {
		if (!this.sePuedeInsertar(pozo, coordenada))
			return false;
		this.hectareasConPozo.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	public boolean insertar(EstacionDeBomberos bomberos, Coordenada coordenada) {
		if (!this.sePuedeInsertar(bomberos, coordenada))
			return false;
		this.hectareasConBomberos.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	public boolean insertar(Industria industria, Coordenada coordenada) {
		if (!this.sePuedeInsertar(industria, coordenada))
			return false;
		this.hectareasIndustriales.add(mapa.obtenerHectarea(coordenada));
		return true;
	}

	public boolean insertar(Comercio comercio, Coordenada coordenada) {
		if (!this.sePuedeInsertar(comercio, coordenada))
			return false;
		this.hectareasComerciales.add(mapa.obtenerHectarea(coordenada));
		return true;

	}

	public boolean insertar(IConectable conectable, Coordenada coordenada) {
		if (!this.sePuedeInsertar(conectable, coordenada))
			return false;
		Hectarea hectarea = mapa.obtenerHectarea(coordenada);
		if (!this.hectareasConConexiones.contains(hectarea)) {
			this.hectareasConConexiones.add(hectarea);
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

	public ArrayList<Hectarea> obtenerHectareasResidenciales() {
		return this.hectareasResidenciales;
	}

	public ArrayList<Hectarea> obtenerHectareasIndustriales() {
		return this.hectareasIndustriales;
	}

	public ArrayList<Hectarea> obtenerHectareasComerciales() {
		return this.hectareasComerciales;
	}

	public ArrayList<Hectarea> obtenerHectareasConCentral() {
		return this.hectareasConCentral;
	}

	public ArrayList<Hectarea> obtenerHectareasConBomberos() {
		return this.hectareasConBomberos;
	}

	public ArrayList<Hectarea> obtenerHectareasConPozo() {
		return this.hectareasConPozo;
	}

	public ArrayList<Hectarea> obtenerHectareasConConexiones() {
		return this.hectareasConConexiones;
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

		this.propagarServicioDeAgua();
		this.propagarServicioElectrico();
		this.propagarServicioDeTransito();

		this.mudarHabitantes();

	}

	private int mudarHabitantes() {

		int capacidadDeAlojamiento = 0;
		int capacidadDeTrabajo = 0;
		int habitantesAMudar = 0;

		Iterator<Hectarea> i = hectareasResidenciales.iterator();
		while (i.hasNext()) {
			Hectarea hectarea = i.next();
			capacidadDeAlojamiento += hectarea.obtenerCapacidadDeAlojamiento();
		}

		Iterator<Hectarea> j = hectareasIndustriales.iterator();
		while (j.hasNext()) {
			Hectarea hectarea = j.next();
			capacidadDeTrabajo += hectarea.obtenerCapacidadDeTrabajo();
		}

		habitantesAMudar = ((capacidadDeTrabajo - capacidadDeAlojamiento) * Configuracion.PORCENTAJE_DE_MUDANZA) / 100;
		return habitantesAMudar;
	}

	private void desconectarServicios() {
		Iterator<Hectarea> i = hectareasConConexiones.iterator();
		while (i.hasNext()) {
			Hectarea hectarea = i.next();
			hectarea.desconectarServicios();
		}

		Iterator<Hectarea> j = hectareasConCentral.iterator();
		while (j.hasNext()) {
			Hectarea hectarea = j.next();
			CentralElectrica central = (CentralElectrica) hectarea
					.obtenerConstruccion();
			central.resetearAbastecimiento();
		}

	}

	private void propagarServicioDeTransito() {
		Construccion entrada = hectareaEntradaALaCiudad.obtenerConstruccion();
		this.hectareaEntradaALaCiudad.propagar((IPropagable) entrada, mapa);

	}

	private void propagarServicioDeAgua() {
		Iterator<Hectarea> i = hectareasConPozo.iterator();
		while (i.hasNext()) {
			Hectarea hectarea = i.next();
			hectarea.propagar((IPropagable) hectarea.obtenerConstruccion(),
					mapa);
		}

	}

	private void propagarServicioElectrico() {
		Iterator<Hectarea> i = hectareasConCentral.iterator();
		while (i.hasNext()) {
			Hectarea hectarea = i.next();
			if (hectarea.estaActivo(TipoDeServicio.Cloacas))
				hectarea.propagar((IPropagable) hectarea.obtenerConstruccion(),
						mapa);
		}
	}

}
