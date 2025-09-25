import java.io.Serializable;

public class Equipe implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigoEquipe;
    private String nomeEquipe;
    private String descricao;

    // Construtor
    public Equipe(String codigoEquipe, String nomeEquipe, String descricao) {
        this.codigoEquipe = codigoEquipe;
        this.nomeEquipe = nomeEquipe;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getCodigoEquipe() {
        return codigoEquipe;
    }

    public void setCodigoEquipe(String codigoEquipe) {
        this.codigoEquipe = codigoEquipe;
    }

    public String getNomeEquipe() {
        return nomeEquipe;
    }

    public void setNomeEquipe(String nomeEquipe) {
        this.nomeEquipe = nomeEquipe;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Código: " + codigoEquipe + ", Nome: " + nomeEquipe;
    }
}