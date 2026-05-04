package com.universidad.productosservice.service;

import com.universidad.productosservice.domain.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> listarTodos();

    Producto crear(String nombre, Double precio, Integer stock);

    Producto buscarPorId(Long id);

    Producto actualizarStock(Long id, Integer nuevoStock);

    void eliminar(Long id);
}
