package controladores;

import DAO.DAOFundacion;
import dominio.Fundacion;
import conexiondb.IConfiguracionBaseDatos;
import java.sql.SQLException;
import java.util.List;

public class ControladorFundacion {

    private DAOFundacion daoFundacion;

    public ControladorFundacion(IConfiguracionBaseDatos configuracion) {
        daoFundacion = new DAOFundacion(configuracion);
    }

    public boolean crearFundacion(Fundacion fundacion) {
        return daoFundacion.insertar(fundacion);
    }

    public List<Fundacion> obtenerTodasLasFundaciones() throws SQLException {
        return daoFundacion.listar();
    }

    public boolean actualizarFundacion(Fundacion fundacion) {
        return daoFundacion.editar(fundacion);
    }

    public Fundacion buscarFundacion(int id) {
        Fundacion fundacion = new Fundacion();
        fundacion.setIdFundacion(id);
        return daoFundacion.buscar(fundacion);
    }

    public boolean eliminarFundacion(int id) {
        Fundacion fundacion = new Fundacion();
        fundacion.setIdFundacion(id);
        return daoFundacion.eliminar(fundacion);
    }
}

