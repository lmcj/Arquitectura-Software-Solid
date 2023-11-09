package dominio;

import java.util.ArrayList;
import java.util.List;

public class GestorMascotas {

    private List<Mascota> mascotas = new ArrayList<>();

    public Mascota agregarMascota(String nombre, String especie, String raza, String genero, int edad, String color, String estado_salud) {
        Mascota mascota = new Mascota(nombre, especie, raza, genero, edad, color, estado_salud, true);
        mascotas.add(mascota);
        return mascota;
    }

    public void mostrarMascotas(Fundacion fundacion) {
        System.out.println("Mascotas de la fundacion " + fundacion.getNombre() + ":");
        for (Mascota mascota : mascotas) {
            System.out.println("Nombre: " + mascota.getNombre() + ", Especie: " + mascota.getEspecie() + ", Raza: " + mascota.getRaza() + ", Genero: " + mascota.getGenero() + ", Edad: " + mascota.getEdad() + ", Color: " + mascota.getColor() + ", Estado de salud: " + mascota.getEstado_salud());
        }
    }

    public void eliminarMascota(String nombre) {
        for (Mascota mascota : mascotas) {
            if (mascota.getNombre().equals(nombre)) {
                mascotas.remove(mascota);
                break;
            }
        }
    }
}
