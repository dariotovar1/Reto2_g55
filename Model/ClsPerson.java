
package Model;

public class ClsPerson {
    // definicion de los atributos de la clase
    protected int IdPeson;
    protected String name;
    protected String lastName;
    protected String dcType;
    protected String document;
    protected String email;
    protected static int counterPerson;

    
        
    //constructor de la clase
    public ClsPerson(String name, String lastName, String dcType, String document, String email) {
        this.name = name;
        this.lastName = lastName;
        this.dcType = dcType;
        this.document = document;
        this.email = email;
        this.IdPeson =++ClsPerson.counterPerson;
        
    }

  

    //sobrescritura de la funcion toString
    public String toString() {
        return "Person :\n{"+
                "\n     IdPerson      : " + IdPeson + 
                "\n     Name          : " + name + 
                "\n     Last Name     : " + lastName + 
                "\n     Type Document : " + dcType + 
                "\n     Document      : " + document + 
                "\n     E - mail      : " + email + "\n}\n";
    }
    
    
    
}
