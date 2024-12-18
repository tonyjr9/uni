import com.*;
import java.util.Scanner;
public class ED005 {

    public static String calcularExpressao(Scanner sc){
        String[] eq = sc.nextLine().split(" ");
        MyStack<Integer> numbers = new LinkedListStack<>(); 
        for (String c : eq) {

            if (c.equals("+")) {
                if (numbers.size() < 2) return "Expressao Incorrecta";
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a + b);

            } else if (c.equals("-")) {
                if (numbers.size() < 2) return "Expressao Incorrecta";
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a - b);
                
            } else if (c.equals("*")) {
                if (numbers.size() < 2) return "Expressao Incorrecta";
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(a * b);
                
            } else if (c.equals("/")) {
                if (numbers.size() < 2) return "Expressao Incorrecta";
                int b = numbers.pop();
                if (b == 0) return "Expressao Incorrecta"; // Division by zero
                int a = numbers.pop();
                numbers.push(a / b);
                
            } else {
                try {
                    numbers.push(Integer.valueOf(c));
                } catch (NumberFormatException e) {
                    return "Expressao Incorrecta";
                }
            }
            
        }
        if (numbers.size() != 1) return "Expressao Incorrecta";
        return numbers.pop().toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] res = new String[N];

        for (int i = 0; i < N; i++) {
            res[i] = calcularExpressao(sc);
        }
        sc.close();
        for (String str : res) {
            System.out.println(str);
        }
        
    }

}
