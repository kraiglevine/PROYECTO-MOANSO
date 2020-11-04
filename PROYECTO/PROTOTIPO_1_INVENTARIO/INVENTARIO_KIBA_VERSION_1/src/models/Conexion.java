package models;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static Connection con;
    
    public static Connection getConnection(){
        String url= "jdbc:mysql://localhost:3306/inventario_kiba?serverTimezone=America/Lima";
        String user="root";
        String pas= "root";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pas);      
        } catch (Exception e) {
            System.out.println("Error conexion..."+e.getMessage());   
        }
        return con;
    }
}
