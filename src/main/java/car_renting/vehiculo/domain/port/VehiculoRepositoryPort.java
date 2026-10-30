package car_renting.vehiculo.domain.port;

import car_renting.vehiculo.domain.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehiculoRepositoryPort {

    List<Vehiculo> listarTodos();

    Optional<Vehiculo> buscarPorId(Long id);

    Vehiculo guardar(Vehiculo vehiculo);

    void eliminarPorId(Long id);
}