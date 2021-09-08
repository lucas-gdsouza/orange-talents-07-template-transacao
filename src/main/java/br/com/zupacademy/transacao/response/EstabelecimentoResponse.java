package br.com.zupacademy.transacao.response;

import java.util.StringJoiner;

public class EstabelecimentoResponse {

    private String nome;
    private String cidade;
    private String endereco;

    public EstabelecimentoResponse(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EstabelecimentoResponse.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("cidade='" + cidade + "'")
                .add("endereco='" + endereco + "'")
                .toString();
    }
}