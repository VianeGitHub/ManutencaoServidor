package com.manutencaoservidor.manutencaoservidor.implantacoes.implantacao;

import com.manutencaoservidor.manutencaoservidor.enums.StatusImplantacao;
import com.manutencaoservidor.manutencaoservidor.usuarios.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "implantacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ImplantacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_implantacao", nullable = false)
    private LocalDate dataImplantacao;

    @Column(name = "hora_implantacao", nullable = false)
    private LocalTime horaImplantacao;

    @Column(length = 20)
    private String duracao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusImplantacao status;

    @Column(nullable = false, length = 100)
    private String tecnico;

    @Column(name = "tipo_implantacao", nullable = false, length = 50)
    private String tipoImplantacao;

    @Column(length = 100)
    private String contato;

    @Column(nullable = false, length = 150)
    private String cliente; // nome ou revenda informada na implantação

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;
}
