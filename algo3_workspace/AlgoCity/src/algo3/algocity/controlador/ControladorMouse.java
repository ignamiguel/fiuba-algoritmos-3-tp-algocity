package algo3.algocity.controlador;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algo3.algocity.modelo.Coordenada;
import algo3.algocity.modelo.Hectarea;
import algo3.algocity.modelo.Juego;
import algo3.algocity.vista.InformacionHectarea;

public class ControladorMouse extends MouseAdapter {

	private Hectarea hectarea;
	private Coordenada coordenada;

	private Juego juego;

	// public ControladorMouse(Hectarea h, VistaHectarea vista) {
	// this.hectarea = h;
	// this.vista = vista;
	// }

	// Old Constructor
	public ControladorMouse(Hectarea h) {
		this.hectarea = h;
	}

	public ControladorMouse(Juego juego, Coordenada c) {
		this.juego = juego;
		this.coordenada = c;
	}

	public void mousePressed(MouseEvent mouseEvent) {

		Hectarea hectarea = this.juego.getMapa().obtenerHectarea(this.coordenada);
		
		InformacionHectarea.getInstance().actualizarInformacion(hectarea);

		if (MouseEvent.BUTTON3 == mouseEvent.getButton()) {
			// Mostrar menu
			PopupMenu editMenu = new MenuManager().popularMenu(hectarea, juego, coordenada);

			Component component = mouseEvent.getComponent();
			component.add(editMenu);
			if (component != null) {
				editMenu.show(component, mouseEvent.getX(), mouseEvent.getY());
			}
		} else {
			// Muestro las coordenadas
			System.out.println("x="
					+ Integer.toString(this.coordenada.obtenerX()) + " y="
					+ Integer.toString(this.coordenada.obtenerY()));

		}
	}
}
