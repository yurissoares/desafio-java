package com.rns.testes.java.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.service.IEstoqueService;
import com.rns.testes.java.service.IFilialService;
import com.rns.testes.java.service.IProdutoService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ZEstoqueSeeder {

    @Autowired
    IEstoqueService service;
    
    @Autowired
    IProdutoService produtoService;
    
    @Autowired
    IFilialService filialService;

    @EventListener
    public void seedFilial(ContextRefreshedEvent event) {
        try {
            log.info("Criando estoques....");
            criandoEstoques();
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void criandoEstoques() {
        for (int i = 1; i < 5; i++) {
            Estoque estoque = new Estoque();
            estoque.setId("Cod-Estoque-"+i);
            estoque.setQuantidade(99);
            estoque.setProduto(produtoService.findById(("Cod-Produto-"+i)));
            estoque.setFilial(filialService.findById(Long.valueOf(i)));
            
            service.save(estoque);
        }
    }
}
