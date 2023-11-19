package gestorFundaciones;

import DTO.DTOFundacion;
import DTO.DTOVoluntario;
import dominio.Fundacion;
import dominio.Voluntario;
import java.util.ArrayList;
import java.util.List;

public class GestorVoluntarios {
    
    private List<DTOVoluntario> voluntarios = new ArrayList<>();

    public DTOVoluntario agregarVoluntario(String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono) {
        DTOVoluntario voluntario = new DTOVoluntario(nombre, direccion, correo_electronico, habilidades, disponibilidad, telefono);
        voluntarios.add(voluntario);
        return voluntario;
    }

    public void mostrarVoluntarios(DTOFundacion fundacion) {
        System.out.println("Voluntarios de la fundacion " + fundacion.getNombre() + ":");
        for (DTOVoluntario voluntario : voluntarios) {
            System.out.println("Nombre: " + voluntario.getNombre() + ", Direccion: " + voluntario.getDireccion() + ", Correo electronico: " + voluntario.getCorreoElectronico() + ", Habilidades: " + voluntario.getHabilidades() + ", Disponibilidad: " + voluntario.getDisponibilidad() + ", Telefono: " + voluntario.getTelefono());
        }
    }

    public void eliminarVoluntario(String nombre) {
        for (DTOVoluntario voluntario : voluntarios) {
            if (voluntario.getNombre().equals(nombre)) {
                voluntarios.remove(voluntario);
                break;
            }
        }
    }
}
