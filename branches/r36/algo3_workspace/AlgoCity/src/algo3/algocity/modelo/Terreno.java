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

	public boolean permite(Construccion construccion) {
		return construccion.puedoEn(this);
	}

	public boolean conectar(Ruta ruta) {
		if(ruta.puedoEn(this)){
		this.conexiones.add(ruta);
		return true;
		}
		return false;
	}

	public boolean conectar(Tuberia tuberia) {
		if(tuberia.puedoEn(this)){
			this.conexiones.add(tuberia);
			return true;
			}
			return false;
	}

	public boolean conectar(LineaDeTension linea) {
		if(linea.puedoEn(this)){
			this.conexiones.add(linea);
			return true;
			}
			return false;

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

	@Override
	public boolean permite(Conexion conexion) {
		return conexion.puedoEn(this);
	}

}
