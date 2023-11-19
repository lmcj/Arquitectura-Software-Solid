/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConversionDTO;

import DTO.DTOVoluntario;
import dominio.Voluntario;

public class VoluntarioConverter {

    public static Voluntario convertirDTOaVoluntario(DTOVoluntario dtoVoluntario) {
        Voluntario voluntario = new Voluntario();
        voluntario.setIdVoluntario(dtoVoluntario.getIdVoluntario());
        voluntario.setNombre(dtoVoluntario.getNombre());
        voluntario.setDireccion(dtoVoluntario.getDireccion());
        voluntario.setCorreo_electronico(dtoVoluntario.getCorreoElectronico());
        voluntario.setHabilidades(dtoVoluntario.getHabilidades());
        voluntario.setDisponibilidad(dtoVoluntario.getDisponibilidad());
        voluntario.setTelefono(dtoVoluntario.getTelefono());
        return voluntario;
    }

    public static DTOVoluntario convertirVoluntarioaDTO(Voluntario voluntario) {
        DTOVoluntario dtoVoluntario = new DTOVoluntario(
                voluntario.getIdVoluntario(),
                voluntario.getNombre(),
                voluntario.getDireccion(),
                voluntario.getCorreo_electronico(),
                voluntario.getHabilidades(),
                voluntario.getDisponibilidad(),
                voluntario.getTelefono()
        );
        return dtoVoluntario;
    }
}
