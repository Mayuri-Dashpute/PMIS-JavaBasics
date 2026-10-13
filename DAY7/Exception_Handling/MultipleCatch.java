package DAY7.Exception_Handling;

public class MultipleCatch {
    public static void main(String[] args) {

        try{
            int numbers[] = {10,20,30};
            System.out.println(numbers[5]); 
            int res = 10/0;
            System.out.println(res);
              }
              catch(ArrayIndexOutOfBoundsException e){
                System.err.println("Invalid array index");
              }
        catch(ArithmeticException e){
            System.out.println("you cant divide by 0");
        }

    }
}
