package homework_20.Controllers;


import homework_20.Services.BancoDados;
import homework_20.Models.Produto;
import java.sql.*;
import java.util.ArrayList;

public class ProdutoController {

  

    
    
    public static void addProduto(Produto p) {
        Connection conn = BancoDados.getConn();

        if (conn == null) {
            System.err.println("Erro na conexão");
        } else {

            String sql = "INSERT INTO produto (nome,fabricante,preco) VALUES (?,?,?)";
            try {
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, p.getNome());
                statement.setString(2, p.getFabricante());
                statement.setDouble(3, p.getPreco());

                int linhasInseridas = statement.executeUpdate();

                if (linhasInseridas > 0) {
                    System.out.println("\nProduto Cadastrado com sucesso!\n");
                } else {
                    System.err.println("Falha ao cadastrar o produto.");
                }

                statement.close();//limpando memória
                conn.close();
            } catch (SQLException e) {
                System.err.println(e);

            }

        }

    }

    public static ArrayList<Produto> getAllProduto() {
        ArrayList<Produto> produtoList = new ArrayList<Produto>();
        Connection conn = BancoDados.getConn();

        if (conn == null) {
            System.err.println("Erro na conexão");
            return produtoList;
        }

        String sql = "SELECT * FROM produto";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                produtoList.add(new Produto(resultado.getString("nome"),
                        resultado.getString("fabricante"),
                        resultado.getDouble("preco"),
                        resultado.getInt(1)
                )
                );
            }
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.err.println(e);
        }

        return produtoList;
    }
    

   
}
