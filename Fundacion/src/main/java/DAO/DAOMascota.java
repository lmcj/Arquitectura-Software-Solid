package DAO;

import InterfazDAO.IDAO_1;
import InterfazDAO.IDAO_2;
import dominio.Fundacion;
import dominio.Mascota;
import gestorTransacciones.GestorTransacciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import conexiondb.IConfiguracionBaseDatos;

public class DAOMascota implements IDAO_1<Mascota>, IDAO_2<Mascota> {

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private GestorTransacciones gestorTransacciones;
    private final IConfiguracionBaseDatos iConfiguracionBaseDatos;

    public DAOMascota(IConfiguracionBaseDatos iConfiguracionBaseDatos) {
        this.iConfiguracionBaseDatos = iConfiguracionBaseDatos;
    }

    @Override
    public boolean insertar(Mascota mascota) {
        String sql = "INSERT INTO mydb.mascotas (nombre, especie, raza, genero, edad, color, estado_salud, disponible, adoptante) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, mascota.getNombre());
            preparedStatement.setString(2, mascota.getEspecie());
            preparedStatement.setString(3, mascota.getRaza());
            preparedStatement.setString(4, mascota.getGenero());
            preparedStatement.setInt(5, mascota.getEdad());
            preparedStatement.setString(6, mascota.getColor());
            preparedStatement.setString(7, mascota.getEstado_salud());
            preparedStatement.setBoolean(8, mascota.getDisponible());
            preparedStatement.setInt(9, mascota.getFundacion().getIdFundacion());

            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE HA CREADO LA MASCOTA CON ÉXITO");
                return true;
            } else {
                gestorTransacciones.deshacerTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "NO SE HA CREADO LA MASCOTA CON ÉXITO");
                return false;
            }
        } catch (SQLException e) {
            gestorTransacciones.deshacerTransaccion(conexion);
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA GUARDAR DATOS");
            System.out.println("Error al guardar datos");
            return false;
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
    }

    @Override
    public List<Mascota> listar() throws SQLException {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.mascotas";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mascota m = new Mascota();
                m.setIdMascota(resultSet.getInt("idMascotas"));
                m.setNombre(resultSet.getString("nombre"));
                m.setEspecie(resultSet.getString("especie"));
                m.setRaza(resultSet.getString("raza"));
                m.setGenero(resultSet.getString("genero"));
                m.setEdad(resultSet.getInt("edad"));
                m.setColor(resultSet.getString("color"));
                m.setEstado_salud(resultSet.getString("estado_salud"));
                m.setDisponible(resultSet.getBoolean("disponible"));
                lista.add(m);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
        return lista;
    }

    @Override
    public List<Mascota> listarSegunFundacion(Fundacion fundacion) {
        List<Mascota> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.mascotas WHERE Fundacion_idFundacion = ?";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, fundacion.getIdFundacion());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Mascota mascota = new Mascota();
                mascota.setIdMascota(resultSet.getInt("idMascotas"));
                mascota.setNombre(resultSet.getString("nombre"));
                mascota.setEspecie(resultSet.getString("especie"));
                mascota.setRaza(resultSet.getString("raza"));
                mascota.setGenero(resultSet.getString("genero"));
                mascota.setEdad(resultSet.getInt("edad"));
                mascota.setColor(resultSet.getString("color"));
                mascota.setEstado_salud(resultSet.getString("estado_salud"));
                mascota.setDisponible(resultSet.getBoolean("disponible"));
                mascota.setFundacion(fundacion);
                lista.add(mascota);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos" + e);
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
        return lista;
    }

    @Override
    public boolean editar(Mascota mascota) {
        String sql = "UPDATE mydb.mascotas SET nombre = ?, especie = ?, raza = ?, genero = ?, edad = ?, color = ?, estado_salud = ?, disponible = ? WHERE idMascotas = ?";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, mascota.getNombre());
            preparedStatement.setString(2, mascota.getEspecie());
            preparedStatement.setString(3, mascota.getRaza());
            preparedStatement.setString(4, mascota.getGenero());
            preparedStatement.setInt(5, mascota.getEdad());
            preparedStatement.setString(6, mascota.getColor());
            preparedStatement.setString(7, mascota.getEstado_salud());
            preparedStatement.setBoolean(8, mascota.getDisponible());
            preparedStatement.setInt(9, mascota.getIdMascota());

            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE ACTUALIZARON DATOS");
                return true;
            } else {
                gestorTransacciones.deshacerTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "NO SE HA ACTUALIZARON DATOS");
                return false;
            }
        } catch (SQLException e) {
            gestorTransacciones.deshacerTransaccion(conexion);
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA GUARDAR DATOS");
            System.out.println("Error al guardar datos");
            return false;
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
    }

    @Override
    public Mascota buscar(Mascota mascota) {
        String sql = "SELECT * FROM mydb.mascotas WHERE idMascotas = ?;";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, mascota.getIdMascota());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                mascota.setIdMascota(resultSet.getInt("idMascotas"));
                mascota.setNombre(resultSet.getString("nombre"));
                mascota.setEspecie(resultSet.getString("especie"));
                mascota.setRaza(resultSet.getString("raza"));
                mascota.setGenero(resultSet.getString("genero"));
                mascota.setEdad(resultSet.getInt("edad"));
                mascota.setColor(resultSet.getString("color"));
                mascota.setEstado_salud(resultSet.getString("estado_salud"));
                mascota.setDisponible(resultSet.getBoolean("disponible"));
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
            System.out.println("Error al buscar datos");
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
        return mascota;
    }

    @Override
    public boolean eliminar(Mascota mascota) {
        String sql = "DELETE FROM mydb.mascotas WHERE idMascotas = ? AND Fundacion_idFundacion = ?";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, mascota.getIdMascota());
            preparedStatement.setInt(2, mascota.getFundacion().getIdFundacion());

            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE LOGRÓ ELIMINAR");
                return true;
            } else {
                gestorTransacciones.deshacerTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "ID NO ENCONTRADO");
                return false;
            }
        } catch (SQLException e) {
            gestorTransacciones.deshacerTransaccion(conexion);
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ELIMINAR");
            System.out.println("Error al eliminar datos");
            return false;
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
    }
}
