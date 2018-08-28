package backtracking;

import java.util.Arrays;

/**
 * @author Zhang
 * @date 2018/8/28
 * @Description
 */
public class SubsetSumAlgorithm {

    private static int[] W={1,2,3,4,5,6,7,8};

    private static int M = 9;

    private static int[] X = new int[W.length];

    public static void main(String[] args) {
        Subsum(0,0,36);
    }

    private static void Subsum(int s, int k, int r){
        X[k] = 1;

        if(s+W[k] == M){
            for(int i = 0; i < X.length; i++){
                if(i > k)
                    X[i] = 0;
                System.out.print(X[i]+", ");
            }
            System.out.println();
        }

        else {
            if(s+W[k]+W[k+1] <= M){
                Subsum(s+W[k],k+1,r-W[k]);
            }
            if(s+r-W[k] >= M && s+W[k+1] <= M){
                X[k] = 0;
                Subsum(s,k+1,r-W[k]);
            }
        }
    }

}

