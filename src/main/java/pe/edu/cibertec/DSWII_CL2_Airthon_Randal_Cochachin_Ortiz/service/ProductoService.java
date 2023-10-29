package pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.model.Producto;
import pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.repository.ProductoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerPorId(Integer id) {
        return productoRepository.findById(id);
    }

    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Integer id) {
        productoRepository.deleteById(id);
    }

    public List<Producto> obtenerPorNombre(String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    public List<Producto> obtenerProductosEntreCantidades() {
        return productoRepository.findProductosBetweenQuantities();
    }

    public List<Producto> obtenerProductosPorVencimiento() {
        return productoRepository.findProductosByExpirationYear2024();
    }
}
