package com.manutencaoservidor.manutencaoservidor.servidores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServidorRepository extends JpaRepository <ServidorEntity, Long>{
}
