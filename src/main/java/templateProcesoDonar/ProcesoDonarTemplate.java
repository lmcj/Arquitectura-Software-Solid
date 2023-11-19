package templateProcesoDonar;

import dominio.Donante;

public abstract class ProcesoDonarTemplate {

    protected Donante donante;
    protected double cantidad;
    protected String metodoPago;

    public ProcesoDonarTemplate(Donante donante, double cantidad, String metodoPago) {
        this.donante = donante;
        this.cantidad = cantidad;
        this.metodoPago = metodoPago;
    }

    protected abstract void validarDonacion();
    protected abstract void procesarDonacion();
    protected abstract void confirmarDonacion();

    public final void realizarProcesoDonacion() {
        validarDonacion();
        procesarDonacion();
        confirmarDonacion();
    }
}
