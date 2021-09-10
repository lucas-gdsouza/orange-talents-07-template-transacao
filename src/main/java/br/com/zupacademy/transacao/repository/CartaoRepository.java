package br.com.zupacademy.transacao.repository;

import br.com.zupacademy.transacao.models.CartaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoRepository extends JpaRepository<CartaoModel, Long> {
}