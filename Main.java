public class Main {
    

    public static void main(String[] args) {
        Cidade osasco  = new Cidade();

         // Adicionar bairros e pontos de interesse
         osasco.adicionarPonto("City Bussocaba - Parque Municipal");
         osasco.adicionarPonto("City Bussocaba - Escola Municipal");
         osasco.adicionarPonto("Jaguaribe - Hospital Geral");
         osasco.adicionarPonto("Cidade de Deus - Shopping União");
         osasco.adicionarPonto("Cidade de Deus - Estação de Trem");

       // Adicionar conexões (ruas) entre os pontos
       osasco.adicionarConexao("City Bussocaba - Parque Municipal", "City Bussocaba - Escola Municipal", 2.5);
       osasco.adicionarConexao("City Bussocaba - Escola Municipal", "Jaguaribe - Hospital Geral", 3.0);
       osasco.adicionarConexao("Jaguaribe - Hospital Geral", "Cidade de Deus - Shopping União", 4.0);
       osasco.adicionarConexao("Cidade de Deus - Shopping União", "Cidade de Deus - Estação de Trem", 1.2);


        osasco.exibirCidade();


        osasco.adicionarPontoPilha(osasco.buscaLinear("City Bussocaba - Parque Municipal"));
        osasco.adicionarPontoPilha(osasco.buscaLinear("City Bussocaba - Escola Municipal"));

        System.out.println("Pontos na pilha:");
        while (!osasco.pilhaLocais.isEmpty()) {
            System.out.println(osasco.removerPontoPilha().nome);
        }

        osasco.adicionarPontoFila(osasco.buscaLinear("Jaguaribe - Hospital Geral"));
        osasco.adicionarPontoFila(osasco.buscaLinear("Cidade de Deus - Shopping União"));

        System.out.println("Pontos na fila:");
        while (!osasco.filaRotas.isEmpty()) {
            System.out.println(osasco.removerPontoFila().nome);
        }
        Ponto pontoEncontradoLinear = osasco.buscaLinear("City Bussocaba - Parquee Municipal");
        System.out.println("Busca Linear: " + (pontoEncontradoLinear != null ? pontoEncontradoLinear.nome : "Não encontrado"));



    }
}