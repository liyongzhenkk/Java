public class Test {
    public static int factoer(int n) {
        if (n == 1)
            return 1;
        return factoer(n - 1) * n;
    }
    public static int Printf1(int n) {
        int sum = 0;
        if(n == 0) return 0;
        int tmp = n;
        sum += Printf1(tmp/10);
        return n%10;
    }

    public static int add(int n) {
        if(n < 10) {
            return n;
        }
        return n%10 + add(n/10);


    }
    public static void main(String[] args) {
        //System.out.println(factoer(5));

        //int sum = Printf1(100000);
        System.out.println(add(123));
    }
}
