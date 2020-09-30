package models;
public class Producto {
   private int id;
   private String codigo;
   private String especie;
   private String cantidad;
   private String tipo;
   private String troza;
   private String procedencia;
   private String proveedor;
   private String transportista;

    public Producto() {
    }

    public Producto(int id, String codigo, String especie, String cantidad, String tipo, String troza, String procedencia, String proveedor, String transportista) {
        this.id = id;
        this.codigo = codigo;
        this.especie = especie;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.troza = troza;
        this.procedencia = procedencia;
        this.proveedor = proveedor;
        this.transportista = transportista;
    }

    public Producto(String codigo,String especie, String cantidad, String tipo, String troza, String procedencia, String proveedor, String transportista) {
        this.codigo = codigo;
        this.especie = especie;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.troza = troza;
        this.procedencia = procedencia;
        this.proveedor = proveedor;
        this.transportista = transportista;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTroza() {
        return troza;
    }

    public void setTroza(String troza) {
        this.troza = troza;
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

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }
 
   
   
}
