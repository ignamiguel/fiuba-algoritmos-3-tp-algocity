package algo3.algocity.modelo;

public class Comercio extends Edificio {

	public Comercio() {
		this.consumoElectrico = Configuracion.CONSUMO_ELECTRICO_COMERCIO;
		this.costo = Configuracion.COSTO_COMERCIO;
		this.salud = Configuracion.SALUD_INICIAL;
	}

	public void afectarCon(Godzilla godzilla) {
		if (this.salud == 0) {
			return;
		}

		int averia = Configuracion.AVERIA_DE_GODZILLA_A_COMERCIO;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	public boolean puedoEn(Hectarea hectarea) {
		return true;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	@Override
	public void brindarServicio(Hectarea hectarea) {
		// No brinda servicios

	}
}
