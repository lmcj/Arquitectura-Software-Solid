package controladores;

import ConversionDTO.FundacionConverter;
import DTO.DTOFundacion;
import InterfazDAO.IDAO_1;
import dominio.Fundacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControladorFundacion {

    private IDAO_1<Fundacion> controladorFundacion;

    public ControladorFundacion(IDAO_1<Fundacion> controladorFundacion) {
        this.controladorFundacion = controladorFundacion;
    }

    public boolean crearFundacion(DTOFundacion dtoFundacion) {
        Fundacion fundacion = FundacionConverter.convertirDTOaFundacion(dtoFundacion);
        return controladorFundacion.insertar(fundacion);
    }

    public List<DTOFundacion> obtenerTodasLasFundaciones() throws SQLException {
        List<Fundacion> fundaciones = controladorFundacion.listar();
        List<DTOFundacion> dtoFundaciones = new ArrayList<>();
        for (Fundacion fundacion : fundaciones) {
            DTOFundacion dtoFundacion = FundacionConverter.convertirFundacionaDTO(fundacion);
            dtoFundaciones.add(dtoFundacion);
        }
        return dtoFundaciones;
    }

   public boolean actualizarFundacion(DTOFundacion dtoFundacion) {
        Fundacion fundacion = FundacionConverter.convertirDTOaFundacion(dtoFundacion);
        return controladorFundacion.editar(fundacion);
    }

    public DTOFundacion buscarFundacion(int id) {
        Fundacion fundacion = new Fundacion();
        fundacion.setIdFundacion(id);
        fundacion = controladorFundacion.buscar(fundacion);
        if (fundacion != null) {
            return FundacionConverter.convertirFundacionaDTO(fundacion);
        }
        return null;
    }
    public boolean eliminarFundacion(int id) {
        Fundacion fundacion = new Fundacion();
        fundacion.setIdFundacion(id);
        return controladorFundacion.eliminar(fundacion);
    }
}
