package algo3.algocity.modelo;

import java.util.ArrayList;
import java.util.Iterator;

public class Terreno extends Hectarea {

	public Terreno() {

		servicios = new ArrayList<Conexiones>();
		construccion = null;
	}

	public String obtenerNombre() {
		return "Terreno";
	}

	public void agregarServicio(Conexiones unServicio) {

		if (!(this.tieneServicio(unServicio)))
			servicios.add(unServicio);

	}

	public void quitarServicio(Conexiones unServicio) {

		if (this.tieneServicio(unServicio))
			servicios.remove(unServicio);

	}

	public boolean tieneServicio(Conexiones unServicio) {
		boolean tieneServicio = false;
		String servicioABuscar = unServicio.obtenerServicio();
		Iterator<Conexiones> iterador = servicios.iterator();
		while (iterador.hasNext()) {
			Conexiones conexion = iterador.next();
			String servicio = conexion.obtenerServicio();
			if (servicio.equals(servicioABuscar))
				tieneServicio = true;

		}
		return tieneServicio;
		// return(servicios.contains(unServicio));
	}

	public boolean tieneLuz() {

		Iterator<Conexiones> item = servicios.iterator();
		while (item.hasNext()) {

			IServicio unServicio = (IServicio) item.next();
			if (unServicio.obtenerServicio() == "luz") {

				return (unServicio.estaActivo());
			}

		}
		return false;
	}   
    
    @Override
	public boolean permite(Construccion construccion){
		return construccion.puedoEn(this); 
	}
    
  
}
