package ConversionDTO;

import DTO.DTOFundacion;
import dominio.Fundacion;

public class FundacionConverter {

    public static Fundacion convertirDTOaFundacion(DTOFundacion dtoFundacion) {
        Fundacion fundacion = new Fundacion();
        fundacion.setIdFundacion(dtoFundacion.getIdFundacion());
        fundacion.setNombre(dtoFundacion.getNombre());
        fundacion.setTelefono(dtoFundacion.getTelefono());
        fundacion.setDireccion(dtoFundacion.getDireccion());
        fundacion.setCorreo_electronico(dtoFundacion.getCorreo_electronico());
        fundacion.setMision(dtoFundacion.getMision());
        return fundacion;
    }

    public static DTOFundacion convertirFundacionaDTO(Fundacion fundacion) {
        DTOFundacion dtoFundacion = new DTOFundacion(
                fundacion.getIdFundacion(),
                fundacion.getNombre(),
                fundacion.getTelefono(),
                fundacion.getDireccion(),
                fundacion.getCorreo_electronico(),
                fundacion.getMision()
        );
        return dtoFundacion;
    }
}
