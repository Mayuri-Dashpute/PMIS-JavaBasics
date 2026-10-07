import java.util.Scanner;

public class calculator {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
        System.out.println("1.Triangle:");
        System.out.println("2.Square:");
        System.out.println("3.Rectangle:");
        System.out.println("4.Exit:");
        System.out.println("Enter your choice:");
        int shape = sc.nextInt();
        switch(shape){
            case 1:
                System.out.println("Triangle:");
                System.out.println("Enter height:");
                int h = sc.nextInt();
                System.out.println("Enter bredth:");
                int b = sc.nextInt();
                System.err.println("Area of Triangle:");
                int triarea = (b*h)/2;
                System.out.println(triarea);
                break;

            case 2:
                System.out.println("Square");
                System.out.println("Enter side:");
                int a = sc.nextInt();
                int squarearea = a * a;
                System.out.println(squarearea);
                break;

            case 3:
                System.out.println("Rectangle");
                System.out.println("Enter Length:");
                int length = sc.nextInt();
                System.out.println("Enter bredth:");
                int bredth = sc.nextInt();
                System.err.println("Area of Triangle:");
                int rectarea = length * bredth ;
                System.out.println(rectarea);
                break;
              
            case 4:
                System.out.println("Thank u");
                return;
                
            default:
                System.out.println("invalid choice");


        }
    }
    
}
}