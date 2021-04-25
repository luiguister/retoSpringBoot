package com.example.Almacen.Repositorio;


import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Almacen.Modelo.Producto;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, Long>{
	public abstract ArrayList<Producto> findByNombre(String nombre);

}
