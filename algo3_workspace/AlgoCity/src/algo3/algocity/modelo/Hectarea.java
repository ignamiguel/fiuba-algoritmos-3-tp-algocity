package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Hectarea implements IAfectable {

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
		construccion.brindarServicio(this);
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

	public void propagar(IPropagable propagable, Mapa mapa) {

		Coordenada coordAux = new Coordenada(ubicacion.obtenerX(),
				ubicacion.obtenerY());

		if (coordAux.validarCoordenada(mapa)) {

			coordAux.disminuirX(1);
			Hectarea hectarea = mapa.obtenerHectarea(coordAux);
			if (!hectarea.estaActivo(propagable.obtenerServicio())) {

				if (hectarea.tieneConexion(propagable.obtenerConexion())) {
					hectarea.activar(propagable.obtenerServicio());
					hectarea.propagar(propagable, mapa);
				}
			}

			coordAux.aumentarX(1);
			coordAux.aumentarY(1);
			hectarea = mapa.obtenerHectarea(coordAux);

			if (!hectarea.estaActivo(propagable.obtenerServicio())) {
				if (hectarea.tieneConexion(propagable.obtenerConexion())) {
					hectarea.activar(propagable.obtenerServicio());
					hectarea.propagar(propagable, mapa);
				}
			}

			coordAux.disminuirY(1);
			coordAux.aumentarX(1);
			hectarea = mapa.obtenerHectarea(coordAux);
			if (!hectarea.estaActivo(propagable.obtenerServicio())) {
				if (hectarea.tieneConexion(propagable.obtenerConexion())) {
					hectarea.activar(propagable.obtenerServicio());
					hectarea.propagar(propagable, mapa);
				}
			}

			coordAux.disminuirX(1);
			coordAux.disminuirY(1);
			hectarea = mapa.obtenerHectarea(coordAux);
			if (!hectarea.estaActivo(propagable.obtenerServicio())) {
				if (hectarea.tieneConexion(propagable.obtenerConexion())) {
					hectarea.activar(propagable.obtenerServicio());
					hectarea.propagar(propagable, mapa);
				}
			}
		}
	}

	public void activar(TipoDeServicio servicio) {
		this.servicios.add(servicio);

	}

	public boolean estaActivo(TipoDeServicio servicio) {
		for (int i = 0; i < this.servicios.size(); i++) {
			if (this.servicios.get(i) == servicio) {
				return true;
			}
		}
		return false;
	}

}
