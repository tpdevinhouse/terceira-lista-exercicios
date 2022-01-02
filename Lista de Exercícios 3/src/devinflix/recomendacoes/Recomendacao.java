package devinflix.recomendacoes;

public class Recomendacao {
    public String nomeUsuario;
    public String comentario;

    public Recomendacao(String nomeUsuario, String comentario) {
        this.nomeUsuario = nomeUsuario;
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
