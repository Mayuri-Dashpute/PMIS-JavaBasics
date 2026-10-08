package DAY4_OOP;

class Tester {
    String accountHolder;
    double balance;

    public Tester(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    void Deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount);
        System.out.println("New Balance " + balance);
    }

    void Withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdraw " + amount);
            System.out.println("Updated Balance " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    void display(){
        System.out.println("AccountHoldername:"+accountHolder);
        System.out.println("balance:"+balance);
    }
}

public class BanlAccount {
    public static void main(String[] args) {
        Tester t1 = new Tester("Mayuri", 64764);
        t1.display();
        t1.Deposit(7657);
        t1.Withdraw(785);

        Tester t2 = new Tester("Jaaee", 747570);
        
        t2.Deposit(687);
        t2.Withdraw(844);
    }
}