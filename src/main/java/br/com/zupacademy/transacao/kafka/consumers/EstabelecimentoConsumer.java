package br.com.zupacademy.transacao.kafka.consumers;

import br.com.zupacademy.transacao.models.EstabelecimentoModel;

import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

public class EstabelecimentoConsumer {

    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoConsumer() {
    }

    public EstabelecimentoConsumer(String nome, String cidade, String endereco) {
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

    public @NotNull EstabelecimentoModel toModel() {
        return new EstabelecimentoModel(this.nome, this.cidade, this.endereco);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EstabelecimentoConsumer.class.getSimpleName() + "[", "]")
                .add("nome='" + nome + "'")
                .add("cidade='" + cidade + "'")
                .add("endereco='" + endereco + "'")
                .toString();
    }
}