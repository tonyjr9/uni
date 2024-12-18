// Implementação da interface IntSet
class ArrayListIntSet implements IntSet {
    private int size;
    private int elem[];

    // Construtor que inicializa o array 'elem' com o tamanho 'n'
    ArrayListIntSet(int n){
        this.size = 0;          // Inicializa o tamanho do conjunto como zero
        this.elem = new int[n];  // Aloca espaço para 'n' elementos no array
    }

    // Verifica se o conjunto contém o número 'x'
    @Override
    public boolean contains(int x) {
        for (int i = 0; i < size; i++) {  // Percorre apenas os elementos válidos
            if (elem[i] == x) {
                return true;
            }
        }
        return false;
    }

    // Adiciona o número 'x' ao conjunto, se ainda não estiver presente
    @Override
    public boolean add(int x) {
        if (this.contains(x)) {
            return false; // Não adiciona se já existir
        }
        if (size >= elem.length) {
            return false; // Não adiciona se o array estiver cheio
        }
        elem[size] = x;  // Adiciona o novo elemento
        size++;          // Incrementa o tamanho do conjunto
        return true;
    }

    // Remove o número 'x' do conjunto
    @Override
    public boolean remove(int x) {
        for (int i = 0; i < size; i++) {
            if (elem[i] == x) {
                // Move todos os elementos após o removido uma posição para trás
                for (int j = i; j < size - 1; j++) {
                    elem[j] = elem[j + 1];
                }
                size--;  // Diminui o tamanho do conjunto
                return true;
            }
        }
        return false; // Retorna false se não encontrar o elemento
    }

    // Retorna o número de elementos no conjunto
    @Override
    public int size() {
        return size;
    }

    // Limpa o conjunto (torna-o vazio)
    @Override
    public void clear() {
        size = 0;  // Simplesmente zera o tamanho
    }

    // Compara se dois conjuntos são iguais
    @Override
    public boolean equals(IntSet s) {
        if (this.size() != s.size()) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (!s.contains(this.elem[i])) {  // Verifica se o elemento atual também está no outro conjunto
                return false;
            }
        }
        return true;
    }

    // Calcula a interseção deste conjunto com outro conjunto
    @Override
    public IntSet intersection(IntSet s) {
        IntSet newSet = new ArrayListIntSet(Math.min(this.size(), s.size())); // Cria um novo conjunto com tamanho suficiente
        for (int i = 0; i < this.size(); i++) {
            if (s.contains(this.elem[i])) {  // Se o elemento estiver em ambos os conjuntos
                newSet.add(this.elem[i]);    // Adiciona à interseção
            }
        }
        return newSet;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0 ; i < this.size(); i++) {
            sb.append(elem[i]);
            if (i != this.size()-1)sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
