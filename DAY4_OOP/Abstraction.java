package DAY4_OOP;
abstract class PaymentGateway{
    void printReceipt(){
        System.out.println("Receipt generated");
    }

    abstract void processPayment(double amount);
}

class UPIPayments extends PaymentGateway{
 @Override 
 void processPayment(double amount){
  System.out.println("Processing Rs " + amount + " Via UPI");
 }


}

class creaditcardPayment extends PaymentGateway{
@Override 
 void processPayment(double amount){
    System.out.println("Processing Rs " + amount + " Via Creaditcards");
 }
}
public class Abstraction {
    public static void main(String args[]){
        PaymentGateway payment = new UPIPayments();
        payment.processPayment((250.0));
        payment.printReceipt();

        PaymentGateway pay = new creaditcardPayment();
        pay.processPayment((300.0));
        pay.printReceipt();
    }
}
