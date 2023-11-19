package InterfazDAO;

import DTO.DTOFundacion;
import java.util.List;

public interface IDAO_2<T> {

    List<T> listarSegunFundacion(DTOFundacion fundacion);
}
