package br.com.zupacademy.transacao.resource;

import br.com.zupacademy.transacao.models.CartaoModel;
import br.com.zupacademy.transacao.models.TransacaoModel;

import br.com.zupacademy.transacao.repository.CartaoRepository;
import br.com.zupacademy.transacao.repository.TransacaoRepository;
import br.com.zupacademy.transacao.response.TransacaoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/transacoes")
public class TransacaoResource {
    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private TransacaoRepository transacaoRepository;

    @GetMapping(value = "/{id}")
    public ResponseEntity consultarTransacoes(@PathVariable("id") Long id) {

        Optional<CartaoModel> cartao = cartaoRepository.findById(id);

        if (cartao.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TransacaoModel> transacoesList = transacaoRepository.findTop10ByCartaoUuidOrderByEfetivadaEmDesc(cartao.get().getUuid());

        return ResponseEntity.ok(transacoesList.stream().map(TransacaoResponse::new));
    }
}