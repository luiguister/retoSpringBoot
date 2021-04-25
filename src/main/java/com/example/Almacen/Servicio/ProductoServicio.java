package com.example.Almacen.Servicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Almacen.Modelo.Producto;
import com.example.Almacen.Repositorio.ProductoRepositorio;

@Service
public class ProductoServicio {

	@Autowired
	ProductoRepositorio productoRepositorio;
	
	public ArrayList<Producto> obtenerProductos(){
		return (ArrayList<Producto>)productoRepositorio.findAll();
	}
	
	public Producto guardarProducto(Producto producto) {
		return productoRepositorio.save(producto);
	}
	
	public Optional<Producto> obtenerPorId(Long id){
		return productoRepositorio.findById(id);
	}
	
	public ArrayList<Producto> obtenerPorNombre(String nombre){
		return productoRepositorio.findByNombre(nombre);
	}
	
	public boolean eliminarProducto(Long id) {
		try {
			productoRepositorio.deleteById(id);
			return true;
		} catch (Exception err) {
			// TODO: handle exception
			return false;
		}
	}
	
}
