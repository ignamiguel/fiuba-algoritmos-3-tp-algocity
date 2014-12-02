package algo3.algocity.modelo;

import java.util.ArrayList;

public abstract class Hectarea {

	// Atributos de la clase
	protected ArrayList<IConectable> conexiones;
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

	public abstract boolean permite(Construccion construccion);

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
}
