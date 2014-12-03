package algo3.algocity.modelo;

public abstract class CentralElectrica extends Construccion {

	public CentralElectrica() {

	}

	// atributos de clase

	protected int capacidadDeAbastecimiento;
	protected int radioDeCovertura;
	protected boolean conectadaARedDeAgua;

	// En la creacion de una centralElectrica necesito guardarme estos datos
	// para despues propagar energia
	// private Coordenada miUbicacion;
	// private Mapa elMapa

	// metodos publicos

	public abstract int darEnergia();

	public int obtenerRadioDeCovertura() {

		return radioDeCovertura;
	}

	public int obtenerCapacidadDeAbastecimiento() {

		return capacidadDeAbastecimiento;
	}

	public boolean estaConectada() {

		return conectadaARedDeAgua;
	}

	public void afectarCon(Godzilla unGodzilla) {
		if (this.salud == 0) {
			return;
		}

		int averia = (Configuracion.AVERIA_DE_GODZILLA_A_CENTRAL_ELECTRICA * this.salud) / 100;
		this.salud -= averia;

		if (this.salud < 0) {
			this.salud = 0;
		}
	}

	public void afectarCon(Terremoto unTerremoto) {
		// TODO Auto-generated method stub

	}

	public boolean puedoEn(Agua agua) {
		return false;
	}

	public boolean puedoEn(Terreno terreno) {
		return true;
	}

	/*
	 * public void brindarServicios(Hectarea hectarea){
	 * this.propagarEnergiaEnRadio();
	 * 
	 * }
	 * 
	 * //Necesito saber mi ubicacion guardandome esa variable al instanciar un
	 * objeto de esta clase // o tambien podria tener un metodo de hectarea que
	 * devuelva su ubicacion, igualmente hectarea tendria que // guardar de
	 * alguna manera su ubicacion //El radio minimo es de 1
	 * 
	 * public void propagarEnergiaEnRadio(){ int numSalto=0; for (int
	 * radioAux=1; radioAux<= radioDeCovertura ; radioAux++){ Coordenada coorAux
	 * = new Coordenada (miUbicacion.obtenerX(),miUbicacion.obtenerY());
	 * coorAux.aumentarY(radioAux); if (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); for (int
	 * saltos=0; saltos< numSalto ; saltos++) { coorAux.disminuirX(1);
	 * coorAux.disminuirY(1); if (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); }
	 * coorAux.disminuirX(1); coorAux.disminuirY(1); if
	 * (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); for (int
	 * saltos=0; saltos< numSalto ; saltos++) { coorAux.disminuirY(1);
	 * coorAux.aumentarX(1); if (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); }
	 * coorAux.disminuirY(1); coorAux.aumentarX(1); if
	 * (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); for (int
	 * saltos=0; saltos< numSalto ; saltos++) { coorAux.aumentarY(1);
	 * coorAux.aumentarX(1); if (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); }
	 * coorAux.aumentarY(1); coorAux.aumentarX(1); if
	 * (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); for (int
	 * saltos=0; saltos< numSalto ; saltos++) { coorAux.aumentarY(1);
	 * coorAux.disminuirX(1); if (elMapa.estaEnElMapaCoordenada(coorAux))
	 * elMapa.obtenerHectarea(coorAux).agregarServicio(Electricidad); }
	 * numSalto= numSalto + 1;
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	// metodos privados

}
