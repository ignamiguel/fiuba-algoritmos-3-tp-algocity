package algo3.algocity.modelo;

public class PozoDeAgua extends Construccion{

	public String obtenerNombre(){
		return "Pozo de Agua";
	}

	public void brindarServicio(Hectarea hectarea){
        hectarea.agregarServicio(new Tuberia());
	}

	public boolean puedoEn(Agua agua) {
		return true;
	}

	public boolean puedoEn(Terreno terreno) {
		return false;
	}

}
