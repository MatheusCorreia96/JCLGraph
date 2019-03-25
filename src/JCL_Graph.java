
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Future;

import implementations.collections.JCLHashMap;
import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;
import interfaces.kernel.JCL_result;
import interfaces.kernel.datatype.Device;

public class JCL_Graph {
	
	public JCL_Graph(String name){
		JCL_facade jcl = JCL_FacadeImpl.getInstance();
		File[] edge = {new File("./Edge.jar"), new File("./Vertice.jar")};
		//System.out.println(jcl.register(edge, "Edge"));
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(name);
	}
	
	public void load(String path, String name) throws IOException{
			File[] edge = {new File("./Edge.jar"), new File("./Vertice.jar")};
			JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(name);
			//JCLHashMap<Vertice, List<String>> mapVertice = new JCLHashMap<Vertice, List<String>>(name+"Vetices");
						
			//ARQUIVO DE LEITURA
			BufferedReader buffRead = new BufferedReader(new FileReader(path));
			String linha = "";
			
			//INCIALIZA O HASH DOS VERTICES
			linha = buffRead.readLine();
			int tamGraph = Integer.parseInt(linha);
		    Vertice v;
		    String aux1;
		    
			for(int i = 0; i<tamGraph; i++){
				aux1 = "v"+i;
				v = new Vertice(i, aux1);
				graph.put(v,new TreeSet<Edge>());
			//	mapVertice.put(v, new ArrayList<String>());
		}
			
			String arquivo = "";
			int j = 0;
			while(linha != null){
				String nameArq = "file" + j + ".txt";
				arquivo = "../Arq/";	
				File arq = new File(arquivo);
				if (!arq.exists()){
					arq.mkdir();
				}
				arquivo = "../Arq/" + nameArq;	
				
				BufferedWriter buffWrite = new BufferedWriter(new FileWriter(arquivo));
				for(int i=0;i<1250;i++){
					linha = buffRead.readLine();
					if(linha != null) buffWrite.append(linha+ System.lineSeparator());
				}
				j++;
				buffWrite.close();
			}
			
			JCL_facade jcl = JCL_FacadeImpl.getInstance();
			List<Future<JCL_result>> tickets = new LinkedList<Future<JCL_result>>();
			File[] JCL_Graph_Load = {new File("./JCL_Graph_Load.jar")};
			jcl.register(JCL_Graph_Load, "JCL_Graph_Load");
						
			//System.out.println(j);
			for(int i = 0; i<j;i++){
				String nameArq = "file" + i + ".txt";
				arquivo = "../Arq/" + nameArq;			
				byte[] by = loadBytes(arquivo);
				Object[] args = {by, name, nameArq};
				Future<JCL_result> ticket = jcl.execute("JCL_Graph_Load", "asynchronousLoad", args);
				tickets.add(ticket);
			}
			
			//System.out.println("aqui");
			jcl.getAllResultBlocking(tickets);
			System.out.println("mapGlobal "+ graph.size()); 
			
			for(int i = 0; i<j;i++){
				String nameArq = "file" + i + ".txt";
				arquivo = "../Arq/" + nameArq;
				File arq = new File(arquivo);
				deleteTree(arq);
			}
			
			System.out.println("mapJCL "+ graph.size());
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
	
	private byte[] loadBytes(String name) {
		FileInputStream in = null;
		try {
			in = new FileInputStream(name);
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int bytesread = 0;
			byte[] tbuff = new byte[512];
			while (true) {
				bytesread = in.read(tbuff);
				if (bytesread == -1) // if EOF
					break;
				buffer.write(tbuff, 0, bytesread);
			}
			return buffer.toByteArray();
		} catch (IOException e) {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e2) {
				}
			}
			return null;
		}
	}
	
	public void destroy(String name){
		Map<String, Vertice> vertices = JCL_FacadeImpl.GetHashMap("Vertice"+name);
		Map<String, Edge> edges = JCL_FacadeImpl.GetHashMap("Edge"+name);
		Map<String, Set<String>> graph = JCL_FacadeImpl.GetHashMap(name);
		vertices.clear();
		edges.clear();
		graph.clear();
	}
	
	public void addVertice(String nameGraph, Vertice vertice){
		File[] edge = {new File("../JCLGraph/Edge.jar"), new File("../JCLGraph/Vertice.jar")};
		Map<Vertice, Set<Edge>> graph = JCL_FacadeImpl.GetHashMap(nameGraph);
				
		Set<Edge> arestas = new TreeSet<Edge>();	
		graph.put(vertice, arestas);
		
		arestas.clear();
		
	}

	public Set<Edge> search(String nameGraph, Vertice keyToSearch){
		Map<String, Set<Edge>> graph = JCL_FacadeImpl.GetHashMap(nameGraph);
		//RETORNA TODOS OS EDGES QUE SAEM DE UM VERTICE
			Set<Edge> n = graph.get(keyToSearch);
			return n;
	}
	
	public void addEdge(String nameGraph, int id, int peso, String name, String vertice1, String vertice2){
			File[] edge = {new File("../JCLGraph/Edge.jar"), new File("../JCLGraph/Vertice.jar")};
			Map<Vertice, Set<Edge>> graph = JCL_FacadeImpl.GetHashMap(name);	
			
			Edge e;
			e = new Edge(id, peso, name, vertice1, vertice2);
			Vertice v = null, a = null;
			boolean b = false, bo = false;
			Set<Edge> arestas = new TreeSet<Edge>();
			for (Vertice key : graph.keySet()){
             	if(key.name.equals(vertice1)){
             		v = key;
             		b = true;
             	}
             	if(key.name.equals(vertice2)){
             		a = key;
             		bo = true;
             	}
             	if(b == true & bo == true){
             		Set<Edge> n = graph.get(v);
			    	n.add(e);
			    	graph.put(v, n);
			    	arestas.clear();
	                graph.put(a, arestas);
	                break;
	            }else{
	            	System.out.println("Vertice de partida nao encontrado");
	            	break;
	            }
            }

	        arestas.clear();
			
	}
		
	public void edgeInfo(String nameGraph, String Edgename){
		File[] edge = {new File("/Users/mac/Documents/workspace/JCLGraph-3/Edge.jar")};
		Map<String, Edge> edges = new JCLHashMap<String, Edge>("Edge"+nameGraph);	
		Edge myinfo= edges.get(Edgename);
		myinfo.print();

	}

	public boolean isEdge(String nameGraph,String vertex1,String vertex2){
		Map<String, Set<String>> graph = JCL_FacadeImpl.GetHashMap(nameGraph);	
		if(graph.containsKey(vertex1) && graph.containsKey(vertex2)){
			Set<String> n = graph.get(vertex1);
			Set<String> n2= graph.get(vertex2);
			return !n.isEmpty() && !n2.isEmpty();
		}
		else{
			throw new IllegalArgumentException("Vertices nao registrados.");
		}
			
				

	}

	public int graphSize(String nameGraph){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		return graph.size();
	}

	public void print(String nameGraph){
		//File[] edge = {new File("../user_jars/Edge.jar")};
		Map<Vertice, Set<Edge>> graph = JCL_FacadeImpl.GetHashMap(nameGraph);
		int tamanho = 0;
		
		 for (Entry<Vertice, Set<Edge>> key : graph.entrySet()) {
			// System.out.print(Thread.currentThread().getId()+" "+key.getKey().id +" = ");
			 //System.out.print("[" + key.getKey().chegam + "]" + " = ");
             //Capturamos o valor a partir da chave
//			 if(!"no result".equals(graph.get(key)) && (graph.get(key) != null)){ 
			
				 //System.out.println(graph.get(key));
			 Set<Edge> value = key.getValue();
             
            tamanho = tamanho + value.size();
//             for(Edge valor:value){
//            	 //System.out.println("en");
//                    System.out.print(valor.name+" ");
//                    
//             }
             
//             System.out.println();
//			 }
//			 else{
//				 System.out.println("asafsaf");
//			 }
		 }
		 
		 System.out.println("Qtd Edge:" + tamanho);
		
		
	}

	public void loadHosts(String nameGraph){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		
		JCL_facade javaCaLa = JCL_FacadeImpl.getInstance();
		List<Device> hosts = javaCaLa.getDevices();
		

		int clusterSize = hosts.size();
		Set<Edge> arestas = new TreeSet<Edge>();
		
		System.out.println(clusterSize);
		
		for(int i = 0; i < clusterSize; i++){
			Entry<String, String> host = hosts.get(i);
			Vertice v = new Vertice(i, "v"+Integer.toString(i), host);
			graph.put(v, arestas);
		}
		
		loadEdges(nameGraph);
	}
	
	public void loadEdges(String nameGraph){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		List<Vertice> keys = new ArrayList<>(graph.keySet());
		//System.out.println("aqui");
		for(int i=0;i<keys.size();i++){
			for(int j=i+1;j<keys.size();j++){
				Edge edgeIda = new Edge(j-1, 100,"e"+Integer.toString(j-1), "v"+Integer.toString(i), "v"+Integer.toString(j));
				Set<Edge> edge = graph.get("v"+Integer.toString(i));
				if(edge != null){
					edge.add(edgeIda);
					graph.put(keys.get(i), edge);
					//System.out.println("aqui" + keys.get(i).name + edge);
				}
				else{
					edge = new TreeSet<Edge>();
					edge.add(edgeIda);
					graph.put(keys.get(i), edge);
					//System.out.println(keys.get(i).name + edge);
				}
			}		
		}
	}

}
	
 