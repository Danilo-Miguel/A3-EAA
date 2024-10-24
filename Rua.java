/**
 * A classe Rua representa uma conexão entre dois pontos na cidade.
 * Cada rua conecta um ponto a outro e possui uma distância associada.
 */
public class Rua {
    // O ponto de destino que esta rua conecta
    Ponto destino;

    // A distância entre o ponto de origem e o ponto de destino
    double distancia;

    /**
     * Construtor da classe Rua.
     * Inicializa a rua com o ponto de destino e a distância entre os pontos.
     * 
     * @param destino O ponto de interesse de destino.
     * @param distancia A distância entre o ponto de origem e o destino.
     */
    public Rua(Ponto destino, double distancia) {
        this.destino = destino;
        this.distancia = distancia;
    }
}
