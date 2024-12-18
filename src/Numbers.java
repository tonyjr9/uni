// Uma classe muito simples que usa um ciclo para imprimir numeros entre 1 e n

// O ficheiro tem de ter o mesmo nome da classe + a extensão '.java'
public class Numbers {
    static void csoma(int n){
        int soma = 0;
        System.out.println("Numeros de 1 a " + n + ":"); // + é o operador de concatenação de strings
        for (int i=1; i<=n; i++){
            System.out.println(i);
            soma += i;
        }
        System.out.println("soma = " + soma);
    }
    public static void main(String[] args) {
        csoma(500);
    }
}
