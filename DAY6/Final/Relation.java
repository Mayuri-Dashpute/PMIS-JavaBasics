package DAY6.Final;

class Bank{
    final void calculateIntrest(){
        System.out.println("Base intrest calculation");
    }
    
}

class Branch extends Bank{
    void calculatIntrest(){
        System.out.println("custom intrest");
    }
}
