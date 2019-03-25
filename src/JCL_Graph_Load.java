import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

import implementations.collections.JCLHashMap;
import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;
import interfaces.kernel.datatype.Device;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;

public class JCL_Graph_Load {
	
	private File[] edge = {new File("../user_jars/Edge.jar"), new File("../user_jars/Vertice.jar")};
	
	public void asynchronousLoad(byte[] file, String name, String nameArq) throws IOException{
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(name);
		
		String path = "../Arq/";
		File arq = new File(path);
		if (!arq.exists()){
			arq.mkdir();
		}
		byteToFile(file,nameArq);
				
		path = "../Arq/"+nameArq;
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		String vertice1, vertice2, edgeName;
		int weightEdge, idEdge, i =0;
		Vertice v;
		Edge e;
	//	Object2ObjectMap<Vertice, Set<Edge>> mapLocal = new Object2ObjectOpenHashMap<Vertice, Set<Edge>>();
		Map<Vertice, Set<Edge>> mapLocal = new HashMap<Vertice, Set<Edge>>();
		
		//System.out.println("AQui");
		
		while(true){
			linha = buffRead.readLine();
			if(linha != null){			
				String[] aux = linha.split(" ");
				vertice1 = "v"+aux[0];
				v = new Vertice(Integer.parseInt(aux[0]), vertice1);
				vertice2 = "v"+aux[1];
				weightEdge = Integer.parseInt(aux[2]);			
            	edgeName = aux[3];
            	String[] id = edgeName.split("e");
            	idEdge = Integer.parseInt(id[1]);
                e = new Edge(idEdge, weightEdge, edgeName, vertice1, vertice2);
              
                //System.out.println("lock" + v.name);
                Set<Edge> arestas;
                
               if(mapLocal.get(v) != null){
            	   
                	arestas = mapLocal.get(v); 
                	//System.out.println(v + "A = " + arestas.size());
	                arestas.add(e);
                }
                else{
                    arestas = graph.get(v);  
                  //  System.out.println(v + "B = " + arestas.size());
                    arestas.add(e);
                }
             //  System.out.println(v.chegam.add(vertice2));
              // System.out.println(v + "B = " + arestas.size());
	            mapLocal.put(v, arestas);
                
	            
	            
	        //    print(name);
               	arestas = null;
               	v = null;
	            i++;
			}
			else break;	
		}
		
	//	System.out.println("mapLocal "+ mapLocal.size()); 
		
		// for (Entry<Vertice, Set<Edge>> key : mapLocal.entrySet()) {
//			 System.out.print(Thread.currentThread().getId()+" "+key.getKey().id +" = ");
		//	 System.out.print("[" + key.getKey().chegam + "]" + " = ");
             //Capturamos o valor a partir da chave
//			 if(!"no result".equals(graph.get(key)) && (graph.get(key) != null)){ 
			
				 //System.out.println(graph.get(key));
		//	 Set<Edge> value = key.getValue();
             
             
         //    for(Edge valor:value){
            	 //System.out.println("en");
                 //   System.out.print(valor.name+" ");
                    
          //   }
             
          //   System.out.println();
//			 }
//			 else{
//				 System.out.println("asafsaf");
//			 }
	//	 }
		
		for (Entry<Vertice, Set<Edge>> key : mapLocal.entrySet()){
			graph.getLock(key.getKey());
			Set<Edge> arestas = mapLocal.get(key.getKey());			
			//System.out.println(key.getKey() + "A = " + arestas.size());
			graph.putUnlock(key.getKey(), arestas);	
		}
					
		arq = new File(path);
		deleteTree(arq);
	}
	
	public void print(String nameGraph){
		//File[] edge = {new File("../user_jars/Edge.jar")};
		Map<Vertice, Set<Edge>> graph = JCL_FacadeImpl.GetHashMap(nameGraph);
		
		 for (Entry<Vertice, Set<Edge>> key : graph.entrySet()) {
			 System.out.print(Thread.currentThread().getId()+" "+key.getKey().id +" = ");
			 //System.out.print("[" + key.getKey().chegam + "]" + " = ");
             //Capturamos o valor a partir da chave
//			 if(!"no result".equals(graph.get(key)) && (graph.get(key) != null)){ 
			
				 //System.out.println(graph.get(key));
			 Set<Edge> value = key.getValue();
             
             
             for(Edge valor:value){
            	 //System.out.println("en");
                    System.out.print(valor.name+" ");
                    
             }
             
             System.out.println();
//			 }
//			 else{
//				 System.out.println("asafsaf");
//			 }
		 }
		
	}
	
    public static void deleteTree(File inFile) {
    //	
        if (inFile.isFile()) {  
            inFile.delete();  
          //  System.out.println("entrou");
        } else {  
             File files[] = inFile.listFiles();  
             for (int i=0;i< files.length; i ++) {  
            	 deleteTree(files[i]);  
             }  
        }  
    }

	private void byteToFile(byte[] bytesArray, String nameArq) throws IOException{
		File sourceFile = new File("../Arq/"+nameArq);
		FileOutputStream file = new FileOutputStream(sourceFile);
		BufferedOutputStream output = new BufferedOutputStream(file); 
		         output.flush();
		         output.write(bytesArray, 0, bytesArray.length); 
		         output.flush();
		         output.close();
	}


}
 