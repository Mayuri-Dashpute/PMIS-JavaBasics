package Day5_Inharitance.Super_keyword;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }
    
    void displayInfo(){
        System.out.println("name:" + name + "salary:"+ salary);
    }
}

    class Manager extends Employee{
        String department;

        Manager(String name, double salary, String department){
            super(name, salary);
            this.department = department;

        }
        @Override 
        void displayInfo(){
            super.displayInfo();
            System.out.println("Department:" +department);
            System.out.println("Role:manager");
        }

    }

