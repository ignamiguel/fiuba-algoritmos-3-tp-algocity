package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class Juego extends Observable {

	private Mapa mapa;

	private List<Coordenada> coordenadasConCentral;

	private List<Coordenada> coordenadasConPozos;

	private List<EstacionDeBomberos> estacionesDeBomberos;

	private List<Coordenada> coordenadasResidenciales;

	private List<Coordenada> coordenadasIndustriales;

	private List<Coordenada> coordenadasComerciales;

	private List<Coordenada> coordenadasConConexiones;

	private Coordenada coordenadaEntradaALaCiudad;

	private int dinero;

	private int turno;

	private int ciudadanos;

	private String jugador;

	/* CONSTRUCTORES */

	public Juego() {
		this.mapa = new Mapa(new MapaConPlaya());

		this.coordenadasResidenciales = new ArrayList<Coordenada>();
		this.coordenadasIndustriales = new ArrayList<Coordenada>();
		this.coordenadasComerciales = new ArrayList<Coordenada>();

		this.coordenadasConCentral = new ArrayList<Coordenada>();
		this.coordenadasConPozos = new ArrayList<Coordenada>();
		this.coordenadasConConexiones = new ArrayList<Coordenada>();

		this.coordenadaEntradaALaCiudad = this.mapa.obtenerEntradaALaCiudad();

		this.estacionesDeBomberos = new ArrayList<EstacionDeBomberos>();

		this.dinero = Configuracion.DINERO_INICIAL;
		this.turno = Configuracion.TURNO_INICIAL;
		this.ciudadanos = Configuracion.CIUDADANOS_INICIALES;
		this.jugador = Configuracion.JUGADOR_DEFAULT;
	}

	public Juego(String jugador) {
		this.mapa = new Mapa(new MapaConPlaya());

		this.coordenadasResidenciales = new ArrayList<Coordenada>();
		this.coordenadasIndustriales = new ArrayList<Coordenada>();
		this.coordenadasComerciales = new ArrayList<Coordenada>();

		this.coordenadasConCentral = new ArrayList<Coordenada>();
		this.coordenadasConPozos = new ArrayList<Coordenada>();
		this.coordenadasConConexiones = new ArrayList<Coordenada>();

		this.coordenadaEntradaALaCiudad = this.mapa.obtenerEntradaALaCiudad();

		this.estacionesDeBomberos = new ArrayList<EstacionDeBomberos>();

		this.dinero = Configuracion.DINERO_INICIAL;
		this.turno = Configuracion.TURNO_INICIAL;
		this.ciudadanos = Configuracion.CIUDADANOS_INICIALES;
		this.jugador = jugador;
	}

	/* METODOS PUBLICOS */

	public void iniciar() {
		this.inicializarModeloDato();
	}

	public int getDinero() {
		return this.dinero;
	}

	public int getCiudadanos() {
		return this.ciudadanos;
	}

	public int getTurno() {
		return this.turno;
	}

	public Mapa getMapa() {
		return this.mapa;
	}

	public void turnoAvanzar() {
		this.turno++;

		if (this.seDebePagarImpuestosEnEsteTurno()) {
			this.cobrarImpuestos();
		}

		// Desconectamos los servicios temporalmente para luego
		// volver a propagarlos y asi, impactar las averias
		// de las catastrofes
		this.desconectarServicios();

		this.generarCatastrofeAleatoria();

		this.propagarServicioDeAgua();
		this.propagarServicioElectrico();
		this.propagarServicioDeTransito();

		this.procesarCiudadanos();

		this.repararAverias();

		this.notificarCambio();
	}

	public boolean insertar(Residencia residencia, Coordenada coordenada) {
		if (!this.hayDineroSuficiente(residencia)) {
			return false;
		}

		if (!this.construir(residencia, coordenada)) {
			return false;
		}

		this.coordenadasResidenciales.add(coordenada);
		return true;
	}

	public boolean insertar(Comercio comercio, Coordenada coordenada) {
		if (!this.hayDineroSuficiente(comercio)) {
			return false;
		}

		if (!this.construir(comercio, coordenada)) {
			return false;
		}

		this.coordenadasComerciales.add(coordenada);
		return true;

	}

	public boolean insertar(Industria industria, Coordenada coordenada) {
		if (!this.hayDineroSuficiente(industria)) {
			return false;
		}

		if (!this.construir(industria, coordenada)) {
			return false;
		}
		this.coordenadasIndustriales.add(coordenada);
		return true;
	}

	public boolean insertar(CentralElectrica central, Coordenada coordenada) {
		if (!this.hayDineroSuficiente(central)) {
			return false;
		}

		if (!this.construir(central, coordenada)) {
			return false;
		}

		this.coordenadasConCentral.add(coordenada);
		return true;
	}

	public boolean insertar(PozoDeAgua pozo, Coordenada coordenada) {
		if (!this.hayDineroSuficiente(pozo)) {
			return false;
		}

		if (!this.construir(pozo, coordenada)) {
			return false;
		}

		this.coordenadasConPozos.add(coordenada);
		return true;
	}

	public boolean insertar(EstacionDeBomberos bomberos, Coordenada coordenada) {
		if (!this.hayDineroSuficiente(bomberos)) {
			return false;
		}

		if (!this.construir(bomberos, coordenada)) {
			return false;
		}

		this.estacionesDeBomberos.add(bomberos);
		return true;
	}

	public boolean insertar(Conexion conexion, Coordenada coordenada) {
		if (!this.hayDineroSuficiente(conexion)) {
			return false;
		}

		if (!this.conectar(conexion, coordenada)) {
			return false;
		}

		if (!this.coordenadasConConexiones.contains(coordenada)) {
			this.coordenadasConConexiones.add(coordenada);
		}
		return true;
	}

	public void repararAverias() {
		Iterator<EstacionDeBomberos> i = estacionesDeBomberos.iterator();
		while (i.hasNext()) {
			EstacionDeBomberos bomberos = i.next();
			bomberos.repararAverias(this.mapa);
		}

	}

	public List<Coordenada> getCoordenadasResidenciales() {
		return this.coordenadasResidenciales;
	}

	public List<Coordenada> getCoordenadasIndustriales() {
		return this.coordenadasIndustriales;
	}

	public List<Coordenada> getCoordenadasComerciales() {
		return this.coordenadasComerciales;
	}

	public List<Coordenada> getCoordenadasConCentral() {
		return this.coordenadasConCentral;
	}

	public List<Coordenada> getCoordenadasConPozo() {
		return this.coordenadasConPozos;
	}

	public List<EstacionDeBomberos> getEstacionesDeBomberos() {
		return this.estacionesDeBomberos;
	}

	public List<Coordenada> getCoordenadasConConexiones() {
		return this.coordenadasConConexiones;
	}

	public void conectarServicios() {
		this.mapa.conectarServicios();
	}

	public void desconectarServicios() {
		mapa.desconectarServicios();
	}

	public void despertarAGodzilla(IAtaqueGodzilla generadorGodzilla) {
		Godzilla godzilla = new Godzilla();
		godzilla.atacar(mapa, generadorGodzilla);
	}

	public String getJugador() {
		return this.jugador;
	}

	/* METODOS PRIVADOS */

	private boolean seDebePagarImpuestosEnEsteTurno() {
		return ((this.turno % Configuracion.TURNO_RECAUDADOR) == 0);
	}

	private void cobrarImpuestos() {
		this.dinero += (this.ciudadanos * Configuracion.IMPUESTOS_POR_CIUDADANO);
	}

	private boolean construir(Construccion construccion, Coordenada coordenada) {
		if (!this.mapa.construir(construccion, coordenada)) {
			return false;
		}
		this.dinero -= construccion.getCosto();
		this.notificarCambio();
		return true;
	}

	private boolean conectar(Conexion conexion, Coordenada coordenada) {
		if (!this.mapa.conectar(conexion, coordenada)) {
			return false;
		}

		this.dinero -= conexion.getCosto();
		this.notificarCambio();
		return true;
	}

	private boolean hayDineroSuficiente(IConstruible construible) {
		if (this.dinero < construible.getCosto()) {
			return false;
		}
		return true;
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

	private void generarCatastrofeAleatoria() {
		Random aleatorio = new Random();
		int numeroAleatorio = aleatorio
				.nextInt(Configuracion.PROBABILIDAD_DE_CATASTROFE);

		if (numeroAleatorio == 0) {
			this.despertarAGodzilla(new AtaqueGodzillaAleatorio(mapa));
		}

		if (numeroAleatorio == 1) {
			Terremoto t = new Terremoto(new GeneradorEpicentro(
					this.mapa.getTamanio()));
			mapa.afectarConTerremoto(t);
		}

	}

	private void procesarCiudadanos() {

		int alojamientoBruto = 0;
		int trabajoBruto = 0;
		int deltaHabitantesTurno = 0;

		Iterator<Coordenada> i = coordenadasResidenciales.iterator();
		while (i.hasNext()) {
			Hectarea hectarea = mapa.getHectarea(i.next());
			alojamientoBruto += hectarea.getCapacidadDeAlojamiento();
		}

		int alojamientoNeto = (alojamientoBruto - this.ciudadanos);

		Iterator<Coordenada> j = coordenadasIndustriales.iterator();
		while (j.hasNext()) {
			Hectarea hectarea = mapa.getHectarea(j.next());
			trabajoBruto += hectarea.getCapacidadDeTrabajo();
		}

		int trabajoNeto = (trabajoBruto - this.ciudadanos);

		// Calculamos el cuello de botella
		// entre alojamiento y trabajo
		deltaHabitantesTurno = Math.min(alojamientoNeto, trabajoNeto);

		// Comparamos el delta con los visitantes
		// y actualizamos los ciudadanos
		this.ciudadanos += Math.min(deltaHabitantesTurno,
				Configuracion.VISITANTES_POR_TURNO);

	}

	private void propagarServicioDeTransito() {
		this.mapa.propagarServicio(coordenadaEntradaALaCiudad);
	}

	private void propagarServicioDeAgua() {
		Iterator<Coordenada> i = coordenadasConPozos.iterator();
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

	private void notificarCambio() {
		setChanged();
		notifyObservers();
	}

	/* BORRAR */

	public String verMapa(Coordenada coordenada) {
		return this.mapa.getHectarea(coordenada).getNombre();
	}

}
