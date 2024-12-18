import java.util.Scanner;

public class ED015 {

    // Vetores que representam as direções: (linha, coluna)
    // Direções: esquerda para direita, direita para esquerda, de cima para baixo, de baixo para cima
    private static final int[] DIRECAO_LINHA = { 0, 0, 1, -1 };  // Movimentos nas linhas
    private static final int[] DIRECAO_COLUNA = { 1, -1, 0, 0 }; // Movimentos nas colunas

    // Função que procura uma palavra em uma direção específica
    public static boolean procurarPalavra(char[][] sopa, boolean[][] sopa_boolean, String palavra, int lin, int col, int dir) {
        int linhas = sopa.length;
        int colunas = sopa[0].length;
        int tamanho = palavra.length();
        int deslocaLinha = DIRECAO_LINHA[dir];   // Direção de movimentação na linha
        int deslocaColuna = DIRECAO_COLUNA[dir]; // Direção de movimentação na coluna

        // Verifica se a palavra cabe na direção dada
        for (int i = 0; i < tamanho; i++) {
            int novaLinha = lin + i * deslocaLinha;   // Nova posição de linha
            int novaColuna = col + i * deslocaColuna; // Nova posição de coluna

            // Se a nova posição estiver fora dos limites ou a letra não corresponder, retorna falso
            if (novaLinha < 0 || novaLinha >= linhas || novaColuna < 0 || novaColuna >= colunas
                    || sopa[novaLinha][novaColuna] != palavra.charAt(i)) {
                return false;
            }
        }

        // Marca as letras da palavra encontrada na matriz de booleanos
        for (int i = 0; i < tamanho; i++) {
            int novaLinha = lin + i * deslocaLinha;
            int novaColuna = col + i * deslocaColuna;
            sopa_boolean[novaLinha][novaColuna] = true; // Marca a letra encontrada
        }
        return true;
    }

    // Função que procura uma palavra em todas as direções possíveis
    public static boolean procurarPalavraTodasDirecoes(char[][] sopa, boolean[][] sopa_boolean, String palavra, int lin, int col) {
        // Tenta encontrar a palavra nas quatro direções
        for (int dir = 0; dir < 4; dir++) {
            if (procurarPalavra(sopa, sopa_boolean, palavra, lin, col, dir)) {
                return true; // Se a palavra for encontrada em alguma direção, retorna true
            }
        }
        return false; // Se não encontrar em nenhuma direção, retorna false
    }

    // Função que processa cada caso de teste
    public static void processarCaso(int caso, Scanner sc, int linhas, int colunas) {
        // Lê a sopa de letras (matriz de caracteres)
        char[][] sopa = new char[linhas][colunas];
        for (int i = 0; i < linhas; i++) {
            String l = sc.nextLine();  // Lê a linha da sopa
            for (int j = 0; j < colunas; j++) {
                sopa[i][j] = l.charAt(j);  // Preenche a matriz com as letras da sopa
            }
        }

        // Lê o número de palavras a procurar
        int n = sc.nextInt();
        sc.nextLine();  // Consome a linha pendente
        String[] palavras = new String[n];  // Vetor para armazenar as palavras
        for (int i = 0; i < n; i++) {
            palavras[i] = sc.nextLine();  // Lê cada palavra
        }

        // Cria uma matriz de booleanos para marcar as letras encontradas
        boolean[][] sopa_boolean = new boolean[linhas][colunas];

        // Para cada palavra, tenta encontrar na sopa de letras
        for (String palavra : palavras) {
            for (int i = 0; i < linhas; i++) {
                for (int j = 0; j < colunas; j++) {
                    // Se a primeira letra corresponder, tenta procurar nas direções
                    if (sopa[i][j] == palavra.charAt(0)) {
                        procurarPalavraTodasDirecoes(sopa, sopa_boolean, palavra, i, j);
                    }
                }
            }
        }

        // Imprime o resultado para o caso atual
        System.out.println("Input #" + caso);
        imprimirSopa(sopa, sopa_boolean);  // Chama a função que imprime a sopa formatada
    }

    // Função para imprimir a sopa de letras com as palavras marcadas
    public static void imprimirSopa(char[][] sopa, boolean[][] sopa_boolean) {
        int linhas = sopa.length;
        int colunas = sopa[0].length;

        // Itera sobre a matriz de sopa e imprime as letras encontradas ou pontos
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (sopa_boolean[i][j]) {
                    System.out.print(sopa[i][j]); // Imprime a letra da palavra encontrada
                } else {
                    System.out.print('.'); // Substitui letras não encontradas por pontos
                }
            }
            System.out.println(); // Pula para a próxima linha
        }
    }

    // Função principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int caso = 1;

        // Leitura contínua de casos até encontrar a condição de parada
        while (sc.hasNext()) {
            int linhas = sc.nextInt();  // Lê o número de linhas
            int colunas = sc.nextInt(); // Lê o número de colunas
            if (colunas == 0 && linhas == 0) break; // Condição de parada (caso especial 0 0)

            sc.nextLine();  // Consome a linha pendente
            processarCaso(caso, sc, linhas, colunas);  // Processa o caso atual
            caso++; // Incrementa o número do caso
        }
        sc.close();  // Fecha o Scanner
    }
}
