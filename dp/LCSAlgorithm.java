package dp;

/**
 * @author Zhang
 * @date 2018/8/27
 * @Description
 */
public class LCSAlgorithm {

    private static char[] X={'A','A','S','G','V','T'};

    private static char[] Y={'A','G','B','V','C'};

    public static void main(String[] args) {
        LCSLength(X,Y);
    }

    private static void LCSLength(char[] X, char[] Y){
        int m = X.length;
        int n = Y.length;
        char[][] b = new char[m+1][n+1];
        int[][] c = new int[m+1][n+1];

        for(int i = 1; i < m+1; i++){
            for(int j = 1; j < n+1; j++){
                if(X[i-1] == Y[j-1]){
                    c[i][j] = c[i-1][j-1]+1;
                    b[i][j] = '↖';
                }
                else if(c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = '↑';
                }
                else {
                    c[i][j] = c[i][j-1];
                    b[i][j] = '←';
                }
            }
        }

        System.out.println("LCS长度为："+c[m][n]);
        PrintLCS(b,X,m,n);
    }

    private static void PrintLCS(char[][] b, char[] X, int i, int j){
        if(i == 0 || j == 0)
            return;
        else if(b[i][j] == '↖'){
            PrintLCS(b, X, i-1, j-1);
            System.out.print(X[i-1]);
        }
        else if(b[i][j] =='↑')
            PrintLCS(b,X, i-1, j);
        else
            PrintLCS(b,X,i,j-1);
    }
}
