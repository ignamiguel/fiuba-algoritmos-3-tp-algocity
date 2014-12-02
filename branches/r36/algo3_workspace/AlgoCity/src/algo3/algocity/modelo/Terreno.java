package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Terreno extends Hectarea {

	protected ArrayList<TipoDeServicio> servicios;

	public Terreno() {
		this.conexiones = new ArrayList<IConectable>();
		this.servicios = new ArrayList<TipoDeServicio>();
		this.construccion = null;
	}

	public String obtenerNombre() {
		return "Terreno";
	}

	@Override
	public boolean permite(Construccion construccion) {
		return construccion.puedoEn(this);
	}

	public void conectar(Ruta ruta) {
		this.conexiones.add(ruta);
	}

	public void conectar(Tuberia tuberia) {
		this.conexiones.add(tuberia);
	}

	public void conectar(LineaDeTension linea) {
		this.conexiones.add(linea);

	}

	public boolean estaActivo(TipoDeServicio servicio) {
		for (int i = 0; i < this.servicios.size(); i++) {
			if (this.servicios.get(i) == servicio) {
				return true;
			}
		}
		return false;
	}

	public void activar(TipoDeServicio servicio) {
		this.servicios.add(servicio);
	}

	public void desactivar(TipoDeServicio servicio) {
		this.servicios.remove(servicio);
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

}
