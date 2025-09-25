import java.io.Serializable;

public class EquipeMembro implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String codigoEquipe;
    private String codigoUsuario;

    // Construtor
    public EquipeMembro(String codigoEquipe, String codigoUsuario) {
        this.codigoEquipe = codigoEquipe;
        this.codigoUsuario = codigoUsuario;
    }

    // Getters e Setters
    public String getCodigoEquipe() {
        return codigoEquipe;
    }

    public void setCodigoEquipe(String codigoEquipe) {
        this.codigoEquipe = codigoEquipe;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    @Override
    public String toString() {
        return "Equipe: " + codigoEquipe + ", Membro: " + codigoUsuario;
    }
}