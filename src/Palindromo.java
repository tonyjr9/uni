import java.util.Scanner;

public class Palindromo {
    public static boolean isPalindromo(String p){

        StringBuilder strNew = new StringBuilder(); // criar um Stringbuilder para construir uma nova string com apenas as letras em minúsculas
        for (int i = 0; i<p.length(); i++) { //ciclo para adicionar as letras em minúsculo na string nova
            char c = Character.toLowerCase(p.charAt(i));
            if (Character.isLetter(c)) { // condiçao para adicionar o char à nova string
                strNew.append(c);
            }
        }

        int esquerda = 0;
        int direita = strNew.length() -1;
        while (esquerda < direita) { // este ciclo verifica se é ou nao palindromo, compaarando a prieira letra à última, a penúltima à segunda etc...
            if (strNew.charAt(esquerda) != strNew.charAt(direita)) {
                return false;
            }
            esquerda++;
            direita--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); // scanner para receber input
        int N = entrada.nextInt(); // número de palavras
        entrada.nextLine(); // passar a linha onde está N à frente
        System.out.println(N);

        for (int i = 0; i < N; i++) {
            String line = entrada.nextLine();
            if (isPalindromo(line)) {
                System.out.println("sim");
            } else {
                System.out.println("nao");
            }
        }
        entrada.close();// Fecha o scanner
    }
}