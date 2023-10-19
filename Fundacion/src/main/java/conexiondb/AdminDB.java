package conexiondb;

import HoraActual.HoraActualDAO;
import HoraActual.HoraActualMySQL;
import HoraActual.HoraActualPostgreSQL;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminDB implements IConfiguracionBaseDatos {

    private String url;
    private String user;
    private String password;
    private String driver;
    private Connection conexion;
    private static AdminDB instancia;

    private AdminDB() {
        configuracion();
    }

    public static AdminDB obtenerInstancia() {
        if (instancia == null) {
            instancia = new AdminDB();
        }
        return instancia;
    }

    private void configuracion() {
        Properties propiedades = new Properties();
        try (InputStream entrada = getClass().getClassLoader().getResourceAsStream("DataBase.properties")) {
            if (entrada == null) {
                throw new FileNotFoundException("El archivo no se encuentra");
            }
            propiedades.load(entrada);
            url = propiedades.getProperty("url");
            user = propiedades.getProperty("user");
            password = propiedades.getProperty("password");
            driver = propiedades.getProperty("driver");
        } catch (IOException e) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public Connection obtenerConexion() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, e);
            try {
                throw new SQLException("No se pudo conectar a la base de datos", e);
            } catch (SQLException ex1) {
                Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return conexion;
    }

    @Override
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            Logger.getLogger(AdminDB.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public HoraActualDAO obtenerHoraActualDAO() {
        switch (driver) {
            case "com.mysql.cj.jdbc.Driver":
                return (HoraActualDAO) new HoraActualMySQL();
            case "org.postgresql.Driver":
                return (HoraActualDAO) new HoraActualPostgreSQL();
            default:
                throw new UnsupportedOperationException("Driver de base de datos no soportado: " + driver);
        }
    }
}
