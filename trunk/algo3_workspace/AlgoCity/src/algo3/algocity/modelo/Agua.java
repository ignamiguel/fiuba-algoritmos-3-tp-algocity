package algo3.algocity.modelo;
	
import java.util.ArrayList;
import java.util.Iterator;

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
      boolean tieneServicio = false;
      String servicioABuscar = unServicio.obtenerServicio();
	  Iterator<Conexiones> iterador = servicios.iterator();
      while(iterador.hasNext()){
    	  Conexiones conexion = iterador.next();
    	  String servicio = conexion.obtenerServicio();
    	  if (servicio.equals(servicioABuscar))
    		  tieneServicio=true;
    	  
      }
      return tieneServicio;
		//return(servicios.contains(unServicio));
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
