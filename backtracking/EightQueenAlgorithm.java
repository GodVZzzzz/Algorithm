package backtracking;

/**
 * @author Zhang
 * @date 2018/8/27
 * @Description
 */
public class EightQueenAlgorithm {
    private static int count = 0;

    public static void main(String[] args) {
        NQueen(8);
        System.out.println("一共有"+count+"种解法");
    }

    private static void NQueen(int n){
        int[] X = new int[n+1];

        int k = 1;
        while (k > 0){
            X[k]++;
            while (X[k] <= n && ! Place(X, k)){
                X[k]++;
            }
            if(X[k] <= n){
                if(k == n){
                    count++;
                    System.out.print("[  ");
                    for(int i = 1; i <= n; i++){
                        System.out.print(X[i]+"  ");
                    }
                    System.out.print("]\n");
                }
                else
                    k++;
            }
            else {
                X[k] = 0;
                k--;
            }
        }
    }
    private static boolean Place(int[] X, int k){
        int i = 1;
        while (i < k){
            if(X[i] == X[k] || Math.abs(X[i]-X[k])==Math.abs(i-k))
                return false;

            i++;
        }

        return true;
    }
}
