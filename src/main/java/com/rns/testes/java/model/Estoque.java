package com.rns.testes.java.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ESTOQUE")
@Data
public class Estoque extends GenericEntity<String> {

	@Id
	private String id;

	@Column
	private Integer quantidade;

	@ManyToOne
	private Produto produto;

	@ManyToOne
	private Filial filial;

}
