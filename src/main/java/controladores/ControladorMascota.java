package controladores;

import DTO.DTOFundacion;
import InterfazDAO.IDAO_1;
import InterfazDAO.IDAO_2;
import dominio.Fundacion;
import dominio.Mascota;
import java.sql.SQLException;

import java.util.List;

public class ControladorMascota {

    private IDAO_1<Mascota> controladorMascota;
    private IDAO_2<Mascota> controladorMascota2;

    public ControladorMascota(IDAO_1<Mascota> controladorMascota, IDAO_2<Mascota> controladorMascota2) {
        this.controladorMascota = controladorMascota;
        this.controladorMascota2 = controladorMascota2;
    }

    public boolean crearMascota(Mascota mascota) {
        return controladorMascota.insertar(mascota);
    }

    public List<Mascota> obtenerTodasLasMascota() throws SQLException {
        return controladorMascota.listar();
    }

    public List<Mascota> obtenerMascotasSegunFundacion(DTOFundacion fundacion) {
        return controladorMascota2.listarSegunFundacion(fundacion);
    }

    public boolean actualizarMascota(Mascota mascota) {
        return controladorMascota.editar(mascota);
    }

    public Mascota buscarMascota(int id) {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(id);
        return controladorMascota.buscar(mascota);
    }

    public boolean eliminarMascota(int id, DTOFundacion fundacion) {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(id);
        mascota.setFundacion(fundacion);
        return controladorMascota.eliminar(mascota);
    }
}
