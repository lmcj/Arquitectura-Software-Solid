/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConversionDTO;

/**
 *
 * @author 57322
 */
import DTO.DTOEmpleado;
import dominio.Empleado;

public class EmpleadoConverter {

    public static Empleado convertirDTOaEmpleado(DTOEmpleado dtoEmpleado) {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(dtoEmpleado.getIdEmpleado());
        empleado.setNombre(dtoEmpleado.getNombre());
        empleado.setCargo(dtoEmpleado.getCargo());
        empleado.setFunciones(dtoEmpleado.getFunciones());
        return empleado;
    }

    public static DTOEmpleado convertirEmpleadoaDTO(Empleado empleado) {
        DTOEmpleado dtoEmpleado = new DTOEmpleado(
                empleado.getNombre(),
                empleado.getCargo(),
                empleado.getFunciones()
        );
        return dtoEmpleado;
    }
}

