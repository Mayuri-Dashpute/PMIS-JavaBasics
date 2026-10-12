package DAY6.HAS_A_1;

class Engine{
    void start(){
        System.out.println("Engine is starting..");
    }
}
class car{
    private Engine engine;
    car(){
        this.engine = new Engine();
    }
    void drive(){
          engine.start();
        System.out.println("Car is moving");
    }
}
