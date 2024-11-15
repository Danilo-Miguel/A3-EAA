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
        this.filaRotas = new LinkedList<>();
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
     * Ordena a lista de pontos por nome para realizar a busca binária.
     */
    public void ordenarPontos() {
        pontos.sort((p1, p2) -> p1.nome.compareTo(p2.nome));
    }

    /**
     * Realiza uma busca binária na lista de pontos da cidade.
     * 
     * @param nome O nome do ponto de interesse a ser buscado.
     * @return O ponto de interesse encontrado, ou null se não encontrado.
     */
    public Ponto buscaBinaria(String nome) {
        int esquerda = 0;
        int direita = pontos.size() - 1;

        while (esquerda <= direita) {
            int meio = (esquerda + direita) / 2;
            Ponto pontoMeio = pontos.get(meio);

            int comparacao = pontoMeio.nome.compareTo(nome);

            if (comparacao == 0) {
                return pontoMeio; // Nome encontrado
            } else if (comparacao < 0) {
                esquerda = meio + 1; // Procurar na metade direita
            } else {
                direita = meio - 1; // Procurar na metade esquerda
            }
        }
        return null; // Nome não encontrado
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

    /**
     * Exibe os pontos e conexões da cidade.
     */
    public void exibirCidade() {
        for (Ponto ponto : pontos) {
            System.out.println("Ponto: " + ponto.nome);
            for (Rua rua : ponto.conexoes) {
                System.out.println("  Conectado a: " + rua.destino.nome + " (Distância: " + rua.distancia + ")");
            }
        }
    }
}
