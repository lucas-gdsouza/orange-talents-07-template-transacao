package br.com.zupacademy.transacao.domains;

import org.springframework.util.Assert;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cartoes")
public class CartaoModel {

    @Column(nullable = false)
    @Id
    @NotBlank
    private String id;

    @Email
    @NotBlank
    private String email;

    /**
     * Para uso do Hibernate
     */
    @Deprecated
    public CartaoModel() {
    }

    public CartaoModel(String id, String email) {
        validarConstrutor(id, email);
        this.id = id;
        this.email = email;
    }

    private void validarConstrutor(String id, String email) {
        Assert.hasText(id, "Necessário preencher o parâmetro 'id'");
        Assert.hasText(email, "Necessário preencher o parâmetro 'email'");
    }
}