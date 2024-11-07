import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * A classe Cidade representa o mapa geral da cidade, contendo os pontos e conexões.
 * Ela permite adicionar novos pontos de interesse e conectar esses pontos com ruas.
 */
public class Cidade {

    ArvoreBinaria arvoreBusca = new ArvoreBinaria();

    // Método para adicionar um ponto à árvore binária
public void adicionarPontoArvore(Ponto ponto) {
    arvoreBusca.adicionar(ponto);
}

// Método para buscar um ponto na árvore binária
public Ponto buscarPontoArvore(String nome) {
    return arvoreBusca.buscar(nome);
}

    // Lista de todos os pontos de interesse na cidade
    List<Ponto> pontos;

    // Pilha para armazenar locais temporários
    Stack<Ponto> pilhaLocais;

    // Fila para processar rotas em ordem
    Queue<Ponto> filaRotas;

    /**
     * Construtor da classe Cidade.
     * Inicializa a cidade com uma lista vazia de pontos de interesse.
     */
    public Cidade() {
        this.pontos = new ArrayList<>();
        this.pilhaLocais = new Stack<>();
        this.filaRotas =   new LinkedList<>();
    }

    /**
     * Adiciona um novo ponto de interesse à cidade.
     * 
     * @param nome O nome do novo ponto de interesse.
     */
    public void adicionarPonto(String nome) {
        Ponto novoPonto = new Ponto(nome);
        pontos.add(novoPonto);
    }

    /**
     * Adiciona uma conexão (rua) entre dois pontos existentes.
     * 
     * @param nomeOrigem Nome do ponto de origem.
     * @param nomeDestino Nome do ponto de destino.
     * @param distancia A distância entre os dois pontos.
     */
    public void adicionarConexao(String nomeOrigem, String nomeDestino, double distancia) {
        Ponto origem = encontrarPonto(nomeOrigem);
        Ponto destino = encontrarPonto(nomeDestino);

        if (origem != null && destino != null) {
            origem.adicionarConexao(destino, distancia);
        }
    }

    /**
     * Encontra um ponto de interesse na cidade pelo nome.
     * 
     * @param nome O nome do ponto de interesse.
     * @return O ponto de interesse encontrado, ou null se não encontrado.
     */
    private Ponto encontrarPonto(String nome) {
        for (Ponto ponto : pontos) {
            if (ponto.nome.equals(nome)) {
                return ponto;
            }
        }
        return null;
    }

    public void exibirCidade() {
        for (Ponto ponto : pontos) {
            System.out.println("Ponto: " + ponto.nome);
            for (Rua rua : ponto.conexoes) {
                System.out.println("  Conectado a: " + rua.destino.nome + " (Distância: " + rua.distancia + ")");
            }
        }
    }
 /**
     * Adiciona um ponto à pilha de locais temporários.
     * 
     * @param ponto O ponto a ser adicionado à pilha.
     */
    public void adicionarPontoPilha(Ponto ponto){
        pilhaLocais.push(ponto);
    }

     /**
     * Remove e retorna o último ponto adicionado à pilha de locais temporários.
     * 
     * @return O ponto removido da pilha, ou null se a pilha estiver vazia.
     */
public Ponto removerPontoPilha(){
    return pilhaLocais.isEmpty() ? null : pilhaLocais.pop();

}
 /**
     * Adiciona um ponto à fila de rotas.
     * 
     * @param ponto O ponto a ser adicionado à fila.
     */
    public void adicionarPontoFila(Ponto ponto) {
        filaRotas.offer(ponto);
    }
      /**
     * Remove e retorna o primeiro ponto da fila de rotas.
     * 
     * @return O ponto removido da fila, ou null se a fila estiver vazia.
     */
    public Ponto removerPontoFila() {
        return filaRotas.poll();
    }

    public Ponto buscaLinear(String nome) {
        for (Ponto ponto : pontos) {
            if (ponto.nome.equals(nome)) {
                return ponto;
            }
        }
        return null;
    }


}
