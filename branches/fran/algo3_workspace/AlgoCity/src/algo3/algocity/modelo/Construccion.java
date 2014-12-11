package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Construccion implements IConstruible {

	protected int costo;
	protected int salud;
	protected List<TipoDeServicio> serviciosNecesarios;

	public Construccion(){
		this.serviciosNecesarios = new ArrayList<TipoDeServicio>();
	}
	
	public int getCosto() {
		return this.costo;
	}

	public int getSalud() {
		return this.salud;
	}

	public boolean estaAveriada(){
		return (this.salud < Configuracion.SALUD_INICIAL);
	}
	
	public abstract int getConsumoElectrico();

	public abstract int getPuestosDeTrabajo();

	public abstract int getCapacidadDeAlojamiento();	
	
	public List<TipoDeServicio> getServiciosRequeridos() {		
		return this.serviciosNecesarios;
	}

	public abstract String getEtiqueta();
}
