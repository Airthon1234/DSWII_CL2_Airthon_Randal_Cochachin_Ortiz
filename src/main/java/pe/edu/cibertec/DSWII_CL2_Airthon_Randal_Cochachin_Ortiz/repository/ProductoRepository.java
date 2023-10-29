package pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.DSWII_CL2_Airthon_Randal_Cochachin_Ortiz.model.Producto;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByNombre(String nombre);
    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> findProductosBetweenQuantities();

    @Query(value = "SELECT * FROM Producto p WHERE YEAR(p.fecha_vencimiento) = 2024", nativeQuery = true)
    List<Producto> findProductosByExpirationYear2024();
}
