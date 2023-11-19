package com.mycompany.fundacion;

import ConversionDTO.FundacionConverter;
import DAO.DAOFundacion;
import java.util.Date;
import conexiondb.ConexionFactory;
import DAO.DAOEmpleado;
import DAO.DAOFundacion;
import DTO.DTOFundacion;
import dominio.Fundacion;
import dominio.Empleado;
import dominio.Voluntario;
import dominio.Mascota;
import java.sql.SQLException;
import java.util.List;
import conexiondb.IConfiguracionBaseDatos;
import controladores.ControladorFundacion;
import controladores.ControladorPrincipal;
import java.util.HashMap;
import java.util.Map;
import templateCalcularSalario.AuxiliarCalcular;
import templateCalcularSalario.CalculadoraSalarioTemplate;

public class Main {

    public static void main(String[] args) throws SQLException {

        ControladorPrincipal controladorPrincipal = new ControladorPrincipal();

        // Obtén la hora actual de la base de datos
        String horaActual = controladorPrincipal.obtenerHoraActual();

        if (horaActual != null) {
            System.out.println("Hora actual de la base de datos: " + horaActual);
        } else {
            System.out.println("No se pudo obtener la hora actual de la base de datos.");
        }
        
//        Map<Date, Double> horarioRegistro = new HashMap<>();
//        Date fecha1 = new Date(); 
//        double valor1 = 10.5;
//        horarioRegistro.put(fecha1, valor1);
//        AuxiliarCalcular auxiliarCalcular = new AuxiliarCalcular();
//        auxiliarCalcular.calcularSalario("auxiliar", horarioRegistro);

        // Crear una nueva Fundación
//        DTOFundacion nuevaFundacion = new DTOFundacion(1, "Nombre Fundación", 123456789, "Dirección Fundación", "correo@fundacion.com", "Misión Fundación");
//        controladorPrincipal.obtenerControladorFundacion().crearFundacion(nuevaFundacion);
//////        
         // Obtener todas las Fundaciones y mostrarlas
//        try {
//            List<DTOFundacion> fundaciones = controladorPrincipal.obtenerControladorFundacion().obtenerTodasLasFundaciones();
//            for (DTOFundacion fundacion : fundaciones) {
//                System.out.println(fundacion.toString());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        
//        // Actualizar una Fundación existente
//        DTOFundacion fundacionActualizada = new DTOFundacion(1, "Nuevo Nombre Fundación", 987654321, "Nueva Dirección Fundación", "nuevo@fundacion.com", "Nueva Misión Fundación");
//        controladorPrincipal.obtenerControladorFundacion().actualizarFundacion(fundacionActualizada);

//        // Buscar una Fundación por ID
//        DTOFundacion fundacionEncontrada = controladorPrincipal.obtenerControladorFundacion().buscarFundacion(1);
//        if (fundacionEncontrada != null) {
//            System.out.println(fundacionEncontrada.toString());
//        } else {
//            System.out.println("Fundación no encontrada.");
//        }
//        
//        // Eliminar una Fundación por ID
//        controladorPrincipal.obtenerControladorFundacion().eliminarFundacion(1);

//         Crea un nuevo empleado

        
        DTOFundacion nuevaFundacion = controladorPrincipal.obtenerControladorFundacion().obtenerDTOFundaciones(1);
       
        //Empleado nuevoEmpleado = new Empleado("Nombre del Empleado","Cargo del Empleado", "Funciones del Empleado", nuevaFundacion);
        
        boolean exitoCreacion = controladorPrincipal.obtenerControladorEmpleado().crearEmpleado(nuevaFundacion.agregarEmpleado("Nombre del Empleado","Cargo del Empleado", "Funciones del Empleado", nuevaFundacion));
        if (exitoCreacion) {
            System.out.println("Empleado creado con éxito");
        } else {
            System.out.println("Error al crear el empleado");
        }
        // Llama al método del controlador para crear un empleado
//        boolean exitoCreacion = controladorPrincipal.obtenerControladorEmpleado().crearEmpleado(nuevoEmpleado);
//        if (exitoCreacion) {
//            System.out.println("Empleado creado con éxito");
//        } else {
//            System.out.println("Error al crear el empleado");
//        }
//        
//        // Llama al método del controlador para obtener una lista de empleados
//        try {
//            List<Empleado> empleados = controladorPrincipal.obtenerControladorEmpleado().obtenerTodasLasEmpleado();
//            for (Empleado empleado : empleados) {
//                System.out.println("ID: " + empleado.getIdEmpleado());
//                System.out.println("Nombre: " + empleado.getNombre());
//                System.out.println("Cargo: " + empleado.getCargo());
//                System.out.println("Funciones: " + empleado.getFunciones());
//                System.out.println();
//            }
//        } catch (SQLException e) {
//            System.out.println("Error al obtener la lista de empleados");
//            e.printStackTrace();
//        }
//
//        // Llama al método del controlador para buscar un empleado por ID
//        int idEmpleadoABuscar = 1; // Reemplaza con el ID que desees buscar
//        Empleado empleadoBuscado = controladorPrincipal.obtenerControladorEmpleado().buscarEmpleado(idEmpleadoABuscar);
//        if (empleadoBuscado != null) {
//            System.out.println("Empleado encontrado:");
//            System.out.println("ID: " + empleadoBuscado.getIdEmpleado());
//            System.out.println("Nombre: " + empleadoBuscado.getNombre());
//            System.out.println("Cargo: " + empleadoBuscado.getCargo());
//            System.out.println("Funciones: " + empleadoBuscado.getFunciones());
//        } else {
//            System.out.println("Empleado no encontrado");
//        }
    }

}
