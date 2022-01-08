package devinflix.filmes;

import java.util.Objects;

public class Filme {
    private  String nome;
    private String sinopse;
    private String genero;
    private String link;

    public Filme(String nome, String sinopse, String genero, String link) {
        this.nome = nome;
        this.sinopse = sinopse;
        this.genero = genero;
        this.link = link;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return this.sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;
        return Objects.equals(nome, filme.nome) && Objects.equals(sinopse, filme.sinopse) &&
                Objects.equals(genero, filme.genero) && Objects.equals(link, filme.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sinopse, genero, link);
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + nome + '\'' +
                ", sinopse='" + sinopse + '\'' +
                ", genero='" + genero + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
