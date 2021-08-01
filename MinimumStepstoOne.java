public class MinimumStepstoOne {
    //if n is divisible by 3 devide by 3
    //if nis divibible by 2 devide by 2
    //else subtract by one
    public static int countMinStepsToOne(int n) {
        if(n==1){
            return 0;
        }
        int ans1 =0;
        int ans2 =Integer.MAX_VALUE;
        int ans3 = Integer.MAX_VALUE;
        ans1=countMinStepsToOne(n-1);
        if(n%2==0){
            ans2 = countMinStepsToOne(n/2);
        }
        if(n%3==0){
            ans3 = countMinStepsToOne(n/3);
        }
        return Math.min(ans1,Math.min(ans2,ans3))+1;

    }
    public static int countMinStepsToOneMemoization(int n) {
        int[] arr = new int[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=-1;
        }
        return helperMemoization(n,arr);
    }

    private static int helperMemoization(int n, int[] arr) {
        if(n==1){
            return 0;
        }
        int ans1;
        if(arr[n-1]==-1){
            ans1=helperMemoization(n-1,arr);
            arr[n-1]=ans1;
        }
        else{
            ans1=arr[n-1];
        }
        int ans2=Integer.MAX_VALUE;
        if(n%2==0){
            if(arr[n/2]==-1){
                ans2 = helperMemoization(n/2,arr);
                arr[n/2]=ans2;
            }
            else{
                ans2=arr[n/2];
            }
        }
        int ans3= Integer.MAX_VALUE;
        if(n%3==0){
            if(arr[n/3]==-1){
                ans3=helperMemoization(n/2,arr);
                arr[n/3]=ans3;
            }
            else{
                ans3=arr[n/3];
            }
        }
        return Math.min(ans1,Math.min(ans2,ans3))+1;
    }

    public static int countMinStepsIterationDP(int n){
        int [] answers = new int [n+1];
        for(int i=2;i<=n;i++){
            int minforprevious=answers[i-1];
            if(i%2==0 && minforprevious>answers[i/2]){
                minforprevious=answers[i/2];
            }
            if(i%3==0&&minforprevious>answers[i/3]){
                minforprevious=answers[i/3];
            }
            answers[i]=minforprevious+1;
        }
        return answers[n];
    }
    public static void main(String[] args){
        System.out.println(countMinStepsToOne(23));
        System.out.println(countMinStepsIterationDP(10));

    }
}
