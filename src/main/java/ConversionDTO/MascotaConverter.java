/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConversionDTO;

import DTO.DTOMascota;
import dominio.Mascota;

public class MascotaConverter {

    public static Mascota convertirDTOaMascota(DTOMascota dtoMascota) {
        Mascota mascota = new Mascota();
        mascota.setIdMascota(dtoMascota.getIdMascota());
        mascota.setNombre(dtoMascota.getNombre());
        mascota.setEspecie(dtoMascota.getEspecie());
        mascota.setRaza(dtoMascota.getRaza());
        mascota.setGenero(dtoMascota.getGenero());
        mascota.setEdad(dtoMascota.getEdad());
        mascota.setColor(dtoMascota.getColor());
        mascota.setEstado_salud(dtoMascota.getEstadoSalud());
        mascota.setDisponible(dtoMascota.getDisponible());
        return mascota;
    }

    public static DTOMascota convertirMascotaaDTO(Mascota mascota) {
        DTOMascota dtoMascota = new DTOMascota(
                mascota.getIdMascota(),
                mascota.getNombre(),
                mascota.getEspecie(),
                mascota.getRaza(),
                mascota.getGenero(),
                mascota.getEdad(),
                mascota.getColor(),
                mascota.getEstado_salud(),
                mascota.getDisponible()
        );
        return dtoMascota;
    }
}
