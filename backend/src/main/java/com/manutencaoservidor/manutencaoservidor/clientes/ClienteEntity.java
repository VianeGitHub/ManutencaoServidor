package com.manutencaoservidor.manutencaoservidor.clientes;

import com.manutencaoservidor.manutencaoservidor.enums.SituacaoAtual;
import com.manutencaoservidor.manutencaoservidor.observacoes.ObservacaoEntity;
import com.manutencaoservidor.manutencaoservidor.servidores.ServidorEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_cliente", nullable = false, length = 255)
    private String nomeCliente;

    @Column(name = "cnpj_cliente", nullable = false, length = 14, unique = true)
    private String cnpjCliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao_atual", nullable = false, length = 20)
    private SituacaoAtual situacaoAtual;

    @ManyToOne
    @JoinColumn(name = "id_servidor", nullable = false)
    private ServidorEntity servidor;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "data_atualizacao")
    private LocalDateTime dataAtualizacao;

    @PrePersist
    protected void onCreate() {
        this.dataCriacao = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.dataAtualizacao = LocalDateTime.now();
    }

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<ObservacaoEntity> observacoes;
}

