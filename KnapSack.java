public class KnapSack {
    public static int knapsackRecursive(int[] weights, int[] values, int n, int maxWeight) {

        if(n==weights.length){
            return 0;
        }

       int ans =0;
       if(weights[n]<=maxWeight){
           int include = values[n]+ knapsackRecursive(weights, values, n+1, maxWeight-weights[n]);
           int exclude = knapsackRecursive(weights, values, n+1, maxWeight);
           ans = Math.max(include,exclude);
       }
       else {
           ans = knapsackRecursive(weights, values, n+1, maxWeight);
       }
       return ans;
    }

    public static int knapsackIterative(int[] weights, int[] values, int n, int maxWeight){

        int[][] arr = new int[n+1][maxWeight+1];

        for(int i=0;i<=n;i++){
            arr[i][0] = 0;
        }
        for(int i=0;i<=maxWeight;i++){
            arr[0][i] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=maxWeight;j++){
                if(weights[i-1]<=j){
                    arr[i][j] = Math.max(values[i-1] + arr[i-1][j-weights[i-1]], arr[i-1][j]);
                }else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }
        return arr[n][maxWeight];
    }

    public static void main(String[] args){
        int [] weights = {12,7,11,8,9};
        int [] values = {24,13,23,15,16};
        int maxweight = 26;
        System.out.println(knapsackRecursive(weights,values,0,maxweight));
        System.out.println(knapsackIterative(weights,values,5,maxweight));
    }
}
