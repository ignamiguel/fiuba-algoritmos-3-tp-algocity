package algo3.algocity.modelo;
import java.util.Comparator;


public class NodeComparator implements Comparator<Nodo>{
    @Override
    public int compare(Nodo x, Nodo y)
    {
        return (x.getDistancia() - y.getDistancia());
    }

	    
}

