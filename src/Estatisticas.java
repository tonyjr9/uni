import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estatisticas {
    public static float media(List<Integer> numbers) {
        float m = 0;
        for (Integer number : numbers) {
            m += number;
            }
        m = m / numbers.size();
        return m;
        }
    public static int amplitude(List<Integer> numbers ){
        int lower = numbers.get(0);
        int upper = numbers.get(0);
        for (Integer number : numbers) {
            if (number > upper) {
                upper = number;
            }
            if (number < lower) {
                lower = number;
            }

        }
        return upper - lower;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            numbers.add(n);
        }
        sc.close();
        System.out.printf("%.2f", media(numbers));
        System.out.println("");
        System.out.println(amplitude(numbers));
        }
}

