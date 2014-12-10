package algo3.algocity.modelo;

public abstract class CentralElectrica extends Construccion implements
		IPropagable {

	protected int capacidadDeAbastecimiento;
	protected int radioDeCovertura;
	protected boolean conectadaARedDeAgua;

	public CentralElectrica() {
		super();		
		
		this.serviciosNecesarios.add(TipoDeServicio.Cloacas);		
	}
	
	public int getRadioDeCovertura() {
		return radioDeCovertura;
	}

	public boolean estaConectada() {
		return conectadaARedDeAgua;
	}

	public void afectarCon(Godzilla unGodzilla) {
		if (this.salud == 0) {
			return;
		}

		int averia = Configuracion.AVERIA_DE_GODZILLA_A_CENTRAL_ELECTRICA;
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

	@Override
	public TipoDeServicio getServicioPropagable() {
		return TipoDeServicio.Electrico;
	}

	@Override
	public TipoDeConexion getConexionNecesaria() {
		return TipoDeConexion.LineaDeTension;
	}

	public boolean puedoBrindarleElServicio(Hectarea hectarea) {
		if (this.capacidadDeAbastecimiento >= hectarea.getConsumo()) {
			this.capacidadDeAbastecimiento -= hectarea.getConsumo();
			return true;
		}
		return false;
	}

	public abstract void cargarAbastecimiento();

	public int getConsumoElectrico() {
		return Configuracion.CONSUMO_ELECTRICO_CENTRAL_ELECTRICA;
	}

	public int getCapacidadDeAbastecimiento() {
		return this.capacidadDeAbastecimiento;
	}
	
	@Override
	public int getPuestosDeTrabajo() {
		// Las centrales electricas 
		// no generan trabajo
		return 0;
	}

	@Override
	public int getCapacidadDeAlojamiento() {
		// Las centrales electricas tiene 
		// capacidad de alojamiento nula
		return 0;
	}

}
