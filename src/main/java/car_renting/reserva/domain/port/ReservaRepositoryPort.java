package car_renting.reserva.domain.port;

import car_renting.reserva.domain.Reserva;

public interface ReservaRepositoryPort {

    Reserva guardar(Reserva reserva);

}