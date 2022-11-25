package homework_20.Models;

public class Produto {

    private String nome;
    private String fabricante;
    private double preco;
    private int id = 0;

    public Produto() {
    }

    public Produto(String nome, String fabricante, double preco, int id) {
        this.nome = nome;
        this.fabricante = fabricante;
        this.preco = preco;
        this.id = id;
    }

    
    
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    

}
