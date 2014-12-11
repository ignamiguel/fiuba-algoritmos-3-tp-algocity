package algo3.algocity.vista;

import java.awt.TextArea;
import java.util.Iterator;

import javax.swing.JPanel;

import algo3.algocity.modelo.Hectarea;
import algo3.algocity.modelo.IConectable;
import algo3.algocity.modelo.TipoDeServicio;

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
		builder.append("INFO HECTÁREA").append("\n");
		builder.append("Tipo: ").append(hectarea.getEtiqueta()).append('\n');
		if (hectarea.estaVacia()) {
			builder.append("Construcción: ").append("No").append('\n');
		} else {
			builder.append("Construcción: ")
					.append(hectarea.getConstruccion().getEtiqueta())
					.append('\n');
			builder.append("\tSalud: ")
			.append(hectarea.getConstruccion().getSalud())
			.append('\n');
		}
		builder.append("Habitantes: ")
				.append(hectarea.getCapacidadDeAlojamiento()).append('\n');
		builder.append("Puestos de Trabajo: ")
				.append(hectarea.getCapacidadDeTrabajo()).append('\n');
		builder.append("Consumo electrico: ").append(hectarea.getConsumo())
				.append('\n');

		if (hectarea.getConexiones().isEmpty()) {
			builder.append("Conexiones: ").append("ninguna").append('\n');
		} else {
			builder.append("Conexiones: ").append('\n');
			Iterator<IConectable> it = hectarea.getConexiones().iterator();
			while (it.hasNext()) {
				IConectable conexion = it.next();
				builder.append("\t").append(conexion.getEtiqueta())
						.append('\n');
			}
		}
		
		if(hectarea.getServicios().isEmpty()){
			builder.append("Servicios: ").append("ninguno").append("\n");
		}else{
			builder.append("Servicios: ").append('\n');
			Iterator<TipoDeServicio> it = hectarea.getServicios().iterator();
			while (it.hasNext()) {
				TipoDeServicio servicio = it.next();
				builder.append("\t").append(TipoDeServicio.getEtiqueta(servicio))
						.append('\n');
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
