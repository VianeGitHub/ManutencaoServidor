package com.manutencaoservidor.manutencaoservidor.clientes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    boolean existsByCnpjCliente(String cnpjCliente);
}
