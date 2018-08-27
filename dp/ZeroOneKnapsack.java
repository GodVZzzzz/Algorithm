package dp;

/**
 * @author Zhang
 * @date 2018/8/27
 * @Description
 */
public class ZeroOneKnapsack {

    private static int[] w = {2,5,1,4,3,7};

    private static int[] v = {3,2,6,9,5,2};

    private static final int W = 15;

    public static void main(String[] args) {
        System.out.println(largestAcount(w,v,5,W));
        DPKnapsack(w,v);
    }

    private static int largestAcount(int[] w, int[] v, int i, int j){

        if(i < 0)
            return 0;
        if(j >= w[i]){
            int q1 = largestAcount(w,v,i-1,j);
            int q2 = largestAcount(w,v,i-1,j-w[i])+v[i];
            if(q1 >= q2)
                return q1;
            else
                return q2;
        }
        else
            return largestAcount(w,v,i-1,j);

    }

    private static void DPKnapsack(int[] w, int[] v){
        int[][] c = new int[w.length+1][W+1];
        for(int i = 1; i < w.length+1; i++){
            for(int j = 1; j <= W; j++) {
                if (j >= w[i - 1]) {
                    int q1 = c[i - 1][j];
                    int q2 = c[i - 1][j - w[i - 1]] + v[i - 1];
                    if (q1 >= q2)
                        c[i][j] = q1;
                    else {
                        c[i][j] = q2;
                    }
                } else {
                    c[i][j] = c[i - 1][j];
                }
            }
        }

        System.out.println(c[w.length][W]);
        print(c,w.length,W);
    }

    private static void print(int[][] s,int i,int j){
        if(i == 0)
            return;
        if(s[i][j] == s[i-1][j])
            print(s,i-1,j);
        else if(s[i][j] == s[i-1][j-w[i-1]]+v[i-1]){
            System.out.print(i+",");
            print(s,i-1,j-w[i-1]);
        }
    }
}
