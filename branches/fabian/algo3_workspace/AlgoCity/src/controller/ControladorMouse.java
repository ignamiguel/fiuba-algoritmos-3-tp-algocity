package controller;

import java.awt.Component;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

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
			JPopupMenu editMenu = new JPopupMenu("Menu Juego");
			JMenu construir = new JMenu("Construir");
			//cutMenuItem.setEnabled(true);
			
			/*MenuItem cutMenuItem = new MenuItem("");
			cutMenuItem.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					ControladorMouse.this.hectarea.cambiar();
				}
				
			});*/
			JMenuItem residencia = new JMenuItem("Residencia");
			//cutMenuItem.setEnabled(true);
			residencia.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					ControladorMouse.this.hectarea.cambiar();
				}
				
			});
			JMenuItem estDeBomberos = new JMenuItem("EstacionDeBomberos");
			//cutMenuItem.setEnabled(true);
			estDeBomberos.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					//ControladorMouse.this.hectarea.construirResidencia();
				}
				
			});
			construir.add(residencia);
			construir.add(estDeBomberos);
			editMenu.add(construir);
			
			Component component = mouseEvent.getComponent();
			//component.add(editMenu);
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
