/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class DTOEmpleado {

    private int idEmpleado;
    private DTOFundacion fundacion;
    private String nombre;
    private String cargo;
    private String funciones;
    
    public DTOEmpleado() {
        
    }
    
    public DTOEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public DTOEmpleado(String nombre, String cargo, String funciones) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.funciones = funciones;
    }
    
    public DTOEmpleado(String nombre, String cargo, String funciones,DTOFundacion fundacion) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.funciones = funciones;
        this.fundacion = fundacion;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }
    
     public DTOFundacion getFundacion() {
        return fundacion;
    }

    public void setFundacion(DTOFundacion fundacion) {
        this.fundacion = fundacion;
    }

    @Override
    public String toString() {
        return "Empleado {"
                + " Id Empleado ='" + getIdEmpleado() + '\''
                + ", Nombre ='" + getNombre() + '\''
                + ", Cargo ='" + getCargo() + '\''
                + ", Funciones='" + getFunciones() + '\''
                + '}';
    }
}
