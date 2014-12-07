package algo3.algocity.controlador;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.modelo.Hectarea;	
import algo3.algocity.modelo.PozoDeAgua;
import algo3.algocity.modelo.Tuberia;

public class FabricaOpcionesMenuAgua implements IFabricaOpcionesMenu {

	@Override
	public void popularMenu(final Hectarea current, PopupMenu editMenu) {
		MenuItem cutMenuItem = new MenuItem("Construir Pozo de Agua");
		cutMenuItem.setEnabled(true);
		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PozoDeAgua industria = new PozoDeAgua();
				current.construir(industria);
			}

		});
		editMenu.add(cutMenuItem);
		cutMenuItem = new MenuItem("Conectar Tuberia");
		cutMenuItem.setEnabled(true);
		cutMenuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Tuberia tuberia = new Tuberia();
				current.conectar(tuberia);
			}

		});
		editMenu.add(cutMenuItem);
	}

}
