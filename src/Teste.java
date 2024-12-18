public class Teste {
    public static void main(String[] args) {
        int n = 5;
        for (int i=1; i<n; i++) System.out.print('*');
        System.out.println("");
        int i=1; while (i<n) {System.out.print('*'); i++;};
        System.out.println("");
        do {System.out.print('*'); i++;} while (i<n);
    }
}
