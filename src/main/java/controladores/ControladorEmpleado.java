package controladores;

import DAO.DAOEmpleado;
import dominio.Empleado;
import dominio.Fundacion;
import conexiondb.IConfiguracionBaseDatos;
import java.sql.SQLException;
import java.util.List;

public class ControladorEmpleado {

    private DAOEmpleado daoEmpleado;

    public ControladorEmpleado(IConfiguracionBaseDatos configuracion) {
        daoEmpleado = new DAOEmpleado(configuracion);
    }

    public boolean crearEmpleado(Empleado empleado) {
        // Lógica para crear un empleado (puede incluir validaciones)
        return daoEmpleado.insertar(empleado);
    }

    public List<Empleado> obtenerTodosLosEmpleados() throws SQLException {
        return daoEmpleado.listar();
    }

    public List<Empleado> obtenerEmpleadosSegunFundacion(Fundacion fundacion) {
        return daoEmpleado.listarSegunFundacion(fundacion);
    }

    public boolean actualizarEmpleado(Empleado empleado) {
        // Lógica para actualizar un empleado (puede incluir validaciones)
        return daoEmpleado.editar(empleado);
    }

    public Empleado buscarEmpleado(int id) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id);
        return daoEmpleado.buscar(empleado);
    }

    public boolean eliminarEmpleado(int id, Fundacion fundacion) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(id);
        empleado.setFundacion(fundacion);
        return daoEmpleado.eliminar(empleado);
    }
}
