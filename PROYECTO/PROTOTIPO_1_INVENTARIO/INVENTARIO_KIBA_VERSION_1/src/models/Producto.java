package models;
public class Producto {
   private int id;
   private String codigo;
   private String especie;
   private String cantidad;
   private String procedencia;
   private String proveedor;

    public Producto(int id, String codigo, String especie, String cantidad, String procedencia, String proveedor) {
        this.id = id;
        this.codigo = codigo;
        this.especie = especie;
        this.cantidad = cantidad;
        this.procedencia = procedencia;
        this.proveedor = proveedor;
    }

    public Producto(String codigo, String especie, String cantidad, String procedencia, String proveedor) {
        this.codigo = codigo;
        this.especie = especie;
        this.cantidad = cantidad;
        this.procedencia = procedencia;
        this.proveedor = proveedor;
    }

    public Producto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
   
   
 
}
