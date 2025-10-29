package com.manutencaoservidor.manutencaoservidor.observacoes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservacaoRepository extends JpaRepository<ObservacaoEntity, Long> {
}