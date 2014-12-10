package algo3.algocity.controlador;

import java.awt.PopupMenu;

import algo3.algocity.modelo.*;

public interface IFabricaOpcionesMenu {
	void popularMenu(final Hectarea current, PopupMenu editMenu, Juego juego, Coordenada coordenada);
}
