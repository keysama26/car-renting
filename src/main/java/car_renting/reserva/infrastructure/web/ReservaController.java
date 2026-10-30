package car_renting.reserva.infrastructure.web;

import car_renting.reserva.application.ReservaService;
import car_renting.reserva.domain.Reserva;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<?> crearReserva(@RequestBody SolicitudReserva solicitud) {
        try {
            Reserva reserva = reservaService.crearReserva(
                    solicitud.nombreCliente,
                    solicitud.correoCliente,
                    solicitud.vehiculoId,
                    solicitud.dias
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                    "mensaje", "Reserva registrada correctamente.",
                    "id", reserva.getId(),
                    "nombreCliente", reserva.getNombreCliente(),
                    "dias", reserva.getDias(),
                    "precioTotal", reserva.getPrecioTotal()
            ));

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(
                    Map.of("error", e.getMessage())
            );
        }
    }

    public static class SolicitudReserva {
        public String nombreCliente;
        public String correoCliente;
        public Long vehiculoId;
        public int dias;
    }
}