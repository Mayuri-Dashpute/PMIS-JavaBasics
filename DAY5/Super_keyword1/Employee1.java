package DAY5.Super_keyword1;
class Manager{
 double salary = 60000;
}
class Employee1  extends Manager{
    double salary = 30000;
    void DisplaySalary(){
        System.out.println("Employee Salary"+salary);
        System.out.println("Manager salary"+super.salary);
    }
}
