public class Main {
    public static void main(String[] args) {
        Cidade osasco = new Cidade();

        // Adicionar bairros e pontos de interesse
        osasco.adicionarPonto("City Bussocaba - Parque Municipal");
        osasco.adicionarPonto("City Bussocaba - Escola Municipal");
        osasco.adicionarPonto("Jaguaribe - Hospital Geral");
        osasco.adicionarPonto("Cidade de Deus - Shopping União");
        osasco.adicionarPonto("Cidade de Deus - Estação de Trem");

        // Ordenar pontos antes de fazer a busca binária
        osasco.ordenarPontos();

        // Adicionar conexões (ruas) entre os pontos
        osasco.adicionarConexao("City Bussocaba - Parque Municipal", "City Bussocaba - Escola Municipal", 2.5);
        osasco.adicionarConexao("City Bussocaba - Escola Municipal", "Jaguaribe - Hospital Geral", 3.0);
        osasco.adicionarConexao("Jaguaribe - Hospital Geral", "Cidade de Deus - Shopping União", 4.0);
        osasco.adicionarConexao("Cidade de Deus - Shopping União", "Cidade de Deus - Estação de Trem", 1.2);

        // Realizar a busca binária
        Ponto pontoEncontrado = osasco.buscaBinaria("City Bussocaba - Escola Municipal");
        System.out.println("Busca Binária: " + (pontoEncontrado != null ? pontoEncontrado.nome : "Não encontrado"));
    }
}
