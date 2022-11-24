package classroom_20;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String host = "localhost";
        String port = "3306";
        String banco = "javacurso";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + banco;

        String user = "root";
        String pass = "";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);

            if (conn != null) {
                System.out.println("Conectado ao banco de dados!\n\n\n");
            }

            Pessoa p = new Pessoa();
            Scanner leia = new Scanner(System.in);

            System.out.print("Nome: ");
            p.nome = leia.nextLine();

            System.out.print("Telefone: ");
            p.telefone = leia.nextLine();

            System.out.print("Nascimento: ");
            p.nascimento = leia.nextLine();

            String sql = "INSERT INTO aluno (nome,nascimento,telefone) VALUES (?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, p.nome);
            statement.setString(2, p.nascimento);
            statement.setString(3, p.telefone);

            int linhasInseridas = statement.executeUpdate();

            if (linhasInseridas > 0) {
                System.out.println("\nPessoa Cadastrada com sucesso!\n");
            }

            conn.close();

        } catch (SQLException ex) {
            System.out.println("Erro: " + ex);
        }

        System.out.println("\n\n--------CONSULTANDO O BANCO DE DADOS------------\n\n");

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("\nCONECTADO AO BANCO\n");
            }

            String sql = "SELECT * FROM aluno";
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
            while (resultado.next()) {
                pessoas.add(new Pessoa(resultado.getString("nome"),
                        resultado.getString("telefone"),
                        resultado.getString("nascimento"),
                        resultado.getInt(1)
                )
                );
            }
            if (pessoas.size() < 1) {
                System.out.println("Não tem ninguém cadastrado!");
            } else {
                for (Pessoa p : pessoas) {
                    System.out.println("ID: " + p.id);
                    System.out.println("Nome: " + p.nome);
                    System.out.println("Telefone: " + p.telefone);
                    System.out.println("Nascimento: " + p.nascimento);
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("ERRO DO BANCO: " + e);
        }

    }
}

class Pessoa {

    String nome, telefone, nascimento;
    int id;

    public Pessoa(String nome, String telefone, String nascimento, int id) {
        this.nome = nome;
        this.telefone = telefone;
        this.nascimento = nascimento;
        this.id = id;
    }

    public Pessoa() {
    }
}
