package DAO;

import InterfazDAO.IDAO_1;
import InterfazDAO.IDAO_2;
import dominio.Fundacion;
import dominio.Voluntario;
import gestorTransacciones.GestorTransacciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import conexiondb.IConfiguracionBaseDatos;

public class DAOVoluntario implements IDAO_1<Voluntario>, IDAO_2<Voluntario> {

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private GestorTransacciones gestorTransacciones;
    private final IConfiguracionBaseDatos iConfiguracionBaseDatos;

    public DAOVoluntario(IConfiguracionBaseDatos iConfiguracionBaseDatos) {
        this.iConfiguracionBaseDatos = iConfiguracionBaseDatos;
    }

    @Override
    public boolean insertar(Voluntario voluntario) {
        String sql = "INSERT INTO mydb.voluntarios (nombre, telefono, correo_electronico, habilidades, disponibilidad, Fundacion_idFundacion) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, voluntario.getNombre());
            preparedStatement.setInt(2, voluntario.getTelefono());
            preparedStatement.setString(3, voluntario.getCorreo_electronico());
            preparedStatement.setString(4, voluntario.getHabilidades());
            preparedStatement.setString(5, voluntario.getDisponibilidad());
            preparedStatement.setInt(6, voluntario.getFundacion().getIdFundacion());

            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE HA CREADO EL VOLUNTARIO CON ÉXITO");
                return true;
            } else {
                gestorTransacciones.deshacerTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "NO SE HA CREADO EL VOLUNTARIO CON ÉXITO");
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
    public List<Voluntario> listar() throws SQLException {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.voluntarios";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Voluntario voluntario = new Voluntario();
                voluntario.setIdVoluntario(resultSet.getInt("idVoluntarios"));
                voluntario.setNombre(resultSet.getString("nombre"));
                voluntario.setDireccion(resultSet.getString("direccion"));
                voluntario.setCorreo_electronico(resultSet.getString("correo_electronico"));
                voluntario.setHabilidades(resultSet.getString("habilidades"));
                voluntario.setDisponibilidad(resultSet.getString("disponibilidad"));
                voluntario.setTelefono(resultSet.getInt("telefono"));
                lista.add(voluntario);
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
    public List<Voluntario> listarSegunFundacion(Fundacion fundacion) {
        List<Voluntario> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.voluntarios WHERE Fundacion_idFundacion = ?";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, fundacion.getIdFundacion());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Voluntario voluntario = new Voluntario();
                voluntario.setIdVoluntario(resultSet.getInt("idVoluntarios"));
                voluntario.setNombre(resultSet.getString("nombre"));
                voluntario.setDireccion(resultSet.getString("direccion"));
                voluntario.setCorreo_electronico(resultSet.getString("correo_electronico"));
                voluntario.setHabilidades(resultSet.getString("habilidades"));
                voluntario.setDisponibilidad(resultSet.getString("disponibilidad"));
                voluntario.setTelefono(resultSet.getInt("telefono"));
                voluntario.setFundacion(fundacion);
                lista.add(voluntario);
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
    public boolean editar(Voluntario voluntario) {
        String sql = "UPDATE mydb.voluntarios SET nombre=?, telefono=?, correo_electronico=?, habilidades=?, disponibilidad=? WHERE idVoluntarios=?";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, voluntario.getNombre());
            preparedStatement.setInt(2, voluntario.getTelefono());
            preparedStatement.setString(3, voluntario.getCorreo_electronico());
            preparedStatement.setString(4, voluntario.getHabilidades());
            preparedStatement.setString(5, voluntario.getDisponibilidad());
            preparedStatement.setInt(6, voluntario.getIdVoluntario());

            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE ACTUALIZARON DATOS");
                return true;
            } else {
                gestorTransacciones.deshacerTransaccion(conexion);
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
    public Voluntario buscar(Voluntario voluntario) {
        String sql = "SELECT * FROM mydb.voluntarios WHERE idVoluntarios=?; ";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, voluntario.getIdVoluntario());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                voluntario.setIdVoluntario(resultSet.getInt("idVoluntarios"));
                voluntario.setNombre(resultSet.getString("nombre"));
                voluntario.setDireccion(resultSet.getString("direccion"));
                voluntario.setCorreo_electronico(resultSet.getString("correo_electronico"));
                voluntario.setHabilidades(resultSet.getString("habilidades"));
                voluntario.setTelefono(resultSet.getInt("telefono"));
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
            System.out.println("Error al buscar datos");
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
        return voluntario;
    }

    @Override
    public boolean eliminar(Voluntario voluntario) {
        String sql = "DELETE FROM mydb.voluntarios WHERE idVoluntarios= ? AND Fundacion_idFundacion = ?";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, voluntario.getIdVoluntario());
            preparedStatement.setInt(2, voluntario.getFundacion().getIdFundacion());

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
