package templateProcesoDonar;

import dominio.Donante;
import dominio.EventoAdopcion;

public class ProcesoDonacionEvento extends ProcesoDonarTemplate {
    private EventoAdopcion evento;

    public ProcesoDonacionEvento(Donante donante, double cantidad, String metodoPago, EventoAdopcion evento) {
        super(donante, cantidad, metodoPago);
        this.evento = evento;
    }

    @Override
    protected void validarDonacion() {
        System.out.println("Validando donación evento...");
    }

    @Override
    protected void procesarDonacion() {
        System.out.println("Procesando donación evento...");
    }

    @Override
    protected void confirmarDonacion() {
        System.out.println("Confirmación de donación evento...");
    }
}
