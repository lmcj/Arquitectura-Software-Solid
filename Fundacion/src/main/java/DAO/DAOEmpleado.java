package DAO;

import dominio.Empleado;
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
import InterfazDAO.IDAO_2;
import conexiondb.IConfiguracionBaseDatos;

public class DAOEmpleado implements IDAO_1<Empleado>, IDAO_2<Empleado> {

    private Connection conexion;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private GestorTransacciones gestorTransacciones;
    private final IConfiguracionBaseDatos iConfiguracionBaseDatos;

    public DAOEmpleado(IConfiguracionBaseDatos iConfiguracionBaseDatos) {
        this.iConfiguracionBaseDatos = iConfiguracionBaseDatos;
    }

    @Override
    public boolean insertar(Empleado empleado) {
        String sql = "INSERT INTO mydb.empleados (nombre, cargo, funciones, Fundacion_idFundacion) VALUES (?, ?, ?, ?)";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getCargo());
            preparedStatement.setString(3, empleado.getFunciones());
            preparedStatement.setInt(4, empleado.getFundacion().getIdFundacion());

            int n = preparedStatement.executeUpdate();

            if (n != 0) {
                gestorTransacciones.confirmarTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "SE HA CREADO EL EMPLEADO CON ÉXITO");
                return true;
            } else {
                gestorTransacciones.deshacerTransaccion(conexion);
                JOptionPane.showMessageDialog(null, "NO SE HA CREADO EL EMPLEADO CON ÉXITO");
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
    public List<Empleado> listar() throws SQLException {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.empleados";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleados"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setCargo(resultSet.getString("cargo"));
                empleado.setFunciones(resultSet.getString("funciones"));
                lista.add(empleado);
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
    public List<Empleado> listarSegunFundacion(Fundacion fundacion) {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM mydb.empleados WHERE Fundacion_idFundacion = ?";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, fundacion.getIdFundacion());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setIdEmpleado(resultSet.getInt("idEmpleados"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setCargo(resultSet.getString("cargo"));
                empleado.setFunciones(resultSet.getString("funciones"));
                empleado.setFundacion(fundacion);
                lista.add(empleado);
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
    public boolean editar(Empleado empleado) {
        String sql = "UPDATE mydb.empleados SET nombre=?, cargo=?, funciones=? WHERE idEmpleados=?";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, empleado.getNombre());
            preparedStatement.setString(2, empleado.getCargo());
            preparedStatement.setString(3, empleado.getFunciones());
            preparedStatement.setInt(4, empleado.getIdEmpleado());

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
    public Empleado buscar(Empleado empleado) {
        String sql = "SELECT * FROM mydb.empleados WHERE idEmpleado=?; ";
        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, empleado.getIdEmpleado());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                empleado.setIdEmpleado(resultSet.getInt("idEmpleado"));
                empleado.setNombre(resultSet.getString("nombre"));
                empleado.setCargo(resultSet.getString("cargo"));
                empleado.setFunciones(resultSet.getString("funciones"));
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            JOptionPane.showMessageDialog(null, "NO SE LOGRA ENCONTRAR DATOS");
            System.out.println("Error al buscar datos");
        } finally {
            gestorTransacciones.cerrarConexion(conexion);
        }
        return empleado;
    }

    @Override
    public boolean eliminar(Empleado empleado) {
        String sql = "DELETE FROM mydb.empleados WHERE idEmpleados = ? AND Fundacion_idFundacion = ?";

        try {
            conexion = iConfiguracionBaseDatos.obtenerConexion();
            gestorTransacciones.iniciarTransaccion(conexion);

            preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, empleado.getIdEmpleado());
            preparedStatement.setInt(2, empleado.getFundacion().getIdFundacion());

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
