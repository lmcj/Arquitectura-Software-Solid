
package DTO;

public class DTOVoluntario {

    private int idVoluntario;
    private String nombre;
    private String direccion;
    private String correoElectronico;
    private String habilidades;
    private String disponibilidad;
    private int telefono;
    private DTOFundacion fundacion;
    
    public DTOVoluntario(){
    
    }
    
    public DTOVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }
    public DTOVoluntario (String nombre, String direccion, String correoElectronico, String habilidades, String disponibilidad, int telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.habilidades = habilidades;
        this.disponibilidad = disponibilidad;
        this.telefono = telefono;
    }

    public DTOVoluntario(int idVoluntario, String nombre, String direccion, String correoElectronico, String habilidades, String disponibilidad, int telefono) {
        this.idVoluntario = idVoluntario;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
        this.habilidades = habilidades;
        this.disponibilidad = disponibilidad;
        this.telefono = telefono;
    }
    
    public DTOFundacion getFundacion() {
        return this.fundacion;
    }
    
    public void setFundacion(DTOFundacion fundacion){
        this.fundacion = fundacion;
    }
    
    public int getIdVoluntario() {
        return idVoluntario;
    }

    public void setIdVoluntario(int idVoluntario) {
        this.idVoluntario = idVoluntario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Voluntario {" +
                "Id Voluntario='" + idVoluntario + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Correo Electrónico='" + correoElectronico + '\'' +
                ", Habilidades='" + habilidades + '\'' +
                ", Disponibilidad='" + disponibilidad + '\'' +
                ", Teléfono=" + telefono +
                '}';
    }
}
