package dp;

/**
 * @author Zhang
 * @date 2018/8/26
 * @Description
 */
public class MatrixChainAlgorithm {

    private static final int MATRIX_COUNT = 7;

    private static int[] p = {30,35,15,5,10,20,25};

    private static int INFINITY = 65535;

    public static void main(String[] args) {
        int result = RecursiveMatrixChain(p,1,MATRIX_COUNT-1);
        System.out.println(result);

        int result1 = MemoizedMatrixChain(p);
        System.out.println(result1);

        MatrixChainOrder(p);
    }

    //递归
    private static int RecursiveMatrixChain(int[] p, int i, int j){
        if(i == j)
            return 0 ;
        else {
            int m = INFINITY;
            for(int k = i; k <j; k++) {
                int q = RecursiveMatrixChain(p, i, k) + RecursiveMatrixChain(p, k + 1, j) + p[i - 1] * p[k] * p[j];
                if (q < m)
                    m = q;
            }
            return m;
        }
    }

    //自顶向下
    private static int MemoizedMatrixChain(int[] p){
        int[][] m = new int[MATRIX_COUNT][MATRIX_COUNT];
        for(int i = 1; i <MATRIX_COUNT; i++){
            for(int j = i; j <MATRIX_COUNT; j++){
                m[i][j] = INFINITY;
            }
        }
        return LookupChain(m,p,1,MATRIX_COUNT-1);
    }

    private static int LookupChain(int[][] m, int[] p, int i, int j){
        if(m[i][j] < INFINITY)
            return m[i][j];
        if(i == j)
            m[i][j] = 0;
        else {
            int q = INFINITY;
            for(int k = i; k <j; k++){
                q = LookupChain(m,p,i,k)+LookupChain(m, p, k+1, j)+p[i-1]*p[k]*p[j];
                if(q < m[i][j])
                    m[i][j] = q;
            }
        }
        return m[i][j];
    }
    //自底向上
    private static void MatrixChainOrder(int[] p){
        int[][] m = new int[MATRIX_COUNT][MATRIX_COUNT];
        int[][] s = new int[MATRIX_COUNT][MATRIX_COUNT];

        for(int i = 0; i < MATRIX_COUNT; i++){
            m[i][i] = 0;
        }

        for(int i = MATRIX_COUNT-2; i >= 1; i--){
            for(int j = i+1; j < MATRIX_COUNT; j++){
                m[i][j] = INFINITY;
                int q = INFINITY;
                for(int k = i; k < j; k++){
                    q = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                    if(q < m[i][j]){
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        printOptimalParens(s, 1, MATRIX_COUNT-1);

    }

    private static void printOptimalParens(int[][] s, int i, int j){
        if(i == j)
            System.out.print("A"+i);
        else {
            System.out.print("(");
            printOptimalParens(s, i, s[i][j]);
            printOptimalParens(s, s[i][j]+1, j);
            System.out.print(")");
        }
    }
}
