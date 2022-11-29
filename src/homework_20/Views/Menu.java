package homework_20.Views;


import homework_20.Services.Read;

public class Menu {

    public static void menu() {

        while (0 == 0) {
           
            System.out.println("\n   ------ MyStore ------ ");
            System.out.println("\n----------Menu Inicial----------\n");
            System.out.println("[1] Cadastros de Produtos");
            System.out.println("[2] Consultas");
            System.out.println("[0] Sair");
            System.out.print("\nDigite a opção: ");
            String option =  Read.texto();

            switch (option) {
                case "1" -> {
                    ProdutosView.cadastra();
                    subMenuCadastro();
                }
                case "2" -> {
                    ProdutosView.consulta();
                }
                case "0" -> {
                    System.out.println("\nSistema finalizado!!!");
                    System.exit(0);
                }
                default -> {
                    System.out.println("\nOps!!! Você digitou uma opção invalida.\nTente Novamente.");
                    menu();
                }
            }
        }

    }

    public static void subMenuCadastro() {

        while (0 == 0) {
           
            System.out.println("\n-----------Sub Menu Cadastros-----------\n");
            System.out.println("[1] Novo Cadastro");
            System.out.println("[2] Voltar");
            System.out.println("[0] Sair");
            System.out.print("\nDigite a opção: ");
            String option =  Read.texto();

            switch (option) {
                case "1" ->
                    ProdutosView.cadastra();

                case "2" ->
                   menu();

                case "0" -> {
                    System.out.println("\nSistema finalizado!!!");
                    System.exit(0);
                }
                default -> {
                    System.err.println("\nOps!!! Você digitou uma opção invalida.\nTente Novamente.");
                }
            }
        }
    }
}
