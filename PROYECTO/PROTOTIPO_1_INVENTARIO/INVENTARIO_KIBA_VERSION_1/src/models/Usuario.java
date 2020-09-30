package models;

import java.util.Date;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date registro;
    private String tipo;  

    public Usuario() {
    }

    public Usuario(int id, String nombre, String apellido, String dni, Date registro, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.registro = registro;
        this.tipo = tipo;
    }

    public Usuario(String nombre, String apellido, String dni, Date registro, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.registro = registro;
        this.tipo = tipo;
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
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getRegistro() {
        return registro;
    }

    public void setRegistro(Date registro) {
        this.registro = registro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
}


