package DAY5.Super_keyword2;

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
