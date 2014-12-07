package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public abstract class Hectarea extends Observable implements IAfectable {

	// Atributos de la clase
	protected ArrayList<IConectable> conexiones;
	protected ArrayList<TipoDeServicio> servicios;
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

	}

	public void afectarCon(Terremoto unTerremoto) {

		if (!this.estaVacia()) {
			this.construccion.afectarCon(unTerremoto);
		}

		Iterator<IConectable> i = conexiones.iterator();
		while (i.hasNext()) {
			i.next().afectarCon(unTerremoto);
		}

	}

	public void activar(TipoDeServicio servicio) {
		this.servicios.add(servicio);

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
	}

	public int obtenerCapacidadDeAlojamiento() {
		return ((Residencia) this.construccion).calcularCapacidadDeAlojamiento(this.servicios);
	}

	public int obtenerCapacidadDeTrabajo() {
		return ((Industria) this.construccion).calcularPuestosDeTrabajo(this.servicios);
	}

	public void reparar() {
		
		if (!this.estaVacia()) {
			(this.construccion).reparar();
		}

		Iterator<IConectable> i = conexiones.iterator();
		while (i.hasNext()) {
			i.next().reparar();
		}
	}

	public void cambiar() {
		// TODO Auto-generated method stub
		this.construccion = new Residencia();
		this.setChanged();
		this.notifyObservers();
	}

}
