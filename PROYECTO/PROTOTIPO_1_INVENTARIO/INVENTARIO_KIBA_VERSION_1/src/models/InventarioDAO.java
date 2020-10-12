package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class InventarioDAO {
    Conexion conectar=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public List<Producto>listar(){
        List<Producto>listarProducto=new ArrayList<>();
        String sql="SELECT * FROM producto";
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
               Producto pro=new Producto();
               pro.setId(rs.getInt(1));
               pro.setCodigo(rs.getString(2));
               pro.setEspecie(rs.getString(3));
               pro.setCantidad(String.valueOf(rs.getDouble(4)));
               pro.setTipo(rs.getString(5));
               pro.setTroza(rs.getString(6));
               pro.setProcedencia(rs.getString(7));
               pro.setProveedor(rs.getString(8));
               pro.setTransportista(rs.getString(9));
               listarProducto.add(pro);
            }         
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listarProducto;
    }
    
    //INTERFAZ USUARIO
    public List<Usuario>listarUsuario(){
        List<Usuario>listarUsuario=new ArrayList<>();
        String sql="SELECT * FROM usuario";
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuario usr=new Usuario();
                usr.setId(rs.getInt(1));
                usr.setNombres(rs.getString(2));
                usr.setApellidos(rs.getString(3));
                usr.setDni(rs.getString(4));
                usr.setContraseña(rs.getString(5));
                usr.setTipo(rs.getString(6));
                listarUsuario.add(usr);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listarUsuario;
    }
    
    public int agregar (Producto p){
        String sql="INSERT INTO producto VALUES(null,?,?,?,?,?,?,?,?)";
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, p.getCodigo());
            ps.setString(2, p.getEspecie());
            ps.setDouble(3,Double.valueOf(p.getCantidad()));
            ps.setString(4, p.getTipo());
            ps.setString(5, p.getTroza());
            ps.setString(6, p.getProcedencia());
            ps.setString(7, p.getProveedor());
            ps.setString(8, p.getTransportista());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar..."+e.getMessage());
        }
        return 1;   
    }
    
    //INTERFAZ USUARIO
    public int agregarUsuario (Usuario u){
        String sql="INSERT INTO usuario VALUES(null,?,?,?,?,?)";
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getDni());
            ps.setString(4, u.getContraseña());
            ps.setString(5,u.getTipo());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error al agregar..."+e.getMessage());
        }
        return 1;   
    }
    //INTERFAZ USUARIO
    
    public int actualizar(Producto p){
        int r=0;
        String sql="UPDATE producto SET pro_codigo=?,pro_especie=?,pro_cantidad=?,pro_tipo_madera=?,pro_tipo_troza=?,pro_procedencia=?,pro_proveedor=?,pro_tranportista=? WHERE pro_id=?";
        try {
            con= Conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getEspecie());
            ps.setDouble(3,Double.valueOf(p.getCantidad()));
            ps.setString(4,p.getTipo());
            ps.setString(5,p.getTroza());
            ps.setString(6,p.getProcedencia());
            ps.setString(7,p.getProveedor());
            ps.setString(8,p.getTransportista());
            ps.setInt(9,p.getId());
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }    
        } catch (Exception e) {
            System.out.println("Error al actualizar!"+e.getMessage());
        }
        return r;
    }
    public int actualizarUsuario(Usuario u){
        int r=0;
        String sql="UPDATE producto SET usr_nombres=?,usr_apellidos=?,usr_dni=?,usr_contraseña=?,usr_tipo=? WHERE usr_id=?";
        try {
            con= Conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, u.getNombres());
            ps.setString(2, u.getApellidos());
            ps.setString(3, u.getDni());
            ps.setString(4, u.getContraseña());
            ps.setString(5,u.getTipo());
            ps.setInt(6, u.getId());
            r=ps.executeUpdate();
            if(r==1){
                return 1;
            }else{
                return 0;
            }    
        } catch (Exception e) {
            System.out.println("Error al actualizar!"+e.getMessage());
        }
        return r;
    }
    
    public void eliminar(int id){
        String sql="DELETE FROM producto WHERE pro_id = "+id;
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();   
        } catch (Exception e) {
            System.err.println("Error eliminar"+e.getMessage());
        } 
    }
    
    public void eliminarUsuario(int id){
        String sql="DELETE FROM usuario WHERE usr_id = "+id;
        try {
            con=Conexion.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();   
        } catch (Exception e) {
            System.err.println("Error eliminar"+e.getMessage());
        } 
    }

}
