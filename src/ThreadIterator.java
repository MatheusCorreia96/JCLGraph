import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;

public class ThreadIterator implements Runnable{
	public String nameGraph;
	public String nameVertice;
	static Integer ttop;
	
	ThreadIterator(String nameGraph, String nameVertice, Integer ttop){
		this.nameGraph = nameGraph;
		this.nameVertice = nameVertice;
		this.ttop = ttop;
	}
	
	public void run(){	
		/*System.out.println(Thread.currentThread().getState()) ;
		IteratorDFS.nextArray(nameGraph, nameVertice, ttop);
		IteratorDFS.nextArray(nameGraph, nameVertice, ttop);
		IteratorDFS.nextArray(nameGraph, nameVertice, ttop);
		IteratorDFS.nextArray(nameGraph, nameVertice, ttop);
		*/
	}
	
}