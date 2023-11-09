package conexiondb;

public class ConexionFactory {

    public static IConfiguracionBaseDatos obtenerConexion() {
        return AdminDB.obtenerInstancia();
    }
}
