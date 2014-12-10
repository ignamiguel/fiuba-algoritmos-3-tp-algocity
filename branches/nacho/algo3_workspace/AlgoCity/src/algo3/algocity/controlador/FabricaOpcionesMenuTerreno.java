package algo3.algocity.controlador;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import algo3.algocity.modelo.*;

public class FabricaOpcionesMenuTerreno implements IFabricaOpcionesMenu {

	@Override
	public void popularMenu(final Hectarea current, PopupMenu editMenu, final Juego juego, final Coordenada coordenada) {
		MenuItem menuItem = null;
		if (current.estaVacia()) {
			menuItem = new MenuItem("Construir Residencia");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

//				@Override
//				public void actionPerformed(ActionEvent arg0) {
//					Residencia residencia = new Residencia();
//					current.construir(residencia);
//				}
				@Override
				public void actionPerformed(ActionEvent arg0) {
					juego.insertar(new Residencia(), coordenada);					
				}

			});
			editMenu.add(menuItem);

			menuItem = new MenuItem("Construir Comercio");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					juego.insertar(new Comercio(), coordenada);
				}

			});
			editMenu.add(menuItem);
			menuItem = new MenuItem("Construir Industria");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {					
					juego.insertar(new Industria(), coordenada);
				}

			});
			editMenu.add(menuItem);
			
			menuItem = new MenuItem("Construir Central Eolica");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {					
					juego.insertar(new CentralEolica(), coordenada);
				}

			});
			editMenu.add(menuItem);
			
			menuItem = new MenuItem("Construir Central Mineal");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {					
					juego.insertar(new CentralMineral(),coordenada);
				}

			});
			editMenu.add(menuItem);
			
			menuItem = new MenuItem("Construir Central Nucelar");
			menuItem.setEnabled(true);
			menuItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {					
					juego.insertar(new CentralNuclear(), coordenada);
				}

			});
			editMenu.add(menuItem);			
			editMenu.addSeparator();
		}

		menuItem = new MenuItem("Conectar Ruta");
		menuItem.setEnabled(true);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {				
				juego.insertar(new Ruta(), coordenada);
			}

		});
		editMenu.add(menuItem);
		menuItem = new MenuItem("Conectar Tuberia");
		menuItem.setEnabled(true);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {				
				juego.insertar(new Tuberia(), coordenada);
			}

		});
		editMenu.add(menuItem);

		menuItem = new MenuItem("Conectar Linea De Tension");
		menuItem.setEnabled(true);
		menuItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {				
				juego.insertar(new LineaDeTension(), coordenada);
			}

		});
		editMenu.add(menuItem);
	}

}
