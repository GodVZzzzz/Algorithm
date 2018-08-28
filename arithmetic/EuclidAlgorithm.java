package arithmetic;

/**
 * @author Zhang
 * @date 2018/8/27
 * @Description
 */
public class EuclidAlgorithm {

    public static void main(String[] args) {
        System.out.println(Euclid(21,30));
        int[] s = ExtendEuclid(99,78);
        for(int t:s){
            System.out.print(t+", ");
        }
        System.out.println();

        ModularLineraEquationSolver(35,10,50);
    }

    private static int Euclid(int a, int b){
        if(b == 0)
            return a;
        else {
            int m = a%b;
            return Euclid(b,m);
        }
    }

    private static int[] ExtendEuclid(int a, int b){
        int[] result = new int[3];

        if(b==0){
            result[0] = a;
            result[1] = 1;
            result[2] = 0;
            return result;
        }

        else {
            int[] s = ExtendEuclid(b,a%b);
            result[0] = s[0];
            result[1] = s[2];
            result[2] = s[1]-a/b*s[2];
            return result;
        }
    }

    private static void ModularLineraEquationSolver(int a, int b, int n){
        int[] m = ExtendEuclid(a,n);

        if(b%m[0] == 0){
            int x = m[1]*(b/m[0])%n;
            for(int i = 0; i < m[0]; i++){
                System.out.print((x+i*(n/m[0]))%n + ", ");
            }
        }

        else
            System.out.println("无解");
    }
}
