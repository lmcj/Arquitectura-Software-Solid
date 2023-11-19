
package templateSolicitudAdopcion;

import dominio.Adoptante;
import dominio.EventoAdopcion;
import dominio.MascotaAdoptada;

public class SolicitudAdopcionEvento extends SolicitudAdopcionTemplate {
    private EventoAdopcion evento;

    public SolicitudAdopcionEvento(Adoptante adoptante, MascotaAdoptada mascotaAdoptada, EventoAdopcion evento) {
        super(adoptante, mascotaAdoptada);
        this.evento = evento;
    }

    @Override
    protected void validarAdopcion() {
        System.out.println("Validando solicitud de adopción para evento");
    }

    @Override
    protected void aprobarAdopcion() {
        System.out.println("Aprobando solicitud de adopción para evento");
    }

    @Override
    protected void rechazarAdopcion() {
        System.out.println("Rechazando solicitud de adopción para evento");
    }
}
