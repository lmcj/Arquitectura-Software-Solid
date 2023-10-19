package controladores;

import InterfazDAO.IDAO_1;
import InterfazDAO.IDAO_2;
import dominio.Empleado;
import dominio.Fundacion;
import java.sql.SQLException;
import java.util.List;

public class ControladorEmpleado {

    private IDAO_1<Empleado> controladorEmpleado;
    private IDAO_2<Empleado> controladorEmpleado2;

    public ControladorEmpleado(IDAO_1<Empleado> controladorFundacion, IDAO_2<Empleado> controladorFundacion2) {
        this.controladorEmpleado = controladorFundacion;
        this.controladorEmpleado2 = controladorFundacion2;
    }

    public boolean crearEmpleado(Empleado empleado) {
        return controladorEmpleado.insertar(empleado);
    }

    public List<Empleado> obtenerTodasLasEmpleado() throws SQLException {
        return controladorEmpleado.listar();
    }

    public List<Empleado> obtenerEmpleadosSegunFundacion(Fundacion fundacion) {
        return controladorEmpleado2.listarSegunFundacion(fundacion);
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        return controladorEmpleado.editar(empleado);
    }

    public Empleado buscarEmpleado(int id) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id);
        return controladorEmpleado.buscar(empleado);
    }

    public boolean eliminarEmpleado(int id, Fundacion fundacion) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id);
        empleado.setFundacion(fundacion);
        return controladorEmpleado.eliminar(empleado);
    }
}
