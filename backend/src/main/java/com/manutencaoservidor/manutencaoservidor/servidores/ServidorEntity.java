package com.manutencaoservidor.manutencaoservidor.servidores;

import com.manutencaoservidor.manutencaoservidor.clientes.ClienteEntity;
import com.manutencaoservidor.manutencaoservidor.observacoes.ObservacaoEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "servidores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ServidorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_servidor", nullable = false, unique = true, length = 30)
    private String nomeServidor;

    @Column(name = "ip_servidor", nullable = true, unique = false, length = 20)
    private String ipServidor;

    // Relacionamento reverso: 1 servidor -> muitos clientes
    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, orphanRemoval = false)
    @ToString.Exclude
    private List<ClienteEntity> clientes;

    @OneToMany(mappedBy = "servidor", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ObservacaoEntity> observacoes;
}
