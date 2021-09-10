package br.com.zupacademy.transacao.models;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.*;

@Entity
@Table(name = "Cartoes")
public class CartaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String uuid;

    @Email
    @NotBlank
    private String email;

    @OneToMany(mappedBy = "cartao")
    private List<TransacaoModel> transacoes;

    /**
     * Para uso do Hibernate
     */
    @Deprecated
    public CartaoModel() {
    }

    public CartaoModel(String uuid, String email) {
        validarConstrutor(uuid, email);
        this.uuid = uuid;
        this.email = email;
    }

    private void validarConstrutor(String uuid, String email) {
        Assert.hasText(uuid, "Necessário preencher o parâmetro 'uuid'");
        Assert.hasText(email, "Necessário preencher o parâmetro 'email'");
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }
}