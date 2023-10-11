
package gestorTransacciones;

import java.sql.Connection;
import java.sql.SQLException;

public class GestorTransacciones {

    public void iniciarTransaccion(Connection conexion) throws SQLException {
        conexion.setAutoCommit(false);
    }

    public void confirmarTransaccion(Connection conexion) throws SQLException {
        conexion.commit();
    }

    public void deshacerTransaccion(Connection conexion) {
        try {
            conexion.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cerrarConexion(Connection conexion) {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.setAutoCommit(true); // Restaurar el modo de autocommit
                conexion.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
