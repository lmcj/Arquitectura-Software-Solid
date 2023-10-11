/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Casallas
 */
public class GestorVoluntarios {
    private List<Voluntario> voluntarios = new ArrayList<>();

    public Voluntario agregarVoluntario(String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono) {
        Voluntario voluntario = new Voluntario(nombre, direccion, correo_electronico, habilidades, disponibilidad, telefono);
        voluntarios.add(voluntario);
        return voluntario;
    }

    public void mostrarVoluntarios(Fundacion fundacion) {
        System.out.println("Voluntarios de la fundacion " + fundacion.getNombre() + ":");
        for (Voluntario voluntario : voluntarios) {
            System.out.println("Nombre: " + voluntario.getNombre() + ", Direccion: " + voluntario.getDireccion() + ", Correo electronico: " + voluntario.getCorreo_electronico() + ", Habilidades: " + voluntario.getHabilidades() + ", Disponibilidad: " + voluntario.getDisponibilidad() + ", Telefono: " + voluntario.getTelefono());
        }
    }

    public void eliminarVoluntario(String nombre) {
        for (Voluntario voluntario : voluntarios) {
            if (voluntario.getNombre().equals(nombre)) {
                voluntarios.remove(voluntario);
                break;
            }
        }
    }
}
