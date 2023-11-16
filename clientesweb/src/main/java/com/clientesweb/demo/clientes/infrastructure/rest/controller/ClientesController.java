package com.clientesweb.demo.clientes.infrastructure.rest.controller;

import com.clientesweb.demo.clientes.application.service.ClienteService;
import com.clientesweb.demo.clientes.infrastructure.rest.dtos.RequestSaveDTO;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final ClienteService clienteService;

    public ClientesController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<Wrapper> findAll() throws AppInternalServerErrorException, AppNotFoundException {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wrapper> findById(@PathVariable Long id) throws AppInternalServerErrorException, AppNotFoundException {
        return clienteService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Wrapper> save(@RequestBody RequestSaveDTO data) throws AppInternalServerErrorException {
        return clienteService.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wrapper> update(@PathVariable Long id, @RequestBody RequestSaveDTO data) throws AppInternalServerErrorException, AppNotFoundException {
        return clienteService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Wrapper> delete(@PathVariable Long id) throws AppInternalServerErrorException, AppNotFoundException {
        return clienteService.delete(id);
    }
}
