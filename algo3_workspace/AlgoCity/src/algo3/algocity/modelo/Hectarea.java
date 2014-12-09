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

	public abstract String obtenerNombre();

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
		if (this.tieneConexion(conexion.obtenerTipo())) {
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

	public Construccion obtenerConstruccion() {
		return this.construccion;
	}

	public void guardarUbicacion(Coordenada unaCoordenada) {
		this.ubicacion = unaCoordenada;
	}

	public Coordenada obtenerUbicacion() {
		return this.ubicacion;
	}

	public boolean tieneConexion(TipoDeConexion servicio) {
		for (int i = 0; i < this.conexiones.size(); i++) {
			if (this.conexiones.get(i).obtenerTipo() == servicio) {
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

	public int obtenerConsumo() {
		if (this.estaVacia()) {
			return 0;
		}
		return (this.construccion).obtenerConsumoElectrico();
	}

	public void desconectarServicios() {
		this.servicios.clear();
		notificarCambio();
	}

	public int obtenerCapacidadDeAlojamiento() {
		if (this.estaVacia()) {
			return 0;
		}
		return this.construccion.calcularCapacidadDeAlojamiento(this.servicios);
	}

	public int obtenerCapacidadDeTrabajo() {
		if (this.estaVacia()) {
			return 0;
		}
		return this.construccion.calcularPuestosDeTrabajo(this.servicios);
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

}
