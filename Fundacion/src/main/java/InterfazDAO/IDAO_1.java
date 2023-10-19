package InterfazDAO;

import java.sql.SQLException;
import java.util.List;

public interface IDAO_1<T> {

    boolean insertar(T entidad);

    List<T> listar() throws SQLException;

    boolean editar(T entidad);

    T buscar(T entidad);

    boolean eliminar(T entidad);
}
