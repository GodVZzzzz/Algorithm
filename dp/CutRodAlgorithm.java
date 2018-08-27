package dp;



/**
 * @author Zhang
 * @date 2018/8/25
 * @Description 钢条切割动规
 */
public class CutRodAlgorithm {

    static int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};  //价格数组

    public static void main(String[] args) {
        System.out.println(cutRod(p, 10));
        System.out.println(memoizedCutRod(p, 10));
        System.out.println(bottomCutRod(p,5));
    }

    //递归实现
    private static int cutRod(int[] p, int n){
        if (n == 0)
            return 0;
        int q = 0;
        for (int i = 0; i < n; i++){
            q = max(q, p[i]+cutRod(p,n-i-1));
        }
        return q;

    }

    //自顶向下
    private static int memoizedCutRod(int[] p,int n){
        int[] r = new int[11];
        int[] s = new int[11];
        return memoizedCutRodAux(p, n, r);
    }

    private static int memoizedCutRodAux(int[] p, int n, int[] r){
        int q = 0;
        if( r[n] > 0)
            return r[n];

        if(n == 0)
            q = 0;
        else {
            for (int i = 0; i < n; i++){
                q = max(q, p[i]+memoizedCutRodAux(p, n-i-1, r));
            }
        }

        r[n] = q;
        return q;
    }

    //自底向上
    private static int bottomCutRod(int[] p, int n){
        int[] r = new int[11];
        for(int i = 0; i < n; i++) {
            int q = 0;
            for(int j = 0; j <= i; j++) {
                if(q<p[j] + r[i-j]){
                    q = p[j]+r[i-j];
                }
            }
            r[i+1] = q;
        }


        return r[n];
    }
    private static int max(int a,int b){
        if(a >= b)
            return a;
        else
            return b;
    }
}
