package DAY2;

public class Pattern6 {
    public static void main(String args[]){
        int n = 5;
        int c = 0;

        for(int i=1; i<=n; i++){
            for(int j=1; j<=i; j++){     
                System.out.print(j + " ");
           c++;
                
            }  
            System.out.println();
        }
    }
}