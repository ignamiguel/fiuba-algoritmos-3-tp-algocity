package algo3.algocity.vista;

import java.awt.TextArea;
import javax.swing.JPanel;

import algo3.algocity.modelo.Hectarea;

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
		builder.append("Esta construida: ").append(!hectarea.estaVacia()).append('\n');
		builder.append("Habitantes: ")
				.append(hectarea.obtenerCapacidadDeAlojamiento()).append('\n');
		builder.append("Puestos de Trabajo: ")
				.append(hectarea.obtenerCapacidadDeTrabajo()).append('\n');
		builder.append("Consumo electrico: ").append(hectarea.obtenerConsumo())
				.append('\n');
		
		area.setText(builder.toString());
	}

	public static InformacionHectarea getInstance() {
		if (instancia == null) {
			instancia = new InformacionHectarea();
		}
		return instancia;
	}
}
