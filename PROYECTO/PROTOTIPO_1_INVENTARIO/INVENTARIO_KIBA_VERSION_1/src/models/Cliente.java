
package models;

public class Cliente {
    private int id;
    private String nombre;
    private String Apellido;
    private String dni;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String Apellido, String dni, String correo, String telefono) {
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Cliente(int id, String nombre, String Apellido, String dni, String correo, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.dni = dni;
        this.correo = correo;
        this.telefono = telefono;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
