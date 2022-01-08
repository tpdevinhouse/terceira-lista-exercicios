package devinflix.usuarios;

import java.util.Objects;

public class Usuario {
    private String nomeCompleto;
    private String cpf;
    private String nick;
    private String dataNasc;
    private String endereco;

    public Usuario(String nomeCompleto, String cpf, String nick, String dataNasc, String endereco) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.nick = nick;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDataNasc() {
        return this.dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public void setEndereco(String endereco) {
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
