package controladores;

import DAO.DAOVoluntario;
import dominio.Fundacion;
import dominio.Voluntario;
import conexiondb.IConfiguracionBaseDatos;
import java.sql.SQLException;

import java.util.List;

public class ControladorVoluntario {

    private DAOVoluntario daoVoluntario;

    public ControladorVoluntario(IConfiguracionBaseDatos configuracion) {
        daoVoluntario = new DAOVoluntario(configuracion);
    }

    public boolean crearVoluntario(Voluntario voluntario) {
        // Lógica para crear un voluntario (puede incluir validaciones)
        return daoVoluntario.insertar(voluntario);
    }

    public List<Voluntario> obtenerTodosLosVoluntarios() throws SQLException {
        return daoVoluntario.listar();
    }

    public List<Voluntario> obtenerVoluntariosSegunFundacion(Fundacion fundacion) {
        return daoVoluntario.listarSegunFundacion(fundacion);
    }

    public boolean actualizarVoluntario(Voluntario voluntario) {
        // Lógica para actualizar un voluntario (puede incluir validaciones)
        return daoVoluntario.editar(voluntario);
    }

    public Voluntario buscarVoluntario(int id) {
        Voluntario voluntario = new Voluntario();
        voluntario.setIdVoluntario(id);
        return daoVoluntario.buscar(voluntario);
    }

    public boolean eliminarVoluntario(int id, Fundacion fundacion) {
        Voluntario voluntario = new Voluntario();
        voluntario.setIdVoluntario(id);
        voluntario.setFundacion(fundacion);
        return daoVoluntario.eliminar(voluntario);
    }
}
