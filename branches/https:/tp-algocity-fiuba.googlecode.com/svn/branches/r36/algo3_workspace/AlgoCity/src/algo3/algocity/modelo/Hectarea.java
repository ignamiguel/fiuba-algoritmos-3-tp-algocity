package algo3.algocity.modelo;

import java.util.ArrayList;

public abstract class Hectarea {

    //atributos de la clase
    protected ArrayList<Conexiones> servicios;
    protected Construccion construccion;
    protected Coordenada ubicacion;


	public abstract void agregarServicio(Conexiones unServicio);

	public abstract void quitarServicio(Conexiones unServicio);

	public abstract boolean tieneElServicio(Conexiones unServicio);

	public abstract String obtenerNombre();

	public boolean puedoConstruirEdificio(){
        return (construccion==null);

	}

	public void construir(Construccion unaConstruccion){
        if (this.puedoConstruirEdificio())
        {
            if(unaConstruccion.puedoEn(this))
                {   construccion= unaConstruccion;
                    unaConstruccion.brindarServicio(this);
                }
        }


	}
	
	public Construccion obtenerSuConstruccion(){
		return this.construccion;	
	}
	public void guardarUbicacion(Coordenada unaCoordenada){
		
		this.ubicacion = unaCoordenada;
	}
	public Coordenada obtenerUbicacion(){
		
	return this.ubicacion;
	}
	
	
	
	
	
}

