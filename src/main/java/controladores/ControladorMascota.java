package controladores;

import DAO.DAOMascota;
import dominio.Fundacion;
import dominio.Mascota;
import conexiondb.IConfiguracionBaseDatos;
import java.sql.SQLException;

import java.util.List;

public class ControladorMascota {

    private DAOMascota daoMascota;

    public ControladorMascota(IConfiguracionBaseDatos configuracion) {
        daoMascota = new DAOMascota(configuracion);
    }

    public boolean crearMascota(Mascota mascota) {
        // Lógica para crear una mascota (puede incluir validaciones)
        return daoMascota.insertar(mascota);
    }

    public List<Mascota> obtenerTodasLasMascotas() throws SQLException {
        return daoMascota.listar();
    }

    public List<Mascota> obtenerMascotasSegunFundacion(Fundacion fundacion) {
        return daoMascota.listarSegunFundacion(fundacion);
    }

    public boolean actualizarMascota(Mascota mascota) {
        // Lógica para actualizar una mascota (puede incluir validaciones)
        return daoMascota.editar(mascota);
    }

    public Mascota buscarMascota(int id) {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(id);
        return daoMascota.buscar(mascota);
    }

    public boolean eliminarMascota(int id, Fundacion fundacion) {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(id);
        mascota.setFundacion(fundacion);
        return daoMascota.eliminar(mascota);
    }
}
