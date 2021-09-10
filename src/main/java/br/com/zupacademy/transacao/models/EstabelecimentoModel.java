package br.com.zupacademy.transacao.models;

import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class EstabelecimentoModel {

    @Column(nullable = false)
    @NotBlank
    private String nome;

    @Column(nullable = false)
    @NotBlank
    private String cidade;

    @Column(nullable = false)
    @NotBlank
    private String endereco;

    /**
     * Para uso do Hibernate
     */
    @Deprecated
    public EstabelecimentoModel() {
    }

    public EstabelecimentoModel(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
        validarConstrutor(nome, cidade, endereco);

        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    private void validarConstrutor(String nome, String cidade, String endereco) {
        Assert.hasText(nome, "Necessário preencher o parâmetro 'nome'");
        Assert.hasText(cidade, "Necessário preencher o parâmetro 'cidade'");
        Assert.hasText(endereco, "Necessário preencher o parâmetro 'endereco'");
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
}