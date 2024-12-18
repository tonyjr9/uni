class BooleanArrayIntSet implements IntSet {
    private boolean[] isElem;
    private int size;
    private int n;
    private int max_index;

    // Construtor que inicializa o array com 'n+1' posições (inclui índice 'n')
    BooleanArrayIntSet(int n) {
        this.isElem = new boolean[n + 1];  // Inclui índice 0, mas não será usado
        this.n = n;
        this.size = 0;
        this.max_index = 0;  // Inicializa como 0, pois ainda não foi adicionado nenhum número
    }

    // Retorna a representação em string do conjunto
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 1; i <= n; i++) {  // Começa em 1, já que '0' não é parte do conjunto
            sb.append(isElem[i] ? "T" : "F");
        }
        sb.append("}");
        return sb.toString();
    }

    // Verifica se o conjunto contém o número 'x'
    @Override
    public boolean contains(int x) {
        if (x < 1 || x > this.n) return false;  // Verifica limites (x deve estar entre 1 e n)
        return this.isElem[x];
    }

    // Adiciona o número 'x' ao conjunto
    @Override
    public boolean add(int x) {
        if (x < 1 || x > this.n || this.isElem[x]) return false;  // Verifica limites e duplicatas

        this.isElem[x] = true;
        this.size++;
        if (x > this.max_index) {
            this.max_index = x;  // Atualiza o índice máximo
        }
        return true;
    }

    // Remove o número 'x' do conjunto
    @Override
    public boolean remove(int x) {
        if (x < 1 || x > this.n || !this.isElem[x]) return false;  // Verifica limites e se o elemento existe

        this.isElem[x] = false;
        this.size--;

        // Se 'x' era o maior índice, encontra o novo maior índice
        if (x == this.max_index) {
            int tmp = 0;
            for (int i = 1; i <= this.max_index; i++) {
                if (isElem[i]) {
                    tmp = i;
                }
            }
            this.max_index = tmp;  // Atualiza o novo 'max_index'
        }
        return true;
    }

    // Retorna o número de elementos no conjunto
    @Override
    public int size() {
        return size;
    }

    // Limpa o conjunto
    @Override
    public void clear() {
        for (int i = 1; i <= this.n; i++) {
            this.isElem[i] = false;
        }
        this.size = 0;
        this.max_index = 0;  // Conjunto agora está vazio
    }

    // Verifica se dois conjuntos são iguais
    @Override
    public boolean equals(IntSet s) {
        if (!(s instanceof BooleanArrayIntSet)) return false;  // Verifica o tipo
        BooleanArrayIntSet otherSet = (BooleanArrayIntSet) s;

        if (this.size() != otherSet.size()) return false;  // Verifica tamanhos
        for (int i = 1; i <= this.max_index; i++) {
            if (this.isElem[i] != otherSet.isElem[i]) return false;  // Compara os elementos
        }
        return true;
    }

    // Retorna a interseção entre dois conjuntos
    @Override
    public IntSet intersection(IntSet s) {
        if (!(s instanceof BooleanArrayIntSet)) return null;  // Verifica o tipo
        BooleanArrayIntSet otherSet = (BooleanArrayIntSet) s;

        BooleanArrayIntSet intersectionSet = new BooleanArrayIntSet(this.n);
        for (int i = 1; i <= this.n; i++) {
            if (this.isElem[i] && otherSet.isElem[i]) {  // Adiciona apenas os elementos que estão em ambos
                intersectionSet.add(i);
            }
        }
        return intersectionSet;
    }
}
