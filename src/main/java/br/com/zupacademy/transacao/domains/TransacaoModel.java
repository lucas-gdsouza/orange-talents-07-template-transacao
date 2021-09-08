package br.com.zupacademy.transacao.domains;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Transacoes")
public class TransacaoModel {

    @Column(nullable = false)
    @Id
    @NotBlank
    private String id;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @Embedded
    @NotNull
    private EstabelecimentoModel estabelecimento;

    @ManyToOne
    private CartaoModel cartao;

    @PastOrPresent
    private LocalDateTime efetivadaEm;

    /**
     * Para uso do Hibernate
     */
    @Deprecated
    public TransacaoModel() {
    }

    public TransacaoModel(@NotBlank String id, @NotNull BigDecimal valor, @NotNull EstabelecimentoModel estabelecimento,
                          @NotNull CartaoModel cartao, @NotNull LocalDateTime efetivadaEm) {
        validarParametros(id, valor, estabelecimento, cartao, efetivadaEm);

        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    private void validarParametros(String id, BigDecimal valor, EstabelecimentoModel estabelecimento,
                                   CartaoModel cartao, LocalDateTime efetivadaEm) {
        Assert.hasText(id, "Necessário preencher o parâmetro 'id'");

        Assert.notNull(valor, "Necessário preencher o parâmetro 'valor'");
        Assert.isTrue(valor.compareTo(new BigDecimal(0)) != -1,
                "Um valor positivo deve ser atribuído ao 'valor'");

        Assert.notNull(estabelecimento, "Necessário preencher o parâmetro 'estabelecimento'");
        Assert.notNull(cartao, "Necessário preencher o parâmetro 'cartao'");
        Assert.notNull(efetivadaEm, "Necessário preencher o parâmetro 'efetivadaEm'");
    }
}