
package homework_20.Views;

import homework_20.Controllers.Constantes;
import homework_20.Models.Produto;
import java.sql.*;
import java.util.ArrayList;


public class ProdutosView {
     public static void consulta() {
      System.out.println("\n\n--------CONSULTANDO O BANCO DE DADOS------------\n\n");

        try {
            Connection conn = DriverManager.getConnection(Constantes.url, Constantes.user, Constantes.pass);
            if (conn != null) {
                System.out.println("\nCONECTADO AO BANCO\n");
            }

            String sql = "SELECT * FROM produto";
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            ArrayList<Produto> produtos = new ArrayList<Produto>();
            
            while (resultado.next()) {
                produtos.add(new Produto(resultado.getString("nome"),
                        resultado.getString("fabricante"),
                        resultado.getDouble("preco"),
                        resultado.getInt(1)
                )
                );
            }
            if (produtos.size() < 1) {
                System.out.println("Não tem ninguém cadastrado!");
            } else {
                for (Produto p : produtos) {
                    System.out.println("\n------------------------------\n");
                    System.out.println("ID: " + p.getId());
                    System.out.println("Nome: " + p.getNome());
                    System.out.println("Fabricante: " + p.getFabricante());
                    System.out.println("Preço: " + p.getPreco());
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.err.println("ERRO DO BANCO: " + e);
        }
     }
}
