import java.io.IOException;

public class testPageRank {
		
	public static void teste() throws IOException{
		//teste 100 vertice 100 edge		
			Arq.escritorPageRank("file1001", 100, 100);
			int tam = 100;	
			int tamEdge = 100;
			String name = "My_first_Graph";				//Graph reference name
			JCL_Graph g1 = new JCL_Graph(name);			//Creating Graph		
			String path = "./file1001.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			long time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g1.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p1 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p1.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p1.destroy();
			g1.destroy(name);
		
		//teste 100 vertice 1000 edge
			Arq.escritorPageRank("file1002", 100, 1000);
			tam = 100;	
			tamEdge = 1000;
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g2 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1002.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g2.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p2 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p2.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p2.destroy();
			g2.destroy(name);
		
		//teste 100 vertice 10000 edge
			Arq.escritorPageRank("file1003", 100, 10000);
			tam = 10000;
			tamEdge = 10000;
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g3 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1003.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g3.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p3 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p3.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p3.destroy();
			g3.destroy(name);
		
		//teste 1000 vertice 1000 edge
			Arq.escritorPageRank("file1004", 1000, 1000);
			tam = 1000;	
			tamEdge = 1000;
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g4 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1004.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g4.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p4 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p4.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p4.destroy();
			g4.destroy(name);
		
		//teste 1000 vertice 10000 edge
			Arq.escritorPageRank("file1005", 1000, 10000);
			tam = 1000;	
			tamEdge = 10000;
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g5 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1005.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g4.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p5 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p5.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p5.destroy();
			g5.destroy(name);
		
		//teste 1000 vertice 100000 edge
			Arq.escritorPageRank("file1006", 1000, 100000);
			tam = 1000;	
			tamEdge = 100000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g6 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1006.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g5.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p6 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p6.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p6.destroy();
			g6.destroy(name);
		
		//teste 1000 vertice 1000000 edge
			Arq.escritorPageRank("file1007", 1000, 10000000);
			tam = 1000;	
			tamEdge = 10000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g7 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1007.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g7.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p7 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p7.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p7.destroy();
			g7.destroy(name);
			
		//teste 10000 vertice 100000000 edge
			Arq.escritorPageRank("file1008", 10000, 100000000);
			tam = 1000;	
			tamEdge = 10000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g8 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1008.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g8.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p8 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p8.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p8.destroy();
			g8.destroy(name);
			
		//teste 10000 vertice 1bi edge
			System.out.println("aqui1");
			Arq.escritorPageRank("file1009", 10000, 1000000000);
			System.out.println("aqui");
			tam = 1000;	
			tamEdge = 1000000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g9 = new JCL_Graph(name);			//Creating Graph		
			path = "./file1009.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g9.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p9 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p7.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p9.destroy();
			g9.destroy(name);
			
		//teste 100 mil vertice 10 mi edge
			Arq.escritorPageRank("file10010", 100000, 10000000);
			tam = 100000;	
			tamEdge = 10000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g10 = new JCL_Graph(name);			//Creating Graph		
			path = "./file10010.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g8.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p10 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p10.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p10.destroy();
			g10.destroy(name);
			
		//teste 100 mil vertice 100 mi edge
			Arq.escritorPageRank("file10011", 100000, 100000000);
			tam = 100000;	
			tamEdge = 100000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g11 = new JCL_Graph(name);			//Creating Graph		
			path = "./file10011.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g9.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p11 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p11.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p11.destroy();
			g11.destroy(name);
			
		//teste 1 mi vertice 10 mi edge
			Arq.escritorPageRank("file10012", 1000000, 10000000);
			tam = 1000000;	
			tamEdge = 10000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g12 = new JCL_Graph(name);			//Creating Graph		
			path = "./file10012.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g10.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p12 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p12.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p12.destroy();
			g12.destroy(name);
			
		//teste 10 mi vertice 10 mi edge
			Arq.escritorPageRank("file10013", 10000000, 10000000);
			tam = 10000000;	
			tamEdge = 10000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g13 = new JCL_Graph(name);			//Creating Graph		
			path = "./file10013.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g13.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p13 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p13.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p13.destroy();
			g13.destroy(name);
			
		//teste 100 mi vertice 100 mi edge
			Arq.escritorPageRank("file10014", 100000000, 100000000);
			tam = 100000000;	
			tamEdge = 100000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g14 = new JCL_Graph(name);			//Creating Graph		
			path = "./file10014.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g14.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p14 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p14.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p14.destroy();
			g14.destroy(name);
			
			
		//teste 100 mi vertice 1 bi edge
			Arq.escritorPageRank("file10015", 100000000, 1000000000);
			tam = 100000000;	
			tamEdge = 1000000000;	
			name = "My_first_Graph";				//Graph reference name
			JCL_Graph g15 = new JCL_Graph(name);			//Creating Graph		
			path = "./file10015.txt";		//Location of the input file	
			
			System.err.println("Começou "+tam+" "+tamEdge);
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load grafo", time);
			g13.load(path, name);							//Loading graph
			reportPerformanceFor("graph allocation " + tam + " ", time);		
			//g.print(name);
			
			time = System.currentTimeMillis();		 
			reportPerformanceFor("Começou load pagerank", time);
			PageRank p15 = new PageRank(name);
			reportPerformanceFor("PageRank allocation " + tam + " ", time);
			time = System.currentTimeMillis();		 
			
			reportPerformanceFor("Começou pagerank algoritmo", time);
			p15.pageRank(1);
			reportPerformanceFor("PageRank algoritmo " + tam + " ", time);
			
			p15.destroy();
			g15.destroy(name);
			
			
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
