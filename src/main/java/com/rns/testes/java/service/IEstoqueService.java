package com.rns.testes.java.service;

import com.rns.testes.java.model.Estoque;

public interface IEstoqueService extends IGenericService<Estoque, String> {
	
	public Boolean transferirEntreFiliais(String idProduto, Long idFilialAntiga, Long idFilialNova);
	
}
