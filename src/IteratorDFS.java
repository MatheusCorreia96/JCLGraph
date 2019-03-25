import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class IteratorDFS{
	public String nameGraph;
	public String nameVertice;
	
	List<String> registers = Collections.synchronizedList(new LinkedList<String>());	//buffer
	
	//criamos um resource
	Resource<String> recurso;
	
	//criamos o numero de produtores compativel com o numero de arquivos/discos
	Producer<String> produtores; 
	
	//criamos os consumidores
	Consumer<String> consumidores;
	
	public IteratorDFS(String nameGraph, String nameVertice){
		this.nameGraph = nameGraph;
		this.nameVertice = nameVertice;
		//criamos um resource
		recurso = new Resource<String>(registers);
		
		//criamos o numero de produtores compativel com o numero de arquivos/discos
		produtores = new Producer<String>(recurso, nameGraph, nameVertice, 0);
		
		//criamos os consumidores
		consumidores = new Consumer<String>(recurso);
		
		//inicializamos							
		produtores.start();						//start em todos os produtores
		consumidores.start();	
	}
	
	public Vertice next() throws InterruptedException{

		
		
		//Thread.currentThread();
		//Thread.sleep(500);
		Vertice v = null;
		try {
			v = consumidores.next();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try{
		//	produtores.join();					//join em todos os produtores
			
		//	recurso.setFinished();				//informa que os produtores ja terminaram
												
		//	consumidores.join();				//join em todos os consumidores
	
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return v;
	}

	
	public void destroy() throws InterruptedException{
		produtores.join();
		
	}


}