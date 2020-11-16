package com.rns.testes.java.dto;

import lombok.Data;

@Data
public class EstoqueDto {

    private String id;
    private Integer quantidade;
    private String idProduto;
    private Long idFilial;

}
