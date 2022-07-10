
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClsConnection {
    
    //instancia de la clase Connection
    Connection connection;
    
    //atributs de la clase
    
    String driver = "com.mysql.cj.jdbc.Driver";
    String connectString = "jdbc:mysql://localhost:3306/reto1_g55_db";
    String user = "root";
    String password = "";
    
    //constructor de la clase ClsConnection
    public ClsConnection(){
        //intentamos conectarnos a la bbdd
        try{
            Class.forName(driver);
            connection =DriverManager.getConnection(connectString, user, password);
            if(connection != null)
                System.out.println("Conexion exitosa con la base de datos");
            
               
        }catch(ClassNotFoundException | SQLException e){
             System.out.println("No se pudo conectar a la base de datos");
        }
    }
    //funcion que devuelve la conexion a la base de datos
    public Connection getConnection (){
        return connection;
    }
}
