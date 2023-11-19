package HoraActual;

import conexiondb.AdminDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoraActualPostgreSQL implements HoraActualDAO {

    @Override
    public String horaActual() {
        String currentTime = null;
        try (Connection connection = AdminDB.obtenerInstancia().obtenerConexion()) {
            String sql = "SELECT CURRENT_TIMESTAMP";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        currentTime = resultSet.getString(1);
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoraActualPostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return currentTime;
    }
}
