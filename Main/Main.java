
package Main;

import Model.ClsConnection;
import Views.*;


public class Main {

    
    public static void main(String[] args) {
        
        // Instancia de conexion a la base de datos
        ClsConnection connectionDB = new ClsConnection();
        
        // Intancia de la vista iniciar sesion
        
        ViewLogin login = new ViewLogin();
 
        login.setVisible(true);
    }
    
}
