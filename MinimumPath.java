public class MinimumPath {
    public static int minCostPathIterative(int [][] input){

        int rows = input.length;
        int column=input[0].length;
        int [][] storage = new int [rows+1][column+1];

        for(int i=0;i<storage.length;i++){
            for(int j=0;j<storage[0].length;j++){
                storage[i][j]= Integer.MAX_VALUE;
            }
        }
        for(int i =rows-1;i>=0;i--){
            for(int j=column-1;j>=0;j--){

                if(i==rows-1 && j ==column-1){
                    storage[i][j]=input[i][j];
                    continue;
                }

                int vertical = storage[i][j+1];
                int horizontal = storage[i+1][j];
                int diagonal = storage[i+1][j+1];
                storage[i][j] = input[i][j] + Math.min(vertical,Math.min(horizontal,diagonal));
            }
        }
        return storage[0][0];
    }

    public static int minCostPathMemoization(int[][] input) {

        int [][] storage = new int[input.length+1][input[0].length+1];
        for(int i=0;i<=input.length;i++){
            for(int j=0;j<=input[0].length;j++){
                storage[i][j]=-1;	//initialize it with max value
            }
        }
        return minCostPathMemoization(input,storage,0,0);
    }

    public static int minCostPathMemoization(int[][] input, int[][] storage, int i, int j){
        int rows = input.length;
        int column = input[0].length;

        if(i==rows-1 && j== column -1){
            // return input[i][j];
            storage[i][j] = input[i][j];
            return storage[i][j];
        }

        if(i>=rows || j>=column){
            return Integer.MAX_VALUE;
        }

        if(storage[i][j]!=-1){
            return storage[i][j];
        }
        int vertical = minCostPathMemoization(input, storage,i+1, j);
        int horizontal = minCostPathMemoization(input, storage,i, j+1);
        int diagonal = minCostPathMemoization(input, storage,i+1, j+1);

        int ans = input[i][j] + Math.min(horizontal,Math.min(vertical,diagonal));
        storage[i][j] = ans;
        return ans;
    }

    public static int minCostPathRecursive(int[][] input) {

      return minCostPathRecursive(input,0,0);
    }

    private static int minCostPathRecursive(int[][] input, int i, int j) {

        int rows = input.length;
        int column = input[0].length;

        if(i==rows-1 && j== column -1){
            return input[i][j];
        }

        if(i>=rows || j>=column){
            return Integer.MAX_VALUE;
        }

        int horizontal = minCostPathRecursive(input,i,j+1);
        int vertical = minCostPathRecursive(input,i+1,j);
        int diagonal = minCostPathRecursive(input,i+1,j+1);

        int ans = input[i][j]+Math.min(horizontal,Math.min(vertical,diagonal));

        return ans;
    }
    public static void main(String[] args){
        int input[][] = {{1,5,11},{8,13,12},{2,3,7},{15,16,18}};
        System.out.println(minCostPathRecursive(input));
        System.out.println(minCostPathMemoization(input));
        System.out.println(minCostPathIterative(input));
    }
}
