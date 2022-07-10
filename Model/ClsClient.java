
package Model;

/**
 *
 * @author herme
 */
public class ClsClient extends ClsPerson{
   
    // definicion de atributos de la clase.
    private int idClient;
    private boolean isPreference;
    private String address;
    private String city;
    private static int counterClient; 

    public ClsClient( String name, String lastName, String dcType, String document, String email, boolean isPreference, String address, String city) {
        super(name, lastName, dcType, document, email);
        this.address = address;
        this.city = city;
        this.idClient = ++ ClsClient.counterClient;
    }

    @Override
    public String toString() {
        return "Client :\n{" + super.toString()+
                "\n     idClient      : " + idClient + 
                "\n     isPreference  : " + isPreference + 
                "\n     Address       : " + address + 
                "\n     City          : " + city + "\n}\n";
    }
    
    
    
}
