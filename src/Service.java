
public class Service {
	public Boolean fibo(){
		//System.out.println("aqui");
		int n =10;
		 int F = 0;     // atual
		 int ant = 0;   // anterior		 
		 for (int i = 1; i <= n; i++) {
			F = F + i;
		}
		//System.out.println(Thread.currentThread().getId()+" "+ F);
		return true;	
	}
	
	public Boolean f(int n){
		System.out.println(n);
		return true;
	}

	public int somaPonderada(int result, int peso, int chamada){
		
		result = result + (chamada*peso);	
		System.out.println(result);
		return result;
	}
}
