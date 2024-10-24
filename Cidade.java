import java.util.ArrayList;
import java.util.List;

/**
 * A classe Cidade representa o mapa geral da cidade, contendo os pontos e conexões.
 * Ela permite adicionar novos pontos de interesse e conectar esses pontos com ruas.
 */
public class Cidade {
    // Lista de todos os pontos de interesse na cidade
    List<Ponto> pontos;

    /**
     * Construtor da classe Cidade.
     * Inicializa a cidade com uma lista vazia de pontos de interesse.
     */
    public Cidade() {
        this.pontos = new ArrayList<>();
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
}
