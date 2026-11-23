package com.parcial.bodegas.services;

import com.parcial.bodegas.dto.BodegaDTO;
import com.parcial.bodegas.model.Bodega;
import com.parcial.bodegas.repository.BodegaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BodegaService {

    private final BodegaRepository bodegaRepository;

    public BodegaService(BodegaRepository bodegaRepository) {
        this.bodegaRepository = bodegaRepository;
    }

    @Transactional
    public Bodega registrarBodega(BodegaDTO datos) {
        Bodega bodega = new Bodega(datos.getNombre().trim(), datos.getUbicacion().trim());
        return bodegaRepository.save(bodega);
    }

    @Transactional(readOnly = true)
    public List<Bodega> listarBodegas() {
        return bodegaRepository.findAll();
    }
}
