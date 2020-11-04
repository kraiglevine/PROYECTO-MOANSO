
package models;

public class Proveedor {
    private int ID;
    private String social;
    private String RUC;
    private String direccion;
    private String correo;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(int ID, String social, String RUC, String direccion, String correo, String telefono) {
        this.ID = ID;
        this.social = social;
        this.RUC = RUC;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Proveedor(String social, String RUC, String direccion, String correo, String telefono) {
        this.social = social;
        this.RUC = RUC;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
