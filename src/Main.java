import java.io.IOException;
import java.util.List;

import implementations.collections.JCLHashMapPacu;

public class Main {

	public static void main(String[] args) throws IOException, InterruptedException {
		new Main();
	}
	
	public Main() throws IOException, InterruptedException{
			
		
		
		testPageRank.teste();
		
		
		
		
		
		//Arq.escritorPageRank("file5", 5, 5);
		
//		int tam = 5;		
//		String name = "My_first_Graph";				//Graph reference name
//		JCL_Graph g = new JCL_Graph(name);			//Creating Graph		
//		String path = "./file5.txt";		//Location of the input file	
//		System.out.println("Começou "+tam);
//		//long time = System.currentTimeMillis();		 
//		//reportPerformanceFor("starting at", time);
//		g.load(path, name);							//Loading graph
//		//reportPerformanceFor("graph allocation ", time);
//		//g.loadHosts(name);
//		System.out.println("FIM" + tam);
//		
//		//if(g.graphSize(name) != tam) System.err.println("ERROR: LOAD" + tam);
//		g.print(name);
//		
//	//	Vertice v = new Vertice(0, "v0");
//		//Vertice[] caminho = DFSiteratorService.nextHostIndependent(v,"./Service.jar" ,name);
//		//Vertice[] caminho = DFSiteratorService.nextIndependent(v,"./Service.jar" ,name);
//		//Vertice[] caminho = DFSiteratorService.nextDependent(v,"./Service.jar" ,name);
//	//	Vertice[] caminho = DFSiteratorService.nextHostDependent(v,"./Service.jar" ,name);
//		
//	//	for(int i = 0; i<caminho.length;i++){
//	//		System.out.println(caminho[i]);
////		}
//		
//		//g.destroy(name);
//		PageRank p = new PageRank(name);
//		p.pageRank(1);
	/*	
		Vertice v;
		System.out.println("Iterator "+ tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		IteratorDFS a = new IteratorDFS(name,"v0");	
		for(int i=0; i<tam-2;i++){
			v = a.next();
			System.out.println(v.name);
		}
		a.destroy();
		reportPerformanceFor("graph allocation ", time);
		
		v = null;
		g.destroy(name);	

		
		/*
		int  tam = 1000;		
		String name = "My_first_Graph";				//Graph reference name
		JCL_Graph g = new JCL_Graph(name);			//Creating Graph		
		String path = "C:/Users/lucfc/workspace/JCLGraph/file"+tam+".txt";		//Location of the input file	
		System.out.println("Começou "+tam);
		long time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		g.load(path, name);							//Loading graph
		reportPerformanceFor("graph allocation ", time);
		System.out.println("FIM" + tam);
		
		if(g.graphSize(name) != tam) System.err.println("ERROR: LOAD" + tam);

		Vertice v;
		System.out.println("Iterator "+ tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
        IteratorDFS a = new IteratorDFS(name,"v0");	
		for(int i=0; i<tam-2;i++){
			v = a.next();
			System.out.println(v.name);
		}
		a.destroy();
		reportPerformanceFor("graph allocation ", time);
		
		g.destroy(name);	
	
		/*
		tam = 10000;		
		name = "My_first_Graph";				//Graph reference name
		g = new JCL_Graph(name);			//Creating Graph		
		path = "C:/Users/lucfc/workspace/JCLGraph/file"+tam+".txt";		//Location of the input file	
		System.out.println("Começou "+tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		g.load(path, name);							//Loading graph
		reportPerformanceFor("graph allocation ", time);
		System.out.println("FIM" + tam);
		
		if(g.graphSize(name) != tam) System.err.println("ERROR: LOAD" + tam);

		
		System.out.println("Iterator "+ tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		a = new IteratorDFS(name,"v0");	
		for(int i=0; i<tam-2;i++){
			v = a.next();
			//System.out.println(v.name);
		}
		a.destroy();
		reportPerformanceFor("graph allocation ", time);
		
		g.destroy(name);	
		
		JCLHashMapPacu.destroy();
		
		tam = 100000;		
		name = "My_first_Graph";				//Graph reference name
		g = new JCL_Graph(name);			//Creating Graph		
		path = "C:/Users/lucfc/workspace/JCLGraph/file"+tam+".txt";		//Location of the input file	
		System.out.println("Começou "+tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		g.load(path, name);							//Loading graph
		reportPerformanceFor("graph allocation ", time);
		System.out.println("FIM" + tam);
		
		if(g.graphSize(name) != tam) System.err.println("ERROR: LOAD" + tam);

		
		System.out.println("Iterator "+ tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		a = new IteratorDFS(name,"v0");	
		for(int i=0; i<tam-2;i++){
			v = a.next();
			//System.out.println(v.name);
		}
		a.destroy();
		reportPerformanceFor("graph allocation ", time);
		
		g.destroy(name);
		
		tam = 1000000;		
		name = "My_first_Graph";				//Graph reference name
		g = new JCL_Graph(name);			//Creating Graph		
		path = "C:/Users/lucfc/workspace/JCLGraph/file"+tam+".txt";		//Location of the input file	
		System.out.println("Começou "+tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		g.load(path, name);							//Loading graph
		reportPerformanceFor("graph allocation ", time);
		System.out.println("FIM" + tam);
		
		if(g.graphSize(name) != tam) System.err.println("ERROR: LOAD" + tam);

		
		System.out.println("Iterator "+ tam);
		time = System.currentTimeMillis();		 
        reportPerformanceFor("starting at", time);
		a = new IteratorDFS(name,"v0");	
		for(int i=0; i<tam-2;i++){
			v = a.next();
			//System.out.println(v.name);
		}
		a.destroy();
		reportPerformanceFor("graph allocation ", time);
		
		g.destroy(name);	
		*/
		
		JCLHashMapPacu.destroy();
		
	}
	
	private static void reportPerformanceFor(String msg, long refTime)
    {
        double time = (System.currentTimeMillis() - refTime) / 1000.0;
        double mem = usedMemory() / (1024.0 * 1024.0);
        mem = Math.round(mem * 100) / 100.0;
        System.out.println(msg + " (" + time + " sec, " + mem + "MB)");
    }

    private static long usedMemory()
    {
        Runtime rt = Runtime.getRuntime();

        return rt.totalMemory() - rt.freeMemory();
    }
}
