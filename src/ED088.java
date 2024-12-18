import java.util.Scanner;

public class ED088 {

    // Função que conta o número de vizinhos vivos ao redor de uma célula
    public static int contarVizinhos(int[][] matrix, int i, int j) {
        int count = 0;
        for (int l = i - 1; l <= i + 1; l++) {
            for (int c = j - 1; c <= j + 1; c++) {
                // Verifica se está dentro dos limites e se não está contando a célula em si
                if (l >= 0 && l < matrix.length && c >= 0 && c < matrix[0].length && !(l == i && c == j)) {
                    count += matrix[l][c]; // Soma 1 se a célula vizinha estiver viva
                }
            }
        }
        return count;
    }

    // Função que aplica as regras do Jogo da Vida a uma célula
    public static int aplicarRegras(int[][] matrix, int i, int j) {
        int vizinhosVivos = contarVizinhos(matrix, i, j);

        if (matrix[i][j] == 1) { // Célula viva
            if (vizinhosVivos < 2 || vizinhosVivos > 3) {
                return 0; // Morre por solidão ou superpopulação
            } else {
                return 1; // Sobrevive
            }
        } else { // Célula morta
            if (vizinhosVivos == 3) {
                return 1; // Revive por reprodução
            }
        }
        return 0; // Permanece morta
    }

    // Função que resolve o jogo para um número de iterações
    public static void resolverJogo(int iteracoes, int linhas, int colunas, int[][] matrix) {
        int[][] proximaIteracao = new int[linhas][colunas]; // Cria uma matriz para a próxima iteração

        for (int iteracao = 0; iteracao < iteracoes; iteracao++) {
            // Processa cada célula da matriz e atualiza a cópia
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    proximaIteracao[i][j] = aplicarRegras(matrix, i, j); // Aplica as regras do Jogo da Vida
                }
            }
            // Troca as matrizes: o estado atual passa a ser o próximo
            int[][] temp = matrix;
            matrix = proximaIteracao;
            proximaIteracao = temp; // Reutiliza a matriz para a próxima iteração
        }

        // Imprime o resultado final
        imprimirResultado(matrix);
    }

    // Função para imprimir o resultado final
    public static void imprimirResultado(int[][] matrix) {
        for (int[] linha : matrix) {
            for (int n : linha) {
                System.out.print(n == 1 ? 'O' : '.'); // 'O' para células vivas, '.' para mortas
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int linhas = sc.nextInt();
        int colunas = sc.nextInt();
        int iteracoes = sc.nextInt();
        sc.nextLine(); // Consumir a linha extra

        // Leitura da matriz inicial
        int[][] matrix_vida = new int[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            String linha = sc.nextLine();
            for (int j = 0; j < colunas; j++) {
                matrix_vida[i][j] = linha.charAt(j) == 'O' ? 1 : 0;
            }
        }

        resolverJogo(iteracoes, linhas, colunas, matrix_vida); // Resolve o jogo
    }
}
