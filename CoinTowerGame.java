import java.util.Arrays;

public class CoinTowerGame {
    public static String findWinnerMemoization(int n, int x, int y) {
        int[] storage = new int[n+1];
 		for(int i=0;i<storage.length;i++){
 		    storage[i]=-1;
        }
 		int ans = helperMemoization(n,x,y,storage);
 		if(ans==1)
 		    return "Beerus";
 		else
 		    return "Whis";
    }

    private static int helperMemoization(int n, int x, int y, int[] storage ) {
        if(n==x || n==1 || n==y) {
            storage[n] = 1;
            return storage[n];
        }
        if(n<=0) {
            return 0;
        }
        if(storage[n]!=-1 ) {
            return storage[n];
        }
        int a = helperMemoization(n-1, x, y, storage);
        int b = helperMemoization(n-x, x, y, storage);
        int c = helperMemoization(n-y, x, y, storage);

        storage[n] = Math.max(a^1, Math.max(b^1,c^1));
        return storage[n];
    }
    public static String findWinnerDP(int n,int x ,int y){
        //Your code goes here
        String s1="Whis";
        String s2="Beerus";
        boolean storage[]=new boolean[n+1];
        Arrays.fill(storage,false);
        storage[0]=false;
        storage[1]=true;

        for(int i=2;i<=n;i++){

            if(i-1 >=0 && storage[i-1]==false){
                storage[i]=true;
            }
            else if(i-x>=0 && storage[i-x]==false){
                storage[i]=true;
            }
            else if(i-y>=0 && storage[i-y]==false){
                storage[i]=true;
            }
            else
                storage[i]=false;
        }
        if(storage[n]==false)
            return s1;
        else
            return s2;
    }
    public static void main(String [] args){
        System.out.println(findWinnerMemoization(10,2,4));
        System.out.println(findWinnerDP(10,2,4));
    }
}
