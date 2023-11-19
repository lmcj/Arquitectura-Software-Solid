package templateProcesoDonar;

import dominio.Donante;

public class ProcesoDonancionDirecta extends ProcesoDonarTemplate {

    public ProcesoDonancionDirecta(Donante donante, double cantidad, String metodoPago) {
        super(donante, cantidad, metodoPago);
    }

    @Override
    protected void validarDonacion() {
        System.out.println("Validando donación directa...");
    }

    @Override
    protected void procesarDonacion() {
        System.out.println("Procesando donación directa...");
    }

    @Override
    protected void confirmarDonacion() {
        System.out.println("Confirmación de donación directa...");
    }
}
