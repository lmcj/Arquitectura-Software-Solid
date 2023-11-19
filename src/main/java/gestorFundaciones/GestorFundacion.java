/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorFundaciones;

import DTO.DTOEmpleado;
import DTO.DTOFundacion;
import DTO.DTOMascota;
import DTO.DTOVoluntario;

public abstract class GestorFundacion {
    
    private GestorEmpleados gestorEmpleados = new GestorEmpleados();
    private GestorVoluntarios gestorVoluntarios = new GestorVoluntarios(); 
    private GestorMascotas gestorMascotas = new GestorMascotas();
    
    public DTOEmpleado agregarEmpleado(String nombre, String cargo, String funciones, DTOFundacion fun) {
     return gestorEmpleados.agregarEmpleado(nombre, cargo, funciones, fun);
    }

    public void mostrarEmpleados(DTOFundacion fundacion) {
        gestorEmpleados.mostrarEmpleados(fundacion);
    }

    public boolean editarEmpleado(DTOEmpleado empleado, String nuevoNombre, String nuevoCargo, String nuevasFunciones) {
        return gestorEmpleados.editarEmpleado(empleado, nuevoNombre, nuevoCargo, nuevasFunciones);
    }

    //eliminar empleado
    public void eliminarEmpleado(String nombre) {
        gestorEmpleados.eliminarEmpleado(nombre);
    }

    public DTOVoluntario agregarVoluntario(String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono) {
        return gestorVoluntarios.agregarVoluntario(nombre, direccion, correo_electronico, habilidades, disponibilidad, telefono);
    }

    public void mostrarVoluntarios(DTOFundacion fundacion){
        gestorVoluntarios.mostrarVoluntarios(fundacion);
    }

    //eliminar voluntario
    public void eliminarVoluntario(String nombre) {
        gestorVoluntarios.eliminarVoluntario(nombre);
    }

    public DTOMascota agregarMascota(String nombre, String especie, String raza, String genero, int edad, String color, String estado_salud) {
        return gestorMascotas.agregarMascota(nombre, especie, raza, genero, edad, color, estado_salud);
    }

    public void mostrarMascotas(DTOFundacion fundacion) {
        gestorMascotas.mostrarMascotas(fundacion);
    }

    //eliminar mascota
    public void eliminarMascota(String nombre) {
       gestorMascotas.eliminarMascota(nombre);  
    }
}
