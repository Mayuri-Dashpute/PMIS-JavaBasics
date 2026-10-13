package DAY7.Exception_Handling;




public class Finally {
    public static void main(String[] args) {

        try{
           
            int res = 10/5;
            System.out.println(res);
              }
              
        catch(ArithmeticException e){
            System.out.println("you cant divide by 0");
        }finally{
            System.out.println("Finally Block Execute");
        }

    }
}
