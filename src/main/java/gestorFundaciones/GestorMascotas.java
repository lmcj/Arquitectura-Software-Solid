package gestorFundaciones;

import DTO.DTOFundacion;
import DTO.DTOMascota;
import dominio.Fundacion;
import dominio.Mascota;
import java.util.ArrayList;
import java.util.List;

public class GestorMascotas {

    private List<DTOMascota> mascotas = new ArrayList<>();

    public DTOMascota agregarMascota(String nombre, String especie, String raza, String genero, int edad, String color, String estado_salud) {
        DTOMascota mascota = new DTOMascota(nombre, especie, raza, genero, edad, color, estado_salud, true);
        mascotas.add(mascota);
        return mascota;
    }

    public void mostrarMascotas(DTOFundacion fundacion) {
        System.out.println("Mascotas de la fundacion " + fundacion.getNombre() + ":");
        for (DTOMascota mascota : mascotas) {
            System.out.println("Nombre: " + mascota.getNombre() + ", Especie: " + mascota.getEspecie() + ", Raza: " + mascota.getRaza() + ", Genero: " + mascota.getGenero() + ", Edad: " + mascota.getEdad() + ", Color: " + mascota.getColor() + ", Estado de salud: " + mascota.getEstadoSalud());
        }
    }

    public void eliminarMascota(String nombre) {
        for (DTOMascota mascota : mascotas) {
            if (mascota.getNombre().equals(nombre)) {
                mascotas.remove(mascota);
                break;
            }
        }
    }
}
