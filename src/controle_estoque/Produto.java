package controle_estoque;

public class Produto {

    private String nome;
    private double preco_unit;
    private String unidade;
    private int qnt_estoque;

    public Produto(String nome, double preco_unit, String unidade, int qnt_estoque) {
        this.nome = nome;
        this.preco_unit = preco_unit;
        this.unidade = unidade;
        this.qnt_estoque = qnt_estoque;
    }

    public Produto() {
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Produto)) return false;
        if(obj == this) return true;
        Produto produto = (Produto) obj;
        return this.nome.equals(produto.getNome());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco_unit() {
        return preco_unit;
    }

    public void setPreco_unit(double preco) {
        this.preco_unit = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade (String unidade) {
        this.unidade = unidade;
    }

    public int getQnt_estoque() {
        return qnt_estoque;
    }

    public void setQnt_estoque(int qnt_estoque) {
        this.qnt_estoque = qnt_estoque;
    }

    public void setAddQuant(int quantidade) {
        this.qnt_estoque += quantidade;
    }

    public void setRemoveQuant(int quantidade) {
        this.qnt_estoque -= quantidade;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}