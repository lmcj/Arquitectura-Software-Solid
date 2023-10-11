
package conexiondb;

import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DAOGenerico{
    public IConfiguracionBaseDatos configuracion;
    
    public DAOGenerico(IConfiguracionBaseDatos configuracion) {
        this.configuracion = configuracion;
    }

    protected Connection obtenerConexion() throws MySQLQueryInterruptedException, SQLException {
        String url = configuracion.obtenerURL();
        String usuario = configuracion.obtenerUsuario();
        String contrasena = configuracion.obtenerContrasena();
        return DriverManager.getConnection(url, usuario, contrasena);
    }
}
