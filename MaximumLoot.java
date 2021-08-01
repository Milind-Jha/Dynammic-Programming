public class MaximumLoot {
    public static int maxMoneyLootedRecursive(int[] houses) {
        return getMaxMoneyRecursive(houses,houses.length);
    }

    private static int getMaxMoneyRecursive(int[] houses, int length) {
        if(length<=0){
            return 0;
        }
        return Math.max(getMaxMoneyRecursive(houses,length-1),houses[length-1]+getMaxMoneyRecursive(houses,length-2));
    }

    public static int maxMoneyMemoization(int[] houses){
        int[] storage = new int[houses.length];
        for (int x=0; x < houses.length; x++) {
            storage[x]=-1;
        }
        return helperMemoization(houses,storage,houses.length);
    }

    private static int helperMemoization(int[] houses, int[] storage, int length) {
        if(length<=0){
            return 0;
        }
       if(storage[length-1]==-1){
           storage[length-1] = Math.max(helperMemoization(houses,storage,length-1),
                               helperMemoization(houses, storage, length-2)+houses[length-1]);
           return storage[length-1];
       }
        else{
           return  storage[length - 1];

       }

    }
    public static int maxMoneyLootedDP(int[] houses) {
        int n=houses.length;
        if(n==0 ) return 0;
        int[] storage = new int[n+1];
        storage[0] = 0;
        storage[1] = houses[0];
        for(int i=2;i<=n;i++) {
            storage[i] = Math.max(storage[i-1] , houses[i-1] + storage[i-2]);
        }
        return storage[n];
    }

    public static void main(String[] args){
        int[] arr = {3,5,4,1};
        System.out.println(maxMoneyLootedRecursive(arr));
        System.out.println(maxMoneyMemoization(arr));
        System.out.println(maxMoneyLootedDP(arr));
    }

}
