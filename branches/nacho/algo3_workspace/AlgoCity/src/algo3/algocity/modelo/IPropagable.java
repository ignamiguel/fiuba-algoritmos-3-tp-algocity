package algo3.algocity.modelo;

public interface IPropagable {

	public TipoDeServicio obtenerServicioPropagable();
	public TipoDeConexion obtenerConexionNecesaria();	
	public boolean puedoBrindarleElServicio(Hectarea hectarea);
	public int obtenerRadioDeCovertura();

}
