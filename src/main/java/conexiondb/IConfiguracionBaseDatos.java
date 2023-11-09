package conexiondb;

import java.sql.Connection;

public interface IConfiguracionBaseDatos {

    Connection obtenerConexion();

    void desconectar();
}
