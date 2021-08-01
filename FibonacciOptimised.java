import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciOptimised {
    public static int fibonacciIterative(int x){
        if(x==0)
            return 0;
        int fn_1=1;
        int fn_2=1;
        for(int i=3;i<=x;i++){
            int temp= fn_1;
            fn_1= fn_2+fn_1;
            fn_2=temp;
        }
        return fn_1;
    }
    public static int fibonacciIterativeDP(int x,int [] storage){
        if(x==0||x==1){
            return x;
        }
        storage = new int[x+1];
        storage[0]=0;
        storage[1]=1;
        for(int i=2;i<=x;i++){
            storage[i]=storage[i-1]+storage[i-2];
        }
        return storage[x];
    }
    public static int fibonacciRecDP(int x,int[] storage){
        if(x==0||x==1){
            storage[x]=x;
            return x;
        }
        int xMinusOne;
        int xMinusTwo;
        if(storage[x-1]!=-1){
            xMinusOne=storage[x-1];
            xMinusTwo=storage[x-2];
            storage[x]=xMinusOne+xMinusTwo;
            return xMinusOne+xMinusTwo;
        }
        else if(storage[x-1]==-1&&storage[x-2]!=-1){
            xMinusTwo=storage[x-2];
            xMinusOne = fibonacciRecDP(x-1,storage);
            storage[x]=xMinusOne+xMinusTwo;
            return xMinusOne+xMinusTwo;
        }
        else{
            xMinusOne = fibonacciRecDP(x-1,storage);
            xMinusTwo = fibonacciRecDP(x-2,storage);
            return xMinusOne+xMinusTwo;
        }

    }
    public static void main(String [] arsg){
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
//        int x=6;
        int[] ans = new int[x+1];
        for (int y=0;y<x+1;y++) {
            ans[y]=-1;
        }
        System.out.println(fibonacciRecDP(x,ans));
        System.out.println(fibonacciIterativeDP(x,ans));
        System.out.println(fibonacciIterative(x));

    }
}
