/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author herme
 */
public class ClsEmployee extends ClsPerson{
    // se definen los tributos e la clase
    protected int IdEmployee;
    protected String positionHeld;
    protected double salary;
    protected static int counterEmployee;
    
    //constructor de la clase

    public ClsEmployee(String name, String lastName, String dcType, String document, String email, String positionHeld, double salary ) {
        super(name, lastName, dcType, document, email);
        this.positionHeld = positionHeld;
        this.salary = salary;
        this.IdEmployee = ++ClsEmployee.counterEmployee;
    }

    //sobrescritura de la funcion toString
    public String toString() {
        return "Employee :\n{" +super.toString()+
                "\n     Cargo         :" + positionHeld + 
                "\n     Salary        :" + salary + "\n}\n";
    }
    
    
}
