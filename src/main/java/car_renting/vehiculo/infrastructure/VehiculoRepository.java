package car_renting.vehiculo.infrastructure;

import car_renting.vehiculo.domain.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehiculoRepository
        extends JpaRepository<Vehiculo, Long> {
}