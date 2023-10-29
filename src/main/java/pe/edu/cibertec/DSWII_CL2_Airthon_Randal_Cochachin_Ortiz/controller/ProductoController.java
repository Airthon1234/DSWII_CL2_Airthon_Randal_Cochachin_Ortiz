package pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.model.Producto;
import pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.service.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> obtenerTodosLosProductos() {
        return productoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Integer id) {
        return productoService.obtenerPorId(id).orElse(null);
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoActualizado) {
        Optional<Producto> optionalProducto = productoService.obtenerPorId(id);

        if (optionalProducto.isPresent()) {
            Producto productoExistente = optionalProducto.get();
            productoExistente.setNombre(productoActualizado.getNombre());
            productoExistente.setDescripcion(productoActualizado.getDescripcion());
            productoExistente.setCantidad(productoActualizado.getCantidad());
            productoExistente.setFechaVencimiento(productoActualizado.getFechaVencimiento());

            return productoService.guardarProducto(productoExistente);
        } else {
            return null;
        }
    }


    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Integer id) {
        productoService.eliminarProducto(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Producto> obtenerPorNombre(@PathVariable String nombre) {
        return productoService.obtenerPorNombre(nombre);
    }

    @GetMapping("/cantidad")
    public List<Producto> obtenerPorCantidad() {
        return productoService.obtenerProductosEntreCantidades();
    }

    @GetMapping("/vencimiento")
    public List<Producto> obtenerPorVencimiento() {
        return productoService.obtenerProductosPorVencimiento();
    }


}
