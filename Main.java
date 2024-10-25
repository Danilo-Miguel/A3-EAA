public class Main {
    

    public static void main(String[] args) {
        Cidade osasco  = new Cidade();

        osasco.adicionarPonto("City Bussocaba - Parque Municipal");
        osasco.adicionarPonto("City Bussocaba - Escola Municipal");


        osasco.adicionarConexao("City Bussocaba - Parque Municipal", "City Bussocaba - Escola Municipal", 2.5);


        osasco.exibirCidade();
    }
}
