package algo3.algocity.controlador;

import javax.swing.ImageIcon;

import algo3.algocity.modelo.CentralEolica;
import algo3.algocity.modelo.CentralMineral;
import algo3.algocity.modelo.CentralNuclear;
import algo3.algocity.modelo.Comercio;
import algo3.algocity.modelo.Construccion;
import algo3.algocity.modelo.EntradaAlaCiudad;
import algo3.algocity.modelo.EstacionDeBomberos;
import algo3.algocity.modelo.Industria;
import algo3.algocity.modelo.PozoDeAgua;
import algo3.algocity.modelo.Residencia;

public class ImagenConstruccion {
	
	private ImageIcon imagen;
	
	public ImagenConstruccion(Construccion construccion){
		
		if (construccion.obtenerNombre().equals(new Comercio().obtenerNombre()))
			{	imagen = new ImageIcon(getClass().getResource("/imagenes/shop.jpg"));}
	    if (construccion.obtenerNombre().equals(new Residencia().obtenerNombre()))
		{	imagen = new ImageIcon(getClass().getResource("/imagenes/residencia.jpg"));}
	    if (construccion.obtenerNombre().equals(new PozoDeAgua().obtenerNombre()))
		{	imagen = new ImageIcon(getClass().getResource("/imagenes/agua.jpg"));}
		if (construccion.obtenerNombre().equals(new CentralEolica().obtenerNombre()))
		{	imagen = new ImageIcon(getClass().getResource("/imagenes/centraleolica.jpg"));}
	    if (construccion.obtenerNombre().equals(new CentralMineral().obtenerNombre()))
		{	imagen = new ImageIcon(getClass().getResource("/imagenes/mineral.jpg"));}
		if (construccion.obtenerNombre().equals(new CentralNuclear().obtenerNombre()))
		{	 imagen = new ImageIcon(getClass().getResource("/imagenes/nuclear.jpg"));}
		if (construccion.obtenerNombre().equals(new EstacionDeBomberos().obtenerNombre()))
		{	imagen = new ImageIcon(getClass().getResource("/imagenes/bombero.jpg"));}
		if (construccion.obtenerNombre().equals(new Industria().obtenerNombre()))
			{imagen = new ImageIcon(getClass().getResource("/imagenes/industria.jpg"));}
		if (construccion.obtenerNombre().equals(new EntradaAlaCiudad().obtenerNombre()))
		{imagen = new ImageIcon(getClass().getResource("/imagenes/entrada.jpg"));}
		
	}
	
	public ImageIcon getImage(){
		return imagen;
	}
}
