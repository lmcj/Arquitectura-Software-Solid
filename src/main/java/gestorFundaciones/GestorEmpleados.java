package gestorFundaciones;

import DTO.DTOEmpleado;
import DTO.DTOFundacion;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {

    private List<DTOEmpleado> empleados = new ArrayList<>();

    public DTOEmpleado agregarEmpleado(String nombre, String cargo, String funciones, DTOFundacion fundacion) {
        DTOEmpleado empleado = new DTOEmpleado(nombre, cargo, funciones, fundacion);
        empleados.add(empleado);
        return empleado;
    }

    public void mostrarEmpleados(DTOFundacion fundacion) {
        System.out.println("Empleados de la fundacion " + fundacion.getNombre() + ":");
        for (DTOEmpleado empleado : empleados) {
            if (empleado.getFundacion().equals(fundacion)) {
                System.out.println("Nombre: " + empleado.getNombre() + ", Cargo: " + empleado.getCargo() + ", Funciones: " + empleado.getFunciones());
            }
        }
    }

    public boolean editarEmpleado(DTOEmpleado empleado, String nuevoNombre, String nuevoCargo, String nuevasFunciones) {
        for (DTOEmpleado emp : empleados) {
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
        for (DTOEmpleado empleado : empleados) {
            if (empleado.getNombre().equals(nombre)) {
                empleados.remove(empleado);
                break;
            }
        }
    }

}
