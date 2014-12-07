package algo3.algocity.controlador;

import java.awt.Component;
import java.awt.PopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import algo3.algocity.modelo.Hectarea;
import algo3.algocity.vista.VistaHectarea;

public class ControladorMouse extends MouseAdapter {

	private Hectarea hectarea;

	private VistaHectarea vista;

	public ControladorMouse(Hectarea h, VistaHectarea vista) {
		this.hectarea = h;
		this.vista = vista;
	}

	public void mousePressed(MouseEvent mouseEvent) {

		// Ojo al piojo.
		// El manejo de las coordenadas del mouse debe ser encapsulado por la
		// clase Posicion
		// modelo.inicializarModeloDato(new Posicion(mouseEvent.getX(),
		// mouseEvent.getY()));

		if (MouseEvent.BUTTON3 == mouseEvent.getButton()) {
			// Mostrar menu
			PopupMenu editMenu = new MenuManager()
					.popularMenu(ControladorMouse.this.hectarea);

			Component component = mouseEvent.getComponent();
			component.add(editMenu);
			if (component != null) {
				editMenu.show(component, mouseEvent.getX(), mouseEvent.getY());
			}
		} else {
			// Selecciono la hectaria, actualizar panel de info
		}
	}
}
