public class Square {
    // Desenha uma linha de n caracteres onde:
    // - o primeiro e o último caracteres são o caracter da variável 'a'
    // - todos os outros caracteres são o caracter da variável 'b'
    static void line(char a, char b, int n) {
        System.out.print(a);
        for (int i=1; i<=n-2; i++)
            System.out.print(b);
        System.out.println(a);
    }
    static void square1(int n) {
        line('+', '-', 5);
        for (int i=1; i<=n-2; i++) {
            line('|', '.', 5);
            }
        line('+', '-', 5);
        }
    public static void main(String[] args) {
        square1(6);
    }
    }
