package algo3.algocity.modelo;

public interface IPropagable {

	public TipoDeServicio getServicioPropagable();
	public TipoDeConexion getConexionNecesaria();	
	public boolean puedoBrindarleElServicio(Hectarea hectarea);
	public int getRadioDeCovertura();

}
