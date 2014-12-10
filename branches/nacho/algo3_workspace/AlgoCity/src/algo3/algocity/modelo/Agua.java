package algo3.algocity.modelo;

import java.util.ArrayList;

public class Agua extends Hectarea {

	public Agua() {
		this.conexiones = new ArrayList<IConectable>();
		this.servicios = new ArrayList<TipoDeServicio>();
		this.construccion = null;
	}

	public String getNombre() {
		return Configuracion.ETIQUETA_AGUA;
	}

	@Override
	public boolean permite(Construccion construccion) {
		return construccion.puedoEn(this);
	}

	public boolean permite(Conexion conexion) {
		return conexion.puedoEn(this);
	}

}