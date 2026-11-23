package com.parcial.bodegas.controllers;

import com.parcial.bodegas.dto.BodegaDTO;
import com.parcial.bodegas.dto.BodegaRespuestaDTO;
import com.parcial.bodegas.model.Bodega;
import com.parcial.bodegas.services.BodegaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping({"/bodegas", "/api/bodegas"})
@CrossOrigin(origins = "*")
public class BodegaController {

    private final BodegaService bodegaService;

    public BodegaController(BodegaService bodegaService) {
        this.bodegaService = bodegaService;
    }

    @PostMapping
    public ResponseEntity<BodegaRespuestaDTO> registrar(@Valid @RequestBody BodegaDTO datos) {
        Bodega creada = bodegaService.registrarBodega(datos);
        return ResponseEntity.status(HttpStatus.CREATED).body(BodegaRespuestaDTO.desde(creada));
    }

    @GetMapping
    public ResponseEntity<List<BodegaRespuestaDTO>> listar() {
        List<BodegaRespuestaDTO> respuesta = bodegaService.listarBodegas()
                .stream()
                .map(BodegaRespuestaDTO::desde)
                .toList();
        return ResponseEntity.ok(respuesta);
    }
}
