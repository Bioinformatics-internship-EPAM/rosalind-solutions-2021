public class FIB {
    public static int getTotalRabbitPairs(int n, int k) {

        if(n >= 40 || k > 5){
            return -1;
        }

        int[] F =  new int[n];
        F[0] = 1;
        F[1] = 1;


        for (int i = 2; i < n; i++) {
            F[i] = F[i-1] + F[i-2] * k;
        }

        return F[n-1];
    }
}
