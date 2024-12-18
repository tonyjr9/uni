import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    public static int countPizza(ArrayList<ArrayList<Integer>> pizzas, ArrayList<Integer> Ai) {
        int count = 0; // variavel para contar quantas pizzas o Mario pode comer
        for (ArrayList<Integer> pizza : pizzas) {
            count++;
            for (Integer ingrediente : pizza) {
                if (Ai.contains(ingrediente)) { //caso a pizza tenha um ingrediente que o mario nao gosta, retira-se a pizza do count e dá break no ciclo, passando para a proxima pizza
                    count--;
                    break;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in); // Cria o scanner para receber input
        int N = menu.nextInt(); // numero de ingredientes que o mario nao gosta
        ArrayList<Integer> Ai = new ArrayList<Integer>(); // Lista para guardar os identificadores dos ingredientes que o mario nao gosta
        for (int i = 1; i <= N; i++) {
            int j = menu.nextInt();
            Ai.add(j);
        }
        int P = menu.nextInt(); // variavel que guarda o numero de pizzas
        ArrayList<ArrayList<Integer>> Pdisponiveis = new ArrayList<ArrayList<Integer>>(); // Lista que guarda as pizzas disponiveis/menu (com os ingredientes)
        for (int i = 1; i <= P; i++) {
            int Ki = menu.nextInt(); // numero de ingredientes da pizza
            ArrayList<Integer> Bij = new ArrayList<Integer>();
            for (int j = 1; j<= Ki; j++){
                Bij.add(menu.nextInt());
            }
            Pdisponiveis.add(Bij);
        }
        menu.close();
        System.out.println(countPizza(Pdisponiveis, Ai));
    }
}
