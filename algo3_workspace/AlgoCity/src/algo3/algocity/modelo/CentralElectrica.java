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
	public abstract int obtenerRadioDeCovertura();
	public abstract int obtenerCapacidadDeAbastecimiento();
	
	//metodos privados
	
	
}
