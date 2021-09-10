package br.com.zupacademy.transacao.kafka.listeners;

import br.com.zupacademy.transacao.models.TransacaoModel;
import br.com.zupacademy.transacao.kafka.consumers.TransacaoConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class ListenerDeTransacao {

    @PersistenceContext
    private EntityManager manager;

    private final Logger logger = LoggerFactory.getLogger(ListenerDeTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(TransacaoConsumer transacaoConsumer) {
        TransacaoModel transacaoModel = transacaoConsumer.toModel();
        manager.persist(transacaoModel);
        logger.info("Transação Inserida no Banco de Dados", transacaoModel);
    }
}