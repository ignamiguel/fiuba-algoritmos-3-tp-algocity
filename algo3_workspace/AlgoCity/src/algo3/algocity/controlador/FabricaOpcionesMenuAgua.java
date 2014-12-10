package algo3.algocity.controlador;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.modelo.*;

public class FabricaOpcionesMenuAgua implements IFabricaOpcionesMenu {

	@Override
	public void popularMenu(final Hectarea current, PopupMenu editMenu, Juego juego, Coordenada coordenada) {
		MenuItem menuItem = null;
		if (current.estaVacia()) {
			menuItem = new MenuItem("Construir Pozo de Agua");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					PozoDeAgua industria = new PozoDeAgua();
					current.construir(industria);
				}

			});
			editMenu.add(menuItem);
			editMenu.addSeparator();
		}

		
		menuItem = new MenuItem("Conectar Tuberia");
		menuItem.setEnabled(true);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tuberia tuberia = new Tuberia();
				current.conectar(tuberia);
			}

		});
		editMenu.add(menuItem);
	}

}
