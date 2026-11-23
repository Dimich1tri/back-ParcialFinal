package com.parcial.bodegas.dto;

import com.parcial.bodegas.model.Producto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoRespuestaDTO {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;

    public static ProductoRespuestaDTO desde(Producto producto) {
        return new ProductoRespuestaDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                producto.getCantidad()
        );
    }
}
