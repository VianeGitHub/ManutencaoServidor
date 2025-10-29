package com.manutencaoservidor.manutencaoservidor.implantacoes.implantacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImplantacaoRepository extends JpaRepository<ImplantacaoEntity, Long> {
}
