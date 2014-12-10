package algo3.algocity.controlador;

import java.awt.PopupMenu;
import java.util.HashMap;
import java.util.Map;

import algo3.algocity.modelo.*;


public class MenuManager {

	private Map<Class<? extends Hectarea>, IFabricaOpcionesMenu> menuBuilders = new HashMap<Class<? extends Hectarea>, IFabricaOpcionesMenu>();

	public MenuManager() {
		menuBuilders.put(Agua.class, new FabricaOpcionesMenuAgua());
		menuBuilders.put(Terreno.class, new FabricaOpcionesMenuTerreno());
	}

	public PopupMenu popularMenu(final Hectarea current, final Juego juego, final Coordenada coordenada) {
		final Hectarea hectaria = current;
		PopupMenu editMenu = new PopupMenu("Menu Juego");

		Class<?> type = hectaria.getClass();
		menuBuilders.get(type).popularMenu(current, editMenu, juego, coordenada);

		return editMenu;
	}
}
