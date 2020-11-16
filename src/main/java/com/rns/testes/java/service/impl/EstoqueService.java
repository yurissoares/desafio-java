package com.rns.testes.java.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rns.testes.java.dao.IEstoqueDao;
import com.rns.testes.java.dao.IFilialDao;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.model.Filial;
import com.rns.testes.java.service.AbstractGenericServicePersistence;
import com.rns.testes.java.service.IEstoqueService;
import com.rns.testes.java.service.IFilialService;
import com.rns.testes.java.service.IProdutoService;

@Service
public class EstoqueService extends AbstractGenericServicePersistence<IEstoqueDao, Estoque, String>
		implements IEstoqueService {

	@Autowired
	IEstoqueService estoqueService;

	@Autowired
	IProdutoService produtoService;

	@Autowired
	IFilialService filialService;

	@Autowired
	IEstoqueDao estoqueDao;

	@Autowired
	IFilialDao filialDao;

	@Override
	public Boolean transferirEntreFiliais(String idProduto, Long idFilialAntiga, Long idFilialNova) {
		Optional<Estoque> estoqueOptional = this.estoqueDao.findByFilialIdAndProdutoId(idFilialAntiga, idProduto);
		Optional<Filial> filialNova = this.filialDao.findById(idFilialNova);
		if (estoqueOptional.isPresent() && filialNova.isPresent()) {
			estoqueOptional.get().setFilial(filialNova.get());
			this.estoqueDao.save(estoqueOptional.get());
			return Boolean.TRUE;
		} else {
			throw new UnsupportedOperationException("Objeto não encontrado");
		}
	}
}
