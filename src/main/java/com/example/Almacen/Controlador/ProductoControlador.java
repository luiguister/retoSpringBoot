package com.example.Almacen.Controlador;

import java.util.ArrayList;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Almacen.Modelo.Producto;
import com.example.Almacen.Servicio.ProductoServicio;

@RestController
@RequestMapping("/producto")
public class ProductoControlador {

	@Autowired
	ProductoServicio productoServicio;
	
	//@GetMapping
	//public ResponseEntity<Producto> getProducto(){
		
	//}
	
	@GetMapping()
	public ArrayList<Producto> obtenerProductos() {
		return productoServicio.obtenerProductos();
	}
	
	@PostMapping
	public Producto guardarProducto(@RequestBody Producto producto) {
		return this.productoServicio.guardarProducto(producto);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Producto> obtenerProductoPorId(@PathVariable("id") Long id){
		return this.productoServicio.obtenerPorId(id);
	}
	
	@GetMapping("/query")
	public ArrayList<Producto> obtenerProductoPorNombre(@PathParam("nombre") String nombre){
		return this.productoServicio.obtenerPorNombre(nombre);
	}
	
	@DeleteMapping(path = "/{id}")
	public String eliminarPorId(@PathVariable("id") Long id) {
		boolean ok = this.productoServicio.eliminarProducto(id);
		if(ok) {
			return "Se eliminó el producto con el id "+ id;
		}else {
			return "No se pudo eliminar el producto con el id "+id;
			
		}
		
	}
}
