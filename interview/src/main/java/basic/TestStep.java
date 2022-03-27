package basic;

public class TestStep {
    public static void main(String[] args) {
        System.out.println(recursion(5));
        System.out.println(loop(40));
    }
    public static int recursion(int n){
        if (n <1){
            return -1;
        }
        if (n == 1 || n == 2){
            return n;
        }
        return recursion(n-2) + (n -1);
    }

    public static int loop(int n){
        if (n <1){
            return -1;
        }
        if (n == 1 || n == 2){
            return n;
        }
        int one = 2; // 初始化走到第二级台阶的走法
        int two = 1; // 初始化走到第一级台阶的走法
        int sum = 0;
        for (int i = 3; i <=n ; i++) {
            sum = one + two;
            two = one;
            one = sum;
        }
        return sum;
    }
}
