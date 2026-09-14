package dayo2;

public class test {
    public static void main(String[] args) {
//        int sum1 = sum("hello",1,2,3,4,5);
//        System.out.println(sum1);
//        String result01 = concat("张无忌", "周芷若", "赵敏", "宋青书");
//        System.out.println(result01);
//        int[] arr = {1,2,3,4,5,6,7,8,9,10};
//        System.out.println(Arrays.toString(arr));
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        System.out.println(n);
//
//        Random random = new Random();
//        System.out.println(random);
//
//        Random random1 = new Random();
//        int i = random1.nextInt(n);
//        String str1 = "ni ";
//        String str2 = "hao ";
//        System.out.println("gei" + str1 + "he" + str2);
//        new ArrayList<Integer>().add(1);

    }
    public static int sum(String str1,int...x) {
        System.out.println(str1);
        int sum = 0;
        for (int i : x) {
            sum += i;
        }
        return sum;
    }
    public static String concat(String...str) {
        String sb = "";
        for(int i = 0; i < str.length; i++) {
            sb += str[i];
        }
        return sb;
    }
}
