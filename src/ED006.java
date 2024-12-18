import com.*;
import java.util.Scanner;

public class ED006 {

    // Método para contar o número de palavras em uma linha de entrada
    private static int getWordCount(Scanner sc) {
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] words = line.trim().split("\\s+");
            return words.length;
        }
        return 0;
    }

    // Método para obter nomes e inserir na lista circular
    private static CircularLinkedList<String> getNames(Scanner sc) {
        CircularLinkedList<String> listaPessoas = new CircularLinkedList<>();

        if (sc.hasNextInt()) {
            int numPessoas = sc.nextInt(); // Número de pessoas na lista
             // Consumir a quebra de linha restante

            for (int i = 0; i < numPessoas; i++) {
                if (sc.hasNext()) {
                    listaPessoas.addLast(sc.next());
                }
            }
        }
        return !listaPessoas.isEmpty() ? listaPessoas : null;
    }

    // Método para determinar o "perdedor" com base no número de palavras
    private static String getLoser(int wordCount, CircularLinkedList<String> listaPessoas) {
        if (listaPessoas.size() == 1) return "Carlos";
        int index;
        while (listaPessoas.size() > 1) {

            if (wordCount >= listaPessoas.size()) {
                index = wordCount % listaPessoas.size(); // Calcular posição de eliminação
                for (int j = 0; j < index; j++) {
                    listaPessoas.rotate(); // Rotacionar até o índice calculado
                }
                listaPessoas.removeLast();

            } else {
                index = wordCount;
                for (int j = 0; j < index; j++) {
                    listaPessoas.rotate(); // Rotacionar até o índice calculado
                }
                listaPessoas.removeLast();

            }
        }

        return listaPessoas.getFirst(); // Retornar o único restante
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numRodadas = sc.nextInt(); // Número de rodadas no jogo
        sc.nextLine(); // Consumir a quebra de linha restante
        String[] estadoJogo = new String[numRodadas];

        for (int i = 0; i < numRodadas; i++) {
            int wordCount = getWordCount(sc);
            CircularLinkedList<String> listaPessoas = getNames(sc);
            String perdedor = getLoser(wordCount, listaPessoas);
            estadoJogo[i] = perdedor;
            sc.nextLine();
        }

        sc.close();

        for (String nome : estadoJogo) {
            if (!nome.equals("Carlos")) {
                System.out.println("O Carlos livrou-se (coitado do " + nome + "!)");
            } else {
                System.out.println("O Carlos nao se livrou");
            }
        }
    }
}
