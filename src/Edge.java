
public class Edge implements Comparable<Edge>{		
		public int id;
		public int peso;
		public String name;
		public String vertice1;
		public String vertice2;
		
		public Edge(int id, int peso, String name, String vertice1, String vertice2){
			this.id = id;
			this.peso = peso;
			this.name = name;
			this.vertice1 = vertice1;
			this.vertice2 = vertice2;
		}
		
		public void print(){
			
			System.out.println(id);
			System.out.println(peso);
			System.out.println(name);
			System.out.println(vertice1);
			System.out.println(vertice2);
		}

		protected synchronized void wakeup(){
			this.notify();						//acorda a thread atual
		}
		
		protected synchronized void suspend()throws Exception{
			wait();
		}
		
		@Override
		public int compareTo(Edge e) {
			// TODO Auto-generated method stub
			return id - e.id;
		}
		
}
