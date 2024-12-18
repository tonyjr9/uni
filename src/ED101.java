import java.util.*;

public class ED101 {
    public static final char RISCO = '*'; // Caractere utilizado para representar o traço da tartaruga

    public static char[][] criarGrelha(int lin, int col) {
        char[][] matriz = new char[lin][col];
        for (int i = 0; i < lin; i++) {
            Arrays.fill(matriz[i], '.'); // Inicializa todas as posições com '.'
        }
        return matriz;
    }

    public static void move(String line, char[][] matriz, Tartaruga tartaruga) {
        int casas = Integer.parseInt(line.split(" ")[1]);
        int direction = tartaruga.dir;


        for (int c = 0; c < casas; c++) {
            if (tartaruga.riscar) {
                matriz[tartaruga.y][tartaruga.x] = RISCO;
            }

            if (tartaruga.verificarLimite(matriz)) {
                if (direction == 0) tartaruga.x++; // Leste esquerda -> direita
                else if (direction == 1) tartaruga.y++; // Sul cima -> baixo
                else if (direction == 2) tartaruga.x--; // Oeste direita -> esquerda
                else if (direction == 3) tartaruga.y--; // Norte baixo -> cima
                
            } else {
                break;
            }
        }
        if (tartaruga.riscar) {
            matriz[tartaruga.y][tartaruga.x] = RISCO;
        }
    }

    public static void interpretar(String line, Tartaruga tartaruga, char[][] matriz) {
        
        if (line.contains("L")) tartaruga.dir = (tartaruga.dir == 0) ? 3 : tartaruga.dir - 1;
        else if (line.contains("R")) tartaruga.dir = (tartaruga.dir == 3) ? 0 : tartaruga.dir + 1;
        else if (line.contains("D")) {
            tartaruga.riscar = true;
            if (tartaruga.riscar) {
                matriz[tartaruga.y][tartaruga.x] = RISCO;
            }
        }
        else if (line.contains("U")) tartaruga.riscar = false;
    }
    

    public static void Flag2(char[][] matriz, char[][] padrao) {
        int patternHeight = padrao.length;
        int patternWidth = padrao[0].length;

        for (int i = 0; i <= matriz.length - patternHeight; i++) {
            for (int j = 0; j <= matriz[0].length - patternWidth; j++) {
                boolean encontrado = true;

                for (int x = 0; x < patternHeight; x++) {
                    for (int y = 0; y < patternWidth; y++) {
                        if (padrao[x][y] != matriz[i + x][j + y]) {
                            encontrado = false;
                            break;
                        }
                    }
                    if (!encontrado) break;
                }

                if (encontrado) {
                    System.out.println("Sim");
                    return;
                }
            }
        }
        System.out.println("Nao");
    }

    public static void Flag1(char[][] matriz) {
        int marcadas = 0;
        int lin = matriz.length;
        int col = matriz[0].length;
        int linhasVazias = 0;
        int colunasVazias = 0;

        for (int i = 0; i < lin; i++) {
            boolean linhaVazia = true;
            for (int j = 0; j < col; j++) {
                if (matriz[i][j] == RISCO) {
                    marcadas++;
                    linhaVazia = false;
                }
            }
            if (linhaVazia) linhasVazias++;
        }

        for (int j = 0; j < col; j++) {
            boolean colunaVazia = true;
            for (char[] chars : matriz) {
                if (chars[j] == RISCO) {
                    colunaVazia = false;
                    break;
                }
            }
            if (colunaVazia) colunasVazias++;
        }

        int percentagem = (marcadas * 100) / (lin * col);
        System.out.println(percentagem + " " + linhasVazias + " " + colunasVazias);
    }

    public static char[][] executar(Scanner sc) {
        int lin = sc.nextInt();
        int col = sc.nextInt();
        char[][] matriz = criarGrelha(lin, col);
        sc.nextLine();
        Tartaruga tartaruga1 = new Tartaruga();

        while (true) {
            String line = sc.nextLine();
            if (Objects.equals(line, "end")) break;

            if (line.contains("F")) {
                move(line, matriz, tartaruga1);
            } else interpretar(line, tartaruga1, matriz);
        }
        return matriz;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flag = sc.nextInt();
        sc.nextLine();
        char[][] desenho = executar(sc);

        int N = sc.nextInt(), M = sc.nextInt();
        sc.nextLine();

        char[][] padrao = new char[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = sc.nextLine().split(" ");
            for (int j = 0; j < M; j++) {
                padrao[i][j] = (Objects.equals(line[j], "*")) ? '*' : '.';
            }
        }

        
        if (flag == 0) {
            for (char[] chars : desenho) {
                for (int j = 0; j < chars.length; j++) {
                    if (j > 0) System.out.print(" ");
                    System.out.print(chars[j]);
                }
                System.out.println();
            }
        }
        else if (flag == 1) Flag1(desenho);
        else if (flag == 2) Flag2(desenho, padrao);
        
        sc.close();
    }
}

class Tartaruga {
    boolean riscar;
    int x, y, dir;
    /*
     dir: 
     0 - esquerda -> direita
     1 - cima -> baixo
     2 - direita -> esquerda
     3 - baixo -> cima
     */

    Tartaruga() {
        this.riscar = false;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
    }

    public boolean verificarLimite(char[][] matriz) {
        return !((this.dir == 0 && this.x == matriz[0].length - 1) ||
                 (this.dir == 1 && this.y == matriz.length - 1) ||
                 (this.dir == 2 && this.x == 0) ||
                 (this.dir == 3 && this.y == 0));
    }
}
