package DAY5.Super_keyword4;
class Animal{
    String name;

    void eat(){
       System.out.println( "Animal is Eating");
    }

}
class Dog extends Animal {
    void bark(){
        System.out.println("dog is barking");
    }
}
