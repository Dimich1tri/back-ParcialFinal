package com.parcial.bodegas.dto;

import com.parcial.bodegas.model.Bodega;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BodegaRespuestaDTO {

    private Long id;
    private String nombre;
    private String ubicacion;
    private List<ProductoRespuestaDTO> productos;

    public static BodegaRespuestaDTO desde(Bodega bodega) {
        List<ProductoRespuestaDTO> listaProductos = bodega.getProductos() == null
                ? List.of()
                : bodega.getProductos().stream().map(ProductoRespuestaDTO::desde).toList();
        return new BodegaRespuestaDTO(
                bodega.getId(),
                bodega.getNombre(),
                bodega.getUbicacion(),
                listaProductos
        );
    }
}
