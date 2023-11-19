package DAO;

import DTO.DTOFundacion;
import dominio.Fundacion;
import gestorTransacciones.GestorTransacciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import InterfazDAO.IDAO_1;
import conexiondb.IConfiguracionBaseDatos;

public class DAOFundacion implements IDAO_1<DTOFundacion> {
    
    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private GestorTransacciones gestorTransacciones;
    private final IConfiguracionBaseDatos iConfiguracionBaseDatos;

    public DAOFundacion(IConfiguracionBaseDatos iConfiguracionBaseDatos) {
        this.iConfiguracionBaseDatos = iConfiguracionBaseDatos;
        this.gestorTransacciones = new GestorTransacciones();
    }

    @Override
    public boolean insertar(DTOFundacion fundacion) {
        String sql = "INSERT INTO fundacion (nombre, telefono, direccion, mision, correo_electronico) VALUES (?, ?, ?, ?, ?)";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, fundacion.getNombre());
            preparedStatement.setInt(2, fundacion.getTelefono());
            preparedStatement.setString(3, fundacion.getDireccion());
            preparedStatement.setString(4, fundacion.getMision());
            preparedStatement.setString(5, fundacion.getCorreo_electronico());

            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE LOGRÓ GUARDAR DATOS");
                return true;
            } else {
                gestorTransacciones.deshacerTransaccion(conexion);
                return false;
            }
        } catch (SQLException e) {
            gestorTransacciones.deshacerTransaccion(conexion);
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRÓ GUARDAR DATOS");
            System.out.println("Error al guardar datos");
            return false;
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
    }

    @Override
    public List<DTOFundacion> listar() throws SQLException {
        List<DTOFundacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM fundacion";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                DTOFundacion fundacion = new DTOFundacion();
                fundacion.setIdFundacion(resultSet.getInt("idFundacion"));
                fundacion.setNombre(resultSet.getString("nombre"));
                fundacion.setTelefono(resultSet.getInt("telefono"));
                fundacion.setDireccion(resultSet.getString("direccion"));
                fundacion.setMision(resultSet.getString("mision"));
                fundacion.setCorreo_electronico(resultSet.getString("correo_electronico"));
                lista.add(fundacion);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "NO SE LOGRA MOSTRAR DATOS");
            System.out.println("Error al mostrar datos " + e);
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
        return lista;
    }

    @Override
    public boolean editar(DTOFundacion fundacion) {
        String sql = "UPDATE fundacion SET nombre=?,telefono=?,direccion=?, mision=?, correo_electronico=? WHERE idfundacion=? ";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(6, fundacion.getIdFundacion());
            preparedStatement.setString(1, fundacion.getNombre());
            preparedStatement.setInt(2, fundacion.getTelefono());
            preparedStatement.setString(3, fundacion.getDireccion());
            preparedStatement.setString(4, fundacion.getMision());
            preparedStatement.setString(5, fundacion.getCorreo_electronico());
            int n = preparedStatement.executeUpdate();
            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE HA ACTUALIZADO CON EXITO");
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
    public DTOFundacion buscar(DTOFundacion fundacion) {
        String sql = "SELECT * FROM fundacion WHERE idFundacion=?; ";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, fundacion.getIdFundacion());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                fundacion.setIdFundacion(resultSet.getInt("idFundacion"));
                fundacion.setNombre(resultSet.getString("nombre"));
                fundacion.setTelefono(resultSet.getInt("telefono"));
                fundacion.setDireccion(resultSet.getString("direccion"));
                fundacion.setMision(resultSet.getString("mision"));
                fundacion.setCorreo_electronico(resultSet.getString("correo_electronico"));
                System.out.println(fundacion.toString());
            } else {
                JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            System.out.println("Error al buscar datos");
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
        return fundacion;
    }

    @Override
    public boolean eliminar(DTOFundacion fundacion) {
        String sql = "DELETE FROM fundacion WHERE idFundacion=?";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, fundacion.getIdFundacion());
            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                conexion.commit();
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
