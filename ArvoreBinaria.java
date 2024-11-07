
public class ArvoreBinaria {

    private No raiz;

    private class No {
        Ponto ponto;
        No esquerda, direita;

        public No(Ponto ponto) {
            this.ponto = ponto;
            esquerda = direita = null;
        }
    }
    // Representa um nó na árvore binária de busca
    // Método para adicionar um ponto à árvore
    public void adicionar(Ponto ponto) {
        raiz = adicionarRecursivo(raiz, ponto);
    }

        // Método recursivo para adicionar um ponto na árvore
        private No adicionarRecursivo(No raiz, Ponto ponto) {
            if(raiz == null){
                raiz = new No(ponto);
                return raiz;
            }

        if (ponto.nome.compareTo(raiz.ponto.nome) < 0) {
            raiz.esquerda = adicionarRecursivo(raiz.esquerda,ponto);
        } else if (ponto.nome.compareTo(raiz.ponto.nome) > 0) {
            raiz.direita = adicionarRecursivo(raiz.direita, ponto);
        }
        return raiz;



        }
        public Ponto buscar(String nome) {
            return buscarRecursivo(raiz, nome);
        }
  // Método recursivo para buscar um ponto na árvore
  private Ponto buscarRecursivo(No raiz, String nome) {
    if (raiz == null || raiz.ponto.nome.equals(nome)) {
        return raiz != null ? raiz.ponto : null;
    }

    if (nome.compareTo(raiz.ponto.nome) < 0) {
        return buscarRecursivo(raiz.esquerda, nome);
    }

    return buscarRecursivo(raiz.direita, nome);
}

}
