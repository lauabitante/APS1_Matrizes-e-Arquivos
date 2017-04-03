import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Application {
	
	public static int[][] matrizOriginal;
	public static int[][] matrizAltered1;
	public static int[][] matrizAltered2;
	
	public static void main(String[] args) {
		showAllExamples();
	}
	
	public static void readTextFile(String fileName) {
		matrizOriginal = createMatriz(fileName);
		printMatriz(matrizOriginal, "Matriz Original");
		
		matrizAltered1 = alterMatriz(createMatriz(fileName), 1, 2);
		printMatriz(matrizAltered1, "Altera 1 pra 2");
		
		matrizAltered2 = alterMatriz(createMatriz(fileName), 0, 2);
		printMatriz(matrizAltered2, "Altera 0 pra 2");
	}
	
	static int[][] createMatriz(String fileName) {
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
		      for (int j=0; j<rows; j++) {
		    	  char[] currentLine = readFile.readLine().toCharArray();
		    	  for (int i=0; i<columns; i++) {
		    		  matriz[j][i] = Integer.parseInt(String.valueOf(currentLine[i]));
		    	  }
		      }
		      file.close();
		      return matriz;     
		} catch (IOException e) {
			System.err.print("Erro ao ler o arquivo: "+e.getMessage()+".\n");
			return new int[0][0];
		}
	}
	
	static void printMatriz(int[][] matriz, String title) {
		
		System.out.println(title+"\n");
        for (int a=0; a<matriz.length; a++) {
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

    static int[][] alterMatriz(int[][] matriz, int currentValue, int newValue) {
     	
        for (int a=0; a<matriz.length; a++) {
            for (int b=0; b<matriz[0].length;b++) {
                int valor = matriz[a][b];
                if (valor == currentValue) {
                    valor = newValue;
                }
                matriz[a][b] = valor;
            }
        }
        return matriz;
    }
    
    static void showAllExamples() {
    	for (int i=1; i<=4; i++) {
			System.out.print("------------------- EXEMPLO "+i+" -------------------\n\n");
			readTextFile("example_"+i+".txt");
		}
    }
}
