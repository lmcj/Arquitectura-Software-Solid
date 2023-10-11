
package conexiondb;

public class ConfiguracionMySQL implements IConfiguracionBaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    @Override
    public String obtenerURL() {
        return URL;
    }

    @Override
    public String obtenerUsuario() {
        return USUARIO;
    }

    @Override
    public String obtenerContrasena() {
        return CONTRASENA;
    }
}


