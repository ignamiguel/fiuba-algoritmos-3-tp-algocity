package algo3.algocity.modelo;

public interface IConectable extends IConstruible{
	
	public boolean estaActiva();
	public String obtenerServicio();	
	public TipoDeConexion obtenerTipo();

}
