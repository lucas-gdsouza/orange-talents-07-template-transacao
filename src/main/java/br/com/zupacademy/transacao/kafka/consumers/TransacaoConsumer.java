package br.com.zupacademy.transacao.kafka.consumers;

import br.com.zupacademy.transacao.models.TransacaoModel;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class TransacaoConsumer {

    private String id;
    private BigDecimal valor;
    private EstabelecimentoConsumer estabelecimento;
    private CartaoConsumer cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoConsumer() {
    }

    public TransacaoConsumer(String id, BigDecimal valor, EstabelecimentoConsumer estabelecimento,
                             CartaoConsumer cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public EstabelecimentoConsumer getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoConsumer getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public @NotNull TransacaoModel toModel() {
        return new TransacaoModel(this.id, this.valor, this.estabelecimento.toModel(),
                this.cartao.toModel(), this.efetivadaEm);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", TransacaoConsumer.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'")
                .add("valor=" + valor)
                .add("estabelecimento=" + estabelecimento)
                .add("cartao=" + cartao)
                .add("efetivadaEm=" + efetivadaEm)
                .toString();
    }
}