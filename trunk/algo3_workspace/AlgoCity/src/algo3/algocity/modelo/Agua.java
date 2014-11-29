package algo3.algocity.modelo;
	
import java.util.ArrayList;

public class Agua extends Hectarea{
	
	private ArrayList<Conexiones> servicios;
	private Construccion construccion;
	
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
	

	@Override
	public Construccion obtenerSuConstruccion() {	
		return this.construccion;
	}
	
	public boolean construir(Construccion unaConstruccion){
        
		if( !this.permite(unaConstruccion) ){
            return false;
        }
		
		if( !(this.construccion == null) ){
			return false;
		}
			
		this.construccion = unaConstruccion;
		return true;
	}
		
	public boolean permite(Construccion c){
		return c.puedoEn(this);
	}
	
}
