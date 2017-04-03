import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {

	public static void main(String[] args) {
	 
	    System.out.print("Matriz:\n");
	    
	    try {
	      FileReader file = new FileReader("example_1.txt");
	      BufferedReader readFile = new BufferedReader(file);
	 
	      String row = readFile.readLine();
	      while (row != null) {
	        System.out.print(row+"\n");
	        row = readFile.readLine();
	      }
	    
	      file.close();
	      
	    } catch (IOException e) {
	        System.err.print("Erro ao ler o arquivo "+e.getMessage()+".\n");
	    }
	    
	    System.out.println();
	  }
}
