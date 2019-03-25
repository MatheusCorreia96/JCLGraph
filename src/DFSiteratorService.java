import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import implementations.collections.JCLHashMap;
import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;
import interfaces.kernel.JCL_result;
import interfaces.kernel.datatype.Device;

import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;

public class DFSiteratorService {
	
	private File[] edge = {new File("../user_jars/Edge.jar"), new File("../user_jars/Vertice.jar")};

	/*Eis uma versão preliminar do algoritmo de busca em profundidade. 
	 *O algoritmo recebe um vértice r e pinta de preto todos os vértices do 
	 *território de r.  O código supõe que os vértices do digrafo são  
	 *1, 2, … , n  e que os arcos são representados pelo vetor Adj[1..n] 
	 *de listas de adjacência.*/
	
	public static Vertice[] nextHostIndependent(Vertice vInicial,String path, String nameGraph){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		JCL_facade javaCaLa = JCL_FacadeImpl.getInstance();
		File[] service = {new File(path)};
		System.out.println(javaCaLa.register(service, "Service"));
		//Object[] args ={new Integer(100)};
		List<Future<JCL_result>> tickets = new ArrayList<Future<JCL_result>>();
		
		
		int tamGraph = graph.size();

		
		List<Vertice> keys = new ArrayList<>(graph.keySet());
		Vertice[] retorno = new Vertice[tamGraph-1];
		int i =0;
		Vertice v = null;
		List<Vertice> cor = new ArrayList<>(graph.keySet());
		
		
		cor.get(vInicial.id).cor = "cinza";		//<-- cor[r] <-cinza
		Stack<Vertice> pilha = new Stack<Vertice>();			//<-- P <- Cria-Pilha(r)
		pilha.push(vInicial);				//<-- P <- Cria-Pilha(r)
		//System.out.println(pilha);
		
		while(!pilha.empty()){				//<-- enquanto  P  não estiver vazia faça
			Vertice topo = pilha.peek(); //<-- u <- Copia-Topo-da-Pilha (P)			
			//System.out.print(topo.name);
			Set<Edge> edge = graph.get(topo);//se  Adj[u]  contém  v  tal que  cor[v] = branco
			//System.out.print(edge);
			if(!edge.isEmpty()){
				for(Edge valor:edge){//se  Adj[u]  contém  v  tal que  cor[v] = branco
					
					String[] aux = valor.vertice2.split("v");
					if(Integer.parseInt(aux[1]) >= keys.size()){
						System.out.println("ERROR");
						break;
					}
					else{ 
						v = keys.get(Integer.parseInt(aux[1]));
					}		
					//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
					if(cor.get(v.id).cor.equals("branco")){//se  Adj[u]  contém  v  tal que  cor[v] = branco
						//System.out.println("aqui1");
						cor.get(v.id).cor = "cinza";// então  cor[v]<- cinza  Coloca-na-Pilha (v, P)
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.push(v);// então  cor[v] <- cinza Coloca-na-Pilha (v, P)
						retorno[i] = v;
						i++;		
						System.out.println(v.device);
						Future<JCL_result> ticket = javaCaLa.executeOnDevice(v.device,"Service","fibo");
						tickets.add(ticket);
						break;
					}		
					else{						//senão  cor[u] <- preto Tira-da-Pilha (P)
						cor.get(topo.id).cor = "preto";
						//System.out.println("aqui");
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.pop();
					}
				}
			}
			else{
				pilha.pop();
			}

		}
		
		javaCaLa.getAllResultBlocking(tickets);
//        try{
//        	System.out.println("aqui");
//        	System.out.println(ticket.get());
//        } catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return retorno;//devolva  cor[1..n]
	}

	public static Vertice[] nextIndependent(Vertice vInicial,String path, String nameGraph){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		JCL_facade javaCaLa = JCL_FacadeImpl.getInstance();
		File[] service = {new File(path)};
		System.out.println(javaCaLa.register(service, "Service"));
		//Object[] args ={new Integer(100)};
		List<Future<JCL_result>> tickets = new ArrayList<Future<JCL_result>>();
		
		
		int tamGraph = graph.size();

		
		List<Vertice> keys = new ArrayList<>(graph.keySet());
		Vertice[] retorno = new Vertice[tamGraph-1];
		int i =0;
		Vertice v = null;
		List<Vertice> cor = new ArrayList<>(graph.keySet());
		
		
		cor.get(vInicial.id).cor = "cinza";		//<-- cor[r] <-cinza
		Stack<Vertice> pilha = new Stack<Vertice>();			//<-- P <- Cria-Pilha(r)
		pilha.push(vInicial);				//<-- P <- Cria-Pilha(r)
		//System.out.println(pilha);
		
		while(!pilha.empty()){				//<-- enquanto  P  não estiver vazia faça
			Vertice topo = pilha.peek(); //<-- u <- Copia-Topo-da-Pilha (P)			
			//System.out.print(topo.name);
			Set<Edge> edge = graph.get(topo);//se  Adj[u]  contém  v  tal que  cor[v] = branco
			//System.out.print(edge);
			if(!edge.isEmpty()){
				for(Edge valor:edge){//se  Adj[u]  contém  v  tal que  cor[v] = branco
					
					String[] aux = valor.vertice2.split("v");
					if(Integer.parseInt(aux[1]) >= keys.size()){
						System.out.println("ERROR");
						break;
					}
					else{ 
						v = keys.get(Integer.parseInt(aux[1]));
					}		
					//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
					if(cor.get(v.id).cor.equals("branco")){//se  Adj[u]  contém  v  tal que  cor[v] = branco
						//System.out.println("aqui1");
						cor.get(v.id).cor = "cinza";// então  cor[v]<- cinza  Coloca-na-Pilha (v, P)
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.push(v);// então  cor[v] <- cinza Coloca-na-Pilha (v, P)
						retorno[i] = v;
						i++;		
						//System.out.println(v.device);
						Future<JCL_result> ticket = javaCaLa.execute("Service","fibo");
						tickets.add(ticket);
						break;
					}		
					else{						//senão  cor[u] <- preto Tira-da-Pilha (P)
						cor.get(topo.id).cor = "preto";
						//System.out.println("aqui");
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.pop();
					}
				}
			}
			else{
				pilha.pop();
			}

		}
		
		javaCaLa.getAllResultBlocking(tickets);
//        try{
//        	System.out.println("aqui");
//        	System.out.println(ticket.get());
//        } catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return retorno;//devolva  cor[1..n]
	}
	
	public static Vertice[] nextDependent(Vertice vInicial,String path, String nameGraph){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		JCL_facade javaCaLa = JCL_FacadeImpl.getInstance();
		File[] service = {new File(path)};
		System.out.println(javaCaLa.register(service, "Service"));
		//Object[] args ={new Integer(100)};
			
		int tamGraph = graph.size();

		int result = 0;
		int chamada = 1;
		
		List<Vertice> keys = new ArrayList<>(graph.keySet());
		Vertice[] retorno = new Vertice[tamGraph-1];
		int i =0;
		Vertice v = null;
		List<Vertice> cor = new ArrayList<>(graph.keySet());
		
		
		cor.get(vInicial.id).cor = "cinza";		//<-- cor[r] <-cinza
		Stack<Vertice> pilha = new Stack<Vertice>();			//<-- P <- Cria-Pilha(r)
		pilha.push(vInicial);				//<-- P <- Cria-Pilha(r)
		//System.out.println(pilha);
		
		while(!pilha.empty()){				//<-- enquanto  P  não estiver vazia faça
			Vertice topo = pilha.peek(); //<-- u <- Copia-Topo-da-Pilha (P)			
			//System.out.print(topo.name);
			Set<Edge> edge = graph.get(topo);//se  Adj[u]  contém  v  tal que  cor[v] = branco
			//System.out.print(edge);
			if(!edge.isEmpty()){
				for(Edge valor:edge){//se  Adj[u]  contém  v  tal que  cor[v] = branco
					
					String[] aux = valor.vertice2.split("v");
					if(Integer.parseInt(aux[1]) >= keys.size()){
						System.out.println("ERROR");
						break;
					}
					else{ 
						v = keys.get(Integer.parseInt(aux[1]));
					}		
					//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
					if(cor.get(v.id).cor.equals("branco")){//se  Adj[u]  contém  v  tal que  cor[v] = branco
						//System.out.println("aqui1");
						cor.get(v.id).cor = "cinza";// então  cor[v]<- cinza  Coloca-na-Pilha (v, P)
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.push(v);// então  cor[v] <- cinza Coloca-na-Pilha (v, P)
						retorno[i] = v;
						i++;		
						//System.out.println(v.device);
						
						
						Object[] args = {result, valor.peso, chamada};
						Future<JCL_result> ticket = javaCaLa.execute("Service","somaPonderada", args);
						try {
							result = (int) ticket.get().getCorrectResult();
						} catch (InterruptedException | ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
						chamada++;
						break;
					}		
					else{						//senão  cor[u] <- preto Tira-da-Pilha (P)
						cor.get(topo.id).cor = "preto";
						//System.out.println("aqui");
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.pop();
					}
				}
			}
			else{
				pilha.pop();
			}

		}
		
//		javaCaLa.getAllResultBlocking(tickets);
//        try{
//        	System.out.println("aqui");
//        	System.out.println(ticket.get());
//        } catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return retorno;//devolva  cor[1..n]
	}

	public static Vertice[] nextHostDependent(Vertice vInicial,String path, String nameGraph){
		JCLHashMap<Vertice, Set<Edge>> graph = new JCLHashMap<Vertice, Set<Edge>>(nameGraph);
		JCL_facade javaCaLa = JCL_FacadeImpl.getInstance();
		File[] service = {new File(path)};
		System.out.println(javaCaLa.register(service, "Service"));
		//Object[] args ={new Integer(100)};
			
		int tamGraph = graph.size();

		int result = 0;
		int chamada = 1;
		
		List<Vertice> keys = new ArrayList<>(graph.keySet());
		Vertice[] retorno = new Vertice[tamGraph-1];
		int i =0;
		Vertice v = null;
		List<Vertice> cor = new ArrayList<>(graph.keySet());
		
		
		cor.get(vInicial.id).cor = "cinza";		//<-- cor[r] <-cinza
		Stack<Vertice> pilha = new Stack<Vertice>();			//<-- P <- Cria-Pilha(r)
		pilha.push(vInicial);				//<-- P <- Cria-Pilha(r)
		//System.out.println(pilha);
		
		while(!pilha.empty()){				//<-- enquanto  P  não estiver vazia faça
			Vertice topo = pilha.peek(); //<-- u <- Copia-Topo-da-Pilha (P)			
			//System.out.print(topo.name);
			Set<Edge> edge = graph.get(topo);//se  Adj[u]  contém  v  tal que  cor[v] = branco
			//System.out.print(edge);
			if(!edge.isEmpty()){
				for(Edge valor:edge){//se  Adj[u]  contém  v  tal que  cor[v] = branco
					
					String[] aux = valor.vertice2.split("v");
					if(Integer.parseInt(aux[1]) >= keys.size()){
						System.out.println("ERROR");
						break;
					}
					else{ 
						v = keys.get(Integer.parseInt(aux[1]));
					}		
					//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
					if(cor.get(v.id).cor.equals("branco")){//se  Adj[u]  contém  v  tal que  cor[v] = branco
						//System.out.println("aqui1");
						cor.get(v.id).cor = "cinza";// então  cor[v]<- cinza  Coloca-na-Pilha (v, P)
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.push(v);// então  cor[v] <- cinza Coloca-na-Pilha (v, P)
						retorno[i] = v;
						i++;		
						//System.out.println(v.device);
						
						
						Object[] args = {result, valor.peso, chamada};
						Future<JCL_result> ticket = javaCaLa.executeOnDevice(v.device,"Service","somaPonderada", args);
						try {
							result = (int) ticket.get().getCorrectResult();
						} catch (InterruptedException | ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}		
						chamada++;
						break;
					}		
					else{						//senão  cor[u] <- preto Tira-da-Pilha (P)
						cor.get(topo.id).cor = "preto";
						//System.out.println("aqui");
						//System.out.println(cor.get(v.id).name + " " + cor.get(v.id).cor);
						pilha.pop();
					}
				}
			}
			else{
				pilha.pop();
			}

		}
		
//		javaCaLa.getAllResultBlocking(tickets);
//        try{
//        	System.out.println("aqui");
//        	System.out.println(ticket.get());
//        } catch (InterruptedException | ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return retorno;//devolva  cor[1..n]
	}
}
