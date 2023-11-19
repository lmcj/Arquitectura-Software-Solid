package controladores;

import DTO.DTOEmpleado;
import DTO.DTOFundacion;
import InterfazDAO.IDAO_1;
import InterfazDAO.IDAO_2;
import dominio.Empleado;
import dominio.Fundacion;
import java.sql.SQLException;
import java.util.List;

public class ControladorEmpleado {

    private IDAO_1<DTOEmpleado> controladorEmpleado;
    private IDAO_2<DTOEmpleado> controladorEmpleado2;

    public ControladorEmpleado(IDAO_1<DTOEmpleado> controladorFundacion, IDAO_2<DTOEmpleado> controladorFundacion2) {
        this.controladorEmpleado = controladorFundacion;
        this.controladorEmpleado2 = controladorFundacion2;
    }

    public boolean crearEmpleado(DTOEmpleado empleado) {
        return controladorEmpleado.insertar(empleado);
    }

    public List<DTOEmpleado> obtenerTodasLasEmpleado() throws SQLException {
        return controladorEmpleado.listar();
    }

    public List<DTOEmpleado> obtenerEmpleadosSegunFundacion(DTOFundacion fundacion) {
        return controladorEmpleado2.listarSegunFundacion(fundacion);
    }

    public boolean actualizarEmpleado(DTOEmpleado empleado) {
        return controladorEmpleado.editar(empleado);
    }

    public DTOEmpleado buscarEmpleado(int id) {
        DTOEmpleado empleado = new DTOEmpleado();
        empleado.setIdEmpleado(id);
        return controladorEmpleado.buscar(empleado);
    }

    public boolean eliminarEmpleado(int id, DTOFundacion fundacion) {
        DTOEmpleado empleado = new DTOEmpleado();
        empleado.setIdEmpleado(id);
        empleado.setFundacion(fundacion);
        return controladorEmpleado.eliminar(empleado);
    }
}
