package com.manutencaoservidor.manutencaoservidor.implantacoes.implantacao;

import com.manutencaoservidor.manutencaoservidor.enums.StatusImplantacao;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImplantacaoRequestDTO {
    private LocalDate dataImplantacao;
    private LocalTime horaImplantacao;
    private String duracao;
    private StatusImplantacao status;
    private String tecnico;
    private String tipoImplantacao;
    private String contato;
    private String cliente;
    private Long idUsuario;
}
