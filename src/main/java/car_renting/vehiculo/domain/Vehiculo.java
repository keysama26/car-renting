    package car_renting.vehiculo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String marca;
    private String modelo;
    private String tipo;
    private double precioPorDia;
    private boolean disponible;

    public Vehiculo() {
    }

    public Vehiculo(String nombre, String marca, String modelo,
                    String tipo, double precioPorDia,
                    boolean disponible) {
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.precioPorDia = precioPorDia;
        this.disponible = disponible;
    }

    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public double getPrecioPorDia() { return precioPorDia; }
    public void setPrecioPorDia(double precioPorDia) { this.precioPorDia = precioPorDia; }
    public boolean isDisponible() { return disponible; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}