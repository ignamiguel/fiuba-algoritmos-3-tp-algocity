package algo3.algocity.modelo;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class TraductorXML {

	public static void generarArchivoPartida(Juego juego, File file) {
		DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder icBuilder;
		try {
			icBuilder = icFactory.newDocumentBuilder();
			Document doc = icBuilder.newDocument();
			Element root = doc.createElement(Configuracion.XML_ROOT);
			doc.appendChild(root);

			// Nodo jugador
			Element nodoJugador = doc
					.createElement(Configuracion.XML_NODO_JUGADOR);
			nodoJugador.setTextContent(juego.getJugador());
			root.appendChild(nodoJugador);

			// Nodo dinero
			Element nodoDinero = doc
					.createElement(Configuracion.XML_NODO_DINERO);
			nodoDinero.setTextContent(Integer.toString(juego.getDinero()));
			root.appendChild(nodoDinero);

			// Nodo turno
			Element nodoTurno = doc.createElement(Configuracion.XML_NODO_TURNO);
			nodoTurno.setTextContent(Integer.toString(juego.getTurno()));
			root.appendChild(nodoTurno);

			// Nodo ciudadanos
			Element nodoCiudadanos = doc
					.createElement(Configuracion.XML_NODO_CIUDADANOS);
			nodoCiudadanos.setTextContent(Integer.toString(juego
					.getCiudadanos()));
			root.appendChild(nodoCiudadanos);

			// Nodo mapa
			Element nodoMapa = doc.createElement(Configuracion.XML_NODO_MAPA);

			for (int i = 0; i < juego.getMapa().getTamanio(); i++) {
				for (int j = 0; j < juego.getMapa().getTamanio(); j++) {

					Hectarea h = juego.getMapa().getHectarea(
							new Coordenada(i, j));

					Element nodoHectarea = doc
							.createElement(Configuracion.XML_NODO_HECTAREA);

					// Guardo la coordenada (x, y)
					nodoHectarea.setAttribute("x", Integer.toString(i));
					nodoHectarea.setAttribute("y", Integer.toString(j));

					// Info de Hectarea
					Element nodoTipo = doc
							.createElement(Configuracion.XML_NODO_HECTAREA_TIPO);
					nodoTipo.setTextContent(h.getEtiqueta());
					nodoHectarea.appendChild(nodoTipo);

					if (!h.estaVacia()) {
						Element nodoContruccion = doc
								.createElement(Configuracion.XML_NODO_HECTAREA_CONSTRUCCION);

						Element nodoTipoCons = doc
								.createElement(Configuracion.XML_NODO_HECTAREA_CONSTRUCCION_TIPO);
						nodoTipoCons.setTextContent(h.getConstruccion()
								.getEtiqueta());

						Element nodoSalud = doc
								.createElement(Configuracion.XML_NODO_HECTAREA_CONSTRUCCION_SALUD);
						nodoSalud.setTextContent(Integer.toString(h
								.getConstruccion().getSalud()));

						nodoContruccion.appendChild(nodoTipoCons);
						nodoContruccion.appendChild(nodoSalud);

						nodoHectarea.appendChild(nodoContruccion);
					}

					Element nodoConexiones = doc
							.createElement(Configuracion.XML_NODO_HECTAREA_CONEXIONES);
					List<IConectable> listaConexiones = h.getConexiones();
					for (IConectable iConectable : listaConexiones) {
						Element nodoIConectable = doc
								.createElement(Configuracion.XML_NODO_HECTAREA_CONEXION);
						nodoIConectable.setTextContent(iConectable
								.getEtiqueta());
						nodoConexiones.appendChild(nodoIConectable);
					}

					nodoHectarea.appendChild(nodoConexiones);

					Element nodoServicios = doc
							.createElement(Configuracion.XML_NODO_HECTAREA_SERVICIOS);
					List<TipoDeServicio> listaServicios = h.getServicios();
					for (TipoDeServicio tipo : listaServicios) {
						Element nodoServicio = doc
								.createElement(Configuracion.XML_NODO_HECTAREA_SERVICIO);
						nodoServicio.setTextContent(TipoDeServicio
								.getEtiqueta(tipo));
						nodoServicios.appendChild(nodoServicio);
					}

					nodoHectarea.appendChild(nodoServicios);

					nodoMapa.appendChild(nodoHectarea);
				}
			}

			root.appendChild(nodoMapa);

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance()
					.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);

			StreamResult outPut = new StreamResult(file);
			transformer.transform(source, outPut);

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void cargarPartida(File file, Juego juego) {
		try {			
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);

			doc.getDocumentElement().normalize();

			// Obtengo el nodo root
			Element root = doc.getDocumentElement();
			
			NodeList jugador = root.getElementsByTagName(Configuracion.XML_NODO_JUGADOR);
			if(jugador.getLength() > 0)
				juego.setJugador(jugador.item(0).getTextContent());
			
			
			NodeList dinero = root.getElementsByTagName(Configuracion.XML_NODO_DINERO);
			if(dinero.getLength() > 0)
				juego.setDinero(Integer.parseInt(dinero.item(0).getTextContent()));
			
			
			NodeList turno = root.getElementsByTagName(Configuracion.XML_NODO_TURNO);
			if(turno.getLength() > 0)
				juego.setTurno(Integer.parseInt(turno.item(0).getTextContent()));
			
			NodeList ciudadanos = root.getElementsByTagName(Configuracion.XML_NODO_CIUDADANOS);
			if(ciudadanos.getLength() > 0)
				juego.setCiudadanos(Integer.parseInt(ciudadanos.item(0).getTextContent()));
			
			// Para el mapa obtengo las hectareas
			NodeList hectareas = root.getElementsByTagName(Configuracion.XML_NODO_HECTAREA);
			for(int i = 0; i < hectareas.getLength(); i++){
				
				// Obtengo los coordenadas
				String x = hectareas.item(i).getAttributes().getNamedItem("x").getNodeValue();
				String y = hectareas.item(i).getAttributes().getNamedItem("y").getNodeValue();
				
				// Reseto la hectarea
				Coordenada coordenada = new Coordenada(Integer.parseInt(x), Integer.parseInt(y));
				juego.getMapa().getHectarea(coordenada).reset();
				
				// Obtengo la construccion
				NodeList construccion = ((Element)hectareas.item(i)).getElementsByTagName(Configuracion.XML_NODO_HECTAREA_CONSTRUCCION);
				if(construccion.getLength() > 0){
					NodeList construccionTipo = ((Element)construccion.item(0)).getElementsByTagName(Configuracion.XML_NODO_HECTAREA_CONSTRUCCION_TIPO);
					
					if(construccionTipo.getLength() > 0){
						String tipo = construccionTipo.item(0).getTextContent();
						
						TraductorXML.construir(juego, tipo, coordenada);
					}
				}
				
				// Proceso Conexiones
				
				
				// Proceso Servicios
			}
			

		} catch (RuntimeException | ParserConfigurationException | SAXException | IOException e) {
			// TODO:
		}

	}

	private static void construir(Juego juego, String construccion,
			Coordenada coordenada) {
		switch (construccion) {
		case Configuracion.ETIQUETA_RESIDENCIA:
			juego.insertar(new Residencia(), coordenada);
			return;
		case Configuracion.ETIQUETA_COMERCIO:
			juego.insertar(new Comercio(), coordenada);
			return;
		case Configuracion.ETIQUETA_INDUSTRIA:
			juego.insertar(new Industria(), coordenada);
			return;
		case Configuracion.ETIQUETA_CENTRAL_EOLICA:
			juego.insertar(new CentralEolica(), coordenada);
			return;
		case Configuracion.ETIQUETA_CENTRAL_MINERAL:
			juego.insertar(new CentralMineral(), coordenada);
			return;
		case Configuracion.ETIQUETA_CENTRAL_NUCLEAR:
			juego.insertar(new CentralNuclear(), coordenada);
			return;
		case Configuracion.ETIQUETA_ENTRADA_A_LA_CIUDAD:
			juego.insertar(new EntradaAlaCiudad(), coordenada);
			return;
		case Configuracion.ETIQUETA_POZO_DE_AGUA:
			juego.insertar(new PozoDeAgua(), coordenada);
			return;
		case Configuracion.ETIQUETA_ESTACION_DE_BOMBEROS:
			juego.insertar(new EstacionDeBomberos(), coordenada);
			return;
		default:
			return;
		}
		
	}
}
