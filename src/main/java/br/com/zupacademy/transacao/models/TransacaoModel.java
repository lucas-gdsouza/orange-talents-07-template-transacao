package br.com.zupacademy.transacao.models;

import org.springframework.util.Assert;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Table(name = "Transacoes")
public class TransacaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String uuid;

    @Column(nullable = false)
    @NotNull
    @PositiveOrZero
    private BigDecimal valor;

    @Embedded
    @NotNull
    private EstabelecimentoModel estabelecimento;

    @ManyToOne(cascade = CascadeType.ALL)
    private CartaoModel cartao;

    @PastOrPresent
    private LocalDateTime efetivadaEm;

    /**
     * Para uso do Hibernate
     */
    @Deprecated
    public TransacaoModel() {
    }

    public TransacaoModel(@NotBlank String uuid, @NotNull BigDecimal valor, @NotNull EstabelecimentoModel estabelecimento,
                          @NotNull CartaoModel cartao, @NotNull LocalDateTime efetivadaEm) {
        validarParametros(uuid, valor, estabelecimento, cartao, efetivadaEm);

        this.uuid = uuid;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    private void validarParametros(String uuid, BigDecimal valor, EstabelecimentoModel estabelecimento,
                                   CartaoModel cartao, LocalDateTime efetivadaEm) {
        Assert.hasText(uuid, "Necessário preencher o parâmetro 'uuid'");

        Assert.notNull(valor, "Necessário preencher o parâmetro 'valor'");
        Assert.isTrue(valor.compareTo(new BigDecimal(0)) != -1,
                "Um valor positivo deve ser atribuído ao 'valor'");

        Assert.notNull(estabelecimento, "Necessário preencher o parâmetro 'estabelecimento'");
        Assert.notNull(cartao, "Necessário preencher o parâmetro 'cartao'");
        Assert.notNull(efetivadaEm, "Necessário preencher o parâmetro 'efetivadaEm'");
    }

    public Long getId() {
        return id;
    }

    public String getUuid() {
        return uuid;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoModel getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoModel getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TransacaoModel.class.getSimpleName() + "[", "]")
                .add("uuid='" + uuid + "'")
                .add("valor=" + valor)
                .add("estabelecimento=" + estabelecimento.getNome())
                .add("cartao=" + cartao.getUuid())
                .add("efetivadaEm=" + efetivadaEm)
                .toString();
    }
}