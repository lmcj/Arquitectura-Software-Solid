
package templateSolicitudAdopcion;

import dominio.Adoptante;
import dominio.MascotaAdoptada;

public abstract class SolicitudAdopcionTemplate {
    protected Adoptante adoptante;
    protected MascotaAdoptada mascotaAdoptada;
    protected String estado;

    public SolicitudAdopcionTemplate(Adoptante adoptante, MascotaAdoptada mascotaAdoptada) {
        this.adoptante = adoptante;
        this.mascotaAdoptada = mascotaAdoptada;
        this.estado = "Pendiente";
    }

    public final void realizarProcesoAdopcion() {
        validarAdopcion();
        aprobarAdopcion();
        rechazarAdopcion();
    }

    protected abstract void validarAdopcion();
    protected abstract void aprobarAdopcion();
    protected abstract void rechazarAdopcion();
}
