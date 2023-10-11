package controladores;

import conexiondb.IConfiguracionBaseDatos;

public class ControladorPrincipal {
    private ControladorEmpleado controladorEmpleado;
    private ControladorMascota controladorMascota;
    private ControladorVoluntario controladorVoluntario;
    private ControladorFundacion controladorFundacion; 

    public ControladorPrincipal(IConfiguracionBaseDatos configuracion) {
        controladorEmpleado = new ControladorEmpleado(configuracion);
        controladorMascota = new ControladorMascota(configuracion);
        controladorVoluntario = new ControladorVoluntario(configuracion);
        controladorFundacion = new ControladorFundacion(configuracion); 
    }

    public ControladorEmpleado getControladorEmpleado() {
        return controladorEmpleado;
    }

    public ControladorMascota getControladorMascota() {
        return controladorMascota;
    }

    public ControladorVoluntario getControladorVoluntario() {
        return controladorVoluntario;
    }

    public ControladorFundacion getControladorFundacion() {
        return controladorFundacion; 
    }
}

