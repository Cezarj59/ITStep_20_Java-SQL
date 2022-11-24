package homework_20.Controllers;

import homework_20.Controllers.Constantes;
import homework_20.Models.Produto;
import java.sql.*;

public class ProdutoController {

    public static void cadastra() {

        try {
            Connection conn = DriverManager.getConnection(Constantes.url, Constantes.user, Constantes.pass);

            if (conn != null) {
                 System.out.println("\n-----------------------------");
                System.out.println("\nConectado ao banco de dados!\n");
            }

            Produto p = new Produto();

            System.out.print("Nome do Produto: ");
            p.setNome(Constantes.read.nextLine());

            System.out.print("Fabricante: ");
            p.setFabricante(Constantes.read.nextLine());

            System.out.print("Preço: ");
            p.setPreco(Constantes.read.nextDouble());

            String sql = "INSERT INTO produto (nome,fabricante,preco) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, p.getNome());
            statement.setString(2, p.getFabricante());
            statement.setDouble(3, p.getPreco());

            int linhasInseridas = statement.executeUpdate();

            if (linhasInseridas > 0) {
                System.out.println("\nProduto Cadastrado com sucesso!\n");
            }

            conn.close();

        } catch (SQLException ex) {
            System.err.println("Erro: " + ex);
        }

    }

}
