package com.parcial.bodegas.config;

import com.parcial.bodegas.model.Bodega;
import com.parcial.bodegas.model.Producto;
import com.parcial.bodegas.repository.BodegaRepository;
import com.parcial.bodegas.repository.ProductoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner inicializarDatos(BodegaRepository bodegaRepository,
                                              ProductoRepository productoRepository) {
        return args -> {
            if (bodegaRepository.count() > 0) {
                return;
            }

            Bodega bodegaNorte = bodegaRepository.save(new Bodega("Bodega Norte", "Zona Industrial Norte"));
            Bodega bodegaSur = bodegaRepository.save(new Bodega("Bodega Sur", "Parque Logístico Sur"));

            productoRepository.saveAll(List.of(
                    new Producto("Computador portátil", "Equipo portátil empresarial", 2500000.0, 15, bodegaNorte),
                    new Producto("Monitor", "Monitor LED de 24 pulgadas", 750000.0, 20, bodegaNorte),
                    new Producto("Impresora", "Impresora láser multifuncional", 1200000.0, 8, bodegaSur)
            ));
        };
    }
}
