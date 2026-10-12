


package DAY5.Super_keyword3;

class BankAccount3 {
    String AccountHolder;

    BankAccount3(String AccountHolder) {
        this.AccountHolder = AccountHolder;
    }

    void displayDetails() {
        System.out.println("Account Holder: " + AccountHolder);
    }
}

class SavingAccount extends BankAccount3 {
    double intrestRate = 4.5;

    SavingAccount(String AccountHolder) {
        super(AccountHolder);
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Interest Rate: " + intrestRate + "%");
    }
}
