package controladores;

import InterfazDAO.IDAO_1;
import InterfazDAO.IDAO_2;
import dominio.Fundacion;
import dominio.Voluntario;
import java.sql.SQLException;

import java.util.List;

public class ControladorVoluntario {

    private IDAO_1<Voluntario> controladorVoluntario;
    private IDAO_2<Voluntario> controladorVoluntario2;

    public ControladorVoluntario(IDAO_1<Voluntario> controladorVoluntario, IDAO_2<Voluntario> controladorVoluntario2) {
        this.controladorVoluntario = controladorVoluntario;
        this.controladorVoluntario2 = controladorVoluntario2;
    }

    public boolean crearVoluntario(Voluntario voluntario) {
        return controladorVoluntario.insertar(voluntario);
    }

    public List<Voluntario> obtenerTodasLasVoluntario() throws SQLException {
        return controladorVoluntario.listar();
    }

    public List<Voluntario> obtenerMascotasSegunFundacion(Fundacion fundacion) {
        return controladorVoluntario2.listarSegunFundacion(fundacion);
    }

    public boolean actualizarVoluntario(Voluntario voluntario) {
        return controladorVoluntario.editar(voluntario);
    }

    public Voluntario buscarVoluntario(int id) {
        Voluntario voluntario = new Voluntario();
        voluntario.setIdVoluntario(id);
        return controladorVoluntario.buscar(voluntario);
    }

    public boolean eliminarVoluntario(int id, Fundacion fundacion) {
        Voluntario voluntario = new Voluntario();
        voluntario.setIdVoluntario(id);
        voluntario.setFundacion(fundacion);
        return controladorVoluntario.eliminar(voluntario);
    }
}
