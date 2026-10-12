package DAY6.HAS_A_2;
class Address{
    String city;
    String state;
    int pincode;

    Address(String city, String state, int pincode){
        this.city = city;
        this.state=state;
        this.pincode=pincode;
    }

    void  displayProfile(){
        System.out.println(city+","+ state+", "+pincode);
    }

}
public class Student {
    String name;
    int rollNumber;
    Address address;

    Student(String name, int rollNumber, Address address){
        this.name = name;
        this.rollNumber = rollNumber;
        this.address =address;
    }

    void displayProfile(){
        System.out.println("student; "+name+"\nRollNo."+rollNumber);
        System.out.println("lives at:");
        address.displayProfile();
    }
}
