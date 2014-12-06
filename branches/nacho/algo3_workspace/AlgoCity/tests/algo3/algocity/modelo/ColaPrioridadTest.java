package algo3.algocity.modelo;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.junit.Assert.*;
import org.junit.Test;

public class ColaPrioridadTest {
	
	// La clase PriorityQueue se utiliza para el recorrido del propagar 
	// con un radio en particular.
	
	
	@Test
	public void cuantoMenorEsDistanciaPrimeroSale(){
		
		Comparator<Nodo> comparator = new NodeComparator();
		PriorityQueue<Nodo> queue = new PriorityQueue<Nodo>(10, comparator);

		queue.add(new Nodo(new Coordenada(0, 0), 0));
		queue.add(new Nodo(new Coordenada(0, 1), 1));
		queue.add(new Nodo(new Coordenada(0, 2), 2));
		queue.add(new Nodo(new Coordenada(0, 3), 3));
		queue.add(new Nodo(new Coordenada(0, 4), 4));
		queue.add(new Nodo(new Coordenada(0, 5), 5));

		Nodo n0 = queue.remove();
		Nodo n1 = queue.remove();
		Nodo n2 = queue.remove();
		Nodo n3 = queue.remove();
		Nodo n4 = queue.remove();
		Nodo n5 = queue.remove();
		
		assertEquals(0, n0.getDistancia());
		assertEquals(1, n1.getDistancia());
		assertEquals(2, n2.getDistancia());
		assertEquals(3, n3.getDistancia());
		assertEquals(4, n4.getDistancia());
		assertEquals(5, n5.getDistancia());
		
	}

}
