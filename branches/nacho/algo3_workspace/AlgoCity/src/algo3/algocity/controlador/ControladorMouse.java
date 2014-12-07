package algo3.algocity.controlador;

import java.awt.Component;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
			System.out.println("Abriendo menu!");
			// Mostrar menu
			PopupMenu editMenu = new PopupMenu("Menu Juego");
			MenuItem cutMenuItem = new MenuItem("Construir Residencia");
			//cutMenuItem.setEnabled(true);
			cutMenuItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					ControladorMouse.this.hectarea.cambiar();
				}
				
			});
			editMenu.add(cutMenuItem);
			Component component = mouseEvent.getComponent();
			component.add(editMenu);
			if (component != null) {
				editMenu.show(component, mouseEvent.getX(), mouseEvent.getY());
			}
		} else {

			// modelo.inicializarModeloDato(vista.posicion);
			System.out.println("Mouse aprateado!");
			this.hectarea.cambiar();
		}
	}
}
