package algo3.algocity.modelo;

import java.util.ArrayList;

public class Comercio extends Edificio {

	public Comercio() {
		this.consumoElectrico = Configuracion.CONSUMO_ELECTRICO_COMERCIO;
		this.costo = Configuracion.COSTO_COMERCIO;
		this.salud = Configuracion.SALUD_INICIAL;
	}

	public void afectarCon(Godzilla godzilla) {
		this.salud -= Configuracion.AVERIA_DE_GODZILLA_A_COMERCIO;
		if (this.salud < 0) {
			this.salud = 0;
		}
	}


	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	@Override
	public boolean tieneLosServiciosRequeridos(
			ArrayList<TipoDeServicio> servicios) {
		// //Servicios que requiera comercio
		return false;
	}

}
