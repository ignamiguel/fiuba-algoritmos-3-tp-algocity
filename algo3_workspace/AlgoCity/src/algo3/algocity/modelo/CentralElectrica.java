package algo3.algocity.modelo;

public abstract class CentralElectrica extends Construccion {
	
	
	public CentralElectrica(){
		
	}
	
	
	
	//atributos de clase
	
	protected int capacidadDeAbastecimiento;
	protected int radioDeCovertura;
	protected boolean conectadaARedDeAgua;


	
	
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
	

	//metodos privados
	
	
}
