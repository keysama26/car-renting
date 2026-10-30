package car_renting.reserva.infrastructure.adapter;

import car_renting.reserva.domain.Reserva;
import car_renting.reserva.domain.port.ReservaRepositoryPort;
import car_renting.reserva.infrastructure.ReservaRepository;
import org.springframework.stereotype.Component;

@Component
public class ReservaRepositoryAdapter implements ReservaRepositoryPort {

    private final ReservaRepository repository;

    public ReservaRepositoryAdapter(ReservaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Reserva guardar(Reserva reserva) {
        return repository.save(reserva);
    }
}