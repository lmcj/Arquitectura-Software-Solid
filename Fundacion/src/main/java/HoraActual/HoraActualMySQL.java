package HoraActual;

import conexiondb.AdminDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoraActualMySQL implements HoraActualDAO {

    @Override
    public String horaActual() {
        String currentTime = null;
        try (Connection connection = AdminDB.obtenerInstancia().obtenerConexion()) {
            String sql = "SELECT NOW()";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        currentTime = resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoraActualMySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentTime;
    }
}
