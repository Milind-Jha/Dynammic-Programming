public class MinimumSquarestoN {

    public static int minimumSquarestoN(int n){
//        int[] minimum = new int[n];
        if(n==0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++) {
            int currAns = minimumSquarestoN(n-(i*i));
            if(min>currAns){
                min=currAns;
            }
        }
        return min+1;
    }
    public static int minimumSquaresTonMemoization(int n){
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++){
           arr[i]=-1;
        }
        return helperMemoization(n,arr);
    }

    private static int helperMemoization(int n, int[] arr) {
        if(n==0){
            return 0;
        }
        int min=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int currAns;
            if( arr[n-(i*i)]==-1){
                currAns = helperMemoization(n-(i*i),arr);
            }
            else{
                currAns = arr[n-(i*i)];
            }
            if(currAns<min){
                min=currAns;
            }
        }
        int Ans = min+1;
        return Ans;
    }
    public static int minSquarestonDP(int n){
        int[] storage = new int[n+1];
        storage[0] =0;
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            for(int j=1;j*j<=i;j++){
                int x = storage[i-(j*j)];
                min = Math.min(min,x);
            }
            storage[i]=min+1;
        }
        return storage[n];
    }
    public static void main(String[] args){
        System.out.println(minimumSquaresTonMemoization(41));
        System.out.println(minimumSquarestoN(41));
        System.out.println(minSquarestonDP(41));
    }
}
