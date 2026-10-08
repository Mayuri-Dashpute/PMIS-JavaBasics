package DAY4_OOP;
class Person{
    private int id;
    private String name;
    private double salary;

    public Person(int id, String name, double salary){
        this.id = id;
        this.name = name;
        if(salary >= 0){
            this.salary = salary;
        }else{
            salary = 0.0;
        }
    }

    public int getId(){
        return id;
    }
      
    public String getname(){
        return name;
    }
    public double getsalary(){
        return salary;
    }

    public void setSalary(double salary){
        if(salary >=0){
            this.salary = salary;
        }else{
            System.out.println("error");
        }
    }

     public void giveRaise(double percent) {  
            if (percent > 0) {
                double raiseAmount = this.salary * (percent / 100.0); 
                 this.salary += raiseAmount; 
                 System.out.println(name + " received a " + percent + "% raise. New Salary: ₹" + this.salary); 
                 } else {            
                System.out.println("Raise percentage must be positive."); 
                    
            }    
         } 
     } 

    

public class Employee {
    public static void main(String args[]){
        Person e1 = new Person(101,"Alice",50000.0);
        e1.giveRaise(78.0);
        e1.setSalary(90.0);
        e1.setSalary(-100);


    }
}
