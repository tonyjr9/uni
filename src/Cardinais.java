import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cardinais {

    /*
     * Método que conta o número de sequências contínuas de 1s (cardinais)
     * e retorna o maior comprimento e a quantidade de ocorrências.
     * param m Objeto do tipo Matrix que contém os dados.
     * return Lista contendo [comprimento, contagem].
     */
    public static List<Integer> contarCardinais(Matrix m) {
        int rows = m.rows, cols = m.cols;
        int count = 0;  // Contagem de linhas de cardinais de tamanho maximo
        int length = 0; // Maior comprimento de cardinais seguidos
        int charcount = 0; // Contagem de caracteres contínuos

        // Contagem ao longo das linhas
        for (int i = 0; i < rows; i++) {
            charcount = 0;
            for (int j = 0; j < cols; j++) {
                if (m.data[i][j] == 1) { // Se encontrar 1, incrementa a contagem de cardinais seguidos
                    charcount++;
                    if (charcount > length) {
                        length = charcount; // Atualiza a contagem para o novo comprimento máximo
                        count = 1; // count = 1 porque temos um novo comprimento maximo
                    } else if (charcount == length) {
                        count++; // Se o comprimento atual for igual ao máximo, incrementa a contagem
                    }
                } else { // Reinicia a contagem se encontrar 0
                    charcount = 0;
                }
            }
        }

        // Contagem ao longo das colunas
        for (int i = 0; i < cols; i++) {
            charcount = 0;
            for (int j = 0; j < rows; j++) {
                if (m.data[j][i] == 1) { // Mesma lógica para contagem nas colunas
                    charcount++;
                    if (charcount > length) {
                        length = charcount;
                        count = 1;
                    } else if (charcount == length) {
                        count++;
                    }
                } else {
                    charcount = 0;
                }
            }
        }

        // Criação de lista para armazenar o comprimento máximo e a contagem
        List<Integer> values = new ArrayList<>();
        values.add(length);
        values.add(count);
        return values;
    }

    /*
     * Método principal para ler entrada do usuário, criar a matriz e
     * exibir o resultado da contagem de cardinais.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leitura do número de linhas e colunas da matriz
        int r = sc.nextInt();
        int c = sc.nextInt();
        Matrix m = new Matrix(r, c); // Criação da matriz

        sc.nextLine(); // Consumir a quebra de linha após o nextInt()

        // Leitura da matriz linha por linha
        for (int i = 0; i < r; i++) {
            String line = sc.nextLine().trim(); // Remove espaços em branco

            // Conversão de cada caractere da linha em 0 ou 1
            for (int j = 0; j < c; j++) {
                if (line.charAt(j) == '#') {
                    m.data[i][j] = 1; // Se for '#', marca como 1
                } else {
                    m.data[i][j] = 0; // Caso contrário, marca como 0
                }
            }
        }

        // Chamada para contar os cardinais e exibir o resultado
        List<Integer> result = contarCardinais(m);
        System.out.println(result.get(0) + " " + result.get(1));

        sc.close(); // Fechar o scanner
    }
}
