import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import implementations.collections.JCLHashMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class PageRank {
	
	String nameGraph;
	Object2ObjectMap<Vertice, List<Vertice>> mapVertice = new Object2ObjectOpenHashMap<Vertice, List<Vertice>>();
	
	public PageRank(String nameGraph){
		this.nameGraph = nameGraph;
		
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		
		
		int tamGraph = graph.size();
		Vertice v, v2;
	    String aux1;
	    
	    
	    for(int i = 0; i<tamGraph; i++){
			aux1 = "v"+i;
			v = new Vertice(i, aux1);
			mapVertice.put(v,new ArrayList<Vertice>());
	    }
	  
	    	
	
		for(int i = 0; i<tamGraph; i++){
			aux1 = "v"+i;
			v = new Vertice(i, aux1);
			Set<Edge> arestas = graph.get(v);			
			for(Edge valor:arestas){
				String vertice2 = valor.vertice2;
				String[] aux = vertice2.split("v");
				v2 = new Vertice(Integer.parseInt(aux[1]), vertice2);
				List<Vertice> chegam = mapVertice.get(v2);
				chegam.add(v);
				mapVertice.put(v2,chegam);
            }			
		}
	}
	
	public Vertice pageRank(int interacoes){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		
		int tamGraph = graph.size();
		Vertice v;
		String aux1;
		
		float[] pRC = new float[tamGraph];
		float[] pRCatual = new float[tamGraph];
		for(int i = 0; i<tamGraph; i++){ pRC[i] = 1; pRCatual[i] = 1;}
		
		for(int j = 0; j < interacoes ; j++){
			for(int i = 0; i<tamGraph; i++){			
				aux1 = "v"+i;
				v = new Vertice(i, aux1);		
				float vizinhos = 0;
				List<Vertice> chegam = mapVertice.get(v);
				//System.out.println("aqui:" + chegam.size());
				for(Vertice valor:chegam){
					int links = graph.get(valor).size();			
					vizinhos = (pRC[valor.id]/links) + vizinhos;
				}
				pRCatual[i] = (float) (0.15 + (0.85 * vizinhos));
			}
			//pRC = pRCatual;
			for(int i = 0; i<tamGraph; i++){ pRC[i] = pRCatual[i];}

		}
			
		
//		for(int i = 0; i<tamGraph; i++){
//			System.out.println("v"+i+" = "+ pRCatual[i]);
//		}
		
//		for (Entry<Vertice, List<Vertice>> key : mapVertice.entrySet()) {
//			System.out.print(key.getKey().name +" = ");
//			List<Vertice> value = key.getValue();	                   
//	        for(Vertice valor:value){
//	            System.out.print(valor.name+" ");                
//	        }	             
//	        System.out.println();
//
//			 }
		return null;	
	}

	public void destroy(){
		mapVertice.clear();
	}
}
