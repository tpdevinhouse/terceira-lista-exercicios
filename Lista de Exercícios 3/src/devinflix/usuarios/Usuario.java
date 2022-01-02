package devinflix.usuarios;

import java.util.Objects;

public class Usuario {
    public String nomeCompleto;
    public String cpf;
    public String nick;
    public String dataNasc;
    public String endereco;

    public Usuario(String nomeCompleto, String cpf, String nick, String dataNasc, String endereco) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.nick = nick;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nomeCompleto, usuario.nomeCompleto) && Objects.equals(cpf, usuario.cpf) &&
                Objects.equals(nick, usuario.nick) && Objects.equals(dataNasc, usuario.dataNasc) &&
                Objects.equals(endereco, usuario.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeCompleto, cpf, nick, dataNasc, endereco);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nomeCompleto='" + nomeCompleto + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nick='" + nick + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

}
