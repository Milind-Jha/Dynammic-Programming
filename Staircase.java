public class Staircase {

    public static long staircaseIterative(int n){
        long[] storage = new long[n+1];
        if(n==0){
            return 1;
        }
        if(n==1||n==2){
            return n;
        }
        storage[0]=1;
        storage[1]=1;
        storage[2]=2;

        for(int i=3;i<=n;i++){
            storage[i]=storage[i-1]+storage[i-2]+storage[i-3];
        }
        return storage[n];

    }

    public static long staircaseRecDP(int n) {
        long [] storage = new long[n+1];
        storage[0]=storage[1]=1;
        for(int i=2;i<storage.length;i++){
            storage[i]=-1;
        }
        return helperOne(n,storage);
    }

    private static long helperOne(int n, long[] storage) {
        if (n == 1 || n == 0){
            storage[n]=1;
            return 1;
        }

        else if (n == 2){
            storage[n]=2;
            return 2;
        }

        if(storage[n-1]!=-1){
            return storage[n-1]+storage[n-2]+storage[n-3];
        }
        else if(storage[n-1]==-1 && storage[n-2]!=-1){
            long x =  helperOne(n-1,storage);
            storage[n-1]=x;
            return storage[n-1]+storage[n-2]+storage[n-3];
        }
        else if(storage[n-1]==-1 && storage[n-2]==-1 && storage[n-3]!=-1){

            long y = (int) helperOne(n-2,storage);
            long x = (int) helperOne(n-1,storage);
            storage[n-2]=y;
            storage[n-1]=x;
            return storage[n-1]+storage[n-2]+storage[n-3];
        }
        else{

            long z =  helperOne(n-3,storage);
            long y =  helperOne(n-2,storage);
            long x =  helperOne(n-1,storage);
            storage[n-3]=z;
            storage[n-2]=y;
            storage[n-1]=x;
            return storage[n-1]+storage[n-2]+storage[n-3];
        }
    }

    public static long StairRec(int n)
    {
        if (n == 1 || n == 0)
            return 1;
        else if (n == 2)
            return 2;
        else
            return StairRec(n - 3) + StairRec(n - 2) + StairRec(n - 1);
    }

    public static void main(String[] args){
        System.out.println(staircaseRecDP(40));
//        System.out.println(StairRec(40));
        System.out.println(staircaseIterative(40));
    }
}
