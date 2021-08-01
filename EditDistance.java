public class EditDistance {
    public static int editDistance(String s, String t) {
       if(s.length()==0){
           return t.length();
       }
       if(t.length()==0){
           return s.length();
       }
       int ans=0;
       if(s.charAt(0)==t.charAt(0)){
           ans = editDistance(s.substring(1),t.substring(1));
       }
       if(s.charAt(0)!=t.charAt(0)){
           int ans1 = 1+ editDistance(s.substring(1),t.substring(1));
           int ans2 = 1+ editDistance(s,t.substring(1));
           int ans3 = 1+ editDistance(s.substring(1),t);
           ans = Math.min(ans1,Math.min(ans2,ans3));
       }
       return ans;
    }
    public static int editdtstanceMemoization(String s, String t){
        int m = s.length();
        int n = t.length();

        int[][]dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return edit(s, t, dp);
    }

    private static int edit(String s, String t, int[][] dp) {
        if(s.length()==0){
            return t.length();
        }
        if(t.length()==0){
            return s.length();
        }
        int m = s.length();
        int n = t.length();

        if(dp[m][n]!=-1){
            return dp[m][n];
        }
        if(s.charAt(0)==t.charAt(0)){
            int smallAns = edit(s.substring(1), t.substring(1), dp);
            dp[m][n] = smallAns;
            return dp[m][n];
        }

        int ans1 = edit(s.substring(1), t, dp);
        int ans2 = edit(s, t.substring(1), dp);
        int ans3 = edit(s.substring(1), t.substring(1), dp);
        dp[m][n] = 1 + Math.min(ans1, Math.min(ans2, ans3));
        return dp[m][n];
    }

    public static int editDistanceIterative(String s, String t){
        int[][] arr = new int[s.length()+1][t.length()+1];

        for(int i=0;i<=s.length();i++){
            arr[i][0] = i;
        }
        for(int i=0;i<=t.length();i++){
            arr[0][i] = i;
        }
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    arr[i][j] = arr[i-1][j-1];
                }else{
                    arr[i][j] = 1 + Math.min(arr[i-1][j-1], Math.min(arr[i-1][j], arr[i][j-1]));
                }
            }
        }
        return arr[s.length()][t.length()];
    }

    public static void main(String[] args){
        System.out.println(editDistance("whgtdwhgtdg","aswcfg"));
        System.out.println(editdtstanceMemoization("whgtdwhgtdg","aswcfg"));
        System.out.println(editDistanceIterative("whgtdwhgtdg","aswcfg"));
    }
}
