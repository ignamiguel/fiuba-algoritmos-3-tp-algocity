package algo3.algocity.modelo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Mapa {

	private Hectarea area[][];
	private int tamanio;
	private Coordenada entradaAlaCiudad;

	public Mapa(IGeneradorDeMapa generadorDeMapa) {

		this.tamanio = generadorDeMapa.obtenerTamanio();
		this.area = new Hectarea[tamanio][tamanio];
		this.entradaAlaCiudad = generadorDeMapa.obtenerEntradaALaCiudad();

		generadorDeMapa.generarArea(this.area);

		this.construir(new EntradaAlaCiudad(), this.entradaAlaCiudad);
		this.conectar(new Ruta(), this.entradaAlaCiudad);

	}

	public Hectarea getHectarea(Coordenada coordenada) {
		if (!this.coordenadaValida(coordenada)) {
			throw new CoordenadaInvalidaExcepcion();
		}
		return area[coordenada.obtenerX()][coordenada.obtenerY()];
	}

	public boolean construir(Construccion construccion, Coordenada coordenada) {
		Hectarea hectarea = this.getHectarea(coordenada);
		return hectarea.construir(construccion);
	}

	public boolean coordenadaValida(Coordenada coord) {
		int coorX = coord.obtenerX();
		int coorY = coord.obtenerY();
		if ((coorX >= 0) & (coorX < tamanio) & (coorY >= 0) & (coorY < tamanio))
			return true;
		else
			return false;
	}

	public int getTamanio() {
		return this.tamanio;
	}

	public boolean conectar(Conexion conexion, Coordenada coordenada) {
		Hectarea hectarea = this.getHectarea(coordenada);
		return hectarea.conectar(conexion);

	}

	public Coordenada obtenerEntradaALaCiudad() {
		return this.entradaAlaCiudad;
	}

	/*----- PROPAGAR SERVICIOS DESDE MAPA ------*/

	public void propagarServicio(Coordenada origen) {

		// Consulto si puedo propagar
		// ya que las centrales necesitan estar conectados
		// a la red de agua para funcionar
		if (!this.getHectarea(origen)
				.estanActivosLosServiciosRequeridosPorLaConstruccion()) {
			return;
		}

		// Declaro una cola de prioridad
		// A menor distancia, mas prioridad
		Comparator<Nodo> comparator = new NodeComparator();
		PriorityQueue<Nodo> queue = new PriorityQueue<Nodo>(10, comparator);

		IPropagable servicio = (IPropagable) this.getHectarea(origen)
				.getConstruccion();

		int radio = servicio.getRadioDeCovertura();

		queue.add(new Nodo(origen, 0));

		this.procesarColaDePropagacion(servicio, queue, radio);
	}

	private void procesarColaDePropagacion(IPropagable servicio,
			PriorityQueue<Nodo> queue, int radio) {

		// Declaro un set
		// para marcar las Hectareas visitadas
		Set<Hectarea> visitadas = new HashSet<Hectarea>();

		int radioParcial = 0;

		while (queue.size() > 0) {

			Nodo n = queue.remove();
			Hectarea h = this.getHectarea(n.getCoordenada());

			if (!visitadas.contains(h)) {
				visitadas.add(h);

				if (radioParcial > radio) {
					if (!h.tieneConexion(servicio.getConexionNecesaria()))
						continue;
				}

				this.procesarHectarea(h, servicio);

				cargarVecinos(n.getCoordenada(), queue, n.getDistancia() + 1);
			}

			// Si el proximo elemento de la cola
			// tiene una distancia mayor al anterior
			// entonces, el radio se incrementa
			if (queue.size() > 0) {
				if (queue.peek().getDistancia() > n.getDistancia())
					radioParcial++;
			}
		}
	}

	private void procesarHectarea(Hectarea hectarea, IPropagable servicio) {
		if (hectarea.estaActivo(servicio.getServicioPropagable())) {
			return;
		}

		if (!servicio.puedoBrindarleElServicio(hectarea)) {
			return;
		}

		// El consumo fue descontado del metodo
		// puedoBrindarleElServicio()
		hectarea.activar(servicio.getServicioPropagable());
	}

	private void cargarVecinos(Coordenada posicion, PriorityQueue<Nodo> queue,
			int distancia) {
		if (coordenadaValida(posicion.moverArriba()))
			queue.add(new Nodo(posicion.copiar(), distancia));
		posicion.moverAbajo();

		if (coordenadaValida(posicion.moverDerecha()))
			queue.add(new Nodo(posicion.copiar(), distancia));
		posicion.moverIzquierda();

		if (coordenadaValida(posicion.moverAbajo()))
			queue.add(new Nodo(posicion.copiar(), distancia));
		posicion.moverArriba();

		if (coordenadaValida(posicion.moverIzquierda()))
			queue.add(new Nodo(posicion.copiar(), distancia));
		posicion.moverDerecha();
	}

	public void desconectarServicios() {
		for (int i = 0; i < this.tamanio; i++) {
			for (int j = 0; j < this.tamanio; j++) {
				Coordenada c = new Coordenada(i, j);
				Hectarea hectarea = this.getHectarea(c);
				hectarea.desconectarServicios();
			}
		}

	}

	public void conectarServicios() {
		for (int i = 0; i < this.tamanio; i++) {
			for (int j = 0; j < this.tamanio; j++) {
				Coordenada c = new Coordenada(i, j);
				Hectarea hectarea = this.getHectarea(c);
				hectarea.activar(TipoDeServicio.AccesoAlTransito);
				hectarea.activar(TipoDeServicio.Electrico);
				hectarea.activar(TipoDeServicio.Cloacas);
			}
		}

	}

	public void afectarConTerremoto(Terremoto t) {
		Coordenada epicentro = t.getEpicentro();

		// Declaro una cola de prioridad
		// A menor distancia, mas prioridad
		Comparator<Nodo> comparator = new NodeComparator();
		PriorityQueue<Nodo> queue = new PriorityQueue<Nodo>(10, comparator);

		queue.add(new Nodo(epicentro, 0));

		this.propagarTerremoto(queue, t);
	}

	private void propagarTerremoto(PriorityQueue<Nodo> queue, Terremoto terremoto) {
		// Declaro un set
		// para marcar las Hectareas visitadas
		Set<Hectarea> visitadas = new HashSet<Hectarea>();

		while (queue.size() > 0) {

			Nodo n = queue.remove();
			Hectarea h = this.getHectarea(n.getCoordenada());

			if (!visitadas.contains(h)) {
				visitadas.add(h);

				h.afectarCon(terremoto);

				cargarVecinos(n.getCoordenada(), queue, n.getDistancia() + 1);
			}

			// Si el proximo elemento de la cola
			// tiene una distancia mayor al anterior
			// quiere decir que incrementamos el radio y
			// entonces el daño del terremoto decrece
			if (queue.size() > 0) {
				if (queue.peek().getDistancia() > n.getDistancia())
					terremoto.disminuirAveria();
			}
			
			// Si las averia del terremoto llegaron a 0
			// dejamos de propagar
			if(terremoto.getAveria() <= 0){
				return;
			}
		}

	}
}
