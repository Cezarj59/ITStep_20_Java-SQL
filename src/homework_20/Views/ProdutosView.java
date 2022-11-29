package homework_20.Views;

import homework_20.Controllers.ProdutoController;
import static homework_20.Controllers.ProdutoController.addProduto;
import homework_20.Models.Produto;
import homework_20.Services.Read;
import java.util.ArrayList;

public class ProdutosView {

    public static void cadastra() {

        Produto p = new Produto();

        System.out.print("Nome do Produto: ");
        p.setNome(Read.texto());

        System.out.print("Fabricante: ");
        p.setFabricante(Read.texto());

        System.out.print("Preço: ");
        p.setPreco(Read.numDouble());

        addProduto(p);
    }

    public static void consulta() {
        System.out.println("\n\n--------CONSULTANDO O BANCO DE DADOS------------\n\n");

        ArrayList<Produto> produtos = new ProdutoController().getAllProduto();

        if (produtos.size() == 0) {
            System.out.println("Não há produto cadastrado!");
        } else {
            for (Produto p : produtos) {
                System.out.println("\n------------------------------\n");
                System.out.println("ID: " + p.getId());
                System.out.println("Nome: " + p.getNome());
                System.out.println("Fabricante: " + p.getFabricante());
                System.out.println("Preço: R$" + p.getPreco());
            }
        }

    }

}
