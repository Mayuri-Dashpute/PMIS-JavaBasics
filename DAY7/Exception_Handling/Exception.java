package DAY7.Exception_Handling;

public class Exception {
    public static void main(String[] args) {
        int balance = 5000;
        int withdraw = 7000;

        try{
            if(withdraw > balance){
                throw new IllegalArgumentException("Insufficient balance");
            }
            balance -= withdraw;
            System.out.println("withdraw was successfull");
            System.out.println("remainning balance" + balance);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println("Program completed");
    }
}
