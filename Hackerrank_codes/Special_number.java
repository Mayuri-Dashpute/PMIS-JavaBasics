package Hackerrank_codes;

import java.util.Scanner;

class Result {

    public static int isSpecialNumber(int n) {
    // Write your code here
    int original = n;
    int sum = 0;
    
    while(n>0){
        int digit = n%10;
        int fact = 1;
    for(int i=1; i<=digit; i++){
        fact *= i;
    }
    
    sum += fact;
    n/=10;
    }
    
    
     return (sum == original) ? 1 : 0; 
    }
    }


public class Special_number{
    public static void main(String[] args)  {
       Scanner sc = new Scanner(System.in)
    }
}
