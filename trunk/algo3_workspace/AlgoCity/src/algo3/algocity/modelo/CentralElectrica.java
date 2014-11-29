package algo3.algocity.modelo;

public abstract class CentralElectrica extends Construccion implements IAfectable{
	
	
	public CentralElectrica(){
		
	}
	
	
	//atributos de clase
	
	protected int capacidadDeAbastecimiento;
	protected int radioDeCovertura;
	protected boolean conectadaARedDeAgua;
	//private Coordenada miUbicacion;
	
	
	//metodos publicos
	
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
	
	@Override
	public void afectarCon(Godzilla unGodzilla) {
		this.salud -= 35;
		
		if(this.salud < 0){
			this.salud = 0;
		}
		
	}
	

	//metodos privados
	
	
}
