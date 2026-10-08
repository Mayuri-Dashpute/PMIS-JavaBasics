package DAY4_OOP;
class customerWallet{
    String name;
    double balance;

   customerWallet(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    void addFunds(double funds){
       balance += funds;
       System.out.println("after addfunds: "+ balance); 
       System.out.println("add funds successfully");
    }

    void purchaseFunds(double funds){
        if(funds<=balance){
            balance -= funds;
            System.out.println("After purchase funds:"+ balance); 
            System.out.println("funds suceessfully");
        }else{
            System.out.println("Unsuffiecient balance");
        }
    }

    void accoundOverview(){
        System.out.println("name: " +name +"\n"+ "current balance:" +balance);
    }


}
public class CofeeWallet {
    public static void main(String args[]){
      customerWallet cs = new customerWallet( "mayuri", 500); 
      cs.accoundOverview();
      cs.addFunds(200);
      cs.purchaseFunds(150);
      cs.purchaseFunds(800);
      cs.accoundOverview(); 

    }
}
