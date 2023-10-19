package dominio;

public class Fundacion {

    private int idFundacion;
    private String nombre;
    private int telefono;
    private String direccion;
    private String correo_electronico;
    private String mision;
    private GestorEmpleados gestorEmpleados;
    private GestorVoluntarios gestorVoluntarios; 
    private GestorMascotas gestorMascotas;

    public Fundacion() {  
    }
    
    public Fundacion(int idFundacion) {
        this.idFundacion = idFundacion;
    }

    public Fundacion(String nombre, int telefono, String direccion, String correo_electronico, String mision) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.mision = mision;
    }

    public Fundacion(int idFundacion, String nombre, int telefono, String direccion, String correo_electronico, String mision) {
        this.idFundacion = idFundacion;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo_electronico = correo_electronico;
        this.mision = mision;
    }

    public int getIdFundacion() {
        return idFundacion;
    }

    public void setIdFundacion(int idFundacion) {
        this.idFundacion = idFundacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public String getMision() {
        return mision;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public Empleado agregarEmpleado(String nombre, String cargo, String funciones, Fundacion fun) {
     return gestorEmpleados.agregarEmpleado(nombre, cargo, funciones, fun);
    }

    public void mostrarEmpleados() {
        gestorEmpleados.mostrarEmpleados(this);
    }

    public boolean editarEmpleado(Empleado empleado, String nuevoNombre, String nuevoCargo, String nuevasFunciones) {
        return gestorEmpleados.editarEmpleado(empleado, nuevoNombre, nuevoCargo, nuevasFunciones);
    }

    //eliminar empleado
    public void eliminarEmpleado(String nombre) {
        gestorEmpleados.eliminarEmpleado(nombre);
    }

    public Voluntario agregarVoluntario(String nombre, String direccion, String correo_electronico, String habilidades, String disponibilidad, int telefono) {
        return gestorVoluntarios.agregarVoluntario(nombre, direccion, correo_electronico, habilidades, disponibilidad, telefono);
    }

    public void mostrarVoluntarios() {
        gestorVoluntarios.mostrarVoluntarios(this);
    }

    //eliminar voluntario
    public void eliminarVoluntario(String nombre) {
        gestorVoluntarios.eliminarVoluntario(nombre);
    }

    public Mascota agregarMascota(String nombre, String especie, String raza, String genero, int edad, String color, String estado_salud) {
        return gestorMascotas.agregarMascota(nombre, especie, raza, genero, edad, color, estado_salud);
    }

    public void mostrarMascotas() {
        gestorMascotas.mostrarMascotas(this);
    }

    //eliminar mascota
    public void eliminarMascota(String nombre) {
       gestorMascotas.eliminarMascota(nombre);  
    }

    @Override
    public String toString() {
        return "Fundacion {"
                + " Id Fundacion ='" + getIdFundacion() + '\''
                + ", Nombre ='" + getNombre() + '\''
                + ", Telefono ='" + getTelefono() + '\''
                + ", Direccion='" + getDireccion() + '\''
                + ", Mision=" + getMision()
                + ", Correo Electronico=" + getCorreo_electronico() + '}';
    }
}
