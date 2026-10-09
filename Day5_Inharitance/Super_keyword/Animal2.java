package Day5_Inharitance.Super_keyword;

class Animal2 {
   void eat(){
    System.out.println("animal eat");
   } 
}

class Dog extends  Animal2{
    void eat(){
        System.out.println("dog eat");
      super.eat();
    }
}
