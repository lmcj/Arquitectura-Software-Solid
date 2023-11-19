/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author 57322
 */
public class DTOMascota {

    private int idMascota;
    private String nombre;
    private String especie;
    private String raza;
    private String genero;
    private int edad;
    private String color;
    private String estado_salud;
    private Boolean disponible;
    private DTOFundacion fundacion;
    public DTOMascota() {
    }

    public DTOMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public DTOMascota(String nombre, String especie, String raza, String genero, int edad, String color, String estado_salud, Boolean disponible) {
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.color = color;
        this.estado_salud = estado_salud;
        this.disponible = disponible;
    }

    public DTOMascota(int idMascota, String nombre, String especie, String raza, String genero, int edad, String color, String estadoSalud, Boolean disponible) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.color = color;
        this.estado_salud = estado_salud;
        this.disponible = disponible;
    }
    
    public DTOFundacion getFundacion (){
        return this.fundacion;
    }
    
    public void setFundacion (DTOFundacion fundacion){
        this.fundacion=fundacion;
    }
    
    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstadoSalud() {
        return estado_salud;
    }

    public void setEstadoSalud(String estadoSalud) {
        this.estado_salud = estadoSalud;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Mascota {"
                + "Id Mascota='" + idMascota + '\''
                + ", Nombre='" + nombre + '\''
                + ", Especie='" + especie + '\''
                + ", Raza='" + raza + '\''
                + ", Género='" + genero + '\''
                + ", Edad=" + edad
                + ", Color='" + color + '\''
                + ", Estado de Salud='" + estado_salud + '\''
                + ", Disponible=" + disponible
                + '}';
    }
}
