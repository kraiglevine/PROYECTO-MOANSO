package models;

public class Usuario {
    private int id;
    private String nombres;
    private String apellidos;
    private String dni;
    private String contraseña;
    private String tipo; 

    public Usuario() {
    }
    
    

    public Usuario(int id, String nombres, String apellidos, String dni, String contraseña, String tipo) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public Usuario(String nombres, String apellidos, String dni, String contraseña, String tipo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
}