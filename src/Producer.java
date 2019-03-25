import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;

public class Producer<S> extends Thread{
	

	private Resource<S> re;
	
	private String nameGraph;
	private String nameVertice;
	private int top;
	
	
	public Producer(Resource<S> re, String nameGraph, String nameVertice, Integer top){
		this.re = re;
		this.nameGraph = nameGraph;
		this.nameVertice = nameVertice;
		this.top = top;
	}
	
	public void run(){
		re.next(nameGraph, nameVertice, top);
	}
	

}
