package devinflix.recomendacoes;

public class Recomendacao {
    private String nomeUsuario;
    private String comentario;

    public Recomendacao(String nomeUsuario, String comentario) {
        this.nomeUsuario = nomeUsuario;
        this.comentario = comentario;
    }

    public String getNomeUsuario() {
        return this.nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Recomendacao{" +
                "nomeUsuario='" + nomeUsuario + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
