package com.clientesweb.demo.cuenta.infrastructure.rest.controller;

import com.clientesweb.demo.cuenta.application.service.CuentaService;
import com.clientesweb.demo.cuenta.infrastructure.rest.dtos.RequestSaveDTOCuenta;
import com.clientesweb.demo.utils.Wrapper;
import com.clientesweb.demo.utils.exceptions.AppInternalServerErrorException;
import com.clientesweb.demo.utils.exceptions.AppNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins = { "http://localhost:4200","*" })
@RestController
@RequestMapping("/cuentas")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @GetMapping
    public ResponseEntity<Wrapper> findAll() throws AppInternalServerErrorException, AppNotFoundException {
        return cuentaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wrapper> findById(@PathVariable Long id) throws AppInternalServerErrorException, AppNotFoundException {
        return cuentaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Wrapper> save(@RequestBody RequestSaveDTOCuenta data) throws AppInternalServerErrorException, AppNotFoundException {
        return cuentaService.save(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wrapper> update(@PathVariable Long id, @RequestBody RequestSaveDTOCuenta data) throws AppInternalServerErrorException, AppNotFoundException {
        return cuentaService.update(id, data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Wrapper> delete(@PathVariable Long id) throws AppInternalServerErrorException, AppNotFoundException {
        return cuentaService.delete(id);
    }
}
