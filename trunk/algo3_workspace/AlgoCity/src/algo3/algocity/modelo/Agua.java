package algo3.algocity.modelo;
	
import java.util.ArrayList;

public class Agua extends Hectarea{

	public Agua(){
		servicios = new ArrayList<Conexiones>();
		construccion=null;
	}
	
	public String obtenerNombre() {
			return "Agua";
	}


	public void agregarServicio(Conexiones unServicio) {
			if(!(this.tieneElServicio(unServicio)))
	            servicios.add(unServicio);

	}

	public void quitarServicio(Conexiones unServicio) {
		if(this.tieneElServicio(unServicio))
	          servicios.remove(unServicio);
	}


	public boolean tieneElServicio(Conexiones unServicio) {
      return(servicios.contains(unServicio));
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
	
}
