package com.rns.testes.java.controller;

import com.rns.testes.java.dto.EstoqueDto;
import com.rns.testes.java.dto.TransfereDto;
import com.rns.testes.java.dto.mapper.EstoqueMapper;
import com.rns.testes.java.model.Estoque;
import com.rns.testes.java.service.IEstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping
public class EstoqueController {

    private static final String BASE_URL = "estoque/";

    @Autowired
    IEstoqueService service;
    
    @PostMapping(value = BASE_URL + "transfer", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Boolean> transfer(@RequestBody TransfereDto dto) {
        return ResponseEntity.ok(service.transferirEntreFiliais(dto.getIdProduto(), dto.getIdFilialAntiga(), dto.getIdFilialNova()));
    }

    @GetMapping(value = BASE_URL + "find-all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<List<Estoque>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = BASE_URL + "find-by-id", produces = MediaType.APPLICATION_JSON_VALUE, params = {"id"})
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Estoque> findById(@RequestParam(name = "id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping(value = BASE_URL + "update", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Estoque> update(@RequestBody EstoqueDto dto) {
        return ResponseEntity.ok(service.update(EstoqueMapper.INSTANCE.dtoToEntity(dto)));
    }

    @PostMapping(value = BASE_URL + "insert", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<Estoque> insert(@RequestBody EstoqueDto dto) {
        return ResponseEntity.ok(service.save(EstoqueMapper.INSTANCE.dtoToEntity(dto)));
    }

    @DeleteMapping(value = BASE_URL + "delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(@RequestParam(name = "id") String id) {
        service.delete(id);
    }

}
