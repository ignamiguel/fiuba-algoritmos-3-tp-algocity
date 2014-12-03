package algo3.algocity.modelo;

import java.util.ArrayList;

public class Terreno extends Hectarea {

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
		if (ruta.puedoEn(this)) {
			this.conexiones.add(ruta);
			return true;
		}
		return false;
	}

	public boolean conectar(Tuberia tuberia) {
		if (tuberia.puedoEn(this)) {
			this.conexiones.add(tuberia);
			return true;
		}
		return false;
	}

	public boolean conectar(LineaDeTension linea) {
		if (linea.puedoEn(this)) {
			this.conexiones.add(linea);
			return true;
		}
		return false;

	}

	public void desactivar(TipoDeServicio servicio) {
		this.servicios.remove(servicio);
	}

	@Override
	public boolean permite(Conexion conexion) {
		return conexion.puedoEn(this);
	}

}
