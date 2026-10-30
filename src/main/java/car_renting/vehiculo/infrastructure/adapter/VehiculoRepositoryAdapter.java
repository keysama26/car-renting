package car_renting.vehiculo.infrastructure.adapter;

import car_renting.vehiculo.domain.Vehiculo;
import car_renting.vehiculo.domain.port.VehiculoRepositoryPort;
import car_renting.vehiculo.infrastructure.VehiculoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class VehiculoRepositoryAdapter implements VehiculoRepositoryPort {

    private final VehiculoRepository repository;

    public VehiculoRepositoryAdapter(VehiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vehiculo> listarTodos() {
        return repository.findAll();
    }

    @Override
    public Optional<Vehiculo> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Vehiculo guardar(Vehiculo vehiculo) {
        return repository.save(vehiculo);
    }

    @Override
    public void eliminarPorId(Long id) {
        repository.deleteById(id);
    }
}