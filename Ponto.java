import java.util.ArrayList;
import java.util.List;

/**
 * A classe Ponto representa um local de interesse na cidade.
 * Cada ponto possui um nome e uma lista de conexões (ruas) para outros pontos.
 */
public class Ponto {
    // Nome do ponto de interesse (ex: Parque, Escola, Hospital)
    String nome;

    // Lista de conexões (ruas) que ligam este ponto a outros pontos
    List<Rua> conexoes;

    /**
     * Construtor da classe Ponto.
     * Inicializa o ponto com um nome e uma lista vazia de conexões.
     * 
     * @param nome Nome do ponto de interesse.
     */
    public Ponto(String nome) {
        this.nome = nome;
        this.conexoes = new ArrayList<>();
    }

    /**
     * Adiciona uma nova conexão (rua) deste ponto para outro ponto.
     * 
     * @param destino Ponto de destino.
     * @param distancia Distância até o ponto de destino.
     */
    public void adicionarConexao(Ponto destino, double distancia) {
        this.conexoes.add(new Rua(destino, distancia));
    }
}
