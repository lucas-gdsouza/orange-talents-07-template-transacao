package br.com.zupacademy.transacao.response;

import br.com.zupacademy.transacao.models.TransacaoModel;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    @NotBlank
    private String uuid;

    @NotBlank
    private BigDecimal valor;

    @NotBlank
    private String estabelecimento;

    @NotNull
    private LocalDateTime efetivadaEm;

    public TransacaoResponse(TransacaoModel transacaoModel) {
        this.uuid = transacaoModel.getUuid();
        this.valor = transacaoModel.getValor();
        this.estabelecimento = transacaoModel.getEstabelecimento().getNome();
        this.efetivadaEm = transacaoModel.getEfetivadaEm();
    }

    public String getUuid() {
        return uuid;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getEstabelecimento() {
        return estabelecimento;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
