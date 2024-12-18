import java.util.Collections;
import java.util.ArrayList;

public class BigNumber {
    private ArrayList<Integer> digits;  // Armazena os dígitos do número

    // Construtor que inicializa o BigNumber a partir de uma String
    BigNumber(String n){
        this.digits = new ArrayList<>();
        // Para cada caractere na String, converte-o para um dígito inteiro e o armazena na lista
        for (char c : n.toCharArray()) {
            digits.add(c - '0');  // Converte o caractere numérico para o valor inteiro correspondente
        }
    }

    // Método que verifica se dois BigNumbers são iguais comparando suas listas de dígitos
    public boolean equals(BigNumber n){
        return this.digits.equals(n.digits);
    }

    // Método que converte um BigNumber para uma String
    public String toString(){
        StringBuilder sb = new StringBuilder();
        // Constrói a String com os dígitos armazenados
        for (int digit : this.digits){
            sb.append(digit);
        }
        return sb.toString();  // Retorna a representação do número como String
    }

    // Método que realiza a adição de dois BigNumbers
    public BigNumber add(BigNumber n){
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>(this.digits);
        ArrayList<Integer> b = new ArrayList<>(n.digits);

        // Inverte as listas para facilitar a soma começando do dígito menos significativo
        Collections.reverse(a);
        Collections.reverse(b);

        int carry = 0;  // Variável para armazenar o valor de "vai um"
        int maxSize = Math.max(a.size(), b.size());  // Tamanho máximo entre os dois números

        // Soma os dígitos, considerando o "vai um" (carry)
        for (int i = 0; i < maxSize; i++) {
            int digitA = (i < a.size()) ? a.get(i) : 0;  // Se não houver mais dígitos em a, considera como 0
            int digitB = (i < b.size()) ? b.get(i) : 0;  // Se não houver mais dígitos em b, considera como 0
            int sum = digitA + digitB + carry;  // Soma os dois dígitos e o carry
            result.add(sum % 10);  // Armazena o dígito (parte da soma) correspondente à unidade
            carry = sum / 10;  // Atualiza o carry (parte da soma que "vai para a próxima casa")
        }

        // Se ainda sobrar um carry no final, adiciona-o como um novo dígito
        if (carry > 0) {
            result.add(carry);
        }

        // Inverte a lista de resultado para voltar à ordem correta
        Collections.reverse(result);

        // Converte o resultado de volta para um BigNumber e retorna
        StringBuilder sb = new StringBuilder();
        for (int digit : result) {
            sb.append(digit);  // Constrói a String final a partir dos dígitos
        }

        return new BigNumber(sb.toString());  // Retorna o novo BigNumber resultante da soma
    }

    // Método que realiza a multiplicação de dois BigNumbers
    public BigNumber multiply(BigNumber n) {
        // O resultado precisa ter espaço para o somatório de todas as multiplicações, que pode ter até a soma dos tamanhos dos dois números
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(this.digits.size() + n.digits.size(), 0));

        // Multiplica cada dígito deste número pelo outro número
        for (int i = this.digits.size() - 1; i >= 0; i--) {
            for (int j = n.digits.size() - 1; j >= 0; j--) {
                // Multiplica os dígitos individuais
                int product = this.digits.get(i) * n.digits.get(j);

                // Determina a posição onde o resultado dessa multiplicação será armazenado
                int pos1 = i + j;     // Posição mais significativa no array de resultado
                int pos2 = i + j + 1; // Posição menos significativa no array de resultado

                // Adiciona o produto à posição correspondente no array e lida com o carry
                int sum = product + result.get(pos2);  // Soma o produto à posição menos significativa atual
                result.set(pos2, sum % 10);  // Armazena o dígito da unidade do somatório
                result.set(pos1, result.get(pos1) + sum / 10);  // Armazena o carry (dígito da dezena) na posição mais significativa
            }
        }

        // Converte o array de resultado para uma String, ignorando zeros à esquerda
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;  // Variável para pular os zeros à esquerda
        for (int digit : result) {
            if (digit == 0 && leadingZero) {
                continue;  // Ignora zeros à esquerda
            }
            leadingZero = false;
            sb.append(digit);  // Adiciona o dígito ao StringBuilder
        }

        // Se o resultado for todo zero (como multiplicar por zero), retorna "0"
        if (sb.length() == 0) {
            return new BigNumber("0");
        }

        return new BigNumber(sb.toString());  // Retorna o BigNumber resultante da multiplicação
    }
}
