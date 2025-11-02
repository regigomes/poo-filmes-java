package com.catalogo.filmes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmeDTO {

    private Long id;

    @NotBlank(message = "Título é obrigatório")
    private String titulo;

    private String dataLancamento;

    @NotNull(message = "Orçamento é obrigatório")
    private Double orcamento;

    private String descricao;

    private Long diretorId;

    private String diretorNome;

    private List<Long> atoresIds;

    private List<String> atoresNomes;
}
