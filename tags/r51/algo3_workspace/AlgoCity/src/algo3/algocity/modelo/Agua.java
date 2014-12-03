package algo3.algocity.modelo;

import java.util.ArrayList;

public class Agua extends Hectarea {

	public Agua() {
		this.conexiones = new ArrayList<IConectable>();
		this.servicios = new ArrayList<TipoDeServicio>();
		this.construccion = null;
	}

	public String obtenerNombre() {
		return "Agua";
	}

	@Override
	public boolean permite(Construccion construccion) {
		return construccion.puedoEn(this);
	}
	
	public void conectar(Tuberia tuberia) {
		this.conexiones.add(tuberia);
	}
	
	public boolean permite(Conexion conexion) {
		return conexion.puedoEn(this);
	}


}
