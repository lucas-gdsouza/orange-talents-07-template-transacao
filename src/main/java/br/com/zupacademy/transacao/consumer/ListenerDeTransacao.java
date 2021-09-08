package br.com.zupacademy.transacao.consumer;

import br.com.zupacademy.transacao.response.TransacaoResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerDeTransacao {

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(TransacaoResponse transacaoResponse) {
        System.out.println(transacaoResponse);
    }
}