import java.util.Scanner;

public class Sopa {

    // Função para procurar uma palavra em todas as direções
    public static boolean procurarPalavra(char[][] sopa, boolean[][] marcado, String palavra, int lin, int col) {
        int linhas = sopa.length;
        int colunas = sopa[0].length;
        int tamanho = palavra.length();

        // Verifica se a palavra cabe da esquerda para direita
        if (col + tamanho <= colunas) {
            boolean encontrado = true;
            for (int i = 0; i < tamanho; i++) {
                if (sopa[lin][col + i] != palavra.charAt(i)) {
                    encontrado = false;
                    break;
                }
            }
            if (encontrado) {
                for (int i = 0; i < tamanho; i++) {
                    marcado[lin][col + i] = true;
                }
                return true;
            }
        }

        // Verifica se a palavra cabe da direita para esquerda
        if (col - tamanho + 1 >= 0) {
            boolean encontrado = true;
            for (int i = 0; i < tamanho; i++) {
                if (sopa[lin][col - i] != palavra.charAt(i)) {
                    encontrado = false;
                    break;
                }
            }
            if (encontrado) {
                for (int i = 0; i < tamanho; i++) {
                    marcado[lin][col - i] = true;
                }
                return true;
            }
        }

        // Verifica se a palavra cabe de cima para baixo
        if (lin + tamanho <= linhas) {
            boolean encontrado = true;
            for (int i = 0; i < tamanho; i++) {
                if (sopa[lin + i][col] != palavra.charAt(i)) {
                    encontrado = false;
                    break;
                }
            }
            if (encontrado) {
                for (int i = 0; i < tamanho; i++) {
                    marcado[lin + i][col] = true;
                }
                return true;
            }
        }

        // Verifica se a palavra cabe de baixo para cima
        if (lin - tamanho + 1 >= 0) {
            boolean encontrado = true;
            for (int i = 0; i < tamanho; i++) {
                if (sopa[lin - i][col] != palavra.charAt(i)) {
                    encontrado = false;
                    break;
                }
            }
            if (encontrado) {
                for (int i = 0; i < tamanho; i++) {
                    marcado[lin - i][col] = true;
                }
                return true;
            }
        }

        return false;
    }

    // Função principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caso = 1;

        while (true) {
            // Leitura do número de linhas e colunas
            int linhas = sc.nextInt();
            int colunas = sc.nextInt();
            if (linhas == 0 && colunas == 0) break;

            // Leitura da sopa de letras
            char[][] sopa = new char[linhas][colunas];
            for (int i = 0; i < linhas; i++) {
                sopa[i] = sc.next().toCharArray();
            }

            // Leitura do número de palavras
            int n = sc.nextInt();
            String[] palavras = new String[n];
            for (int i = 0; i < n; i++) {
                palavras[i] = sc.next();
            }

            // Criação da matriz de marcação
            boolean[][] marcado = new boolean[linhas][colunas];

            // Procura cada palavra na sopa de letras
            for (String palavra : palavras) {
                boolean encontrada = false;
                for (int i = 0; i < linhas && !encontrada; i++) {
                    for (int j = 0; j < colunas && !encontrada; j++) {
                        if (sopa[i][j] == palavra.charAt(0)) {
                            encontrada = procurarPalavra(sopa, marcado, palavra, i, j);
                        }
                    }
                }
            }

            // Imprime o output formatado
            System.out.println("Input #" + caso);
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    if (marcado[i][j]) {
                        System.out.print(sopa[i][j]);
                    } else {
                        System.out.print('.');
                    }
                }
                System.out.println();
            }
            caso++;
        }

        sc.close();
    }
}
