package com.rns.testes.java.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rns.testes.java.model.Estoque;

/**
 * Interface representa a camada de persistência da entidade Produto. Deve ser injetada <b>exclusivamente</b> em uma
 * camada service.
 */
public interface IEstoqueDao extends JpaRepository<Estoque, String> {

	public boolean findByProdutoId(String string);

	public Optional<Estoque> findByFilialIdAndProdutoId(Long filialId, String produtoId);
}
