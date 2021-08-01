import java.net.PortUnreachableException;

public class LongestCommonSubsequence {
    public static int lowestCommonSubsequenceIterative(String a, String b){
        int row =a.length();
        int column = b.length();
        int [][] storage = new int[a.length()+1][b.length()+2];

        for(int i=row-1;i>=0;i--){
            for(int j=column-1;j>=0;j--){
                int ans;
                if(a.charAt(i)==b.charAt(j)){
                    ans= 1+ storage[i+1][j+1];
                }
                else{
                int ans1 = storage[i][j+1];
                int ans2 = storage[i+1][j];
                ans = Math.max(ans1,ans2);
                }
                storage[i][j] = ans;
            }
        }
        return storage[0][0];
    }
    public static int lowestCommonSubsequenceMemoization(String a, String b){
        int [][] storage = new int[a.length()+1][b.length()+2];
        for(int i=0;i<a.length();i++){
            for(int j=0;j<b.length();j++){
                storage[i][j]=-1;
            }
        }
        return lowestCommonSubsequenceMemoization(a,b,0,0,storage);
    }
    public static int lowestCommonSubsequenceMemoization(String a, String b, int i, int j ,int [] [] storage)  {
        if(i==a.length() || j==b.length()){
            return 0;
        }
        int ans;
        if(a.charAt(i) == b.charAt(j)){
            int smallans;
            if(storage[i+1][j+1]==-1){
                smallans = lowestCommonSubsequenceMemoization(a,b,i+1,j+1,storage);
                storage[i+1][j+1]=smallans;
            }
            else{
                smallans = storage[i+1][j+1];
            }
            ans = 1 +smallans;
        }
        else{
            int smallans1, smallans2;
            if(storage[i+1][j]==-1){
                smallans1 = lowestCommonSubsequenceMemoization(a,b,i+1,j,storage);
                storage[i+1][j]= smallans1;
            }
            else{
                smallans1 = lowestCommonSubsequenceMemoization(a,b,i+1,j,storage);
            }
            if(storage[i][j+1]==-1){
                smallans2 = lowestCommonSubsequenceMemoization(a,b,i,j+1,storage);
                storage[i][j+1]=smallans2;
            }
            else{
                smallans2=storage[i][j+1];
            }
            ans= Math.max(smallans1,smallans2);
        }
        return ans;
    }
    public static int lowestCommonSubsequenceRec(String a , String b){
        return lowestCommonSubsequenceRec(a, b, 0, 0);

    }
    public static int lowestCommonSubsequenceRec(String a, String b, int i, int j){
        if(i==a.length() || j==b.length()){
            return 0;
        }
        int ans =0;
        if(a.charAt(i) == b.charAt(j)){
            ans = 1 + lowestCommonSubsequenceRec(a, b, i+1, j+1);
        }
        else{
            int x = lowestCommonSubsequenceRec(a, b, i, j+1);
            int y = lowestCommonSubsequenceRec(a, b, i+1, j);
            ans = Math.max(x,y);
        }
        return ans;
    }

    public static void main(String [] args){
        System.out.println(lowestCommonSubsequenceRec("abdgec","bfdmgjc"));
        System.out.println(lowestCommonSubsequenceMemoization("abdgec","bfdmgjc"));
        System.out.println(lowestCommonSubsequenceIterative("abdgec","bfdmgjc"));
    }
}
