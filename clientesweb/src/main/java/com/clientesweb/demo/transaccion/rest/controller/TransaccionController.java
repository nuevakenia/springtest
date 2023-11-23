package com.clientesweb.demo.transaccion.rest.controller;

import com.clientesweb.demo.transaccion.rest.dtos.RequestSaveDTOTransaccion;
import com.clientesweb.demo.transaccion.service.TransaccionService;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.exceptions.AppBadRequestException;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/transaccion")
public class TransaccionController {

    private final TransaccionService transaccionService;

    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public ResponseEntity<Wrapper> findAll() throws AppInternalServerErrorException, AppNotFoundException {
        return transaccionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wrapper> findById(@PathVariable Long id) throws AppInternalServerErrorException, AppNotFoundException {
        return transaccionService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Wrapper> save(@RequestBody RequestSaveDTOTransaccion data) throws AppInternalServerErrorException, AppNotFoundException, AppBadRequestException {
        return transaccionService.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wrapper> update(@PathVariable Long id, @RequestBody RequestSaveDTOTransaccion data) throws AppInternalServerErrorException, AppNotFoundException {
        return transaccionService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Wrapper> delete(@PathVariable Long id) throws AppInternalServerErrorException, AppNotFoundException {
        return transaccionService.delete(id);
    }
}
