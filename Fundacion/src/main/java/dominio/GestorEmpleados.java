package dominio;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {

    private List<Empleado> empleados = new ArrayList<>();

    public Empleado agregarEmpleado(String nombre, String cargo, String funciones, Fundacion fundacion) {
        Empleado empleado = new Empleado(nombre, cargo, funciones, fundacion);
        empleados.add(empleado);
        return empleado;
    }

    public void mostrarEmpleados(Fundacion fundacion) {
        System.out.println("Empleados de la fundacion " + fundacion.getNombre() + ":");
        for (Empleado empleado : empleados) {
            if (empleado.getFundacion().equals(fundacion)) {
                System.out.println("Nombre: " + empleado.getNombre() + ", Cargo: " + empleado.getCargo() + ", Funciones: " + empleado.getFunciones());
            }
        }
    }

    public boolean editarEmpleado(Empleado empleado, String nuevoNombre, String nuevoCargo, String nuevasFunciones) {
        for (Empleado emp : empleados) {
            if (emp.equals(empleado)) {
                emp.setNombre(nuevoNombre);
                emp.setCargo(nuevoCargo);
                emp.setFunciones(nuevasFunciones);
                return true;
            }
        }
        return false;
    }

    public void eliminarEmpleado(String nombre) {
        for (Empleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre)) {
                empleados.remove(empleado);
                break;
            }
        }
    }

}
