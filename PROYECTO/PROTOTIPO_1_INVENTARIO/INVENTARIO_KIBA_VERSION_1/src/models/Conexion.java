package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    
    public Connection getConnection(){
        String url= "jdbc:mysql://localhost:3306/inventario_kiba?serverTimezone=America/Lima";
        String user="root";
        String pas= "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pas);      
        } catch (Exception e) {
            System.out.println("Error conexion..."+e.getMessage());   
        }
        return con;
    }
}
