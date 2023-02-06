package com.wayon.transferencias.controller;

import com.wayon.transferencias.model.Transferencia;
import com.wayon.transferencias.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @RequestMapping(value = "/api/transferencias", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Transferencia agendarTransfer(@RequestBody Transferencia transfer) {
        return transferService.agendarTransfers(transfer);
    }

    @RequestMapping(value = "/api/transferencias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Transferencia>> consultarTransferencias() {
        List<Transferencia> transferencias = transferService.consultarTransfers();
        return new ResponseEntity<>(transferencias, HttpStatus.OK);
    }
};


