import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Arq {
	
		 public static void escritor() throws IOException {			//GERA UM ARQUIVO ALEATORIO DE ENTRADA
			 
		        BufferedWriter buffWrite = new BufferedWriter(new FileWriter("../JCLGraph/file10.txt"));
		        
		        Random rand = new Random();
		        
		        
		        
		        int numVertices = 10;        
		        String linha = Integer.toString(numVertices);
		        buffWrite.append(numVertices+System.lineSeparator());
		        int numArestas = numVertices -1;				
		        int vertice1, j = 0, k =0;
		        int a = 1;
		        for(int i=0; i<(numArestas)/2;i++){
		        	
		        	if(i == 0){
		        	vertice1 = i;
		        	String aux = Integer.toString(vertice1);
		        	int vertice2 = i+a;
		        	String aux2 = Integer.toString(vertice2);
		        	int peso = 100;
		        	String aux1 = Integer.toString(peso);
		        	buffWrite.append(aux + " " + aux2 + " " + aux1 + " " +"e"+j+System.lineSeparator());
		        	vertice2 = i+a+1;
		        	aux2 = Integer.toString(vertice2);
		        	j++;
		        	buffWrite.append(aux + " " + aux2 + " " + aux1 +  " " +"e"+ j+System.lineSeparator());
		        	a++;
		        	
		        	}
		        	else{
		        		
		        		vertice1 = i;
			        	String aux = Integer.toString(vertice1);
			        	int vertice2 = i+a;
			        	String aux2 = Integer.toString(vertice2);
			        	int peso = 100;
			        	String aux1 = Integer.toString(peso);
			        	buffWrite.append(aux + " " + aux2 + " " + aux1 + " " +"e"+j+System.lineSeparator());
			        	vertice2 = i+a+1;
			        	aux2 = Integer.toString(vertice2);
			        	j++;
			        	buffWrite.append(aux + " " + aux2 + " " + aux1 +  " " +"e"+j+System.lineSeparator());
			        	a++;
		        	}
		        	j++;
		        }		        
		        buffWrite.close();
	    }

		 public static void escritorPageRank(String nameArq, int numVertices, int numArestas) throws IOException {			//GERA UM ARQUIVO ALEATORIO DE ENTRADA
			 
			 	String auxiliar = "../JCLGraph/" + nameArq + ".txt";
			 
			 	BufferedWriter buffWrite = new BufferedWriter(new FileWriter(auxiliar));
		        
		        Random rand = new Random();
		        
		               
		        String linha = Integer.toString(numVertices);
		        buffWrite.append(numVertices+System.lineSeparator());			
		        int vertice1, j = 0, k =0;
		        for(int i=0; i<numArestas;i++){
		        	vertice1 = rand.nextInt(numVertices);
		        	String aux = Integer.toString(vertice1);
		        	int vertice2 = rand.nextInt(numVertices);
		        	while(vertice1 == vertice2) vertice2 = rand.nextInt(numVertices);
		        	String aux2 = Integer.toString(vertice2);
		        	int peso = 100;
		        	String aux1 = Integer.toString(peso);
		        	buffWrite.append(aux + " " + aux2 + " " + aux1 + " " +"e"+i+System.lineSeparator());	        	
		        	}
		        buffWrite.close();
	    }

}
