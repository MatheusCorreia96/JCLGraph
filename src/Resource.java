import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;


public class Resource<S> {
	
	private List<S> registers;	//buffer
	protected boolean finished;
	private File[] edge = {new File("../JCLGraph/Edge.jar"), new File("../JCLGraph/Vertice.jar")};
	private static JCL_facade jcl = JCL_FacadeImpl.getInstance();
	
	public Resource(List<S> registers){
		this.registers = (List) registers;
		this.finished = false;		
	}
		
	public synchronized void putRegister(S register){
		this.registers.add(register);
	//	wakeup();
	}
	
	protected synchronized void wakeup(){
		this.notify();						//acorda a thread atual
	}
							
	public synchronized S getRegister() throws Exception{
		if(!this.registers.isEmpty()){
			Vertice v = (Vertice) registers.get(0);
			//System.out.println(v.name);
			return this.registers.remove(0);
			
		}
		else {
		//	if(finished==false)
			//	suspend();
			return null;		
		}
	}
	
	protected synchronized void suspend()throws Exception{
		//System.out.println("re"+Thread.currentThread().getName());
		wait();
	}
	
	public int getNumOfRegisters(){
		return this.registers.size();
	}
	
	public synchronized void setFinished(){
		this.finished = true;
		//this.notifyAll();			//acorda todas as threads
	}
	
	public boolean isFinished(){
		return this.finished;
	}
	
	public void next(String nameGraph, String nameVertice, int top){
		//System.out.println("Aqui");
		
		JCL_Graph g = new JCL_Graph(nameGraph);
		
		
		Map<Vertice, Set<Edge>> graph = JCL_FacadeImpl.GetHashMap(nameGraph);
		
		String white = "-1";		//Vertice não visitado
		String grey = "0";			//Vertice atual
		String black ="1";			//Vertice já visitado
		String retornado = "2";		//Vertice já retornado
		
		
		Vertice retorno;
		//Atribui ao vertice inicial como sendo vertice atual(cinza)
		String[] nameV = nameVertice.split("v");		
		Vertice auxiliar = new Vertice(Integer.parseInt(nameV[1]), nameVertice);
		retorno = auxiliar;
		jcl.setValueUnlocking(nameGraph+"_visit_"+retorno.id, "0");
					
		//Inicia a pilha com o nome do primeiro vertice
		if(top == 0){
			jcl.instantiateGlobalVar(nameGraph+"top", top);							// Contador de chamadas do metodo no main
			jcl.instantiateGlobalVar(nameGraph+"aux", "0");							// 
			jcl.instantiateGlobalVar(nameGraph+"stack_"+top, nameVertice);			// Coloca na pilha o vertice atual
			int size = g.graphSize(nameGraph);
			for(int i=0; i<size;i++) jcl.instantiateGlobalVar(nameGraph+"_visit_"+i, "-1");		// Inicializa todos os vertice como não visitados
			nameV = nameVertice.split("v");											
			auxiliar = new Vertice(Integer.parseInt(nameV[1]), nameVertice);
			retorno = auxiliar;														// Coloca o vertice inicial como o primeiro a ser retornado
			jcl.setValueUnlocking(nameGraph+"_visit_"+retorno.id, "2");				// Coloca q o vertice inicial já foi retornado
		}	
		
		String topo = jcl.getValue(nameGraph+"top").getCorrectResult().toString(); 	// Retorna o contador de chamadas no main
		int i = Integer.parseInt(topo);
		
		String check;
				
		if(i>=0){																// Caso o contador seja maior ou igual a zero
			int j = 0;			
			int l = 0;
			Edge e = null;
			Vertice ve = null;
			
				//Pega o topo da pilha e todos os edges q esse verrtice possui
				String u = jcl.getValue(nameGraph+"stack_"+i).getCorrectResult().toString();	// Retorna o topo da pilha
				nameV = u.split("v");
				auxiliar = new Vertice(Integer.parseInt(nameV[1]), u);	
				Set<Edge> v = g.search(nameGraph, auxiliar);
				if( v == null){
					retorno = null;
					auxiliar = null;
					nameV = null;
					check = null;
					return;			//retorna todas as conexões do vertice do topo da pilha
				}

				
				Iterator<Edge> iterator;
				iterator = v.iterator();
				
				do{			//Laço para controle do proximo vertice que será visitado
					if(iterator.hasNext()){			//Todos os Edges do vertice do topo da pilha
						e = iterator.next();		//Esse vertice é selecionado
	    				nameV = e.vertice2.split("v");
	    				auxiliar = new Vertice(Integer.parseInt(nameV[1]), e.vertice2);
	    				ve = auxiliar;
						String a = jcl.getValue(nameGraph+"aux").getCorrectResult().toString();
						int aux = Integer.parseInt(a);
						aux++;						
						jcl.setValueUnlocking(nameGraph+"aux", aux);
					}
					else {				// Caso todos os Edges daquele vertice ja foram percorridos
						String a = jcl.getValue(nameGraph+"aux").getCorrectResult().toString();
						int aux = Integer.parseInt(a);
						if(aux>0){		//Caso entre nesse if, é verificado o edge anterior percorrido e ele é selecionado
							 jcl.setValueUnlocking(nameGraph+"aux", "0");
							 l = 1;
							 j = i -1;
							 	
							 if(j>=0){
								 u = jcl.getValue(nameGraph+"caminho_"+j).getCorrectResult().toString();						
								 for (Vertice key : graph.keySet()){      		
							    		Set<Edge> n = graph.get(key);
							    		iterator = n.iterator();
							    		while (iterator.hasNext()){
							    			Edge ed = iterator.next();
							    			if(ed.name.equals(u)){
							    				e = ed;
							    				nameV = e.vertice2.split("v");
							    				auxiliar = new Vertice(Integer.parseInt(nameV[1]), e.vertice2);
							    				ve = auxiliar;
							    			}
							    		}
								 }
							 }
						}
					}	
					check = jcl.getValue(nameGraph+"_visit_"+ve.id).getCorrectResult().toString();
				}while((check.equals(black) && l!=1)|(check.equals(grey) && l!=1)|(check.equals(retornado) && l!=1));
				
				if(ve != null){
					check = jcl.getValue(nameGraph+"_visit_"+ve.id).getCorrectResult().toString();
					if(check.equals(white)){			//Se o vertice não tiver sido visitado ainda(grey), ele é atribuido como atual(cinza)	
						jcl.setValueUnlocking(nameGraph+"_visit_"+ve.id, "0");
						jcl.instantiateGlobalVar(nameGraph+"caminho_"+i, e.name);		//O edge usado para chegar ali é salvo também
						i++;
						jcl.setValueUnlocking(nameGraph+"top", i);	
						jcl.instantiateGlobalVar(nameGraph+"stack_"+i, ve.name);		//O vertice é empilhado 
					}
					else{	
						jcl.setValueUnlocking(nameGraph+"_visit_"+ve.id, "1");
						jcl.deleteGlobalVar(nameGraph+"stack_"+i);		//O vertice no topo da pilha é retirado
						i--;
						jcl.setValueUnlocking(nameGraph+"top", i);
						jcl.instantiateGlobalVar(nameGraph+"caminho_"+i, e.name);			//O Edge para chegar nesse vertice é salvo também
						j++;
					}
				}
		}
		String p = jcl.getValue(nameGraph+"stack_"+i).getCorrectResult().toString();
		if(!p.equals("No value found!")){
	//		System.out.println("retorno" + p);
			nameV = p.split("v");
			retorno = new Vertice(Integer.parseInt(nameV[1]), p);
			retorno = auxiliar;
			check = jcl.getValue(nameGraph+"_visit_"+retorno.id).getCorrectResult().toString();
			if(!check.equals(retornado)&&!retorno.name.equals(nameVertice)){
				jcl.setValueUnlocking(nameGraph+"_visit_"+retorno.id, "2");
				
				putRegister((S) retorno);
				retorno = null;
				auxiliar = null;
				nameV = null;
				check = null;
				//registers.add((S)retorno);
			//	System.out.println(retorno.name);
				//array[b] = retorno;
				//b++; 
				//if(b == 8) b = 0;
				top++;
				//ttop = top;
				next(nameGraph, nameVertice, top);
			}
			else{
				retorno = null;
				auxiliar = null;
				nameV = null;
				check = null;
				next(nameGraph, nameVertice, top);
			}
		}
	}
}