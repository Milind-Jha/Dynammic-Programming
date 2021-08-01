import java.util.HashMap;

public class ByteGoldCoinExchange {
    public static long bytelandian(long n, HashMap<Long, Long> memo) {
       if(n<=1){
           return n;
       }
       if(memo.get(n)!=null){
           return memo.get(n);
       }

           long value = bytelandian(n/2,memo)+ bytelandian(n/3,memo) + bytelandian(n/4,memo);
           memo.put(n,Math.max(n,value));
           return memo.get(n);

    }

    public static long bytelandianIterative(long n , HashMap<Long,Long> storage){
        if(n<=1){
            return n;
        }
        if(storage.get(n)!=null){
            return storage.get(n);
        }
        storage.put(0L,0L);
        storage.put(1L,1L);

        for(long i=2L; i<=n;i++){
            storage.put(i,Math.max(i,storage.get(i/2) + storage.get(i/3) + storage.get(i/4)));
        }
        return storage.get(n);
    }
    public static void main(String[] args){
        HashMap<Long,Long> map = new HashMap<Long, Long>();
        System.out.println(bytelandian(1000000000,map));
        System.out.println(bytelandianIterative(1000000000,map));
    }
}
