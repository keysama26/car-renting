package car_renting.reserva.application;

import car_renting.reserva.domain.Reserva;
import car_renting.reserva.infrastructure.ReservaRepository;
import car_renting.vehiculo.domain.Vehiculo;
import car_renting.vehiculo.infrastructure.VehiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final VehiculoRepository vehiculoRepository;

    public ReservaService(
            ReservaRepository reservaRepository,
            VehiculoRepository vehiculoRepository) {
        this.reservaRepository = reservaRepository;
        this.vehiculoRepository = vehiculoRepository;
    }

    @Transactional
    public Reserva crearReserva(
            String nombreCliente,
            String correoCliente,
            Long vehiculoId,
            int dias) {

        if (nombreCliente == null || nombreCliente.isBlank()) {
            throw new IllegalArgumentException(
                    "El nombre del cliente es obligatorio.");
        }

        if (correoCliente == null || correoCliente.isBlank()) {
            throw new IllegalArgumentException(
                    "El correo del cliente es obligatorio.");
        }

        if (vehiculoId == null) {
            throw new IllegalArgumentException(
                    "Debes seleccionar un vehículo.");
        }

        if (dias < 1 || dias > 365) {
            throw new IllegalArgumentException(
                    "Los días deben estar entre 1 y 365.");
        }

        Vehiculo vehiculo = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new IllegalArgumentException(
                        "El vehículo seleccionado no existe."));

        if (!vehiculo.isDisponible()) {
            throw new IllegalArgumentException(
                    "El vehículo no está disponible.");
        }

        Reserva reserva = new Reserva();
        reserva.setNombreCliente(nombreCliente);
        reserva.setCorreoCliente(correoCliente);
        reserva.setDias(dias);
        reserva.setPrecioTotal(vehiculo.getPrecioPorDia() * dias);
        reserva.setFechaSolicitud(LocalDateTime.now());
        reserva.setVehiculo(vehiculo);

        return reservaRepository.save(reserva);
    }
}