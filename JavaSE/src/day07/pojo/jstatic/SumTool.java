package day07.pojo.jstatic;

public class SumTool {
    private SumTool() {
    }

    public static int Getsum(int...arr1) {
        int sum = 0;
        for(int i = 0; i < arr1.length; i++) {
            sum+=arr1[i];
        }
        return sum;
    }


}
