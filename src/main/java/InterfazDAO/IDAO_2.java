
package InterfazDAO;

import dominio.Fundacion;
import java.sql.SQLException;
import java.util.List;

public interface IDAO_2<T> {
    List<T> listarSegunFundacion(Fundacion fundacion);
}
