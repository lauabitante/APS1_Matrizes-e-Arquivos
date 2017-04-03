import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {

	public static void main(String[] args) {
		showAllExamples();
	}
	
	public static void readTextFile(String fileName) {
		try {
		      FileReader file = new FileReader(fileName);
		      BufferedReader readFile = new BufferedReader(file);
		 
		      String firstLine = readFile.readLine();
		      // Cria um array contendo o numero de linhas e colunas, utilizando o espaçamento como separador
		      String[] splitLine = firstLine.split(" ");
		      int columns = Integer.parseInt(splitLine[0]);
		      int rows = Integer.parseInt(splitLine[1]);
		      int[][] matriz = new int[rows][columns];
		      
	          // Lê os dados da matriz
		      for (int j=0; j< rows; j++) {
		    	  char[] currentLine = readFile.readLine().toCharArray();
		    	  for (int i=0; i<columns; i++) {
		    		  matriz[j][i] = Integer.parseInt(String.valueOf(currentLine[i]));
		    	  }
		      }
	            
	         // Imprime a matrizes: original e alteradas
		      printOriginalMatriz(matriz);
		      printAlteredMatriz(matriz, 1, 2, "1 para 2:");
		      printAlteredMatriz(matriz, 0, 2, "0 para 2:");
		      
		      System.out.println();
		      
		      file.close();
		      
		} catch (IOException e) {
			System.err.print("Erro ao ler o arquivo: "+e.getMessage()+".\n");
		}
	}
	
	static void printOriginalMatriz(int[][] matriz) {
		
		System.out.println("Matriz Original: \n");
        for (int a=0; a< matriz.length; a++) {
            for (int b=0; b<matriz[0].length; b++) {
                if (b == matriz[0].length - 1) {
                    System.out.println(matriz[a][b] + "|");
                } else {
                    System.out.print("|" + matriz[a][b] + "|");
                }
            }
        }
        System.out.println();
        System.out.println();
    }

    static void printAlteredMatriz(int[][] matriz, int currentValue, int newValue, String title) {
    	
    	System.out.println(title+"\n");
    	
        for (int a=0; a< matriz.length; a++) {
            for (int b=0; b<matriz[0].length;b++) {
                int valor = matriz[a][b];
                if (valor == currentValue) {
                    valor = newValue;
                }
                if (b == matriz[0].length - 1) {
                    System.out.println(valor + "|");
                } else {
                    System.out.print("|" + valor + "|");
                }
            }
        }
        System.out.println();
        System.out.println();
    }
    
    static void showAllExamples() {
    	for (int i=1; i<=4; i++) {
			System.out.print("------------------- EXEMPLO "+i+" -------------------\n\n");
			readTextFile("example_"+i+".txt");
		}
    }
}
