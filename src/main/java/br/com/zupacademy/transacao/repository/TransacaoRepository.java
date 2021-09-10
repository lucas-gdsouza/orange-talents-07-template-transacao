package br.com.zupacademy.transacao.repository;

import br.com.zupacademy.transacao.models.TransacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<TransacaoModel, Long> {
    List<TransacaoModel> findTop10ByCartaoUuidOrderByEfetivadaEmDesc(String uuid);
}