package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

public abstract class Hectarea extends Observable implements IAfectable {

	// Atributos de la clase
	protected List<IConectable> conexiones = new ArrayList<IConectable>();
	protected List<TipoDeServicio> servicios = new ArrayList<TipoDeServicio>();
	protected Construccion construccion;
	protected Coordenada ubicacion;

	/* METODOS PUBLICOS */
	public abstract String getNombre();

	public boolean estaVacia() {
		return (construccion == null);
	}

	public boolean construir(Construccion construccion) {
		if (!this.estaVacia()) {
			return false;
		}

		if (!this.permite(construccion)) {
			return false;
		}

		this.construccion = construccion;
		notificarCambio();
		return true;
	}

	public boolean conectar(Conexion conexion) {
		if (this.tieneConexion(conexion.getTipo())) {
			return false;
		}

		if (!this.permite(conexion)) {
			return false;
		}

		this.conexiones.add(conexion);
		notificarCambio();
		return true;

	}

	public abstract boolean permite(Construccion construccion);

	public abstract boolean permite(Conexion conexion);

	public Construccion getConstruccion() {
		return this.construccion;
	}

	public void setUbicacion(Coordenada unaCoordenada) {
		this.ubicacion = unaCoordenada;
	}

	public Coordenada getUbicacion() {
		return this.ubicacion;
	}

	public boolean tieneConexion(TipoDeConexion servicio) {
		for (int i = 0; i < this.conexiones.size(); i++) {
			if (this.conexiones.get(i).getTipo() == servicio) {
				return true;
			}
		}
		return false;
	}

	public void afectarCon(Godzilla godzilla) {
		// Defino que Godzilla dana las conexiones, no lo servicios.
		// Hay que definir con que nivel de salud de la conexion,
		// el servicio se considera activo.

		if (!this.estaVacia()) {
			this.construccion.afectarCon(godzilla);
		}

		Iterator<IConectable> i = conexiones.iterator();
		while (i.hasNext()) {
			i.next().afectarCon(godzilla);
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void afectarCon(Terremoto unTerremoto) {

		if (!this.estaVacia()) {
			this.construccion.afectarCon(unTerremoto);
		}

		Iterator<IConectable> i = conexiones.iterator();
		while (i.hasNext()) {
			i.next().afectarCon(unTerremoto);
		}
		this.setChanged();
		this.notifyObservers();
	}

	public void activar(TipoDeServicio servicio) {
		this.servicios.add(servicio);
		notificarCambio();
	}

	public boolean estaActivo(TipoDeServicio servicio) {
		return this.servicios.contains(servicio);
	}

	public int getConsumo() {
		if (this.estaVacia()) {
			return 0;
		}
		return (this.construccion).getConsumoElectrico();
	}

	public void desconectarServicios() {
		this.servicios.clear();
		notificarCambio();
	}

	public int getCapacidadDeAlojamiento() {
		if (this.estaVacia()) {
			return 0;
		}

		// Consulto si la hectarea tiene los servicios
		// que requiere la construccion
		if (!this.estanActivosLosServiciosRequeridosPorLaConstruccion()) {
			return 0;
		}

		return this.construccion.getCapacidadDeAlojamiento();
	}

	public boolean estanActivosLosServiciosRequeridosPorLaConstruccion() {
		if(this.estaVacia()){
			return true;
		}
		
		return (this.servicios.containsAll(this.construccion
				.getServiciosRequeridos()));
	}

	public int getCapacidadDeTrabajo() {
		if (this.estaVacia()) {
			return 0;
		}

		if (!this.estanActivosLosServiciosRequeridosPorLaConstruccion()) {
			return 0;
		}
		return this.construccion.getPuestosDeTrabajo();
	}

	public void reparar() {

		if (!this.estaVacia()) {
			(this.construccion).reparar();
		}

		Iterator<IConectable> i = conexiones.iterator();
		while (i.hasNext()) {
			i.next().reparar();
		}
		notificarCambio();
	}

	protected void notificarCambio() {
		this.setChanged();
		this.notifyObservers();
	}

	public List<IConectable> getConexiones() {
		return this.conexiones;
	}
	
	public List<TipoDeServicio> getServicios(){
		return this.servicios;
	}

}
