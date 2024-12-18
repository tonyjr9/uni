import java.util.Scanner;

public class ED004 {
    // Constantes para os jogadores e para a casa vazia
    private static final char JOGADOR_X = 'X';
    private static final char JOGADOR_O = 'O';
    private static final char CASA_VAZIA = '.';

    // Método auxiliar para verificar se houve vitória
    public boolean verificaVitoria(int contadorX, int contadorO, int n) {
        return contadorX == n || contadorO == n;
    }

    // Método que verifica o estado do jogo da velha
    public String jogo_do_galo(int n, char[][] tabuleiro) {
        boolean gameover = true; // Variável que indica se o jogo terminou
        int diagonalX = 0, diagonalO = 0; // Contadores para a diagonal principal
        int revDiagonalX = 0, revDiagonalO = 0; // Contadores para a diagonal inversa

        // Iteração sobre as linhas e colunas do tabuleiro
        for (int i = 0; i < n; i++) {
            int horizontalX = 0, verticalX = 0; // Contadores para 'X' na linha e coluna
            int horizontalO = 0, verticalO = 0; // Contadores para 'O' na linha e coluna

            for (int j = 0; j < tabuleiro[i].length; j++) {
                // Verificação horizontal
                if (tabuleiro[i][j] == JOGADOR_X) {
                    horizontalX++;
                } else if (tabuleiro[i][j] == JOGADOR_O) {
                    horizontalO++;
                } else if (tabuleiro[i][j] == CASA_VAZIA) {
                    gameover = false; // O jogo ainda não terminou
                }

                // Verificação vertical
                if (tabuleiro[j][i] == JOGADOR_X) {
                    verticalX++;
                } else if (tabuleiro[j][i] == JOGADOR_O) {
                    verticalO++;
                } else if (tabuleiro[j][i] == CASA_VAZIA) {
                    gameover = false; // O jogo ainda não terminou
                }
            }

            // Verificação diagonal principal
            if (tabuleiro[i][i] == JOGADOR_X) {
                diagonalX++;
            } else if (tabuleiro[i][i] == JOGADOR_O) {
                diagonalO++;
            } else if (tabuleiro[i][i] == CASA_VAZIA) {
                gameover = false; // O jogo ainda não terminou
            }

            // Verificação diagonal inversa
            if (tabuleiro[i][n - i - 1] == JOGADOR_X) {
                revDiagonalX++;
            } else if (tabuleiro[i][n - i - 1] == JOGADOR_O) {
                revDiagonalO++;
            } else if (tabuleiro[i][n - i - 1] == CASA_VAZIA) {
                gameover = false; // O jogo ainda não terminou
            }

            // Verificar vitória nas linhas ou colunas
            if (verificaVitoria(horizontalX, horizontalO, n)) {
                return horizontalX == n ? "Ganhou o X" : "Ganhou o O";
            }

            if (verificaVitoria(verticalX, verticalO, n)) {
                return verticalX == n ? "Ganhou o X" : "Ganhou o O";
            }
        }

        // Verificar vitória nas diagonais
        if (verificaVitoria(diagonalX, diagonalO, n)) {
            return diagonalX == n ? "Ganhou o X" : "Ganhou o O";
        }

        if (verificaVitoria(revDiagonalX, revDiagonalO, n)) {
            return revDiagonalX == n ? "Ganhou o X" : "Ganhou o O";
        }

        // Se o jogo terminou e não houve vencedor, é empate
        return gameover ? "Empate" : "Jogo incompleto";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();// Lê o tamanho do tabuleiro
        if (N == 1) {
            System.out.println("Jogo incompleto");
            return;
        }
        sc.nextLine(); // Lê a linha em branco
        char[][] tabuleiro = new char[N][N]; // Cria o tabuleiro de tamanho N

        // Preenche o tabuleiro
        for (int i = 0; i < N; i++) {
            String linha = sc.nextLine(); // Lê a linha de entrada
            for (int j = 0; j < N; j++) {
                tabuleiro[i][j] = linha.charAt(j); // Preenche cada posição do tabuleiro
            }
        }
        sc.close();

        // Executa o jogo e exibe o resultado
        System.out.println(new ED004().jogo_do_galo(N, tabuleiro));
    }
}
