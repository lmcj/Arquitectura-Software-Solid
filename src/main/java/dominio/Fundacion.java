package dominio;

public class Fundacion {

    private int idFundacion;
    private String nombre;
    private int telefono;
    private String direccion;
    private String correo_electronico;
    private String mision;
    

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

}
