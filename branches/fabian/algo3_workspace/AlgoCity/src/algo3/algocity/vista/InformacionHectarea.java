package algo3.algocity.vista;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import algo3.algocity.modelo.Conexion;
import algo3.algocity.modelo.Hectarea;
import algo3.algocity.modelo.IConectable;

public class InformacionHectarea extends JPanel {

	private static InformacionHectarea instancia;
	private static final long serialVersionUID = 4727690797032146688L;
	private TextArea area;

	private InformacionHectarea() {
		area = new TextArea("Click en una hectarea...", 20, 30);
		area.setEditable(false);		
		this.add(area);
	}

	public void actualizarInformacion(Hectarea hectarea) {

		StringBuilder builder = new StringBuilder();
		builder.append("Tipo:").append(hectarea.obtenerNombre())
				.append('\n');
		if (hectarea.estaVacia()){
		builder.append("Construccion: ").append("ninguna").append('\n');}
		else {
		builder.append("Construccion: ").append(hectarea.obtenerConstruccion().obtenerNombre()).append('\n');
		}
		//builder.append("Esta construida: ").append(!hectarea.estaVacia()).append('\n');
		builder.append("Habitantes: ")
				.append(hectarea.obtenerCapacidadDeAlojamiento()).append('\n');
		builder.append("Puestos de Trabajo: ")
				.append(hectarea.obtenerCapacidadDeTrabajo()).append('\n');
		builder.append("Consumo electrico: ").append(hectarea.obtenerConsumo())
				.append('\n');
		if(hectarea.obtenerConexiones().isEmpty()){
			builder.append("Conexiones: ").append("ninguna").append('\n');
		}else {
			builder.append("Conexiones: ").append('\n');
			ArrayList<Conexion> conexionesActuales = new ArrayList<Conexion>();
			Iterator<Conexion> it= hectarea.obtenerConexiones().iterator();
			while (it.hasNext()){
				Conexion conexion = it.next();
				builder.append("              ").append(conexion.obtenerNombre()).append('\n');	
			}	
		}
		area.setText(builder.toString());
	}

	public static InformacionHectarea getInstance() {
		if (instancia == null) {
			instancia = new InformacionHectarea();
		}
		return instancia;
	}
}
