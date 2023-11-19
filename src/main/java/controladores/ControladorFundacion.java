package controladores;

import ConversionDTO.FundacionConverter;
import DAO.DAOFundacion;
import DTO.DTOFundacion;
import InterfazDAO.IDAO_1;
import dominio.Fundacion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControladorFundacion {

    private IDAO_1<Fundacion> controladorFundacion;
    private IDAO_1<Fundacion> daoFundacion;

    public ControladorFundacion(IDAO_1<Fundacion> controladorFundacion, IDAO_1<Fundacion> daoFundacion) {
        this.controladorFundacion = controladorFundacion;
        this.daoFundacion = daoFundacion;
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

    public DTOFundacion obtenerDTOFundaciones(int idFundacion) {
        
        DTOFundacion nuevaFundacion = new DTOFundacion(idFundacion);
        
        return nuevaFundacion;
    }

}
