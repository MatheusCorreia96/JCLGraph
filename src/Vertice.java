import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import interfaces.kernel.datatype.Device;

public class Vertice {			
		public int id;
		public String name;
		public Entry<String, String> device;
		public String cor;
		//public List<String> chegam =  new ArrayList<>();
		public float prc;
		
		public Vertice(int id, String name){
			this.id = id;
			this.name = name;
			this.device = null;
			this.cor = "branco";
			this.prc = 1;
			//chegam =  new ArrayList<>();
		}
		
		public Vertice(int id, String name,  Entry<String, String> device){
			this.id = id;
			this.name = name;
			this.device = device;
			this.cor = "branco";
			this.prc = 1;
			//chegam =  new ArrayList<>();
		}
			
		public void print(){
			System.out.println(id);
			System.out.println(name);
		}
		
		protected synchronized void wakeup(){
			this.notify();						//acorda a thread atual
		}
		
		protected synchronized void suspend()throws Exception{
			wait();
		}
		
		@Override
	    public int hashCode() {
			return id;
		}
			
		@Override
		public boolean equals(Object obj) {
			if ((obj instanceof Vertice) && ((Vertice) obj).id == id) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public String toString(){
		//	if(chegam == null) chegam =  new ArrayList<>();
			return "Vertice"+id;
		}
}
