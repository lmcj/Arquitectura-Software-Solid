
package templateSolicitudAdopcion;

import dominio.Adoptante;
import dominio.MascotaAdoptada;

public class SolicitudAdopcionDirecta extends SolicitudAdopcionTemplate {
    public SolicitudAdopcionDirecta(Adoptante adoptante, MascotaAdoptada mascotaAdoptada) {
        super(adoptante, mascotaAdoptada);
    }

    @Override
    protected void validarAdopcion() {
        System.out.println("Validando solicitud de adopción directa");
    }

    @Override
    protected void aprobarAdopcion() {
        System.out.println("Aprobando solicitud de adopción directa");
    }

    @Override
    protected void rechazarAdopcion() {
        System.out.println("Rechazando solicitud de adopción directa");
    }
}

