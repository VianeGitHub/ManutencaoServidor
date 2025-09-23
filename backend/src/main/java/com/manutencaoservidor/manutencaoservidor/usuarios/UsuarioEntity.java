package com.manutencaoservidor.manutencaoservidor.usuarios;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login_usuario", nullable = false, length = 30, unique = true)
    private String loginUsuario;

    @Column(name = "senha_usuario", nullable = false, length = 255)
    private String senhaUsuario;
}
