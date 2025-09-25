import java.io.Serializable;

public class Projeto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigoProjeto;
    private String nomeProjeto;
    private String descricao;
    private String dataInicio;
    private String dataTermino;
    private String status;
    private String codigoGerente;

    // Construtor
    public Projeto(String codigoProjeto, String nomeProjeto, String descricao, String dataInicio, String dataTermino, String status, String codigoGerente) {
        this.codigoProjeto = codigoProjeto;
        this.nomeProjeto = nomeProjeto;
        this.descricao = descricao;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.status = status;
        this.codigoGerente = codigoGerente;
    }

    // Getters e Setters
    public String getCodigoProjeto() {
        return codigoProjeto;
    }

    public void setCodigoProjeto(String codigoProjeto) {
        this.codigoProjeto = codigoProjeto;
    }

    public String getNomeProjeto() {
        return nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(String dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigoGerente() {
        return codigoGerente;
    }

    public void setCodigoGerente(String codigoGerente) {
        this.codigoGerente = codigoGerente;
    }

    @Override
    public String toString() {
        return "Código: " + codigoProjeto + ", Nome: " + nomeProjeto + ", Status: " + status;
    }
}